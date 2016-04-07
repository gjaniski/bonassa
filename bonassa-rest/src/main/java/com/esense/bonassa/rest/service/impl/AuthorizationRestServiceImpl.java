package com.esense.bonassa.rest.service.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.UnauthorizedException;
import com.esense.bonassa.core.service.AuthorizationService;
import com.esense.bonassa.rest.service.AuthorizationRestService;

@Component
public class AuthorizationRestServiceImpl implements AuthorizationRestService {

	@Autowired
	private AuthorizationService authorizationService;

	private Logger logger = Logger.getLogger(AuthorizationRestService.class);

	@Override
	public Response login(String login, String password) {
		User user = null;
		try {
			if (login == null || password == null)
				throw new NullPointerException();
			user = authorizationService.authentication(login, password);
		} catch (NullPointerException ex) {
			logger.error("Login or password is null");
			return Response.status(Status.BAD_REQUEST).entity(user).build();
		} catch (UnauthorizedException ex) {
			logger.error("Login or password is incorrect");
			return Response.status(Status.UNAUTHORIZED).entity(user).build();
		}
		return Response.status(Status.OK).entity(user).build();
	}

	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub

	}

}
