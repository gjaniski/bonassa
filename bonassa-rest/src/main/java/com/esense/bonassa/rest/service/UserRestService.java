package com.esense.bonassa.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esense.bonassa.rest.dto.UserDto;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserRestService {

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(String login, String pwd);

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(UserDto userDto);

	@Path("/list")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(UserDto userDto);
	
	@Path("/update")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(UserDto userDto);

}
