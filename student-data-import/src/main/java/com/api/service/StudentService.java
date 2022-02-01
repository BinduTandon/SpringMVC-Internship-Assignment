package com.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Student;


public interface StudentService {

	public List<Student> findAll();
	
	public void save(MultipartFile file);
	
	
}
