package com.in28minutes.springboot.model;


import java.io.Serializable;

import javax.persistence.Column;
/**
 *Always use Annotation from JAVAX!!!
*If In future need to replace like other ORM framework 
*like Hibernate
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 //JPA to acknowledge the Data Entity
//public class Shipwreck extends ResourceSupport {
/**
 * INSERT INTO SHIPWRECK(ID, CONDITION, DEPTH,DESCRIPTION,LATITUDE,LONGITUDE,NAME,YEAR_DISCOVERED)
VALUES (3,'Khidirpur',2000,'FERARY WS Bug Ship',11.2,11.2,'fERARY',2013);
 * @author Rabi
 *
 */
@Entity 
public class Shipwreck {


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
Long id;  //Primary KEy 

String name;
String description;
String condition;
Integer depth;
Double latitude;
Double longitude;
Integer yearDiscovered;

/**
 * Default Constructor...Spring can create..
 */
public Shipwreck() { } 

public Shipwreck(Long id, String name, String description, String condition, Integer depth, Double latitude,
		Double longitude, Integer yearDiscovered) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.condition = condition;
	this.depth = depth;
	this.latitude = latitude;
	this.longitude = longitude;
	this.yearDiscovered = yearDiscovered;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getCondition() {
	return condition;
}

public void setCondition(String condition) {
	this.condition = condition;
}

public Integer getDepth() {
	return depth;
}

public void setDepth(Integer depth) {
	this.depth = depth;
}

public Double getLatitude() {
	return latitude;
}

public void setLatitude(Double latitude) {
	this.latitude = latitude;
}

public Double getLongitude() {
	return longitude;
}

public void setLongitude(Double longitude) {
	this.longitude = longitude;
}

public Integer getYearDiscovered() {
	return yearDiscovered;
}

public void setYearDiscovered(Integer yearDiscovered) {
	this.yearDiscovered = yearDiscovered;
}


@Override
public String toString() {
	return "Shipwreck [id=" + id + ", name=" + name + ", description=" + description + ", condition=" + condition
			+ ", depth=" + depth + ", latitude=" + latitude + ", longitude=" + longitude + ", yearDiscovered="
			+ yearDiscovered + "]";
}

}