package com.sanluis.springRestBoot.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="subjects")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Subject implements Serializable{
	
	private static final long serialVersionUID = -2885056111094559192L;

	@Id
	@Column(name="id")
	@JsonProperty(value="id")
	private int id;
	
	@Column(name="name")
	@JsonProperty(value="name")
	private String name;
	
	@ManyToMany(mappedBy="subjects", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<Student> students = new HashSet<Student>();

	
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
	
	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	
	

}
