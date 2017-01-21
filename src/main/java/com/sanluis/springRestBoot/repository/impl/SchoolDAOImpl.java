package com.sanluis.springRestBoot.repository.impl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanluis.springRestBoot.domain.Student;
import com.sanluis.springRestBoot.domain.Subject;
import com.sanluis.springRestBoot.repository.SchoolDAO;

@Repository
public class SchoolDAOImpl implements SchoolDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly=true)
	public ArrayList<Student> getStudents() {
		Criteria c = currentSession().createCriteria(Student.class);
		ArrayList<Student> objs = (ArrayList<Student>) c.list();
		return objs;
	}

	@Override
	@Transactional(readOnly=true)
	public ArrayList<Subject> getSubjects() {
		Criteria c = currentSession().createCriteria(Subject.class);
		ArrayList<Subject> objs = (ArrayList<Subject>) c.list();
		return objs;
	}

}
