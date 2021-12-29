
package Classes;

import javax.swing.JComboBox;
import javax.swing.JLabel;


public class HelperClass {
    public static boolean isEmptyOrWhiteSpace(String value) {
        
        if(value == null)
            return true;
        
        for (int index = 0; index < value.length(); index ++) {
            if(!Character.isWhitespace(value.charAt(index))) {
                return false;
            }
        }
        return true;        
    }
    
    public static void hideFields(JComboBox combo, JComboBox secondCombo, JLabel label, JLabel secondLabel){
        combo.setVisible(false);
        secondCombo.setVisible(false);
        label.setVisible(false);
        secondLabel.setVisible(false);
    }
    
     public static void showFields(JComboBox combo, JComboBox secondCombo, JLabel label, JLabel secondLabel){
        combo.setVisible(true);
        secondCombo.setVisible(true);
        label.setVisible(true);
        secondLabel.setVisible(true);
    }

    public static boolean validateForm(JComboBox cmbPredstava, JComboBox cmbTermin, JComboBox cmbPozicija) {
        if (cmbPredstava.getSelectedItem() == Globals.predstavaDefault ||
            cmbTermin.getSelectedItem() == Globals.terminDefault || 
            cmbPozicija.getSelectedItem() == Globals.pozicijaDefault) {
            return false;
        }
        return true;
    }
    
    public static void resetForm(JComboBox cmbPredstava, JComboBox cmbTermin, JComboBox cmbPozicija) {
        cmbPredstava.setSelectedIndex(0);
        cmbTermin.setSelectedIndex(0);
        cmbPozicija.setSelectedIndex(0);
    }
    
    public static String formatDateToMySqlFormat(String date) {
        //date = 29-10-2021 19:05:00, mora da se prebaci u date = 2021-10-29 19:05:00 pre ubacivanja u bazu
        String formattedDate = date.substring(6, 10) + date.substring(2, 6) + date.substring(0, 2) + date.substring(10, 19);
        
        return formattedDate;
    }
}
