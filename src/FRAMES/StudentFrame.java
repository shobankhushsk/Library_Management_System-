/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.DBManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class StudentFrame extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    public StudentFrame() {
        initComponents();
        getFaculty();
       getDepartment();
        getProgram();
        getBatch();
    //    getStudents();
        
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
    
    private void  getProgram(){
    try {
            Vector v = DBManager.getProgram();   
            
            for(int i = 0; i<v.size(); i++){
                this.programComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    private void getBatch(){
       try {
            Vector v = DBManager.getBatch();   
            
            for(int i = 0; i<v.size(); i++){
                this.batchYearComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

   
    private void getStudents(){
      BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();
      if(selectedBean==null)return;  
      try {
            int batchId = selectedBean.getBatchId();
            Vector v = DBManager.getStudent(batchId);   
            this.rollNoList.setListData(v);
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
    }
    
    
     private void addRecord(){
    
     BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();
        
       int batchId = selectedBean.getBatchId();
       String  name = nameTextField.getText();
       String  fName = fatherNameTextField.getText();
       String surName=surNameTextField.getText();
       String rollNo=rollNoTextField.getText();
       String remarks = remarksTextArea.getText();
       
        
        try {
            int row = DBManager.addStudent(batchId,name,fName,surName,rollNo,remarks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getStudents();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
      private void deleteRecord(){
      
        StudentsBean  bean = (StudentsBean ) rollNoList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DBManager.deleteStudent(bean.getStudId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
                getStudents();
            
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }  
      
      
      private void updateRecord(){
      
        StudentsBean  bean = (StudentsBean) rollNoList.getSelectedValue();  
        if(bean==null)return;
        try {
             //int row = DBManager.updateFaculty(bean.getFacId());
             //updateBatch(int batchId, String shift, int batchYear, String groupDes, String remarks)        
             //(int studId,String studName,String fatherName,String surName,String rollNo,String,String remarks)            
            int row = DBManager.updateStudent(bean.getStudId(),nameTextField.getText(),fatherNameTextField.getText(),surNameTextField.getText(),rollNoTextField.getText(),remarksTextArea.getText());
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               
               getStudents();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 }  
    
      private void clear(){
       this.studentIdTextField.setText("");
       this.nameTextField.setText("");
       this.fatherNameTextField.setText("");
       this.surNameTextField.setText("");
       this.rollNoTextField.setText("");
       this.remarksTextArea.setText("");
     } 
    
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        studentIdTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        surNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        addButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JToggleButton();
        clearButton1 = new javax.swing.JToggleButton();
        backButton1 = new javax.swing.JToggleButton();
        shiftComboBox = new javax.swing.JComboBox<>();
        groupComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 220, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 90, 30));

        facultyComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 650, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("DEPARTMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, 30));

        departmentComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 650, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText(" PROGRAM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 100, 30));

        programComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 650, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("BATCH YEAR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 120, -1));

        batchYearComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        batchYearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchYearComboBoxItemStateChanged(evt);
            }
        });
        batchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 120, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("SHIFT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 60, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GROUP");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 80, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("STUDENT ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 120, 30));

        studentIdTextField.setEditable(false);
        studentIdTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        studentIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(studentIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 120, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("NAME");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 60, 30));

        nameTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 330, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("FATHER's NAME");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 150, 30));

        fatherNameTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(fatherNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 330, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("SURNAME");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 100, 30));

        surNameTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(surNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 330, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("ROLL-NO");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 90, 30));

        rollNoTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rollNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 330, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("REMARKS");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 120, 30));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 650, 200));

        rollNoList.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 320, 630));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("ROLL NO");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 120, -1));

        addButton1.setBackground(new java.awt.Color(242, 242, 242));
        addButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addButton1.setText("ADD");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 750, 130, 40));

        updateButton1.setBackground(new java.awt.Color(242, 242, 242));
        updateButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton1.setText("UPDATE");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 750, 130, 40));

        deleteButton1.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 750, 120, 40));

        clearButton1.setBackground(new java.awt.Color(242, 242, 242));
        clearButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 750, 120, 40));

        backButton1.setBackground(new java.awt.Color(242, 242, 242));
        backButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backButton1.setText("BACK");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 740, 230, 50));

        shiftComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MORNING", "EVENING", "NOON" }));
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 110, 30));

        groupComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEDICAL", "ENGINEERING", "COMMERCE", "GENERAL" }));
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void rollNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollNoTextFieldActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();   
    }//GEN-LAST:event_backButton1ActionPerformed

    private void studentIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdTextFieldActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
        // TODO add your handling code here:
       StudentsBean  bean = (StudentsBean) rollNoList.getSelectedValue(); 
       if(bean==null)return;  
       this.studentIdTextField.setText(""+bean.getStudId());
       this.nameTextField.setText(bean.getStudName());
       this.fatherNameTextField.setText(bean.getFname());
       this.surNameTextField.setText(bean.getSurName());
       this.rollNoTextField.setText(bean.getRollNo());
       this.remarksTextArea.setText(bean.getRemarks());
             
    }//GEN-LAST:event_rollNoListValueChanged

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

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        // TODO add your handling code here:
           ProgramsBean selectedBean = (ProgramsBean) this.programComboBox.getSelectedItem();        
     
         if(selectedBean==null)return;     
        try {
          Vector v = DBManager.getBatch(selectedBean.getProgId());
          this.batchYearComboBox.removeAllItems();
          for(int i = 0; i<v.size(); i++){  
            this.batchYearComboBox.addItem(v.elementAt(i));
          }
       }catch (Exception ex) {
             Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_programComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        //TODO add your handling code here:
        
        DepartmentBean selectedBean = (DepartmentBean) this.departmentComboBox.getSelectedItem();        
        if(selectedBean==null)return;     
        try {
            
            Vector v = DBManager.getProgram(selectedBean.getDeptId());
            this.programComboBox.removeAllItems();
            for(int i = 0; i<v.size(); i++){ 
            this.programComboBox.addItem(v.elementAt(i));
         }
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
     
        BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();         
        if(selectedBean==null)return;     
          shiftComboBox.setSelectedItem(DatabaseManager.Decoder.shiftDecode(selectedBean.getShift()));
          groupComboBox.setSelectedItem(DatabaseManager.Decoder.groupDecode(selectedBean
                .getGroupDesc()));
        try {
            
            Vector v = DBManager.getStudent(selectedBean.getBatchId());
            //this.rollNoList.removeAllItems();
              this.rollNoList.setListData(v);
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JToggleButton backButton1;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JToggleButton clearButton1;
    private javax.swing.JToggleButton deleteButton1;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JComboBox<String> groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JComboBox<String> shiftComboBox;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JTextField surNameTextField;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
