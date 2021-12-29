
package Forms;

import Classes.Globals;
import Classes.Grupa;
import Classes.Predstava;
import Classes.Termin;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


public class NewPredstava extends javax.swing.JFrame {
    Predstava predstava;
    Grupa grupa;
    
    
    public NewPredstava() {
        initComponents(); 
        restrictDateChooser();
        makeDateFieldReadOnly();
        makeTimeFieldReadOnly();
        predstava = new Predstava();
        grupa = new Grupa();
        predstava.fillComboSvePredstave(comboPredstava);
        grupa.fillComboGrupa(comboGrupa);  
        icon();
    }
    
    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }
    
    private void resetForm() {
        comboPredstava.setSelectedIndex(0);
        comboGrupa.setSelectedIndex(0);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) datePicker.getDateEditor();
        editor.setText("");
    }
    
    private void makeTimeFieldReadOnly() {
        JFormattedTextField tf = ((JSpinner.DefaultEditor) timeSpinner.getEditor()).getTextField();
        tf.setEditable(false);
    }
    private void makeDateFieldReadOnly() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) datePicker.getDateEditor();
        editor.setEditable(false);
    }
    
    private void restrictDateChooser() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        datePicker.setMinSelectableDate(dt);
    }
    
    private boolean validateForm() {
        if (comboPredstava.getSelectedItem().toString() == Globals.predstavaDefault)
            return false;
        
        if (comboGrupa.getSelectedItem().toString() == Globals.grupaDefault)
            return false;
        
        if (datePicker.getDate() == null)
            return false;
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboPredstava = new javax.swing.JComboBox<>();
        btnZakazi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboGrupa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        datePicker = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeSpinner = new javax.swing.JSpinner(sm);
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Izaberite predstavu");

        comboPredstava.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        comboPredstava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnZakazi.setBackground(new java.awt.Color(255, 255, 102));
        btnZakazi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnZakazi.setForeground(new java.awt.Color(0, 0, 0));
        btnZakazi.setText("Zakazi");
        btnZakazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Izaberite grupu");

        comboGrupa.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        comboGrupa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Izaberite datum izvodjenja");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Vreme");

        JSpinner.DateEditor de = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(de);

        btnHome.setBackground(new java.awt.Color(51, 255, 255));
        btnHome.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 0, 0));
        btnHome.setText("Natrag na pocetnu stranu");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboPredstava, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(datePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(comboGrupa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(timeSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnZakazi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHome)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboPredstava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnZakazi)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        dispose();
        HomePage home = new HomePage();
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziActionPerformed
        if(validateForm() == false) {
            JOptionPane.showMessageDialog(null, "Morate popuniti sva polja. ", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        String predstavaName = (String)comboPredstava.getSelectedItem();
        int idPredstava = predstava.getPredstavaId(predstavaName);
        
        String grupaName = (String)comboGrupa.getSelectedItem();
        int idGrupa = grupa.getGrupaId(grupaName);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(datePicker.getDate());
        
        String timeValue = timeSpinner.getValue().toString();
        timeValue = timeValue.substring(11, 19);
        
        String finalDate = date + " " + timeValue;

        
        int idAdmin = Globals.loggedUserId;
        
        var termin = new Termin();
        
        if(!termin.checkIfTerminIsAvailable(date)) {
            JOptionPane.showMessageDialog(null, "Termin za izabrani datum je zauzet. Molimo izaberite drugi datum izvodjenja predstave.,", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(termin.zakaziPredstavu(idPredstava, finalDate, idAdmin) && predstava.insertIntoIzvedenePredstave(idPredstava, idGrupa, finalDate)) {
            resetForm();
            JOptionPane.showMessageDialog(null, "Uspesno ste zakazali predstavu!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnZakaziActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewPredstava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPredstava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPredstava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPredstava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPredstava().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnZakazi;
    private javax.swing.JComboBox<String> comboGrupa;
    private javax.swing.JComboBox<String> comboPredstava;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables
}
