package DatabaseManager;

import BeanClasses.*;
import java.sql.*;
import java.util.Vector;


public class DBManager {

    private static Connection con;
    private static Statement st=null;
    private static ResultSet rs =null; 
    
    static{
       try{
            init(); 
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }

    private static void init()throws Exception{
    
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        // Connect to the database
        String dbPath = "E:\\NetBeansProjects\\LIBRARY\\src\\DatabaseManager\\DB_LIBRARY_MANAGEMENT.accdb";
        String url = "jdbc:ucanaccess://" + dbPath;
        con = DriverManager.getConnection(url);
        System.out.println("Connection successfully ");
    }
    
    
    
     public static int addBookDefault(String starDate,String endDate)throws Exception{
       String query=("select std.STUD_NAME,std.ROLL_NO,b.BOOKS_NAME,bi.DATE_OF_ISSUE FROM Students std, books b,books_issue bi where bi.STUD_ID=std.STUD_ID AND bi.BOOK_ID=b.BOOKS_ID AND bi.DATE_OF_ISSUE>=#"+starDate+"# AND bi.DATE_OF_ISSUE<=#"+endDate+"#");
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add BOOk
    
    
    
    
    
    public static Vector getFaculty()throws Exception{
       try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM faculty");
           
            Vector v = new Vector();
         
            while(rs.next()){
            FacultyBean bean=new FacultyBean();
            
            bean.setFacId(rs.getInt("FAC_ID"));
            bean.setFacName(rs.getString("FAC_NAME"));
            bean.setRemarks(rs.getString("REMARKS"));
          
            v.addElement(bean);
          }//end of while
           return v;
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of getfaculty Method
    
    
public static Vector getDepartment() throws Exception{
  
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM department");
             Vector v = new Vector();
           while(rs.next()){
             DepartmentBean bean=new DepartmentBean();
             bean.setFacId(rs.getInt("FAC_ID"));
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setDeptName(rs.getString("DEPT_NAME"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getDepartment Method



public static Vector getDepartment(int facId) throws Exception{

        String query="SELECT * FROM department where FAC_ID="+facId;
        System.out.println(query);  
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             DepartmentBean bean=new DepartmentBean();
             bean.setFacId(rs.getInt("FAC_ID"));
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setDeptName(rs.getString("DEPT_NAME"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getDepartment Method

public static Vector  getProgram()throws Exception{
    
 String query="SELECT * FROM programs";
        System.out.println(query);  
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             ProgramsBean bean=new ProgramsBean();
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setProgName(rs.getString("PROG_NAME"));
            bean.setProgDuration(rs.getInt("PROG_DURATION_IN_SEM"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getProgram Method  


public static Vector  getProgram(int dept)throws Exception{
    
         String query="SELECT * FROM programs where DEPT_ID="+dept;
         System.out.println(query);  
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             ProgramsBean bean=new ProgramsBean();
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setProgName(rs.getString("PROG_NAME"));
            bean.setProgDuration(rs.getInt("PROG_DURATION_IN_SEM"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getProgram Method  


public static Vector  getBatch()throws Exception{
    
   
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM batch");
             Vector v = new Vector();
           while(rs.next()){
             BatchBean bean=new BatchBean();
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setShift(rs.getString("SHIFT"));
             bean.setBatchYear(rs.getString("BATCH_YEAR"));
             bean.setGroupDesc(rs.getString("GROUP_DES"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getBatch Method  

public static Vector  getBatch(int progId)throws Exception{
    
 
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM batch where PROG_ID="+progId);
             Vector v = new Vector();
           while(rs.next()){
             BatchBean bean=new BatchBean();
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setShift(rs.getString("SHIFT"));
             bean.setBatchYear(rs.getString("BATCH_YEAR"));
             bean.setGroupDesc(rs.getString("GROUP_DES"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getBatch Method  

public static Vector  getStudent()throws Exception{
    
 //String query="SELECT * FROM students";
   //     System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM students");
             Vector v = new Vector();
           
        while(rs.next()){
             StudentsBean bean=new StudentsBean();
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
             bean.setStudName(rs.getString("STUD_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SURNAME"));
             bean.setRollNo(rs.getString("ROLL_NO"));
             bean.setRemarks(rs.getString("REMARKS"));
             bean.setCnic(rs.getString("CNIC"));
             bean.setPhoneNo(rs.getString("PHONE_NO"));
             bean.setEmail(rs.getString("EMAIL"));
             bean.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getStudents Method


public static Vector  getStudent(int batchId)throws Exception{
    
 
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM students where BATCH_ID="+batchId);
             Vector v = new Vector();
           while(rs.next()){
             StudentsBean bean=new StudentsBean();
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
             bean.setStudName(rs.getString("STUD_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SURNAME"));
             bean.setRollNo(rs.getString("ROLL_NO"));
             bean.setRemarks(rs.getString("REMARKS"));
             bean.setCnic(rs.getString("CNIC"));
             bean.setPhoneNo(rs.getString("PHONE_NO"));
             bean.setEmail(rs.getString("EMAIL"));
             bean.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getStudents Method


public static Vector getBook(int deptId) throws Exception{
  
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM books where DEPT_ID ="+deptId);
             System.out.print(rs+ "Shoban");
                     
             Vector v = new Vector();
           while(rs.next()){
             BookBean bean=new BookBean();
          
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setBookId(rs.getInt("BOOKS_ID"));
             bean.setBookName(rs.getString("BOOKS_NAME"));
             bean.setAuthorEditor(rs.getString("AUTHOR_EDITOR"));
             bean.setQuantity(rs.getString("QUANTITY"));
             bean.setVolumeEdition(rs.getString("VOLUME_EDITION"));
             bean.setPrice(rs.getString("PRICE"));
             bean.setPurchaseFrome(rs.getString("PURCHASE_FROM"));
             bean.setDataOfRurchase(rs.getString("DATE_OF_PURCHASE"));
             bean.setIseNo(rs.getString("ISE_NO"));  
             bean.setAccessNo(rs.getString("ACCESS_NO"));
             bean.setYearOfpublish(rs.getString("YEAR_OF_PUBLISH"));
             bean.setNumberOfPages(rs.getString("NUMBER_OF_PAGES"));
             bean.setPublisherName(rs.getString("PUBLISHER_NAME"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getpart Method





public static Vector getBook() throws Exception{
  
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM books");
             System.out.print(rs+ "Shoban");
                     
             Vector v = new Vector();
           while(rs.next()){
             BookBean bean=new BookBean();
          
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setBookId(rs.getInt("BOOKS_ID"));
             bean.setBookName(rs.getString("BOOKS_NAME"));
             bean.setAuthorEditor(rs.getString("AUTHOR_EDITOR"));
             bean.setQuantity(rs.getString("QUANTITY"));
             bean.setVolumeEdition(rs.getString("VOLUME_EDITION"));
             bean.setPrice(rs.getString("PRICE"));
             bean.setPurchaseFrome(rs.getString("PURCHASE_FROM"));
             bean.setDataOfRurchase(rs.getString("DATE_OF_PURCHASE"));
             bean.setIseNo(rs.getString("ISE_NO"));  
             bean.setAccessNo(rs.getString("ACCESS_NO"));
             bean.setYearOfpublish(rs.getString("YEAR_OF_PUBLISH"));
             bean.setNumberOfPages(rs.getString("NUMBER_OF_PAGES"));
             bean.setPublisherName(rs.getString("PUBLISHER_NAME"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getpart Method





public static Vector getBookIssue(int studId) throws Exception{
  
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM books_issue where STUD_ID ="+studId);
             System.out.print(rs+ "Shoban");
                     
             Vector v = new Vector();
           while(rs.next()){
             BookIssueBean bean=new BookIssueBean();
          
             bean.setBookIssueId(rs.getInt("BOOK_ISSUE_ID"));
             bean.setBookId(rs.getInt("BOOK_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
        
             bean.setDataOfIssue(rs.getDate("DATE_OF_ISSUE"));
             bean.setDataOfReturn(rs.getDate("DATE_OF_RETURN"));
             bean.setFine(rs.getInt("FINE"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getBookIssue Method



public static Vector getBookIssue() throws Exception{
  
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM books_issue");
             System.out.print(rs+ "Shoban");
                     
             Vector v = new Vector();
           while(rs.next()){
             BookIssueBean bean=new BookIssueBean();
          
             bean.setBookIssueId(rs.getInt("BOOK_ISSUE_ID"));
             bean.setBookId(rs.getInt("BOOK_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
        
             bean.setDataOfIssue(rs.getDate("DATE_OF_ISSUE"));
             bean.setDataOfReturn(rs.getDate("DATE_OF_RETURN"));
             bean.setFine(rs.getInt("FINE"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally
   
}///emd of getBookIssue Method


 public static int deleteFaculty(int facId)throws Exception{
        String query="delete from faculty where FAC_ID="+facId;
         System.out.println(query);
         Statement st=null;
         try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
        }finally{
             if(st!=null){
                 st.close();
             }
        }//end finally
    }//end DeleteFaculty
    
 public static int deleteDepartment(int deptId)throws Exception{
        String query="delete from department where DEPT_ID="+deptId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
        }finally{
             if(st!=null){
                 st.close();
             }
        }//end finally
    }// end DeleteDepartment
 
  public static int deleteProgram(int progId)throws Exception{
        String query="delete from programs where PROG_ID="+progId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
             if(st!=null){
                 st.close();
             }
        }//end finally
        
    }//end DeleteProgram
    
  public static int deleteBatch(int batchId)throws Exception{
        String query="delete from batch where BATCH_ID="+batchId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
             if(st!=null){
                 st.close();
             }
        } // end finally
    } // end DeleteBatch

   public static int deleteStudent(int studId)throws Exception{
        String query="delete from students where STUD_ID="+studId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end DeleteStudent

   
   
   public static int deletePart(int part)throws Exception{
        String query="delete from part where PART="+part;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end DeleteStudent

   
   public static int deleteTeacher(int teacherId)throws Exception{
        String query="delete from teacher where TEACHER_ID="+teacherId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end DeleteTeacher
   
   public static int deleteBook(int bookId)throws Exception{
        String query="delete from books where BOOKS_ID="+bookId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end DeleteTeacher
   
   
    public static int deleteBookIssue(int bookIssueId)throws Exception{
        String query="delete from books_issue where BOOK_ISSUE_ID="+bookIssueId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end 
   
   
 public static int updateFaculty(int facId,String facName,String remarks) throws Exception{
        String query= "update faculty set FAC_NAME='"+facName+"',REMARKS='"+remarks+"' where FAC_ID="+facId;
        System.out.println(query);
        Statement st=null;
        try{
            
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows; 
        }finally{
            if(st!=null){
                st.close();
            }
        }
    } //end updateFaculty
    
    public static int updateDepartment(int deptId, String deptName, String remarks)throws Exception{ 
        //String query= "update department set DEPT_NAME='"+deptName+"'REMARKS='"+remarks+"' where DEPT_ID="+deptId;
        
        
        String query = "update department set DEPT_NAME='"+deptName+"', REMARKS='"+remarks+"'where DEPT_ID="+deptId;
        
        
        System.out.println(query);
        Statement st=null;
        try{
            
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
              st.close();
            }
        }
    }// end update Department
    
    public static int updateProgram(int progId, String progName, String progDuration, String remarks)throws Exception{
      String query= "update programs set PROG_NAME='"+progName+"',PROG_DURATION_IN_SEM='"+progDuration+"',REMARKS='"+remarks+"'where PROG_ID="+progId;
       
      //String query = "update programs set PROG_NAME='"+progName+"',PROG_DURATION_IN_SEM'"+progDuration+"',REMARKS='"+remarks+"' where PROG_ID="+progId;
        
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Program
    
        public static int updateBatch(int batchId, String shift, String batchYear, String groupDesc, String remarks)throws Exception{
        String query= "update batch set BATCH_YEAR='"+batchYear+"',SHIFT='"+shift+"',GROUP_DES='"+groupDesc+"',REMARKS='"+remarks+"'where BATCH_ID="+batchId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Batch
        
            
        public static int updateStudent(int studId,String studName,String fatherName,String surName,String rollNo,String remarks)throws Exception{
        String query= "update students set STUD_NAME='"+studName+"',FATHER_NAME='"+fatherName+"',SURNAME='"+surName+"',ROLL_NO='"+rollNo+"',REMARKS='"+remarks+"'where STUD_ID="+studId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Student
   
          
             
     
      public static int updateBook(int bookId,String bookName,String authorEditor,String volumeEdition,String quantity,String price,String  purchaseFrome,String  dataOfRurchase,String iseNo,String accessNo,String yearOfpublish,String  numberOfPages,String  publisherName,String remarks)throws Exception{
        String query= "update books set BOOKS_NAME='"+bookName+"',AUTHOR_EDITOR='"+authorEditor+"',VOLUME_EDITION='"+volumeEdition+"',QUANTITY='"+quantity+"',PRICE='"+price+"',PURCHASE_FROM='"+purchaseFrome+"',DATE_OF_PURCHASE='"+dataOfRurchase+"',ISE_NO='"+iseNo+"',ACCESS_NO='"+accessNo+"',YEAR_OF_PUBLISH='"+yearOfpublish+"',NUMBER_OF_PAGES='"+numberOfPages+"',PUBLISHER_NAME='"+publisherName+"',REMARKS='"+remarks+"'where BOOKS_ID="+bookId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Student
   
     
      
      
        public static int updateBookIssue(int bookIssueId,String dataOfIssue,String dataOfReturn,String fine)throws Exception{
        
            if(dataOfIssue.equals(""))
                dataOfIssue=null;
            else
                dataOfIssue="#"+dataOfIssue+"#";
            
            if(dataOfReturn.equals(""))
                dataOfReturn=null;
            else
                dataOfReturn="#"+dataOfReturn+"#";
                    
            
            
        String query= "update books_issue set DATE_OF_ISSUE="+dataOfIssue+",DATE_OF_RETURN="+dataOfReturn+",FINE="+fine+" where BOOK_ISSUE_ID="+bookIssueId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Student
   
     
        
  public static int addFaculty(String facName,String remarks)throws Exception{
        String query="insert into faculty (FAC_NAME,REMARKS) values ('"+facName+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }//end add Faculty
        
                
        public static int addDepartment(int facId,String deptName, String remarks)throws Exception{
        String query="insert into department(FAC_ID,DEPT_NAME,REMARKS) values ("+facId+",'"+deptName+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Department
                        
        public static int addProgram(int deptId,String progName,int progDuration, String remarks)throws Exception{
        String query="insert into programs (DEPT_ID,PROG_NAME,PROG_DURATION_IN_SEM,REMARKS) values ("+deptId+",'"+progName+"',"+progDuration+",'"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Program
        
        public static int addBatch(int progId, String batchYear,String shift,String groupDes,String remarks)throws Exception{
        String query="insert into batch (PROG_ID,BATCH_YEAR,SHIFT,GROUP_DES,REMARKS) values ("+progId+","+batchYear+",'"+shift+"','"+groupDes+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Batch
        
        public static int addStudent(int batchId,String studName,String fatherName,String surName,String rollNo,String remarks)throws Exception{
        String query="insert into students (BATCH_ID,STUD_NAME,FATHER_NAME,SURNAME,ROLL_NO,REMARKS) values ("+batchId+",'"+studName+"','"+fatherName+"','"+surName+"','"+rollNo+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Stduent
        
         
        
        
        public static int addBookIssue(int studId,int bookId,String dataOfIssue,String dataOfReturn,int fine,String remarks)throws Exception{
            
            if(dataOfIssue.equals(""))
                dataOfIssue=null;
            else
                dataOfIssue="#"+dataOfIssue+"#";
            
            if(dataOfReturn.equals(""))
                dataOfReturn=null;
            else
                dataOfReturn="#"+dataOfReturn+"#";
        

        // dataOfIssue = 14/03/2023
        // dataOfIssue = 03/14/2023

        // java date format examples;
        
        
        
        
        String query="insert into books_issue (STUD_ID,BOOK_ID,DATE_OF_ISSUE,DATE_OF_RETURN,FINE,REMARKS) values ("+studId+","+bookId+","+dataOfIssue+","+dataOfReturn+","+fine+",'"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                System.out.print(rows);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Stduent
        
        
        
         
       public static int addBook(int deptId,String bookName,String authorEditor,String volumeEdition,String quantity,String price,String  purchaseFrome,String  dataOfRurchase,String iseNo,String accessNo,String yearOfpublish,String  numberOfPages,String  publisherName,String remarks)throws Exception{
       String query="insert into books (DEPT_ID,BOOKS_NAME,AUTHOR_EDITOR,QUANTITY,VOLUME_EDITION,PRICE,PURCHASE_FROM,DATE_OF_PURCHASE,ISE_NO,ACCESS_NO,YEAR_OF_PUBLISH,NUMBER_OF_PAGES,PUBLISHER_NAME,REMARKS) values ("+deptId+",'"+bookName+"','"+authorEditor+"','"+volumeEdition+"','"+quantity+"','"+price+"','"+purchaseFrome+"','"+dataOfRurchase+"','"+iseNo+"','"+accessNo+"','"+yearOfpublish+"','"+"','"+numberOfPages+"','"+publisherName+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add BOOk
        
        
       
 public  static void main(String arg[]){
    DBManager ob=new DBManager();
}
}// end Manager
