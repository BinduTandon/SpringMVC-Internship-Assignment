package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private String ToEmail;
	
	private String subject;
	
	private String message;

	public EmailRequest() {
	
	}

	public EmailRequest(Integer iD, String to, String subject, String message) {
		this.ID = iD;
		this.ToEmail = to;
		this.subject = subject;
		this.message = message;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTo() {
		return ToEmail;
	}

	public void setTo(String to) {
		ToEmail = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailRequest [ID=" + ID + ", To=" + ToEmail + ", subject=" + subject + ", message=" + message + "]";
	}

	
	
	
}
