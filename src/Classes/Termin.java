/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
/**
 *
 * @author PC
 */
public class Termin {
    
    private Connection conn;
    
    public Termin(){};
    
    public ArrayList getAllTerminIdsForPredstava(int predstavaId) {
        ArrayList terminIds = new ArrayList();
        conn = DBConnectionManager.GetConnection();
        String query = "SELECT id FROM termin WHERE IDPredstava = " + predstavaId + " AND datum > now()";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                terminIds.add(rs.getInt("id"));
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return terminIds;
    }
    
    public void fillComboTermin(int predstavaID, JComboBox combo) {
        conn = DBConnectionManager.GetConnection();
        Termin termin;
        Rezervacija rezervacija;
        Pozicija pozicija;
        ArrayList listTerminDates = new ArrayList(); 
        ArrayList listTerminDatesFinal = new ArrayList();
        
        combo.removeAllItems();              

        String query = "SELECT date_format(datum, '%d-%m-%Y %H:%i:%s') as datum from termin where IDPredstava=" + predstavaID + " and datum > now()";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                listTerminDates.add(rs.getString("datum"));
            }
            
            termin = new Termin();
            rezervacija = new Rezervacija();
            pozicija = new Pozicija();
            listTerminDatesFinal.add(Globals.terminDefault);
            
            for (int i = 0; i < listTerminDates.size(); i++) {
                String date = listTerminDates.get(i).toString();
                String dateFormatted = HelperClass.formatDateToMySqlFormat(date);
                
                int terminId = termin.getTerminId(dateFormatted);
                
                int numOfResForTermin = rezervacija.getNumbOfAllReservationsForTermin(terminId);
                int ukupnoMestaPozicija = pozicija.getUkupnoBrojMesta();
                
                if (numOfResForTermin < ukupnoMestaPozicija) {
                    if(!listTerminDatesFinal.contains(date)) {
                        listTerminDatesFinal.add(date);
                    }
                }
            }
            
            for(int i = 0; i < listTerminDatesFinal.size(); i++) {
                combo.addItem(listTerminDatesFinal.get(i));
            }      
                    
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
    }
    
    public int getTerminId(String terminDate) {
        conn = DBConnectionManager.GetConnection();
        int terminId = 0;
        String query = "SELECT id FROM termin WHERE datum = '" + terminDate + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                terminId = rs.getInt("id");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return terminId;
    }
    
    public boolean checkIfStartsBefore24Hours(int terminId) {
        int count = 0;
        conn = DBConnectionManager.GetConnection();
        String query = "select COUNT(*) as 'row count' from termin where id = " + terminId + " and date_sub(datum, interval 1 day) > now()";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                count = rs.getInt("row count");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        if (count == 0)
            return true;
        else
            return false;
    }
    
    public boolean checkIfShowIsFinished(int terminId) {
        int count = 0;
        conn = DBConnectionManager.GetConnection();
        String query = "select COUNT(*) as 'row count' from termin where id = " + terminId + " and now() > datum";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                count = rs.getInt("row count");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        if (count == 1)
            return true;
        else
            return false;
    }
    
    
    public boolean checkIfTerminIsAvailable(String date) {
        int count = 0;
        conn = DBConnectionManager.GetConnection();
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        
        String query = "select Count(datum) as dateFound from termin where year(datum) = " + year + " AND month(datum) = " + month + " AND day(datum) = " + day;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                count = rs.getInt("dateFound");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        if (count == 0)
            return true;
        else
            return false;
    }
    
    
    public boolean zakaziPredstavu(int idPredstava, String datum, int idAdmin) {
        conn = DBConnectionManager.GetConnection();
        int result = 0;
        String query = "insert into termin(IDPredstava, datum, IDAdmin)"
                + " values(" + idPredstava + ", '" + datum + "', " + idAdmin + ")";
        
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
            System.out.println("Greska sa - Class Termin, method zakaziRezervaciju");
            return false;
        }
    }
    
}
