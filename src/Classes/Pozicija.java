
package Classes;

import java.sql.*;
import javax.swing.JComboBox;



public class Pozicija {
    
    private Connection conn;
   
    public Pozicija(){};
    
     public void fillComboPozicija(JComboBox combo) {
        conn = DBConnectionManager.GetConnection();
        combo.removeAllItems();
        combo.addItem(Globals.pozicijaDefault);
        String query = "select * from pozicija";
        
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
     
     public int getPozicijaId(String pozicijaName) {
        conn = DBConnectionManager.GetConnection();
        int pozicijaId = 0;
        String query = "SELECT id FROM pozicija WHERE naziv = '" + pozicijaName + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                pozicijaId = rs.getInt("id");
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return pozicijaId;
    }
    
     
      public int getPositionBrojMesta(String positionName) {
        conn = DBConnectionManager.GetConnection();
        int brojMesta = 0;
        String query = "SELECT broj_mesta from pozicija where naziv = '" + positionName + "'";        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                brojMesta = rs.getInt("broj_mesta");
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return brojMesta;
    }
      
      public int getUkupnoBrojMesta() {
        conn = DBConnectionManager.GetConnection();
        int brojMesta = 0;
        String query = "SELECT broj_mesta from pozicija";        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                brojMesta += rs.getInt("broj_mesta");
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return brojMesta;
    }
}
