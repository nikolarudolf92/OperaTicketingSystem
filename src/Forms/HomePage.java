
package Forms;

import Classes.Globals;
import Classes.User;
import java.awt.Toolkit;


 
public class HomePage extends javax.swing.JFrame {
    User user;
    
    public HomePage() {
        initComponents();
        user = new User(Globals.loggedUserId);
        labelWelcome.setText("Dobrodosli " + user.getFirstName());
        icon();
        
        if(!user.isAdmin()) {
            btnZakaziPredstavu.setVisible(false);
        }
        displayRole();
    }
    
    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }
    
    private void displayRole() {
        if(!user.isAdmin()) {
            comboRole.setVisible(false);
            btnSetRole.setVisible(false);
        }
        else {
            fillComboRole();
        }
    }
    
    private void fillComboRole() {
        comboRole.removeAllItems();
        comboRole.addItem("Administrator");
        comboRole.addItem("Korisnik");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        comboRole = new javax.swing.JComboBox<>();
        btnSetRole = new javax.swing.JButton();
        btnRezervacijaKarata = new javax.swing.JButton();
        btnPregledRezervacija = new javax.swing.JButton();
        btnZakaziPredstavu = new javax.swing.JButton();
        labelWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(510, 400));
        setSize(new java.awt.Dimension(0, 0));

        btnLogout.setBackground(new java.awt.Color(51, 255, 255));
        btnLogout.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout.setText("Odjavi se");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        comboRole.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSetRole.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSetRole.setText("Promeni rolu");
        btnSetRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetRoleActionPerformed(evt);
            }
        });

        btnRezervacijaKarata.setBackground(new java.awt.Color(255, 255, 102));
        btnRezervacijaKarata.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRezervacijaKarata.setForeground(new java.awt.Color(51, 51, 51));
        btnRezervacijaKarata.setText("Rezervisi kartu za predstavu");
        btnRezervacijaKarata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervacijaKarataActionPerformed(evt);
            }
        });

        btnPregledRezervacija.setBackground(new java.awt.Color(255, 255, 102));
        btnPregledRezervacija.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnPregledRezervacija.setForeground(new java.awt.Color(0, 0, 0));
        btnPregledRezervacija.setText("Pregled vasih rezervacija");
        btnPregledRezervacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregledRezervacijaActionPerformed(evt);
            }
        });

        btnZakaziPredstavu.setBackground(new java.awt.Color(255, 255, 102));
        btnZakaziPredstavu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnZakaziPredstavu.setForeground(new java.awt.Color(0, 0, 0));
        btnZakaziPredstavu.setText("Zakazi novu predstavu");
        btnZakaziPredstavu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziPredstavuActionPerformed(evt);
            }
        });

        labelWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRezervacijaKarata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPregledRezervacija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnZakaziPredstavu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSetRole, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogout)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSetRole)
                .addGap(52, 52, 52)
                .addComponent(btnRezervacijaKarata)
                .addGap(26, 26, 26)
                .addComponent(btnPregledRezervacija)
                .addGap(29, 29, 29)
                .addComponent(btnZakaziPredstavu)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetRoleActionPerformed
        if(comboRole.getSelectedItem().toString() == "Administrator") {
            btnZakaziPredstavu.setVisible(true);
        }
        else {
            btnZakaziPredstavu.setVisible(false);
        }
    }//GEN-LAST:event_btnSetRoleActionPerformed

    private void btnRezervacijaKarataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervacijaKarataActionPerformed
       dispose();
       NovaRezervacija novaRezForm = new NovaRezervacija();
       novaRezForm.setVisible(true);
    }//GEN-LAST:event_btnRezervacijaKarataActionPerformed

    private void btnPregledRezervacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregledRezervacijaActionPerformed
       dispose();
       PregledRezervacija pregledRezForm = new PregledRezervacija();
       pregledRezForm.setVisible(true);
    }//GEN-LAST:event_btnPregledRezervacijaActionPerformed

    private void btnZakaziPredstavuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziPredstavuActionPerformed
        dispose();
        NewPredstava newPredstavaForm = new NewPredstava();
        newPredstavaForm.setVisible(true);
        
    }//GEN-LAST:event_btnZakaziPredstavuActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Globals.loggedUserId = 0;
        dispose();
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPregledRezervacija;
    private javax.swing.JButton btnRezervacijaKarata;
    private javax.swing.JButton btnSetRole;
    private javax.swing.JButton btnZakaziPredstavu;
    private javax.swing.JComboBox<String> comboRole;
    private javax.swing.JLabel labelWelcome;
    // End of variables declaration//GEN-END:variables
}
