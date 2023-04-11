package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Override
	public BookDto convertBookToBookDto(Book book) {
		
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setBookName(book.getBookName());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setIsbn(book.getIsbn());
		
		return bookDto;
	}

}
