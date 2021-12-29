
package Classes;
import java.sql.*;

public class User {
    private int id;
    private String firstName;
    private int admin;
    
   
    public User(int id) {
        var conn = DBConnectionManager.GetConnection();
        String query = "SELECT * FROM korisnik WHERE id = " + id;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                this.firstName = rs.getString("ime");
                this.admin = rs.getInt("admin");
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
    }
        
        public User(String username) {
            var conn = DBConnectionManager.GetConnection();
            String query = "SELECT * FROM korisnik WHERE korisnicko_ime = '" + username + "'";
            
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
               
                while(rs.next()) {
                    this.id = rs.getInt("id");
                }
                
                conn.close();
            } catch (SQLException ex) {
                System.err.println("greska: " + ex.getMessage());
            }
        }
        public int getId() {
            return this.id;
        }
         public String getFirstName() {
        return this.firstName;
    }
         public boolean isAdmin() {
        if(admin == 1)
            return true;
        else
            return false;
    }
}
