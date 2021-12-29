

package Classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class Account {
    
    private Connection conn;
    
    public Account() {};
    
    
    
    private boolean validateUsername(String username) {
        if(username.length() < 4 || username.length() > 25)
            return false;
        else return true;
    }
    
    private boolean validateName(String name) {
        if(name.length() < 2 || name.length() > 25)
            return false;
        else return true;
        }
    
    private boolean validateEmail(String email) {
        if(email.length() < 8 || email.length() >= 50) {
            return false;
        }
        if(!email.contains("@")) {
            return false;
        }
        if(!email.contains(".com")) {
            return false;
        }
        return true;
        }
    
    private boolean validatePassword(String password) {
        if(password.length() < 6 || password.length() >= 30) {
            return false;
        }
        return true;
    }
    
    private boolean validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() <9 || phoneNumber.length() > 10) {
            return false;
        }
        if(phoneNumber.contains(" ")) {
            return false;
        }
        if(!phoneNumber.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
    
    
    
    private boolean validateForm(String username, String firstName, String lastName, String email, String password, String phoneNumber) {
        if(!validateUsername(username)) {
            return false;
        }
        
        if(!validateName(firstName)) {
            return false;
        }
        
        if(!validateName(lastName)) {
            return false;
        }
        
        if(!validateEmail(email)) {
            return false;
        }
        
        if(!validatePassword(password)) {
            return false;
        }
        
        if(!validatePhoneNumber(phoneNumber)) {
            return false;
        }
        
        return true;
    }
    
    
    public int register(String username, String firstName, String lastName, String email, String password, String phoneNumber) {
        if(!validateForm(username, firstName, lastName, email, password, phoneNumber)) 
            return -1;
        
        if(checkIfUsernameExists(username) == true) 
             return 0;
       
        if(insertUserDetails(username, firstName, lastName, email, password, phoneNumber))
            return 1;
        else 
            return -10;
        
    }
    
    
    private boolean checkIfUsernameExists(String username) {
        conn = DBConnectionManager.GetConnection();
        int num = 0;
        
        String query = "SELECT COUNT(*) as number FROM korisnik WHERE korisnicko_ime ='" + username + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                num = rs.getInt("number");
            }
            
            conn.close();
        } catch (Exception ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        if(num == 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    private String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            password = hash.toString(16);
            if(password.length() % 2 != 0) {
                password = "0" + password;
            }
            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error with hashing: " + ex.getMessage());
        }
        return password;
    }
    
    
    private boolean insertUserDetails(String username, String firstName, String lastName, String email, String password, String phoneNumber) {
        conn = DBConnectionManager.GetConnection();
        int result = 0;
        String encryptedPw = md5(password);
        
        String query = "insert into korisnik(korisnicko_ime, ime, prezime, email, sifra, telefon, admin)"
                + "values('" + username + "', '" + firstName + "', '" + lastName + "', '" + email + "', '" + encryptedPw + "', '" + phoneNumber + "', 0)";
        
        try {
           Statement st = conn.createStatement();
           result = st.executeUpdate(query);
           conn.close();
        } catch (SQLException e) {
            System.err.println("Greska: " + e.getMessage());
        }
        if(result != 0) 
            return true;
        else 
            return false;
    }
  
    public boolean login(String username, String password) {
        conn = DBConnectionManager.GetConnection();
        String encryptedPw = md5(password);
        int num = 0;
        String query = "SELECT COUNT(*) as number FROM korisnik WHERE korisnicko_ime = '" + username +
                "' AND sifra = '" + encryptedPw + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                num = rs.getInt("number");
            }
            
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Greska: " + ex.getMessage());
        }
        
        if(num == 0) {
            return false;
        }
        else {
            return true;
        }
       
    }
    
}





