
package Forms;

import Classes.Account;
import Classes.Globals;
import Classes.HelperClass;
import Classes.User;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class LoginForm extends javax.swing.JFrame {
    
    private Account account;
    
    
    public LoginForm() {
        icon();
        initComponents();
        account = new Account();
    }
    
    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbPassword = new javax.swing.JPasswordField();
        btnConfirm = new javax.swing.JButton();
        btnOpenRegistrationForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Korisnicko ime");

        tbUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUsernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Sifra");

        btnConfirm.setBackground(new java.awt.Color(255, 255, 102));
        btnConfirm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirm.setText("Prijava");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnOpenRegistrationForm.setBackground(new java.awt.Color(51, 255, 255));
        btnOpenRegistrationForm.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        btnOpenRegistrationForm.setForeground(new java.awt.Color(0, 0, 0));
        btnOpenRegistrationForm.setText("Nemate nalog? Kliknite ovde da se registrujete");
        btnOpenRegistrationForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOpenRegistrationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenRegistrationFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(tbPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnOpenRegistrationForm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(18, 18, 18)
                .addComponent(btnOpenRegistrationForm)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
       String username = tbUsername.getText();
       String password = new String(tbPassword.getPassword());
       
       if(HelperClass.isEmptyOrWhiteSpace(username) || HelperClass.isEmptyOrWhiteSpace(password)) {
           JOptionPane.showMessageDialog(null, "Morate da unesete tekst u sva polja na formi. ", "Warning", JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       boolean wasSuccessful = account.login(username, password);
       if(wasSuccessful == false) {
           JOptionPane.showMessageDialog(null, "Pogresno korisnicko ime ili lozinka. ", "Information", JOptionPane.INFORMATION_MESSAGE);
           return;
       }
       
       var loggedUser = new User(username);
       Globals.loggedUserId = loggedUser.getId();
          
       HomePage homePageForm = new HomePage();
       dispose();
       homePageForm.setVisible(true);
              
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnOpenRegistrationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenRegistrationFormActionPerformed
        dispose();
        RegistrationForm regForm = new RegistrationForm();
        regForm.setVisible(true);
    }//GEN-LAST:event_btnOpenRegistrationFormActionPerformed

    private void tbUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnOpenRegistrationForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tbPassword;
    private javax.swing.JTextField tbUsername;
    // End of variables declaration//GEN-END:variables
}
