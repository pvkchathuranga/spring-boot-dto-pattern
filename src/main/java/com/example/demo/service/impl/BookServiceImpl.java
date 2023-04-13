package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.domain.User;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.commonModel.ResponseDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	private BookDto convertBookToBookDto(Book book) {
		
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setBookName(book.getBookName());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setIsbn(book.getIsbn());
		
		Iterable<User> users = book.getUsers();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user : users) {

			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setAddress(user.getAddress());
			userDtos.add(userDto);

		}
		bookDto.setUserDtos(userDtos);
		
		return bookDto;
	}

	@Override
	public ResponseDto addBook(BookDto bookDto) {
		ResponseDto responseDto = new ResponseDto();
		Book book = convertBookDtoToBook(bookDto);
		bookRepository.save(book);
		responseDto.setStatus(true);
		responseDto.setStatusMessage("Success");
		responseDto.setData(book);
		return responseDto;
	}

	private Book convertBookDtoToBook(BookDto bookDto) {
		Book book = new Book();
		book.setBookName(bookDto.getBookName());
		book.setAuthor(bookDto.getAuthor());
		book.setIsbn(bookDto.getIsbn());
		
		return book;
	}

	@Override
	public ResponseDto getAllBooks() {
		ResponseDto responseDto = new ResponseDto();
		Iterable<Book> bookList = bookRepository.findAll();
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		
		for(Book book : bookList) {
			BookDto bookDto = convertBookToBookDto(book);
			bookDtos.add(bookDto);
		}
		responseDto.setStatus(true);
		responseDto.setStatusMessage("Success");
		responseDto.setData(bookDtos);
		return responseDto;
	}

}
