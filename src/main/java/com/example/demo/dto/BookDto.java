package com.example.demo.dto;

public class BookDto {
	
	private Long id;
	
	private String bookName;
	
	private String isbn;
	
	private String author;
	
	private UserDto userData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public UserDto getUserData() {
		return userData;
	}

	public void setUserData(UserDto userData) {
		this.userData = userData;
	}

}
