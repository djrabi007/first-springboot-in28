package com.in28minutes.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
	private String aId;
	private String aName;
	
	public Alien() {}
	public Alien(String aId, String aName) {
		super();
		this.aId = aId;
		this.aName = aName;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	
	
	
	

}
