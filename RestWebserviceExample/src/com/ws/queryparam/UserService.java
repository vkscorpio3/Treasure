package com.ws.queryparam;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



@Path("/users")
public class UserService {

	
	//http://192.168.1.19:8080/RestWebserviceExample/rest/users/query?from=10&to=99999&orderBy=test,test1
	@GET
	@Path("/query")
	public Response getUsers(@DefaultValue("1000") @QueryParam("from") int from,
			@DefaultValue("999")@QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	
	//http://192.168.1.19:8080/RestWebserviceExample/rest/users/queryUriInfo?from=10&to=99999&orderBy=test,test1
	@GET
	@Path("/queryUriInfo")
	public Response getUsers(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		
		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	
	//http://192.168.1.19:8080/RestWebserviceExample/rest/users/pathParam/5555
	@GET
	@Path("pathParam/{id}")
	public Response getUserById(@PathParam("id") String id) { 
	   return Response.status(200).entity("getUserById is called, id : " + id).build(); 
	}
	
	//http://192.168.1.19:8080/RestWebserviceExample/rest/users/matrixParam/5555;author=GANESAN;country=IN
	@GET
	@Path("matrixParam/{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {
 
		return Response
			.status(200)
			.entity("getBooks is called, year : " + year
				+ ", author : " + author + ", country : " + country)
			.build();
 
	}
	
	
	
	//http://192.168.1.19:8080/RestWebserviceExample/formparam.html
	@POST
	@Path("/add")
	public Response addUser(
		@FormParam("name") String name,
		@FormParam("age") int age) {
 
		return Response.status(200)
			.entity("addUser is called, name : " + name + ", age : " + age)
			.build();
 
	}
	
	
	
	//http://192.168.1.19:8080/RestWebserviceExample/rest/users/get
	@GET
	@Path("/get")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {
 
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}

}