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


public class BookIssueFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookIssueFrame
     */
    public BookIssueFrame() {
        initComponents();
        getFaculty();
        getBookFaculty();
        getDepartment();
        getBookDepartment();
        getProgram();
        getBatch();
       // getBookIssue();
        getBook();
        getStudents();
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }

     private void getFaculty(){
    
      try {
            Vector v = DBManager.getFaculty();   
            
            for(int i = 0; i<v.size(); i++){
                this.facultyComboBox1.addItem(v.elementAt(i));
               // bookFacultyComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     private void getBookFaculty(){
    
      try {
            Vector v = DBManager.getFaculty();   
            
            for(int i = 0; i<v.size(); i++){
                bookFacultyComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     
     
    
    private void  getDepartment(){
     try {
            Vector v = DBManager.getDepartment();   
            
            for(int i = 0; i<v.size(); i++){
                 this.departemtComboBox.addItem(v.elementAt(i));
                 bookDepartmentComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     private void  getBookDepartment(){
     try {
            Vector v = DBManager.getDepartment();   
            
            for(int i = 0; i<v.size(); i++){
                // this.departemtComboBox.addItem(v.elementAt(i));
                 bookDepartmentComboBox.addItem(v.elementAt(i));
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
               // this.bookTitleComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
     private void getBatch(){
      
       ProgramsBean  bean = (ProgramsBean) this.programComboBox.getSelectedItem();
       if(bean==null)return; 
       try {
           int progId = bean.getProgId();
            Vector v = DBManager.getBatch(progId);
            for(int i = 0; i<v.size(); i++){
              batchYearComboBox.addItem(v.elementAt(i));
            }
        }catch (Exception ex) {
         Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
     private void getStudents(){
         BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();
      if(selectedBean==null)return;  
      try {
             int batchId = selectedBean.getBatchId();
            Vector v = DBManager.getStudent(batchId);
            for(int i=0; i<v.size(); i++){      
            this.rollNoComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//      private void  getBookIssue(){
//    try {
//           
//         Vector v = DBManager.getBook();   
//          this.dateOfIssueList.setListData(v); 
//         // System.out.println(dateOfIssueList.setListData(v));
//        } catch (Exception ex) {
//            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
      
     
      private void  getBook(){
    try {
           
         Vector v = DBManager.getBook();   
          this.dateOfIssueList.setListData(v); 
         // System.out.println(dateOfIssueList.setListData(v));
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
     
     private void deleteRecord(){
      
        BookIssueBean  bean = (BookIssueBean) dateOfIssueList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DBManager.deleteBookIssue(bean.getStudId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }  
      
      
      
      private void addRecord(){
    
       StudentsBean selectedBean = (StudentsBean) this.rollNoComboBox.getSelectedItem();        
       int studId = selectedBean.getStudId();
       
       BookBean Bean = (BookBean) this.bookTitleComboBox.getSelectedItem();
       int bookid = Bean.getBookId();
    
       String  dateOfIssued = dateOfIssuedTextField1.getText();
       String  dateOfReturn = dateOfReturnTextField1.getText();  
       int fine=Integer.parseInt(fineTextField1.getText());
       String remaeks=remarksTextArea.getText();
       
        
        try {
            int row = DBManager.addBookIssue(studId,bookid,dateOfIssued,dateOfReturn,fine,remaeks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,"This way is valid Date  (Month/Date/Year) \n BUT This way is Unvalid Date (Date-Month-Year)");
            // Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
       
        private void updateRecord(){
      
        BookIssueBean  bean = (BookIssueBean) dateOfIssueList.getSelectedValue();  
        if(bean==null)return;
        try { 
            // JAVA MYSQL DATE FORMAT EXAMPLE JFRAME INPUT EXAMPLE
            int row = DBManager.updateBookIssue(bean.getBookIssueId(),dateOfIssuedTextField1.getText(),dateOfReturnTextField1.getText(),fineTextField1.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
           // Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"This way is valid Date  (Month/Date/Year) \n BUT This way is Unvalid Date (Date/Month/Year)");
        }
    
 }  
       
 public void clear(){
    
        bookIssueIdTextField1.setText(" ");
       dateOfIssuedTextField1.setText(" ");
       dateOfReturnTextField1.setText(" ");
       fineTextField1.setText(" ");
       
   
   }     
       
       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        rollNoComboBox = new javax.swing.JComboBox();
        bookTitleComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        bookDepartmentComboBox = new javax.swing.JComboBox();
        bookFacultyComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        surNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bookIssueIdTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dateOfIssuedTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dateOfReturnTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fineTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        publishedYearTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        bookIdTextField2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        studentIdTextField = new javax.swing.JTextField();
        authorTextField2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        editionTextField2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateOfIssueList = new javax.swing.JList();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        addButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        clearButton1 = new javax.swing.JButton();
        facultyComboBox1 = new javax.swing.JComboBox();
        departemtComboBox = new javax.swing.JComboBox();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK ISSUE");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 470, 59));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("FACULTY");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 130, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("PROGRAM");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 140, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("GROUP");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 70, 50));

        programComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 380, -1));

        rollNoComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rollNoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rollNoComboBoxItemStateChanged(evt);
            }
        });
        rollNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 170, 30));

        bookTitleComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookTitleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookTitleComboBoxItemStateChanged(evt);
            }
        });
        bookTitleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(bookTitleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 320, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("VOLUME EDITION");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 210, 30));

        bookDepartmentComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookDepartmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookDepartmentComboBoxItemStateChanged(evt);
            }
        });
        bookDepartmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookDepartmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(bookDepartmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 320, -1));

        bookFacultyComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookFacultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookFacultyComboBoxItemStateChanged(evt);
            }
        });
        bookFacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookFacultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(bookFacultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 320, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("FINE RS");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, 110, 40));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("STUDENT INFORMATION");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 470, 59));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("DEPARTMENT");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 200, 20));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BOOK INFORMATION");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 470, 59));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("FACULTY");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 190, -1));

        surNameTextField.setEditable(false);
        surNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        surNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(surNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 370, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("BOOK ISSUE ID");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 60, 140, 40));

        bookIssueIdTextField1.setEditable(false);
        bookIssueIdTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bookIssueIdTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIssueIdTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(bookIssueIdTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 60, 100, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("DATE OF  ISSUED");
        jLabel13.setToolTipText("");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, 160, 40));

        dateOfIssuedTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateOfIssuedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfIssuedTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(dateOfIssuedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 100, 170, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("ROLL NO");
        jLabel14.setToolTipText("");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 120, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("SHIFT");
        jLabel15.setToolTipText("");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 90, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("DATE OF  RETURN");
        jLabel16.setToolTipText("");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 140, 240, 40));

        dateOfReturnTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateOfReturnTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfReturnTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(dateOfReturnTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 140, 170, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("BOOK TITLE");
        jLabel17.setToolTipText("");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 200, 20));

        fineTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fineTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fineTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(fineTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 180, 170, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setText("BATCH YEAR");
        jLabel18.setToolTipText("");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, 50));

        publishedYearTextField.setEditable(false);
        publishedYearTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        publishedYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishedYearTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(publishedYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 320, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("DATE OF ISSUE");
        jLabel19.setToolTipText("");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 280, 220, 50));

        batchYearComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 110, 30));

        bookIdTextField2.setEditable(false);
        bookIdTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bookIdTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIdTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(bookIdTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 140, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setText("STUDENT ID");
        jLabel21.setToolTipText("");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 160, 50));

        studentIdTextField.setEditable(false);
        studentIdTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(studentIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 100, 30));

        authorTextField2.setEditable(false);
        authorTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        authorTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(authorTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 320, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setText("AUTHOR/EDITOR");
        jLabel22.setToolTipText("");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 210, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setText("BOOK ID");
        jLabel23.setToolTipText("");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 160, 50));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setText("NAME");
        jLabel20.setToolTipText("");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, 30));

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 370, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("REMARKS");
        jLabel24.setToolTipText("");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 140, 40));

        editionTextField2.setEditable(false);
        editionTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editionTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editionTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(editionTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 320, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("FATHER NAME");
        jLabel25.setToolTipText("");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 180, 30));

        fatherNameTextField.setEditable(false);
        fatherNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fatherNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(fatherNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 370, 30));

        ComboBox.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BOOK", "STUDENT" }));
        ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxItemStateChanged(evt);
            }
        });
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, 330, 50));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setText("PUBLISHED YEAR ");
        jLabel26.setToolTipText("");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 220, 30));

        dateOfIssueList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        dateOfIssueList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dateOfIssueListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(dateOfIssueList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 340, 350));
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel28.setText("SURNAME");
        jLabel28.setToolTipText("");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 140, 30));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 900, 220));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 710, 230, 70));

        addButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton1.setText("ADD");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 720, 160, 50));

        updateButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton1.setText("UPDATE");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 720, 160, 50));

        deleteButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 720, 160, 50));

        clearButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 720, 160, 50));

        facultyComboBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        facultyComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBox1ItemStateChanged(evt);
            }
        });
        facultyComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 380, -1));

        departemtComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        departemtComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departemtComboBoxItemStateChanged(evt);
            }
        });
        departemtComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departemtComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departemtComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 380, -1));

        shiftComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING", "NOON" }));
        shiftComboBox.setName(""); // NOI18N
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 110, 30));

        groupComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MEDICAL", "ENGINEERING", "COMMERCE", "GENERAL" }));
        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void rollNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollNoComboBoxActionPerformed

    private void bookTitleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleComboBoxActionPerformed

    private void bookFacultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookFacultyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookFacultyComboBoxActionPerformed

    private void surNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surNameTextFieldActionPerformed

    private void bookIssueIdTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIssueIdTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookIssueIdTextField1ActionPerformed

    private void dateOfIssuedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfIssuedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfIssuedTextField1ActionPerformed

    private void dateOfReturnTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfReturnTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfReturnTextField1ActionPerformed

    private void fineTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fineTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fineTextField1ActionPerformed

    private void publishedYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishedYearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publishedYearTextFieldActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void bookIdTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIdTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookIdTextField2ActionPerformed

    private void studentIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdTextFieldActionPerformed

    private void authorTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextField2ActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void editionTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editionTextField2ActionPerformed

    private void fatherNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherNameTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
       this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
       addRecord();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void facultyComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultyComboBox1ActionPerformed

    private void departemtComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departemtComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departemtComboBoxActionPerformed

    private void facultyComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBox1ItemStateChanged
        // TODO add your handling code here:
           FacultyBean selectedBean = (FacultyBean) this.facultyComboBox1.getSelectedItem();        
        try {
            Vector vec = DBManager.getDepartment(selectedBean.getFacId());
            this.departemtComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.departemtComboBox.addItem(vec.elementAt(i));
                
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facultyComboBox1ItemStateChanged

    private void departemtComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departemtComboBoxItemStateChanged
        // TODO add your handling code here:
          DepartmentBean selectedBean = (DepartmentBean) this.departemtComboBox.getSelectedItem();        
               if(selectedBean==null) return;
             try {
            Vector vec = DBManager.getProgram(selectedBean.getDeptId());
            this.programComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.programComboBox.addItem(vec.elementAt(i));
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departemtComboBoxItemStateChanged

    private void bookFacultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookFacultyComboBoxItemStateChanged
        // TODO add your handling code here:
        
          FacultyBean selectedBean = (FacultyBean) this.bookFacultyComboBox.getSelectedItem();        
        try {
            Vector vec = DBManager.getDepartment(selectedBean.getFacId());
            this.bookDepartmentComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.bookDepartmentComboBox.addItem(vec.elementAt(i));
                
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                                                     

    }//GEN-LAST:event_bookFacultyComboBoxItemStateChanged

    private void bookDepartmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookDepartmentComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookDepartmentComboBoxActionPerformed

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        // TODO add your handling code here:   
        ProgramsBean selectedBean = (ProgramsBean) this.programComboBox.getSelectedItem();        
           
         if(selectedBean==null)return;     
       try {  
          Vector v = DBManager.getBatch(selectedBean.getProgId());
          this. batchYearComboBox.removeAllItems();
          for(int i = 0; i<v.size(); i++){
           batchYearComboBox.addItem(v.elementAt(i));
         }         
         } catch (Exception ex) {
             Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_programComboBoxItemStateChanged

    private void bookDepartmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookDepartmentComboBoxItemStateChanged
        // TODO add your handling code here:
        
           DepartmentBean selectedBean = (DepartmentBean) this.bookDepartmentComboBox.getSelectedItem();        
               if(selectedBean==null) return;
             try {
            Vector vec = DBManager.getBook(selectedBean.getDeptId());
             bookTitleComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.bookTitleComboBox.addItem(vec.elementAt(i));
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bookDepartmentComboBoxItemStateChanged

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
         BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();         
        if(selectedBean==null)return;     
          shiftComboBox.setSelectedItem(DatabaseManager.Decoder.shiftDecode(selectedBean.getShift()));
          groupComboBox.setSelectedItem(DatabaseManager.Decoder.groupDecode(selectedBean
                 .getGroupDesc()));
        try {
            
            Vector v = DBManager.getStudent(selectedBean.getBatchId());
            rollNoComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++){
                  
              this.rollNoComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void rollNoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rollNoComboBoxItemStateChanged
        // TODO add your handling code here:
          
         StudentsBean  selectedBean = (StudentsBean) rollNoComboBox.getSelectedItem();         
         if(selectedBean==null) return;
          try{
               Vector vec = DBManager.getBook(selectedBean.getStudId());
              // this.dateOfIssueList.removeAllItems();   
                //System.out.println(vec.elementAt(i));
                this.dateOfIssueList.setListData(vec);
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       StudentsBean  bean = (StudentsBean) rollNoComboBox.getSelectedItem(); 
       if(bean==null)return;  
       this.studentIdTextField.setText(""+bean.getStudId());
      // JOptionPane.showMessageDialog(null,""+bean.getStudId());
       this.nameTextField.setText(bean.getStudName());
       this.fatherNameTextField.setText(bean.getFname());
       this.surNameTextField.setText(bean.getSurName());
       this.remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_rollNoComboBoxItemStateChanged

    private void bookTitleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookTitleComboBoxItemStateChanged
        // TODO add your handling code here:
        
       // StudentsBean  selectedBean = (StudentsBean) rollNoComboBox.getSelectedItem();         
        BookBean  selectedBean = (BookBean) bookTitleComboBox.getSelectedItem();  
        if(selectedBean==null) return;
          try{
               Vector vec = DBManager.getStudent(selectedBean.getBookId());
                this.dateOfIssueList.setListData(vec);
        }catch (Exception ex){
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        BookBean  bean = (BookBean) bookTitleComboBox.getSelectedItem(); 
       if(bean==null)return;  
       this.bookIdTextField2.setText(""+bean.getBookId());
       this.authorTextField2.setText(bean.getAuthorEditor());
       this.editionTextField2.setText(bean.getVolumeEdition());
       this.publishedYearTextField.setText(bean.getYearOfpublish());
      // this.remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_bookTitleComboBoxItemStateChanged

    private void dateOfIssueListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dateOfIssueListValueChanged
        // TODO add your handling code here:
      String selectedStudent = (String) ComboBox.getSelectedItem();
            // display the student record
            if (selectedStudent.equals("BOOK")) {
                
                BookBean  bean = (BookBean) dateOfIssueList.getSelectedValue();  
                if(bean==null)return;  
                    this.bookIdTextField2.setText(""+bean.getBookId());
                    this.authorTextField2.setText(bean.getAuthorEditor());
                     this.editionTextField2.setText(bean.getVolumeEdition());
                     this.publishedYearTextField.setText(bean.getYearOfpublish());
            }else if (selectedStudent.equals("STUDENT")) {
                    StudentsBean  beans = (StudentsBean) dateOfIssueList.getSelectedValue();
                    if(beans==null)return;  
                    this.studentIdTextField.setText(""+beans.getStudId());
                    this.nameTextField.setText(beans.getStudName());
                    this.fatherNameTextField.setText(beans.getFname());
                    this.surNameTextField.setText(beans.getSurName());
                    this.remarksTextArea.setText(beans.getRemarks());
              } 
    }//GEN-LAST:event_dateOfIssueListValueChanged

    private void ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxItemStateChanged
        // TODO add your handling code here:
         String selectedStudent = (String) ComboBox.getSelectedItem();
            // display the student record
            if (selectedStudent.equals("STUDENT")) {
                // this.getBookIssue();
            try {
                     Vector v = DBManager.getStudent();
                     this.dateOfIssueList.setListData(v);    
            } catch (Exception ex) {
                Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }  
              
                
            }  
          else if (selectedStudent.equals("BOOK")) {
              try {
                        Vector v = DBManager.getBook();         
                        this.dateOfIssueList.setListData(v); 
            } catch (Exception ex) {
                Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }  
              
               //JOptionPane.showMessageDialog(null,"Hello shoban");
         }
      
        
        
        
    }//GEN-LAST:event_ComboBoxItemStateChanged

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
        
         
           

        
    }//GEN-LAST:event_ComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookIssueFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JButton addButton1;
    private javax.swing.JTextField authorTextField2;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JComboBox bookDepartmentComboBox;
    private javax.swing.JComboBox bookFacultyComboBox;
    private javax.swing.JTextField bookIdTextField2;
    private javax.swing.JTextField bookIssueIdTextField1;
    private javax.swing.JComboBox bookTitleComboBox;
    private javax.swing.JButton clearButton1;
    private javax.swing.JList dateOfIssueList;
    private javax.swing.JTextField dateOfIssuedTextField1;
    private javax.swing.JTextField dateOfReturnTextField1;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JComboBox departemtComboBox;
    private javax.swing.JTextField editionTextField2;
    private javax.swing.JComboBox facultyComboBox1;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JTextField fineTextField1;
    private javax.swing.JComboBox groupComboBox;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JTextField publishedYearTextField;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox rollNoComboBox;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JTextField surNameTextField;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
