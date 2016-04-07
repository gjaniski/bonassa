package com.esense.bonassa.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.rest.dto.ParameterDto;

/**
 * @author Douglas Cardoso
 * 
 * */
@Path("/parameter")
@Produces(MediaType.APPLICATION_JSON)
public interface ParameterRestService {

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list();

	@Path("/insert")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response insert(ParameterDto paramDto);

	@Path("/insertValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertValue(@QueryParam("paramId") Integer paramId,
			@QueryParam("parentId") Integer parentId,
			@QueryParam("value") String value);

	@Path("/updateValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateValue(@QueryParam("paramId") Integer paramId,
			@QueryParam("parentId") Integer parentId,
			@QueryParam("value") String value) throws MandatoryFieldException;

	@Path("/selectByName")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectByName(ParameterDto parameterDto);
	
	@Path("/selectById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectById(ParameterDto parameterDto);
	
//	@Path("/selectByParent")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response selectByParent(ParameterDto parameterDto);

}
