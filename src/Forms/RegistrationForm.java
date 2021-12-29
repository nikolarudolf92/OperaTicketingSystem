
package Forms;

import Classes.Account;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class RegistrationForm extends javax.swing.JFrame {
    
    private Account account;
    
    public RegistrationForm() {
        initComponents();
        account = new Account();
        icon();
        
    }
    private void icon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carmina-burana.png")));
    }
    
    private void clearForm() {
        tbUsername.setText("");
        tbFirstName.setText("");
        tbLastName.setText("");
        tbEmail.setText("");
        jPassword.setText("");
        tbPhoneNumber.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbFirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        tbPhoneNumber = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnOpenLoginForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRACIJA");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(new java.awt.Dimension(10, 10));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Korisnicko ime");

        tbUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUsernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Ime");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Prezime");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Email");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setText("Sifra");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setText("Broj telefona");

        btnConfirm.setBackground(new java.awt.Color(255, 255, 102));
        btnConfirm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirm.setText("Potvrdi");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnOpenLoginForm.setBackground(new java.awt.Color(102, 255, 255));
        btnOpenLoginForm.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        btnOpenLoginForm.setForeground(new java.awt.Color(0, 0, 0));
        btnOpenLoginForm.setText("Vec imate nalog? Kliknite ovde da se prijavite");
        btnOpenLoginForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenLoginFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbEmail)
                            .addComponent(tbPhoneNumber)
                            .addComponent(jPassword)
                            .addComponent(tbFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(tbUsername)
                            .addComponent(tbLastName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnOpenLoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnConfirm)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(28, 28, 28)
                .addComponent(btnOpenLoginForm)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsernameActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String username = tbUsername.getText();
        String firstName = tbFirstName.getText();
        String lastname = tbLastName.getText();
        String email = tbEmail.getText();
        String password = new String(jPassword.getPassword());
        String phoneNumber = tbPhoneNumber.getText();
        
        int wasSuccessful = account.register(username, firstName, lastname, email, password, phoneNumber);
        if(wasSuccessful == -1) {
            JOptionPane.showMessageDialog(null, "Morate pravilno uneti podatke u formi.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(wasSuccessful == 0) {
            JOptionPane.showMessageDialog(null, "Korisnicko ime je zauzeto. ", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(wasSuccessful == 1) {
            clearForm();
            JOptionPane.showMessageDialog(null, "Uspesno ste se registrovali! Mozete se ulogovati sa vasim kredencijalima", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            return;
         }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnOpenLoginFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenLoginFormActionPerformed
        dispose();
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }//GEN-LAST:event_btnOpenLoginFormActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnOpenLoginForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFirstName;
    private javax.swing.JTextField tbLastName;
    private javax.swing.JTextField tbPhoneNumber;
    private javax.swing.JTextField tbUsername;
    // End of variables declaration//GEN-END:variables
}
