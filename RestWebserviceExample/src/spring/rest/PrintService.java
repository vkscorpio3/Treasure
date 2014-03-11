package spring.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import spring.context.SpringApplicationContext;
import spring.customer.CustomerBo;

//http://192.168.1.19:8080/RestWebserviceExample/rest/customer/print
@Path("/customer")
public class PrintService {

	CustomerBo customerBo;

	@GET
	@Path("/print")
	public Response printMessage() {

		customerBo = (CustomerBo) SpringApplicationContext.getBean("customerBo");
		
		String result = customerBo.getMsg();

		return Response.status(200).entity(result).build();

	}

}