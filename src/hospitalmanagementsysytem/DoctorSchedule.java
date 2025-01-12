/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsysytem;

import static hospitalmanagementsysytem.Doctor.lblRoom;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author navee
 */
public class DoctorSchedule extends javax.swing.JFrame {

    /**
     * Creates new form DoctorShedule
     */
    public DoctorSchedule() {

        initComponents();
        Connect();
        table_update();
        AutoID();

        //BC PICTURE
        ImageIcon myImage1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/SRC/BC.jpeg")));
        Image img10 = myImage1.getImage();
        Image img20 = img10.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ii = new ImageIcon(img20);
        jLabel1.setIcon(ii);

        //Small panel BC PICTURE
        ImageIcon myImage1m = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/SRC/UcreationBC.png")));
        Image img10m = myImage1m.getImage();
        Image img20m = img10m.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iim = new ImageIcon(img20m);
        jLabel2.setIcon(iim);

    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp_hms", "root", "");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public final void AutoID() {
        try {
            java.sql.Statement s = con.createStatement();
            rs = s.executeQuery("SELECT MAX(She_ID ) FROM doctor_shedule");
            rs.next();
            String maxPatientNo = rs.getString("MAX(She_ID )");
            if (maxPatientNo == null) {
                lblSheID.setText("Sh001");
            } else {
                int id = Integer.parseInt(maxPatientNo.substring(2));
                id++;
                String newPatientNo = String.format("Sh%03d", id);
                lblSheID.setText(newPatientNo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void table_update() {
        int CC;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp_hms", "root", "");
            pst = con.prepareStatement("SELECT * FROM doctor_shedule");
            ResultSet Rs = pst.executeQuery();
            java.sql.ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("She_ID"));
                    v2.add(Rs.getString("Doctor_ID"));
                    v2.add(Rs.getString("DoctorName"));
                    v2.add(Rs.getString("Day1"));
                    v2.add(Rs.getString("TimePeriode1"));
                    v2.add(Rs.getString("Day2"));
                    v2.add(Rs.getString("TimePeriode2"));
                }
                DFT.addRow(v2);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoctorSchedule.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbDay2 = new javax.swing.JComboBox();
        cmbDay1 = new javax.swing.JComboBox();
        cmbTime1 = new javax.swing.JComboBox();
        cmbTime2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        lblDname = new javax.swing.JLabel();
        txtDoctorID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblSheID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnADD = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Doctor Schedule Creater");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 460, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Schedule ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Doctor ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Doctor Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("1 st Day");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("2 nd Day");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Working days");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        cmbDay2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDay2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MonDay", "TuesDay", "WednesDay", "ThursDay", "FriDay", "SaturDay", "SunDay", " " }));
        cmbDay2.setSelectedIndex(-1);
        jPanel2.add(cmbDay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 150, 30));

        cmbDay1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDay1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MonDay", "TuesDay", "WednesDay", "ThursDay", "FriDay", "SaturDay", "SunDay", " " }));
        cmbDay1.setSelectedIndex(-1);
        jPanel2.add(cmbDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 233, 150, 30));

        cmbTime1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbTime1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07.00 am - 10.00 am", "01.00 pm - 05.00 pm", "06.00 pm - 10.00 pm" }));
        cmbTime1.setSelectedIndex(-1);
        jPanel2.add(cmbTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 170, 30));

        cmbTime2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbTime2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07.00 am - 10.00 am", "01.00 pm - 05.00 pm", "06.00 pm - 10.00 pm" }));
        cmbTime2.setSelectedIndex(-1);
        cmbTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTime2ActionPerformed(evt);
            }
        });
        jPanel2.add(cmbTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 170, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Day");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 40, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Time Period");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, 20));

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 480, 220));

        lblDname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblDname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 147, 300, 30));

        txtDoctorID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtDoctorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 190, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Schedule View Table");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 330, 50));

        lblSheID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblSheID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 57, 300, 30));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Schedule ID", "Doctor ID", "Doctor Name", "1 st Day", "Time period", "2 nd Day", "Time Periode"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 710, 440));

        btnADD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnADD.setText("Add");
        btnADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        jPanel2.add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 240, 40));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 240, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 240, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Exit");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 240, 40));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, 240, 40));

        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel2.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SRC/UcreationBC.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 640));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1310, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SRC/BC.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1370, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        if (txtDoctorID.getText() == null || lblDname.getText() == null || cmbDay1.getSelectedItem() == null || cmbTime1.getSelectedItem() == null || cmbDay2.getSelectedItem() == null || cmbTime2.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Enter Doctor ID and Fill Doctor Name");
        } else {

            String SheID = lblSheID.getText();
            String did = txtDoctorID.getText();
            String dName = lblDname.getText();
            String Day1 = (String) cmbDay1.getSelectedItem();
            String Time1 = (String) cmbTime1.getSelectedItem();
            String Day2 = (String) cmbDay2.getSelectedItem();
            String Time2 = (String) cmbTime2.getSelectedItem();

            try {
                pst = con.prepareStatement("UPDATE doctor_shedule set Doctor_ID=?,DoctorName=?,Day1=?,TimePeriode1=?,Day2=?,TimePeriode2=? WHERE She_ID=?");
                pst.setString(1, did);
                pst.setString(2, dName);
                pst.setString(3, Day1);
                pst.setString(4, Time1);
                pst.setString(5, Day2);
                pst.setString(6, Time2);
                pst.setString(7, SheID);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, " DoctorSchedule Information successfully UPDATED");

                AutoID();
                txtDoctorID.setText("");
                txtDoctorID.requestFocus();
                table_update();

            } catch (SQLException ex) {
                Logger.getLogger(DoctorSchedule.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("update not work");
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTime2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTime2ActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        // TODO add your handling code here:
        if (txtDoctorID.getText() == null || lblDname.getText() == null || cmbDay1.getSelectedItem() == null || cmbTime1.getSelectedItem() == null || cmbDay2.getSelectedItem() == null || cmbTime2.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Enter Doctor ID and Fill Doctor Name");
        } else {

            String SheID = lblSheID.getText();
            String did = txtDoctorID.getText();
            String dName = lblDname.getText();
            String Day1 = (String) cmbDay1.getSelectedItem();
            String Time1 = (String) cmbTime1.getSelectedItem();
            String Day2 = (String) cmbDay2.getSelectedItem();
            String Time2 = (String) cmbTime2.getSelectedItem();

            try {
                pst = con.prepareStatement("INSERT INTO doctor_shedule (She_ID ,Doctor_ID,DoctorName,Day1,TimePeriode1,Day2,TimePeriode2) VALUES (?,?,?,?,?,?,?)");
                pst.setString(1, SheID);
                pst.setString(2, did);
                pst.setString(3, dName);
                pst.setString(4, Day1);
                pst.setString(5, Time1);
                pst.setString(6, Day2);
                pst.setString(7, Time2);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, " DoctorSchedule Information successfully ADDED");

                AutoID();
                txtDoctorID.setText("");
                txtDoctorID.requestFocus();
                table_update();

            } catch (SQLException ex) {
                Logger.getLogger(DoctorSchedule.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Adding not work");
            }
        }

    }//GEN-LAST:event_btnADDActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtDoctorID.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();

        lblSheID.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtDoctorID.setText(d1.getValueAt(SelectIndex, 1).toString());
        cmbDay1.setSelectedItem(d1.getValueAt(SelectIndex, 2).toString());
        cmbTime1.setSelectedItem(d1.getValueAt(SelectIndex, 3).toString());
        cmbDay2.setSelectedItem(d1.getValueAt(SelectIndex, 4).toString());
        cmbTime2.setSelectedItem(d1.getValueAt(SelectIndex, 5).toString());

        btnADD.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gp_hms", "root", "");

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }

        try {
            pst = con.prepareStatement("select DoctorName from doctor where DoctorNo=? ");
            String id = txtDoctorID.getText();
            pst.setString(1, id);
            ResultSet rs1 = pst.executeQuery();
            if (rs1.next() == false) {
                JOptionPane.showMessageDialog(this, "Sorry Record Not Found");
                txtDoctorID.setText("");
                txtDoctorID.requestFocus();
            } else {

                lblDname.setText(rs1.getString("DoctorName"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DoctorSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnOkActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you Want To Delete ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String dno = lblSheID.getText();

            try {
                pst = con.prepareStatement("DELETE FROM doctor_shedule WHERE She_ID=?");

                pst.setString(1, dno);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, " Shedule Information DELETED successfully");

                AutoID();

                table_update();

                btnADD.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbDay1;
    private javax.swing.JComboBox cmbDay2;
    private javax.swing.JComboBox cmbTime1;
    private javax.swing.JComboBox cmbTime2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDname;
    private javax.swing.JLabel lblSheID;
    private javax.swing.JTextField txtDoctorID;
    // End of variables declaration//GEN-END:variables
}
