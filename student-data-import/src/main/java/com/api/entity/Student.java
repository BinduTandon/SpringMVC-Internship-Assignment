package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer StdID;
	
	private String StdName;

	private String StdEmail;
	
	private int StdPhoneNo;

	public Student(Integer iD, String name, String email, int phoneNo) {
		this.StdID = iD;
		this.StdName = name;
		this.StdEmail = email;
		this.StdPhoneNo = phoneNo;
	}

	public Student() {
		
	}

	public Integer getID() {
		return StdID;
	}

	public void setID(Integer iD) {
		StdID = iD;
	}

	public String getName() {
		return StdName;
	}

	public void setName(String name) {
		StdName = name;
	}

	public String getEmail() {
		return StdEmail;
	}

	public void setEmail(String email) {
		StdEmail = email;
	}

	public int getPhoneNo() {
		return StdPhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		StdPhoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Student [ID=" + StdID + ", Name=" + StdName + ", Email=" + StdEmail + ", PhoneNo=" + StdPhoneNo + "]";
	}
	
	
	
}
