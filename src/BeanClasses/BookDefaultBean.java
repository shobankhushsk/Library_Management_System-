	package BeanClasses;

public class BookDefaultBean{

	
	private String studName;
	private String rollNo;
	private String bookName;
    private String dateOfIssue;
	



	public void setSudName(String studName){
		this.studName=studName;
	}

	public void setRollNo(String rollNo){
		this.rollNo=rollNo;
	}

	public void setBookName(String bookName){
		this.bookName=bookName;
	}

	public void setDateOfIssue(String dateOfIssue){
		this.dateOfIssue=dateOfIssue;
	}

	
  

  	
	public String setStudName(){
     return studName;
	}

	public String setRollNo(){
		return rollNo;
	}

  public String getBookName(){
		 return bookName;
  }

  public String getDateOfIssue(){
	return dateOfIssue;
 }

 
  


public String toString(){
	return bookName;
}
}