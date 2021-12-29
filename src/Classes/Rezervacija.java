
package Classes;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class Rezervacija {
    
    private Connection conn;
    
    public Rezervacija() {};
    
    public int getNumOfReservationsForPosition(int idTermin, int idPozicija) {
        conn = DBConnectionManager.GetConnection();
        int num = 0;        
        String getNumOfReservationsQuery = "select count(*) as brojRezervacija from rezervacija where IDTermin = " 
                                        + idTermin + " and IDPozicija = " + idPozicija + " and IDKorisnik = " + Globals.loggedUserId;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getNumOfReservationsQuery);
            
            while (rs.next()){
                num = rs.getInt("brojRezervacija");
            }
                    
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return num;
    }
    
    public int getNumbOfAllReservationsForTermin(int idTermin) {
        conn = DBConnectionManager.GetConnection();
        int num = 0;        
        String getNumOfReservationsQuery = "select count(*) as brojRezervacija from rezervacija where IDTermin = " + idTermin;
        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getNumOfReservationsQuery);
            
            while (rs.next()){
                num = rs.getInt("brojRezervacija");
            }
                    
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return num;
    }
    
    public boolean makeReservation(int idTermin, int idKorisnik, int idPozicija) {
        conn = DBConnectionManager.GetConnection();
        int result = 0;
        String query = "insert into rezervacija(IDTermin, IDKorisnik, IDPozicija)"
                + " values(" + idTermin + ", " + idKorisnik + ", " + idPozicija + ")";
        
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
            System.out.println("Greska sa - Class Rezervacija, method makeReservation");
            return false;
        }
        
    }  
    
    public boolean CancelReservation(int idTermin, int idKorisnik, int idPozicija) {
        conn = DBConnectionManager.GetConnection();
        int result = 0;
        boolean success = false;
        
        String query = "Delete from rezervacija WHERE IDTermin = " + idTermin + " AND IDKorisnik = " + idKorisnik + 
                        " AND IDPozicija = " + idPozicija;        
        
        try {
            Statement st = conn.createStatement();
            result = st.executeUpdate(query);
            conn.close();
            
        } catch (SQLException e) {
            System.err.println("Greska: " + e.getMessage());
        }
        
        if (result == 0) {
            System.out.println("Greska sa - Class Rezervacija, method cancelReservation");
            return false;
        }
        
        if (result == 1)
            return true;
        
        for (int i = 1; i < result; i++){
            success = makeReservation(idTermin, idKorisnik, idPozicija);
        }
        
        return success;
    }
    
    public void PopulateTable(JTable tableReservation) {
        conn = DBConnectionManager.GetConnection();
        String query = "select p.naziv as 'Predstava', date_format(t.datum, '%d-%m-%Y %H:%i:%s') as 'Termin održavanja', poz.naziv as 'Pozicija' from rezervacija r" +
                        " join termin t on r.IDTermin = t.id" +
                        " join predstava p on t.IDPredstava = p.id" +
                        " join pozicija poz on r.IDPozicija = poz.id where r.IDKorisnik = " + Globals.loggedUserId;
        
        try 
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            resultSetToTableModel(rs, tableReservation);
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
    }
    
    private void resultSetToTableModel(ResultSet rs, JTable table) {
        try {
            //Create new table model
            DefaultTableModel tableModel = new DefaultTableModel();
            
            //Retrieve meta data from ResultSet
            ResultSetMetaData metaData = rs.getMetaData();
            
            //Get number of columns from meta data
            int columnCount = metaData.getColumnCount();
            
            //Get all column names from meta data and add columns to table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }
            
            //Create array of Objects with size of column count from meta data
            Object[] row = new Object[columnCount];
            
            //Scroll through result set
            while (rs.next()) {
                //Get object from column with specific index of result set to array of objects
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Now add row to table model with that array of objects as an argument
                
                tableModel.addRow(row);
            }
            
            //Now add that table model to your table and you are done :D
            table.setModel(tableModel);
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
    }
    
}
