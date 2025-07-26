package BeanClasses;
public class  BookIssueBean{

	private int bookIssueId;
    private int  bookId;
	private int studId;
	private java.util.Date dataOfIssue;
	private java.util.Date dataOfReturn;
	private int fine;
	private String remarks;
	


    public void setBookIssueId(int bookIssueId){
		this.bookIssueId=bookIssueId;
	}

	public void setBookId(int bookId){
		this.bookId=bookId;
	}

	public void setStudId(int studId){

		this.studId=studId;
	}
	
	public void setDataOfIssue(java.util.Date dataOfIssue){
		this.dataOfIssue=dataOfIssue;
	}

	public void setDataOfReturn(java.util.Date dataOfReturn){
		this.dataOfReturn=dataOfReturn;
	}

	public void setFine(int fine){
		this.fine=fine;
	}

   public void setRemarks(String remarks){
   	this.remarks=remarks;
   }


   public int  getBookIssueId(){
		return bookIssueId;
	}

	public int getBookId(){
		 return bookId;
	}

	public int  getStudId(){

		return studId;
	}
	
	public java.util.Date getDataOfIssue(){
		return dataOfIssue;
	}

	public java.util.Date getDataOfReturn(){
		return dataOfReturn;
	}

	public int getFine(){
		return fine;
	}

   public String getRemarks(){
   	return remarks;
   }

public String toString(){
	return DatabaseManager.Decoder.decodeDate(dataOfIssue);
}


}