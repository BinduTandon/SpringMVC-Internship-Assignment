package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.EmailRequest;
import com.api.service.EmailService;



@RestController
public class EmailController {
	@Autowired
	EmailService emailService;

	@PostMapping("/sendingMail")
	public String sendMail(@RequestBody EmailRequest request) {
		boolean result = this.emailService.sendEmail
				(request.getSubject(), request.getMessage(), request.getTo());
		if(result) {
			return "Email sent successfully...";
		}
		else
			return "Email sending failed";
	}
		
	
}
