package com.in28minutes.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AngularUser {
	@Id
	private Long Id;
	private String name;
	private String email;
	private String experience;
	private String domain;
	
	public AngularUser() {}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	
	}

	


