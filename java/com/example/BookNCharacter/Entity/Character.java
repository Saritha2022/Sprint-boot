package com.example.BookNCharacter.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Character {
	
	@Id
	private String charcterName;
	private String characterType;
	private String characterGender;
	private String charcterDescription;
	@ManyToOne
	private Book book;
	
	
		@Override
	public String toString() {
			System.out.println("*****character...toString()....");
		return "Character [charcterName=" + charcterName + ", characterType=" + characterType + ", characterGender="
				+ characterGender + ", charcterDescription=" + charcterDescription + ", book=" + book + "]";
	}

	public Character(String charcterName, String characterType, String characterGender,
			String charcterDescription,String id) {
		super();
		System.out.println("parameter..CHARACTERwith Id"
				+ "..constructor");
		this.charcterName = charcterName;
		this.characterType = characterType;
		this.characterGender = characterGender;
		this.charcterDescription = charcterDescription;
		this.book=new Book(id,"","","","");
	}
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCharcterName() {
		return charcterName;
	}
	public void setCharcterName(String charcterName) {
		this.charcterName = charcterName;
	}
	public String getCharacterType() {
		return characterType;
	}
	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}
	public String getCharacterGender() {
		return characterGender;
	}
	public void setCharacterGender(String characterGender) {
		this.characterGender = characterGender;
	}
	public String getCharcterDescription() {
		return charcterDescription;
	}
	public void setCharcterDescription(String charcterDescription) {
		this.charcterDescription = charcterDescription;
	}

}
