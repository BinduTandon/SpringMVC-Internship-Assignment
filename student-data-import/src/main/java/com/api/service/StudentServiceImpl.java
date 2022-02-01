package com.api.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Student;
import com.api.helper.HelperToUpload;
import com.api.repository.StudentRepo;



@Service

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Override
	public List<Student> findAll() {

		return studentRepo.findAll();
	}

	@Override
	public void save(MultipartFile file) {
		try {
			List<Student> students = HelperToUpload.convertExceltoListOfStudent(file.getInputStream());
			studentRepo.saveAll(students);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
