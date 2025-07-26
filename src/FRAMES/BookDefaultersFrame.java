/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;



import DatabaseManager.DBManager;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Dell
 */
public final class BookDefaultersFrame extends javax.swing.JFrame {
private static Connection con;
    private static Statement st=null;
    private static ResultSet rs =null; 
    /**
     * Creates new form BookDefaultersFrame
     */
    public BookDefaultersFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String dbPath = "E:\\JAVA_Programs_A_To_Z\\DataBase\\DB_LIBRARY_MANAGEMENT.accdb";
        String url = "jdbc:ucanaccess://" + dbPath;
        con = DriverManager.getConnection(url);

            //   DBManager.qureyShow();
               
               
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        //DataShow();
    }
    
    
    
    public void DataShow(){
    
    String starDate=startDateTextField.getText();
    String endDate= endDateTextField.getText();       
    String sql="select std.STUD_NAME,std.ROLL_NO,b.BOOKS_NAME,bi.DATE_OF_ISSUE FROM Students std, books b,books_issue bi where bi.STUD_ID=std.STUD_ID AND bi.BOOK_ID=b.BOOKS_ID AND bi.DATE_OF_ISSUE>=#"+starDate+"# AND bi.DATE_OF_ISSUE<=#"+endDate+"#";
    // System.out.println(sql);
  try{
      PreparedStatement pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      DefaultTableModel model=(DefaultTableModel)bookjTable1.getModel();
      while(rs.next()){
          
           
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDateTime datetime = LocalDateTime.parse(rs.getString("DATE_OF_ISSUE"), inputFormatter);
        LocalDate date = datetime.toLocalDate();
        String formattedDate = outputFormatter.format(date);
  
          
          model.addRow(new String[]{rs.getString("STUD_NAME"),rs.getString("ROLL_NO"),rs.getString("BOOKS_NAME"),formattedDate});
      
          ///System.out.println(rs.getString("DATE_OF_ISSUE"));
     }
  }catch(Exception e){JOptionPane.showMessageDialog(null,"Invalid Date"+e);}
  }   
     
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookjTable1 = new javax.swing.JTable();
        endDateTextField = new javax.swing.JTextField();
        startDateTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        searchButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("BOOK DEFAULTY");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(590, 0, 310, 48);

        bookjTable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bookjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student", "Roll-NO", "BookTitle", "Book_Issue_Date"
            }
        ));
        jScrollPane1.setViewportView(bookjTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 150, 1270, 440);

        endDateTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(endDateTextField);
        endDateTextField.setBounds(430, 100, 170, 30);

        startDateTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(startDateTextField);
        startDateTextField.setBounds(70, 100, 170, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Start Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 70, 90, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("End Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 71, 90, 25);

        saveButton.setBackground(new java.awt.Color(0, 0, 204));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        saveButton.setText("SAVE.CSV");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(70, 600, 190, 50);

        searchButton1.setBackground(new java.awt.Color(255, 51, 51));
        searchButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        searchButton1.setText("SEARCH");
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton1);
        searchButton1.setBounds(650, 90, 150, 40);

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 0));
        jToggleButton1.setText("CLEAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(260, 90, 120, 40);

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 0));
        jToggleButton2.setText("BACK");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2);
        jToggleButton2.setBounds(280, 600, 180, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:        
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        
      if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
        try {
                FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                TableModel model = bookjTable1.getModel();

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        bw.write(model.getValueAt(i, j).toString());
                        if (j < model.getColumnCount() - 1) {
                            bw.write(",");
                        }
                    }
                    bw.newLine();
                 }/// end of Inner loop
                // Close the BufferedWriter object and the FileWriter object.
                    bw.close();
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
                JOptionPane.showMessageDialog(null, "Selected file to save: " + fileToSave.getAbsolutePath());
        }/// end of if 
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        // TODO add your handling code here:
          this.DataShow();
    }//GEN-LAST:event_searchButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        this.startDateTextField.setText(" ");
        this.endDateTextField.setText(" ");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

  
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
            java.util.logging.Logger.getLogger(BookDefaultersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDefaultersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDefaultersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDefaultersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookDefaultersFrame().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BookDefaultersFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BookDefaultersFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookjTable1;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton1;
    private javax.swing.JTextField startDateTextField;
    // End of variables declaration//GEN-END:variables

   
}
