package com.api.service;

public interface EmailService {

	public boolean sendEmail(String subject, String body, String toEmail);
}
