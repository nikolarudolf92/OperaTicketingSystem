
package Forms;

import Classes.Globals;
import Classes.HelperClass;
import Classes.Pozicija;
import Classes.Rezervacija;
import Classes.Termin;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class PregledRezervacija extends javax.swing.JFrame {

    Rezervacija rezervacija;
    
    public PregledRezervacija() {
        initComponents();
        rezervacija = new Rezervacija();
        rezervacija.PopulateTable(tableRezervacija);
        icon();
    }

    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRezervacija = new javax.swing.JTable();
        btnCancelReservation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setBackground(new java.awt.Color(51, 255, 255));
        btnHome.setFont(new java.awt.Font("Dialog", 3, 11)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 0, 0));
        btnHome.setText("Natrag na pocetnu stranu");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        tableRezervacija.setBackground(new java.awt.Color(0, 0, 0));
        tableRezervacija.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tableRezervacija.setForeground(new java.awt.Color(255, 255, 255));
        tableRezervacija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRezervacija.setFocusable(false);
        jScrollPane1.setViewportView(tableRezervacija);

        btnCancelReservation.setBackground(new java.awt.Color(255, 255, 102));
        btnCancelReservation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelReservation.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelReservation.setText("Otkazi rezervaciju");
        btnCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelReservationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCancelReservation)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelReservationActionPerformed
        if (tableRezervacija.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Molimo odaberite rezervaciju!");
            return;
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni da zelite da otkazete rezervaciju?", "Warning", dialogButton);
        if(dialogResult == JOptionPane.NO_OPTION){
            return;
        }
        
        int selectedRow = tableRezervacija.getSelectedRow();
        
        String pozicijaName = tableRezervacija.getValueAt(selectedRow, 2).toString();
        
        String terminDate = tableRezervacija.getValueAt(selectedRow, 1).toString();        
        //terminDate = 29-10-2021 19:05:00, mora da se prebaci u terminDate = 2021-10-29 19:05:00 pre ubacivanja u bazu
        String dateFormatted = HelperClass.formatDateToMySqlFormat(terminDate);
        
        //find termin id
        var termin = new Termin();
        int terminId = termin.getTerminId(dateFormatted);
        
        var pozicija = new Pozicija();
        int pozicijaId = pozicija.getPozicijaId(pozicijaName);

        if (termin.checkIfShowIsFinished(terminId) == true) {
            JOptionPane.showMessageDialog(null, "Ne mozete otkazati rezervaciju za predstavu koja se vec zavrsila", "Obavestenje", 1);
            return;
        }
        
        if (termin.checkIfStartsBefore24Hours(terminId) == true) {
            JOptionPane.showMessageDialog(null, "Ne mozete otkazati rezervacije za predstave koje pocinju za manje od 24h.", "Obavestenje", 2);
            return;
        }
        
        //ako ima - onda delete from reservations where termin = idtermin, idkorisnik = id, idpozicija = idpozicija
        if(rezervacija.CancelReservation(terminId, Globals.loggedUserId, pozicijaId)) {
            JOptionPane.showMessageDialog(null, "Uspesno ste otkazali rezervaciju", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            rezervacija.PopulateTable(tableRezervacija);
        }
        
    }//GEN-LAST:event_btnCancelReservationActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
       dispose();
       HomePage homePage = new HomePage();
       homePage.setVisible(true);
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
            java.util.logging.Logger.getLogger(PregledRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregledRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregledRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregledRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregledRezervacija().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelReservation;
    private javax.swing.JButton btnHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRezervacija;
    // End of variables declaration//GEN-END:variables
}
