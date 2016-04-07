package com.esense.bonassa.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esense.bonassa.core.entity.User;

/**
 * @author Douglas Cardoso
 * 
 * */
@Path("/authorization")
@Produces(MediaType.APPLICATION_JSON)
public interface AuthorizationRestService {

	@Path("/login")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("login") String login,
			@QueryParam("password") String password);

	@Path("/logout")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void logout(User user);

}
