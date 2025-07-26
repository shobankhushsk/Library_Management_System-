/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.DBManager;
import DatabaseManager.Encode;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Farhan Hyder
 */
public class BookFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookFrame
     */
    public BookFrame() {
        initComponents();
        getFaculty();
        getDepartment();
       getBooks();
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }

    private void getFaculty(){
    
      try {
            Vector v = DBManager.getFaculty();   
            
            for(int i = 0; i<v.size(); i++){
                this.facultyComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
    private void  getDepartment(){
     try {
            Vector v = DBManager.getDepartment();   
            
            for(int i = 0; i<v.size(); i++){
                this.departmentComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
  private void getBooks(){
     
       DepartmentBean  bean = (DepartmentBean)this.departmentComboBox.getSelectedItem();
       if(bean==null)return;
   
       try {
           int deptId = bean.getDeptId();
            Vector v = DBManager.getBook(deptId);
            booktitleList.setListData(v);  
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  
  
  
  
  
    private void deleteRecord(){
      
        BookBean  bean = (BookBean ) booktitleList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DBManager.deleteBook(bean.getBookId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
          getBooks();
          clear();
            
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"THIS BOOKS IS ALRADY ISSUE");
        }
   }
    
      private void addRecord(){
       DepartmentBean  bean = (DepartmentBean)this.departmentComboBox.getSelectedItem();
        
        int deptId = bean.getDeptId();
        String remarks = remarksTextArea.getText(); 
        try {
            int row = DBManager.addBook(deptId,bookTileTextField.getText(),authorTextField.getText(),volumeTextField.getText(),quantityTextField.getText(),priceTextField.getText(),purchaseFromTextField.getText(),dateOfPurchaseTextField.getText(),isbTextField.getText(),accessNoTextField.getText(),yearOfPublishedTextField.getText(),noPagesTextField.getText(),publisherNameTextField.getText(),remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getBooks();
            clear();
            
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
        private void updateRecord(){
         BookBean  bean = (BookBean)this.booktitleList.getSelectedValue();         
        int bookId = bean.getBookId();
        if(bean==null)return;
        try {  
             String remarks = remarksTextArea.getText();            
            int row = DBManager.updateBook(bookId,bookTileTextField.getText(),authorTextField.getText(),volumeTextField.getText(),quantityTextField.getText(),priceTextField.getText(),purchaseFromTextField.getText(),dateOfPurchaseTextField.getText(),isbTextField.getText(),accessNoTextField.getText(),yearOfPublishedTextField.getText(),noPagesTextField.getText(),publisherNameTextField.getText(),remarks);
           if(row>0){
                System.out.println("SUCCESSFULLY");
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
                getBooks();
                 clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        }catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 }  
    
    private void clear(){
   bookIdTextField.setText(" ");     
    bookTileTextField.setText(" ");
    authorTextField.setText("");
    volumeTextField.setText("");
    yearOfPublishedTextField.setText("");
    quantityTextField.setText("");
    priceTextField.setText("");
    purchaseFromTextField.setText("");
    dateOfPurchaseTextField.setText("");
    accessNoTextField.setText("");
    isbTextField.setText("");
    publisherNameTextField.setText("");
    noPagesTextField.setText("");  
    remarksTextArea.setText("");
    
    
    
    }
     
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        bookIdTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bookTileTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        volumeTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        yearOfPublishedTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        purchaseFromTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dateOfPurchaseTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        accessNoTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        isbTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        noPagesTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        publisherNameTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        booktitleList = new javax.swing.JList();
        backButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK TITLE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 400, 60));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 710, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("NUMBER OF PAGES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 260, 30));

        departmentComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 710, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, 30));

        bookIdTextField.setEditable(false);
        bookIdTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(bookIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 270, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ACCESS NO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 190, -1));

        bookTileTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(bookTileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 720, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("BOOK TITLE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 150, 40));

        authorTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(authorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 720, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("AUTHOR / EDITOR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, 50));

        volumeTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(volumeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 720, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("VOLUME / EDITION");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 210, 40));

        yearOfPublishedTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(yearOfPublishedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 140, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("BOOK ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, 30));

        quantityTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 140, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ISB");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 140, 30));

        priceTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 160, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("REMARKS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 190, -1));

        purchaseFromTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(purchaseFromTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 730, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("PURCHASED FROM");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 210, 30));

        dateOfPurchaseTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(dateOfPurchaseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 170, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("QUANTITY");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 120, 30));

        accessNoTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(accessNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 160, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PRICE");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 90, 30));

        isbTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(isbTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 170, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("DATE OF PURCHASE");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 220, 40));

        noPagesTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(noPagesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 170, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("YEAR OF PUBLISHED ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 230, 40));

        publisherNameTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(publisherNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 290, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("PUBLISHER NAME ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 200, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 740, 180));

        addButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, 140, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 150, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 690, 150, 60));

        clearButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 690, 160, 60));

        booktitleList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        booktitleList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                booktitleListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(booktitleList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 330, 590));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 690, 330, 70));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("BOOKS");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 10, 1920, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
          clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
        
             FacultyBean selectedBean = (FacultyBean) this.facultyComboBox.getSelectedItem();        
        try {
            Vector vec = DBManager.getDepartment(selectedBean.getFacId());
            this.departmentComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.departmentComboBox.addItem(vec.elementAt(i));
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void booktitleListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_booktitleListValueChanged
        // TODO add your handling code here:
        
           BookBean  bean = (BookBean ) booktitleList.getSelectedValue();  
        
       if(bean==null)return; 
        
     this.bookIdTextField.setText(""+bean.getBookId());
     bookTileTextField.setText(bean.getBookName());
    authorTextField.setText(bean.getAuthorEditor());
    volumeTextField.setText(bean.getVolumeEdition());
    yearOfPublishedTextField.setText(bean.getYearOfpublish());
    quantityTextField.setText(bean.getQuantity());
    priceTextField.setText(bean.getPrice());
    purchaseFromTextField.setText(bean.getPurchaseFrome());
    dateOfPurchaseTextField.setText(bean.getDataOfRurchase());
    accessNoTextField.setText(bean.getAccessNo());
    isbTextField.setText(bean.getIseNo());
    publisherNameTextField.setText(bean.getPublisherName());
    noPagesTextField.setText(bean.getNumberOfPages());
    //volumeTextField.setText(bean.getVolumeEdition());
    remarksTextArea.setText(bean.getRemarks());
    
    
        
    }//GEN-LAST:event_booktitleListValueChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here:
        
        DepartmentBean selectedBean = (DepartmentBean) this.departmentComboBox.getSelectedItem();        
               if(selectedBean==null) return;
             try {
            Vector vec = DBManager.getBook(selectedBean.getDeptId());
             //booktitleList.remove(this);
                this.booktitleList.setListData(vec);
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessNoTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField bookIdTextField;
    private javax.swing.JTextField bookTileTextField;
    private javax.swing.JList booktitleList;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField dateOfPurchaseTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField isbTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField noPagesTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField publisherNameTextField;
    private javax.swing.JTextField purchaseFromTextField;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField volumeTextField;
    private javax.swing.JTextField yearOfPublishedTextField;
    // End of variables declaration//GEN-END:variables
}
