package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.commonModel.ResponseDto;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/api/mail")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseDto sendMail(@RequestBody EmailDto emailDto) {
		ResponseDto responseDto = emailService.sendMail(emailDto);
		return responseDto;
	}
	
	
	

}
