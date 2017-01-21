package com.sanluis.springRestBoot.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="students")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE) 
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1180467747661697518L;

	@Id
	@Column(name="id")
	@JsonProperty(value="id")
	private int id;
	
	@Column(name="name")
	@JsonProperty(value="name")
	private String name;
	
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="students_subjects", 
		joinColumns={@JoinColumn(name="subjects_id", referencedColumnName="id")},	// name = columna, referencedColumnName = atributo
		inverseJoinColumns={@JoinColumn(name="students_id", referencedColumnName="id")}
	)
	@JsonProperty(value="subjects")	// Necesario usar EAGER para que nos lo incluya, si no error
	private Set<Subject> subjects = new HashSet<Subject>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	

}
