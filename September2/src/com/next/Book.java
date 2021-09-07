package com.next;

public class Book {
	private long SerialNumber;
	private String BookName;
	private String BookAuthor;
	private Double BookCost;
	public long getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(long Serialnumber) {
		SerialNumber = Serialnumber;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String Bookname) {
		BookName = Bookname;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	@Override
	public String toString() {
		return "Book [SerialNumber=" + SerialNumber + ", BookName=" + BookName + ", BookAuthor=" + BookAuthor + ", BookCost="
				+ BookCost + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setBookAuthor(String Bookauthor) {
		BookAuthor = Bookauthor;
	}
	public Double getBookCost() {
		return BookCost;
	}
	public void setBookCost(Double Bookcost) {
		BookCost = Bookcost;
	}

}
