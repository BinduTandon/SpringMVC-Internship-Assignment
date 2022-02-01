package com.api.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	

	@Override
	public boolean sendEmail(String subject, String message, String to) {
		boolean email = false; 

		String senderEmail = "apitesting228@gmail.com"; 
		String senderPassword = "apitesting"; 

		// Properties class enables us to connect to the host SMTP server
		Properties properties = new Properties();

	
		// Setup host and mail server
		properties.put("mail.smtp.auth", "true"); 
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587"); 
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {

			MimeMessage msg = new MimeMessage(session); 

			msg.setFrom(new InternetAddress(senderEmail)); 
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			msg.setSubject(subject); 
			msg.setText(message);

			Transport.send(msg); 
			System.out.println("Email Sent Successfully...");

			email = true; 

		} catch (Exception e) {

			System.out.println("EmailService File Error" + e);
		}

		return email; 
	}

}
