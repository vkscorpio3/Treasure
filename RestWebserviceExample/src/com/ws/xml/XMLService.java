package com.ws.xml;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//http://192.168.1.19:8080/RestWebserviceExample/rest/xml/user/get
@Path("/xml/user")
public class XMLService {

	@GET
	@Path("/get")
	@Produces("application/xml")
	public User getUserInXML() {

		User user = new User();
		user.setUsername("ganesan");
		user.setPassword("password");
		user.setId(123456);
		
		UserAttribute useratt = new UserAttribute();
		useratt.setAddress("chennai");
		useratt.setDob("27031987");
		
		
		UserAttribute useratt1 = new UserAttribute();
		useratt1.setAddress("newyork");
		useratt1.setDob("27031987");
		
		ArrayList<UserAttribute> ar = new ArrayList<UserAttribute>();
		ar.add(useratt);
		ar.add(useratt1);
		
		
		
		user.setUserAttributelist(ar);
		user.setUserAttribute(useratt);
		
		
		
		
		
		return user; 

	}

}