package com.sanluis.springRestBoot.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanluis.springRestBoot.domain.Student;
import com.sanluis.springRestBoot.domain.Subject;
import com.sanluis.springRestBoot.repository.SchoolDAO;
import com.sanluis.springRestBoot.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	SchoolDAO schoolDAO;

	@Override
	public ArrayList<Student> getStudents() {
		return schoolDAO.getStudents();
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		return schoolDAO.getSubjects();
	}

	
	

}
