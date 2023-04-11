package com.example.demo.dto;

import java.util.List;

public class UserDto {

	private Long id;
	
	private String name;
	
	private String address;
	
	private List<BookDto> bookDtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BookDto> getBookDtos() {
		return bookDtos;
	}

	public void setBookDtos(List<BookDto> bookDtos) {
		this.bookDtos = bookDtos;
	}


	


	
}
