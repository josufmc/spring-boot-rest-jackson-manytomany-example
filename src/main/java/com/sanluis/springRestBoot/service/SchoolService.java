package com.sanluis.springRestBoot.service;

import java.util.ArrayList;

import com.sanluis.springRestBoot.domain.Student;
import com.sanluis.springRestBoot.domain.Subject;

public interface SchoolService {

	ArrayList<Student> getStudents();
	ArrayList<Subject> getSubjects();

}
