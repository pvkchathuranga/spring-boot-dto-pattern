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
import com.example.demo.repository.UserReopsitory;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserReopsitory userReopsitory;
	
	@Autowired
	private BookService bookService;
	
	@Override
	public ResponseDto createUser(UserDto userDto) {
		ResponseDto responseDto = new ResponseDto();
		User user = convertUserDtoToUser(userDto);
		userReopsitory.save(user);
		responseDto.setStatus(true);
		responseDto.setStatusMessage("Success");
		responseDto.setData(user);
		return responseDto;
	}
	
	

	private User convertUserDtoToUser(UserDto userDto) {
		
		User user = new User();
		
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());

		return user;
		
	}
	
	private UserDto convertUserToUserDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setAddress(user.getAddress());
		
		Iterable<Book> books = user.getBooks();
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		for(Book book : books) {

			BookDto bookDto = bookService.convertBookToBookDto(book);
			bookDtos.add(bookDto);

		}
		userDto.setBookDtos(bookDtos);
		
		return userDto;
	}


	@Override
	public ResponseDto getAllUsers() {
		ResponseDto responseDto = new ResponseDto();
		Iterable<User> userList = userReopsitory.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user : userList) {
			UserDto userDto = convertUserToUserDto(user);
			userDtos.add(userDto);
		}
		responseDto.setStatus(true);
		responseDto.setStatusMessage("Success");
		responseDto.setData(userDtos);
		return responseDto;
	}

}
