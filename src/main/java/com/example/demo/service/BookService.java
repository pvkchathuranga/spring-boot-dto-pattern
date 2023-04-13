package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.commonModel.ResponseDto;

public interface BookService {

	ResponseDto addBook(BookDto bookDto);

	ResponseDto getAllBooks();

}
