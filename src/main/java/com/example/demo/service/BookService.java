package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;

public interface BookService {

	BookDto convertBookToBookDto(Book book);

}
