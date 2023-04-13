package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.commonModel.ResponseDto;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseDto addBook(@RequestBody BookDto bookDto) {
		ResponseDto responseDto = bookService.addBook(bookDto);
		return responseDto;
	}
	
	@GetMapping("/getAllBooks")
	public ResponseDto getrAllBooks() {
		ResponseDto responseDto = bookService.getAllBooks();
		return responseDto;
	}

}
