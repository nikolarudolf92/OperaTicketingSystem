
package Forms;

import Classes.Globals;
import Classes.HelperClass;
import Classes.Pozicija;
import Classes.Predstava;
import Classes.Rezervacija;
import Classes.Termin;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;


public class NovaRezervacija extends javax.swing.JFrame {

    Predstava predstava;
    Termin termin;
    Pozicija pozicija;
    Rezervacija rezervacija;
    
    
    
    public NovaRezervacija() {
        initComponents();
        icon();
        
        predstava = new Predstava();
        termin = new Termin();
        pozicija = new Pozicija();
        rezervacija = new Rezervacija();
        
        predstava.fillComboPredstava(cmbPredstava);
        
        pozicija.fillComboPozicija(cmbPozicija);
        
        HelperClass.hideFields(cmbTermin, cmbPozicija, labelTermin, labelPozicija);
    }
    
    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }
    
    private void fillComboTermin(String predstavaNaziv) {
        int predstavaId = predstava.getPredstavaId(predstavaNaziv);
        termin.fillComboTermin(predstavaId, cmbTermin);        
    }
    
    private boolean validateForm() {
        if (!HelperClass.validateForm(cmbPredstava, cmbTermin, cmbPozicija)) {
            return false;
        }
        
        return true;
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbPredstava = new javax.swing.JComboBox<>();
        labelPozicija = new javax.swing.JLabel();
        cmbPozicija = new javax.swing.JComboBox<>();
        labelTermin = new javax.swing.JLabel();
        cmbTermin = new javax.swing.JComboBox<>();
        btnReservation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setBackground(new java.awt.Color(51, 255, 255));
        btnHome.setFont(new java.awt.Font("Dialog", 3, 10)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 0, 0));
        btnHome.setText("Natrag na pocetnu stranu");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Izaberite predstavu");

        cmbPredstava.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cmbPredstava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPredstava.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPredstavaItemStateChanged(evt);
            }
        });

        labelPozicija.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labelPozicija.setText("Izaberite poziciju");

        cmbPozicija.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cmbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelTermin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labelTermin.setText("Izaberite termin");

        cmbTermin.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cmbTermin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnReservation.setBackground(new java.awt.Color(255, 255, 102));
        btnReservation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReservation.setForeground(new java.awt.Color(0, 0, 0));
        btnReservation.setText("Napravi rezervaciju");
        btnReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(labelPozicija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTermin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTermin, 0, 190, Short.MAX_VALUE)
                    .addComponent(cmbPredstava, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnHome)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPredstava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTermin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnReservation)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPredstavaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPredstavaItemStateChanged
        if(cmbPredstava.getSelectedItem() == Globals.predstavaDefault) {
            HelperClass.hideFields(cmbTermin, cmbPozicija, labelTermin, labelPozicija);
        }
        else {
            fillComboTermin((String)cmbPredstava.getSelectedItem());
            HelperClass.showFields(cmbTermin, cmbPozicija, labelTermin, labelPozicija);
        }         
    }//GEN-LAST:event_cmbPredstavaItemStateChanged

    private void btnReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationActionPerformed
       if (!validateForm()) {
            JOptionPane.showMessageDialog(null, "Morate popuniti sva polja da biste izvrsili rezervaciju.");
            return;
        }

        String terminDate = (String)cmbTermin.getSelectedItem();
        String dateFormatted = HelperClass.formatDateToMySqlFormat(terminDate);
        String pozicijaName = (String)cmbPozicija.getSelectedItem();
        
        int idTermin = termin.getTerminId(dateFormatted);
        int idPozicija = pozicija.getPozicijaId(pozicijaName);
        int idKorisnik = Globals.loggedUserId;
              
        int brojZakazanihRezervacija = rezervacija.getNumOfReservationsForPosition(idTermin, idPozicija);
        int brojMestaPozicije = pozicija.getPositionBrojMesta(pozicijaName);
        
        if (brojZakazanihRezervacija >= brojMestaPozicije) {
            JOptionPane.showMessageDialog(null, "Za traženu poziciju \"" + pozicijaName + "\" su sva mesta popunjena. Molimo izaberite neku drugu.");
            return;
        }
        
        if(rezervacija.makeReservation(idTermin, idKorisnik, idPozicija)) {
            JOptionPane.showMessageDialog(null, "Rezervacija je uspesno napravljena.");
            HelperClass.resetForm(cmbPredstava, cmbTermin, cmbPozicija);
        }
        
                                                  
    }//GEN-LAST:event_btnReservationActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
       dispose();
        HomePage home = new HomePage();
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(NovaRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaRezervacija().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReservation;
    private javax.swing.JComboBox<String> cmbPozicija;
    private javax.swing.JComboBox<String> cmbPredstava;
    private javax.swing.JComboBox<String> cmbTermin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelPozicija;
    private javax.swing.JLabel labelTermin;
    // End of variables declaration//GEN-END:variables
}
