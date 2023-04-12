package com.example.demo.service;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.commonModel.ResponseDto;

public interface EmailService {

	ResponseDto sendMail(EmailDto emailDto);

}
