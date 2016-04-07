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
import com.esense.bonassa.core.service.PartnerService;
import com.esense.bonassa.rest.dto.PartnerDto;
import com.esense.bonassa.rest.dto.UserDto;
import com.esense.bonassa.rest.service.PartnerRestService;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */
@Component
public class PartnerRestServiceImpl implements PartnerRestService {

	@Autowired
	private PartnerService customerService;

	@Autowired
	private AuthorizationService authorizationService;

	private Logger logger = Logger.getLogger(PartnerRestServiceImpl.class);

	@Override
	public Response insert(PartnerDto customerDto) {
		StatusType status = Status.OK;
		
		try {
			if (customerDto == null) throw new IllegalArgumentException();
			if (!authorizationService.getAuthorization("teste",
					UserDto.toUserFromDto(customerDto.getUserDto())))
				throw new UnauthorizedException();
			customerService.insert(PartnerDto.toCustomer(customerDto));
		} catch (IllegalArgumentException ex) {
			logger.error("Customer object is null");
			status = Status.BAD_REQUEST;
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			status = Status.BAD_REQUEST;
		}
		return Response.status(status).build();
	}

	@Override
	public Response listCustomer(UserDto userDto) {
		StatusType status = Status.OK;
		List<PartnerDto> list = null;
		try {
			if (!authorizationService.getAuthorization("teste2",
					UserDto.toUserFromDto(userDto)))
				throw new UnauthorizedException();
			list = PartnerDto.fromListCustomer(customerService.customer());
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(list).build();
	}

	@Override
	public Response selectById(PartnerDto customerDto) {
		StatusType status = Status.OK;
		PartnerDto list = null;
		try {
			if (!authorizationService.getAuthorization("teste3",
					UserDto.toUserFromDto(customerDto.getUserDto())))
				throw new UnauthorizedException();
			list = PartnerDto.fromCustomer(customerService
					.selectById(customerDto.getId()));
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(list).build();
	}

	@Override
	public Response update(PartnerDto customerDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (customerDto == null)
				throw new NullPointerException();
			customerService.update(PartnerDto.toCustomer(customerDto));
			statusType = Status.OK;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		} catch (MandatoryFieldException e) {
			logger.error(e.getMessage());
			statusType = Status.BAD_REQUEST;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response listOpponent(UserDto userDto) {
		StatusType status = Status.OK;
		List<PartnerDto> list = null;
		try {
			if (!authorizationService.getAuthorization("teste2",
					UserDto.toUserFromDto(userDto)))
				throw new UnauthorizedException();
			list = PartnerDto.fromListCustomer(customerService.opponent());
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(list).build();
	}

	@Override
	public Response listOther(UserDto userDto) {
		StatusType status = Status.OK;
		List<PartnerDto> list = null;
		try {
			if (!authorizationService.getAuthorization("teste2",
					UserDto.toUserFromDto(userDto)))
				throw new UnauthorizedException();
			list = PartnerDto.fromListCustomer(customerService.other());
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			status = Status.FORBIDDEN;
		}
		return Response.status(status).entity(list).build();
	}

}
