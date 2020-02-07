package com.in28minutes.springboot.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User1 {
	String email;
	@XmlElement(name="name")
	String userName;
	@NotNull
	String password;
	
	public User1() {
		
	}
	
	public User1(String email, String userName, String password) {
		//super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
