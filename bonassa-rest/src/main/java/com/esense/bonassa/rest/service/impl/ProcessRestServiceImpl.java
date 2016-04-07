package com.esense.bonassa.rest.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.core.exception.UnauthorizedException;
import com.esense.bonassa.core.service.AuthorizationService;
import com.esense.bonassa.core.service.ProcessService;
import com.esense.bonassa.rest.dto.ProcessAppointmentDto;
import com.esense.bonassa.rest.dto.ProcessAttachedDto;
import com.esense.bonassa.rest.dto.ProcessDto;
import com.esense.bonassa.rest.dto.ProcessIdDto;
import com.esense.bonassa.rest.dto.ProcessProgressDto;
import com.esense.bonassa.rest.dto.ProcessPropertyDto;
import com.esense.bonassa.rest.dto.ProcessRequestDto;
import com.esense.bonassa.rest.service.ProcessRestService;

@Component
public class ProcessRestServiceImpl implements ProcessRestService {

	@Autowired
	private AuthorizationService authorizationService;

	@Autowired
	private ProcessService processService;

	private Logger logger = Logger.getLogger(ProcessRestServiceImpl.class);

	@Override
	public Response list() {
		List<com.esense.bonassa.core.entity.Process> processes;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			processes = processService.selectAll();
			if (processes == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(processes).build();
		} catch (NullPointerException ex) {
			logger.error("Processes is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response select(ProcessDto processDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processDto == null)
				throw new NullPointerException();
			processService.selectById(processDto.getId());
			statusType = Status.OK;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insert(ProcessDto processDto) {
		StatusType statusType = null;;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processDto == null)
				throw new NullPointerException();
			processService.insert(ProcessDto.toProcess(processDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error("The Object is null");
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response update(ProcessDto processDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processDto == null)
				throw new NullPointerException();
			processService.update(ProcessDto.toProcess(processDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error(e.getMessage());
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insertProgress(ProcessProgressDto processProgressDto) {
		try {
			if (processProgressDto == null)
				throw new NullPointerException();
			processService.insertProgress(ProcessProgressDto
					.toProcessProgress(processProgressDto));
			return Response.status(Response.Status.OK).build();
		} catch (NullPointerException ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

	@Override
	public Response listProgress(ProcessIdDto processIdDto) {
		List<com.esense.bonassa.core.entity.ProcessProgress> progresses;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			progresses = processService.selectProgress(ProcessIdDto
					.toProcessId(processIdDto).getProcess().getId());						
			if (progresses == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(progresses).build();
		} catch (NullPointerException ex) {
			logger.error("Progress is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response updateProgress(ProcessProgressDto processProgressDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processProgressDto == null)
				throw new NullPointerException();
			processService.updateProcessProgress(ProcessProgressDto.toProcessProgress(processProgressDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insertAppointment(ProcessAppointmentDto processAppointmentDto) {
		try {
			if (processAppointmentDto == null)
				throw new NullPointerException();
			processService.insertProcessAppointment(ProcessAppointmentDto
					.toProcessAppointment(processAppointmentDto));
			return Response.status(Response.Status.OK).build();
		} catch (NullPointerException ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

	@Override
	public Response listAppointment(ProcessIdDto processIdDto) {
		List<com.esense.bonassa.core.entity.ProcessAppointment> appointments;
				
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			appointments = processService.selectProcessAppointment(ProcessIdDto
					.toProcessId(processIdDto).getProcess().getId());			
			if (appointments == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(appointments).build();
		} catch (NullPointerException ex) {
			logger.error("Appointment is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response updateAppointment(ProcessAppointmentDto processAppointmentDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processAppointmentDto == null)
				throw new NullPointerException();
			processService.updateProcessAppointment(ProcessAppointmentDto.toProcessAppointment(processAppointmentDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insertRequest(ProcessRequestDto processRequestDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processRequestDto == null)
				throw new NullPointerException();
			processService.insertProcessRequest(ProcessRequestDto.toProcessRequest(processRequestDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response listRequest(ProcessIdDto processIdDto) {
		List<com.esense.bonassa.core.entity.ProcessRequest> requests;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			requests = processService.selectProcessRequest(ProcessIdDto
					.toProcessId(processIdDto).getProcess().getId());						
			if (requests == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(requests).build();
		} catch (NullPointerException ex) {
			logger.error("Request is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response updateRequest(ProcessRequestDto processRequestDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processRequestDto == null)
				throw new NullPointerException();
			processService.updateProcessRequest(ProcessRequestDto.toProcessRequest(processRequestDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insertProperty(ProcessPropertyDto processPropertyDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processPropertyDto == null)
				throw new NullPointerException();
			processService.insertProcessProperty(ProcessPropertyDto.toProcessProperty(processPropertyDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response listProperty(ProcessIdDto processIdDto) {
		List<com.esense.bonassa.core.entity.ProcessProperty> properties;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			properties = processService.selectProcessProperty(ProcessIdDto
					.toProcessId(processIdDto).getProcess().getId());						
			if (properties == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(properties).build();
		} catch (NullPointerException ex) {
			logger.error("Progress is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response updateProperty(ProcessPropertyDto processPropertyDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processPropertyDto == null)
				throw new NullPointerException();
			processService.updateProcessProperty(ProcessPropertyDto.toProcessProperty(processPropertyDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response insertAttached(ProcessAttachedDto processAttachedDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processAttachedDto == null)
				throw new NullPointerException();
			processService.insertProcessAttached(ProcessAttachedDto.toProcessAttached(processAttachedDto));
			statusType = Status.OK;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory field is null");
			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response listAttached(ProcessIdDto processIdDto) {
		List<com.esense.bonassa.core.entity.ProcessAttached> attachedes;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			attachedes = processService.selectProcessAttached(ProcessIdDto
					.toProcessId(processIdDto).getProcess().getId());						
			if (attachedes == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(attachedes).build();
		} catch (NullPointerException ex) {
			logger.error("Attached is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response deleteAttached(ProcessAttachedDto processAttachedDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (processAttachedDto == null)
				throw new NullPointerException();
			processService.deleteProcessAttached(ProcessAttachedDto.toProcessAttached(processAttachedDto));
			statusType = Status.OK;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(statusType).build();
	}
}
