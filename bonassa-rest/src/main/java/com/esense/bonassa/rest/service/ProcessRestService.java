package com.esense.bonassa.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esense.bonassa.rest.dto.ProcessAppointmentDto;
import com.esense.bonassa.rest.dto.ProcessAttachedDto;
import com.esense.bonassa.rest.dto.ProcessDto;
import com.esense.bonassa.rest.dto.ProcessIdDto;
import com.esense.bonassa.rest.dto.ProcessProgressDto;
import com.esense.bonassa.rest.dto.ProcessPropertyDto;
import com.esense.bonassa.rest.dto.ProcessRequestDto;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */
@Path("/process")
@Produces(MediaType.APPLICATION_JSON)
public interface ProcessRestService {

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list();

	@Path("/select")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response select(ProcessDto processDto);

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(ProcessDto processDto);

	@Path("/update")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(ProcessDto processDto);

	@Path("/insertProgress")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProgress(ProcessProgressDto processProgressDto);

	@Path("/listProgress")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listProgress(ProcessIdDto processIdDto);

	@Path("/updateProgress")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProgress(ProcessProgressDto processProgressDto);

	@Path("/insertAppointment")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAppointment(ProcessAppointmentDto processAppointmentDto);
	
	@Path("/listAppointment")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAppointment(ProcessIdDto processIdDto);

	@Path("/updateAppointment")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAppointment(ProcessAppointmentDto processAppointmentDto);

	@Path("/insertRequest")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertRequest(ProcessRequestDto processRequestDto);
	
	@Path("/listRequest")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listRequest(ProcessIdDto processIdDto);

	@Path("/updateRequest")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRequest(ProcessRequestDto processRequestDto);

	@Path("/insertProperty")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProperty(ProcessPropertyDto processPropertyDto);
	
	@Path("/listProperty")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listProperty(ProcessIdDto processIdDto);

	@Path("/updateProperty")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProperty(ProcessPropertyDto processPropertyDto);

	@Path("/insertAttached")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAttached(ProcessAttachedDto processAttachedDto);
	
	@Path("/listAttached")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAttached(ProcessIdDto processIdDto);

	@Path("/deleteAttached")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAttached(ProcessAttachedDto processAttachedDto);

}
