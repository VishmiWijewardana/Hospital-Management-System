/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsysytem;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author navee
 */
public class FrogotPassword extends javax.swing.JFrame {

    /**
     * Creates new form FrogotPassword
     */
    public FrogotPassword() {
        initComponents();
        Connect();
        
        //BC PICTURE
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/SRC/ChangePasswordBC.jpg")));
        Image img1 = myImage.getImage();
        Image img2 = img1.getScaledInstance(lblBC.getWidth(), lblBC.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        lblBC.setIcon(i);
        
        
        
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp_hms", "root", "");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUname = new javax.swing.JTextField();
        btnChangePass = new javax.swing.JButton();
        txtOldPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfPass = new javax.swing.JPasswordField();
        lblUname = new javax.swing.JLabel();
        lblOldPass = new javax.swing.JLabel();
        lblConfPass = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        lblBC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 0, 204))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 43, 219, -1));

        btnChangePass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChangePass.setText("Change Password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, 40));
        jPanel1.add(txtOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 113, 217, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Old Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 114, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("User Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 46, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("New Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 176, -1, -1));
        jPanel1.add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 175, 219, 31));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Confirm Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 225, -1, -1));
        jPanel1.add(txtConfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 224, 219, 31));

        lblUname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUname.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 78, 219, -1));

        lblOldPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOldPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 147, 217, -1));

        lblConfPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblConfPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblConfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 266, 219, -1));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 150, 40));

        lblBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SRC/ChangePasswordBC.jpg"))); // NOI18N
        jPanel1.add(lblBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        String Uname, OldPass, NewPass, ConfPass;
        Uname = txtUname.getText();
        OldPass = txtOldPass.getText();
        NewPass = txtNewPass.getText();
        ConfPass = txtConfPass.getText();
        String sql = "SELECT * FROM user WHERE UserName='" + Uname + "'";
        String sql1 = "UPDATE user SET Password='" + NewPass + "'WHERE UserName='" + Uname + "' ";
        
       // JOptionpane.

        try{
            rs=pst.executeQuery(sql);
            if(rs.next())
            {
                if(rs.getString("Password").equals(OldPass))
                {
                    lblOldPass.setText("");
                    if(NewPass.equals(ConfPass))
                    {
                        lblConfPass.setText("");
                        pst.executeUpdate(sql);
                        
                    }else
                        {
                            lblConfPass.setText("Confirm Password Does not Match");
                            txtConfPass.requestFocus();
                        }
                }else
                    {
                        lblOldPass.setText("Inavalide Old Password");
                        txtOldPass.requestFocus();
                    }
                lblUname.setText("");
            }else
                {
                    lblUname.setText("Inavalide User Name");
                    txtUname.requestFocus();
                }
            
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_btnChangePassActionPerformed

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
            java.util.logging.Logger.getLogger(FrogotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrogotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrogotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrogotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrogotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBC;
    private javax.swing.JLabel lblConfPass;
    private javax.swing.JLabel lblOldPass;
    private javax.swing.JLabel lblUname;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
