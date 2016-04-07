package com.esense.bonassa.rest.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esense.bonassa.core.exception.UnauthorizedException;
import com.esense.bonassa.core.service.AuthorizationService;
import com.esense.bonassa.core.service.ParameterService;
import com.esense.bonassa.rest.dto.ParameterDto;
import com.esense.bonassa.rest.service.ParameterRestService;

/**
 * @author Douglas Cardoso
 * 
 * */
@Component
public class ParameterRestServiceImpl implements ParameterRestService {

	@Autowired
	private ParameterService parameterService;

	@Autowired
	private AuthorizationService authorizationService;

	private final Logger logger = Logger
			.getLogger(ParameterRestServiceImpl.class);

	@Override
	public Response list() {
		List<ParameterDto> dto = ParameterDto
				.fromListParameter(parameterService.list());
		return Response.status(Status.OK).entity(dto).build();
	}

	@Override
	public Response insert(ParameterDto paramDto) {
		try {
			if (paramDto == null) throw new NullPointerException();
			parameterService.insert(ParameterDto.toParameter(paramDto));
			return Response.status(Response.Status.OK).build();
		} catch (NullPointerException ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Override
	public Response insertValue(Integer paramId, Integer parentId, String value) {		
		try {
			if (logger.isDebugEnabled())
				logger.debug("Parameter 'paramId' " + paramId + "'parentId' "
						+ parentId + "'value' " + value);
			if (paramId == null || value.isEmpty())
				throw new NullPointerException();
			parameterService.insertValue(paramId, parentId, value);
			return Response.status(Response.Status.OK).build();
		} catch (NullPointerException ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Override
	public Response updateValue(Integer paramId, Integer parentId, String value) {
		try{
			if(paramId == null || value.isEmpty())
				throw new NullPointerException();
			
			parameterService.updateValue(paramId, parentId, value);
			return Response.status(Response.Status.OK).build();
		} catch (NullPointerException ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();			
		}
	}

	@Override
	public Response selectByName(ParameterDto parameterDto) {
		StatusType status = Status.OK;
		try {
			if (!authorizationService.getAuthorization(null,
					parameterDto.getTicket(), parameterDto.getUserId()))
				throw new UnauthorizedException();
			parameterDto = ParameterDto.fromParameter(parameterService
					.selectByName(parameterDto.getName()));
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(parameterDto).build();
	}

	@Override
	public Response selectById(ParameterDto parameterDto) {
		StatusType status = Status.OK;
		try {
			if (!authorizationService.getAuthorization(null,
					parameterDto.getTicket(), parameterDto.getUserId()))
				throw new UnauthorizedException();
			parameterDto = ParameterDto.fromParameter(parameterService
					.selectById(parameterDto.getId()));
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(parameterDto).build();
	}

	// @Override
	// public Response selectByParent(ParameterDto parameterDto) {
	// StatusType status = Status.OK;
	// try {
	// if (!authorizationService.getAuthorization(null,
	// parameterDto.getTicket(), parameterDto.getUserId()))
	// throw new UnauthorizedException();
	// parameterDto = ParameterDto.fromParameter(parameterService
	// .selectByParent(parameterDto.getId()));
	// } catch (UnauthorizedException ex) {
	// logger.error("Ticket is not valid");
	// status = Status.FORBIDDEN;
	// }
	// return Response.status(status).entity(parameterDto).build();
	// }
}
