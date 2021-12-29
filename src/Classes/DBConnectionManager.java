
package Classes;
import java.sql.*;

public class DBConnectionManager {
    public static Connection GetConnection() {
        Connection conn = null;
        
        String url = "jdbc:mysql://localhost:3306/Opera";
        String user = "root";
        String pass = "";
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        return conn;
    }
}
