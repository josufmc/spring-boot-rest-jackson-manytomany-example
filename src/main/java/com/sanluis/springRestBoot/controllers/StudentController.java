package com.sanluis.springRestBoot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanluis.springRestBoot.domain.Student;
import com.sanluis.springRestBoot.service.SchoolService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	SchoolService schoolService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<Student> getStudents(){
		ArrayList<Student> list = schoolService.getStudents();
		for(Student s: list){
			s.getSubjects();
		}
		return list;
	}

}
