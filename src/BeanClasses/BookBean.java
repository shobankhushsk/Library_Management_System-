 	package BeanClasses;

public class BookBean{
	private int  deptId;
    private int  bookId;
	private String bookName;
	private String authorEditor;
	private String volumeEdition;
    private String quantity;
	private String price;
	private String  purchaseFrome;
	private String  dataOfRurchase;
	private String  iseNo;
	private String  accessNo;
	private String  yearOfpublish;
	private String  numberOfPages;
    private String  publisherName;
	private String remarks;



	public void setDeptId(int deptId){
		this.deptId=deptId;
	}

	public void setBookId(int bookId){
		this.bookId=bookId;
	}

	public void setBookName(String bookName){
		this.bookName=bookName;
	}

	public void setAuthorEditor(String authorEditor){
		this.authorEditor=authorEditor;
	}

	public void setVolumeEdition(String volumeEdition){
     this.volumeEdition=volumeEdition;
	}

  public void setQuantity(String quantity){
	this.quantity=quantity;
 }

 
  public void setPrice(String price){
	this.price=price;
 }
   
  public void setPurchaseFrome(String  purchaseFrome){
  	this.purchaseFrome=purchaseFrome;
  }

  public void setDataOfRurchase(String dataOfRurchase){
  	this.dataOfRurchase=dataOfRurchase;
  }

  public void setIseNo(String iseNo){
  	this.iseNo=iseNo;
  }

  public void setAccessNo(String accessNo){
  	this.accessNo=accessNo;
  }

   public void setYearOfpublish(String yearOfpublish){
  	this.yearOfpublish=yearOfpublish;
  }

 public void setNumberOfPages(String numberOfPages){
  	this.numberOfPages=numberOfPages;
 }
 
 public void setPublisherName(String publisherName){
  	this.publisherName=publisherName;
 }

  public void setRemarks(String remarks){
  	this.remarks=remarks;
  }

  

  	
public int  getDeptId(){
		return deptId;
	}

	public int getBookId(){
		return bookId;
	}

	public String getBookName(){
		 return bookName;
	}

	public String getAuthorEditor(){
		return authorEditor;
	}

	public String getVolumeEdition(){
     return volumeEdition;
	}

  public String getQuantity(){
	return quantity;
 }

 
  public String getPrice(){
	return price;
 }
   
  public String getPurchaseFrome(){
  	return purchaseFrome;
  }

  public String getDataOfRurchase(){
  	return dataOfRurchase;
  }

  public String getIseNo(){
  	return iseNo;
  }

  public String getAccessNo(){
  	return accessNo;
  }

   public String getYearOfpublish(){
  	return yearOfpublish;
  }

 public String getNumberOfPages(){
  	return numberOfPages;
 }
 
 
 public String getPublisherName(){
  	return publisherName;
 }

  public String getRemarks(){
  	return remarks;
  }


public String toString(){
	return bookName;
}
}