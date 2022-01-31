package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageRestService {
	@GET
	@Path("/helloWorld")
	public Response helloWorld() {
		String result = "Hello World";
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/helloWorld/{param}")
	public Response helloWorld(@PathParam("param") String msg) {
		String result = msg + " Hello the World";
		return Response.status(200).entity(result).build();
	}
}