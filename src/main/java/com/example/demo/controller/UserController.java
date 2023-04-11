package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.commonModel.ResponseDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public String getUser() {
		return "User Can access get request!";
	}
	
	@PostMapping("/createUser")
	public ResponseDto createUser(@RequestBody UserDto userDto) {
		ResponseDto responseDto = userService.createUser(userDto);
		return responseDto;
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseDto getAllUsers() {
		ResponseDto responseDto = userService.getAllUsers();
		return responseDto;
	}
	
	

}
