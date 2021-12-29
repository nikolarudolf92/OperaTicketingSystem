/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class Predstava {
    
    private Connection conn;
    
    public Predstava() {};
    
    public void fillComboSvePredstave(JComboBox combo) {
        conn = DBConnectionManager.GetConnection();
        combo.removeAllItems();
        combo.addItem(Globals.predstavaDefault);
        String query = "SELECT * FROM predstava";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                combo.addItem(rs.getString("naziv"));
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
    }
    
    public void fillComboPredstava(JComboBox combo) {
        
        ArrayList listPredstava = new ArrayList();
        ArrayList listPredstavaFinal = new ArrayList();
        Termin termin;
        Rezervacija rezervacija;
        Pozicija pozicija;        
        
        combo.removeAllItems();
        String query = "select DISTINCT predstava.naziv " +
                    "FROM predstava INNER JOIN Termin on predstava.id = termin.IDPredstava "
                  + "where termin.datum > now() order by termin.IDpredstava asc";
        
        try {
            conn = DBConnectionManager.GetConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);            
            
            while (rs.next()) {
                listPredstava.add(rs.getString("naziv"));
            }           
            
            termin = new Termin();
            rezervacija = new Rezervacija();
            pozicija = new Pozicija();
            listPredstavaFinal.add(Globals.predstavaDefault);
            
            for (int i = 0; i < listPredstava.size(); i++) {
                String item = listPredstava.get(i).toString();
                
                int predstavaId = getPredstavaId(item);                
                var terminIds = termin.getAllTerminIdsForPredstava(predstavaId);
                
                for (int j = 0; j < terminIds.size(); j++) {
                    int terminId = Integer.parseInt(terminIds.get(j).toString());

                    int numOfResForTermin = rezervacija.getNumbOfAllReservationsForTermin(terminId);
                    int ukupnoMestaPozicija = pozicija.getUkupnoBrojMesta();
                    //System.out.println("Broj rezervacija za termin ID " + terminId + " je: " + numOfResForTermin);
                    //System.out.println("Ukupan broj rezervacija dozvoljenih je: " + ukupnoMestaPozicija + "\n");
                    if (numOfResForTermin < ukupnoMestaPozicija) {
                        if(!listPredstavaFinal.contains(item)) {
                            listPredstavaFinal.add(item);
                        }
                    }                        
                }                   
            }
            
            for(int i = 0; i < listPredstavaFinal.size(); i++) {
                combo.addItem(listPredstavaFinal.get(i));
            }            
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage() + " OVDEEEE");
        }
        
    }
    
    
    public int getPredstavaId(String predstavaName) {
        conn = DBConnectionManager.GetConnection();
        int predstavaId = 0;
        String query = "SELECT id FROM predstava WHERE naziv = '" + predstavaName + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                predstavaId = rs.getInt("id");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return predstavaId;
    }
    
    public boolean insertIntoIzvedenePredstave(int idPredstava, int idGrupa, String date) {
        conn = DBConnectionManager.GetConnection();
        int result = 0;
        
        String query = "insert into izvedenepredstave(IDPredstava, IDGrupa, datum)"
                + " values(" + idPredstava + ", " + idGrupa + ", '" + date + "')";
        
        try {
            Statement st = conn.createStatement();
            result = st.executeUpdate(query);
            conn.close();
            
        } catch (SQLException e) {
            System.err.println("Greska: " + e.getMessage());
        }
        
        if (result != 0)
            return true;
        else {
            System.out.println("Greska sa - Class Predstava, method insertIntoIzvedenePredstave");
            return false;
        }
    }
}

    
