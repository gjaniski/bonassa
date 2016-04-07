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
import com.esense.bonassa.core.service.UserService;
import com.esense.bonassa.rest.dto.UserDto;
import com.esense.bonassa.rest.service.UserRestService;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */

@Component
public class UserRestServiceImpl implements UserRestService {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorizationService authorizationService;

	private Logger logger = Logger.getLogger(UserRestServiceImpl.class);

	// private final Logger logger =
	// Logger.getLogger(UserRestServiceImpl.class);

	@Override
	public Response login(String login, String pwd) {
		// try {
		// if (login == null || pwd == null) throw new NullPointerException();
		// if (login.isEmpty() || pwd.isEmpty())
		// throw new IllegalArgumentException();
		// UserDto dto = UserDto.fromUser(authorizationService.authentication(
		// login, pwd));
		// if (users.isEmpty()) throw new UnauthorizedException();
		// if (users.size() > 1)
		// return Response.status(Status.OK).entity(users).build();
		// return Response.status(Status.OK).entity(users.get(0)).build();
		// } catch (NullPointerException e) {
		// if (logger.isDebugEnabled())
		// logger.debug("'login' || 'password' is null");
		// return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		// } catch (IllegalArgumentException e) {
		// if (logger.isDebugEnabled())
		// logger.debug("'login' || 'password' is invalid");
		// return Response.status(Status.BAD_REQUEST).build();
		// } catch (UnauthorizedException e) {
		// if (logger.isDebugEnabled()) logger.debug("User not authorized");
		// return Response.status(Status.FORBIDDEN).build();
		// }
		return null;
	}

	@Override
	public Response insert(UserDto userDto) {
		StatusType statusType = null;
								
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (userDto == null)
				throw new NullPointerException();
			userService.insert(UserDto.toUserFromDto(userDto));
			statusType = Status.OK;
//		} catch (MandatoryFieldException e) {
//			logger.error(e.getMessage());
//			statusType = Status.BAD_REQUEST;
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		}
		return Response.status(statusType).build();
	}

	@Override
	public Response list(UserDto userDto) {
		List<com.esense.bonassa.core.entity.User> user;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			user = userService.selectAll();						
			if (user == null)
				throw new NullPointerException();
			return Response.status(Status.OK).entity(user).build();
		} catch (NullPointerException ex) {
			logger.error("User is null");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (UnauthorizedException ex) {
			logger.error("Ticket is not valid");
			return Response.status(Status.FORBIDDEN).build();
		}
	}

	@Override
	public Response update(UserDto userDto) {
		StatusType statusType = null;
		try {
			if (!authorizationService.getAuthorization(null, null, null))
				throw new UnauthorizedException();
			if (userDto == null) 
				throw new NullPointerException();
			userService.update(UserDto.toUserFromDto(userDto));
			statusType = Status.OK;
//			if(userDto.getId() == null) throw new MandatoryFieldException();
		} catch (UnauthorizedException e) {
			logger.error("Ticket is not valid or resource is forbidden");
			statusType = Status.FORBIDDEN;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			statusType = Status.INTERNAL_SERVER_ERROR;
		} catch (MandatoryFieldException e) {
			logger.error("Mandatory Field is null");
			statusType = Status.BAD_REQUEST;
		}
		return Response.status(statusType).build();
	}

	// private String generateTicket(UserDto){
	//
	// }
}
