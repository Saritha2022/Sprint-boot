package com.example.BookNCharacter.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
		@Id
	private String id;
	private String bookName;
	private String bookAuthor;
	private String bookPrice;
	private String bookReleaseDate;
		
	public Book() {
		super();
		System.out.println("Constructor called...BOOK...");
	
	
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setBookId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookReleaseDate() {
		//System.out.println("Getter date...."+this.bookReleaseDate);
		return bookReleaseDate;
	}
	public void setBookReleaseDate(String bookReleaseDate) {
		//System.out.println("setter date....");
		this.bookReleaseDate = bookReleaseDate;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	
	
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public Book(String id, String bookName, String bookAuthor, String bookPrice, String bookReleaseDate) {
		super();
		System.out.println("*parameterised  BOOk Construct***"+id+"   "+bookName+"  "+
				 bookAuthor+"  "+bookPrice+"  "+bookReleaseDate);
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookReleaseDate = bookReleaseDate;
	}
	@Override
	public String toString() {
		System.out.println("********Book..toString()*******");
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice
				+ ", bookReleaseDate=" + bookReleaseDate + "]";
	}


}
