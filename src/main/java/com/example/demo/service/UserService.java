package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.commonModel.ResponseDto;

public interface UserService {
	
	ResponseDto createUser(UserDto userDto);

	ResponseDto getAllUsers();

}
