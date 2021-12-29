/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JComboBox;
import java.sql.*;

/**
 *
 * @author PC
 */
public class Grupa {
    private Connection conn;
    
    public Grupa() {};
    
    public int getGrupaId(String grupaName) {
        conn = DBConnectionManager.GetConnection();
        int grupaId = 0;
        String query = "SELECT id FROM grupa WHERE naziv = '" + grupaName + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                grupaId = rs.getInt("id");
            }
            conn.close();          
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        return grupaId;
    }
    
    public void fillComboGrupa(JComboBox comboGrupa) {
        conn = DBConnectionManager.GetConnection();
        comboGrupa.removeAllItems();
        comboGrupa.addItem(Globals.grupaDefault);
        String query = "select * from grupa";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                comboGrupa.addItem(rs.getString("naziv"));
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
    }
}
