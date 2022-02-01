package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{
	

}
