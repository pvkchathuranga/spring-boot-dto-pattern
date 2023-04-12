package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Email;
import com.example.demo.dto.EmailDto;
import com.example.demo.dto.commonModel.ResponseDto;
import com.example.demo.repository.EmailRepository;
import com.example.demo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Value("${sender.email}")
	private String senderMail;
	
	@Override
	public ResponseDto sendMail(EmailDto emailDto) {
		ResponseDto responseDto = new  ResponseDto();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(senderMail);
		message.setTo(emailDto.getEmailAddress());
		message.setSubject(emailDto.getEmailSubject());
		message.setText(emailDto.getEmailBody());
		
		try {
			javaMailSender.send(message);
			Email emailSaveToDB = convertEmailDtoToEmail(emailDto);
			emailRepository.save(emailSaveToDB);
			
			responseDto.setStatus(true);
			responseDto.setStatusMessage("Success");
			responseDto.setData(emailSaveToDB);
			return responseDto;
		}catch (Exception e) {
			
			responseDto.setStatus(false);
			responseDto.setStatusMessage(e.getMessage());
			return responseDto;
		}

	}
	
	private Email convertEmailDtoToEmail(EmailDto emailDto) {
		
		Email email = new Email();
		email.setEmailAddress(emailDto.getEmailAddress());
		email.setEmailSubject(emailDto.getEmailSubject());
		email.setEmailBody(emailDto.getEmailBody());
		
		return email;
		
	}

}
