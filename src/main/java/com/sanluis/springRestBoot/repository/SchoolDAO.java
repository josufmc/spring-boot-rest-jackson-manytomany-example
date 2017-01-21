package com.sanluis.springRestBoot.repository;

import java.util.ArrayList;

import com.sanluis.springRestBoot.domain.Student;
import com.sanluis.springRestBoot.domain.Subject;

public interface SchoolDAO {

	ArrayList<Student> getStudents();
	ArrayList<Subject> getSubjects();

}
