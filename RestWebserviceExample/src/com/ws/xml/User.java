package com.ws.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

	String username;
	String password;
	int id;
	
	UserAttribute userAttribute;
	
	ArrayList<UserAttribute> userAttributelist;

	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public UserAttribute getUserAttribute() {
		return userAttribute;
	}

	public void setUserAttribute(UserAttribute userAttribute) {
		this.userAttribute = userAttribute;
	}

	@XmlElement
	public ArrayList<UserAttribute> getUserAttributelist() {
		return userAttributelist;
	}

	public void setUserAttributelist(ArrayList<UserAttribute> userAttributelist) {
		this.userAttributelist = userAttributelist;
	}

	
	
	
	
	

}
