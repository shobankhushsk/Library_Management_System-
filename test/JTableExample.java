
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BeanClasses.*;
import DatabaseManager.DBManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class JTableExample{
	public static void main(String[] args) {
	  new MyTabel();
	}
}

class MyTabel extends JFrame{
  JTable tabel;

	MyTabel(){
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    
             StudentsBean  bean = (StudentsBean ) tabel.getColumnModel();  
                 
	    Object[][] date={{101,bean.getStudName(),21},{102,"Shyam",10},{103,"Raju",20}};
	    String[] columnName={"Roll No","Names","Age"};

	    DefaultTableModel model=new DefaultTableModel(date, columnName);   

	  tabel=new JTable(model);

	  add(new JScrollPane(tabel));
	}
}