package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Student;
import com.api.helper.HelperToUpload;
import com.api.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentService.findAll();
	}

	@PostMapping("/student/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		if (HelperToUpload.checkFormat(file)) {
			studentService.save(file);
			return "File uploaded to Db successfully";
		}

		return "please upload only excel files";
	}

}
