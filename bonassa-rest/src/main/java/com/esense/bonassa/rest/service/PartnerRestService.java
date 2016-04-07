package com.esense.bonassa.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.rest.dto.PartnerDto;
import com.esense.bonassa.rest.dto.UserDto;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */

@Path("/partner")
@Produces(MediaType.APPLICATION_JSON)
public interface PartnerRestService {

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(PartnerDto customerDto);

	@Path("/listCustomer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCustomer(UserDto userDto);
	
	@Path("/listOpponent")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOpponent(UserDto userDto);
	
	@Path("/listOther")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOther(UserDto userDto);

	@Path("/selectById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectById(PartnerDto customerDto);
	
	@Path("/update")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(PartnerDto customerDto);

}
