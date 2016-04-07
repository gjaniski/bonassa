package com.esense.bonassa.core.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.UserDao;
import com.esense.bonassa.core.entity.Group;
import com.esense.bonassa.core.entity.Resource;
import com.esense.bonassa.core.entity.Ticket;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.AuthorizationException;
import com.esense.bonassa.core.exception.ResultNotFoundException;
import com.esense.bonassa.core.exception.UnauthorizedException;
import com.esense.bonassa.core.service.AuthorizationService;
import com.esense.bonassa.core.service.ResourceService;

/**
 * @author Douglas Cardoso
 *
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	private String login;
	private String password;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ResourceService resourceService;

	private final Logger logger = Logger
			.getLogger(AuthorizationServiceImpl.class);

	private boolean validateTicket(Ticket ticket) throws UnauthorizedException {

		DateTime dt = new DateTime(ticket.getDate());
		DateTime after = dt.plusMinutes(30);
		DateTime now = new DateTime(new Date());
		if (logger.isDebugEnabled()) {
			logger.debug("30 minuts after: " + after.getMillis());
			logger.debug("Now: " + now.getMillis());
		}
		if (after.getMillis() >= now.getMillis()) return true;
		return false;
	}

	public boolean getAuthorization(String resourceName, User user) {
		return true;
//		try {
//			if (validateTicket(user.getTicket())) {
//				if (resourceName != null) {
//					Resource resource = resourceService
//							.selectByName(resourceName);
//					if (resource == null) throw new ResultNotFoundException();
//					if (compareGroups(resource.getGroups(), user.getGroups()))
//						return true;
//
//					throw new UnauthorizedException();
//				}
//				return true;
//			} else {
//				throw new AuthorizationException();
//			}
//		} catch (UnauthorizedException ex) {
//			logger.error("Operation not allowed for this user");
//		} catch (AuthorizationException ex) {
//			logger.error("Ticket is not valid");
//		} catch (ResultNotFoundException ex) {
//			logger.error("Result not found");
//		}
//		return false;
	}

	@Override
	public User authentication(String login, String password)
			throws UnauthorizedException {
		try {
			if (login == null || password == null)
				throw new NullPointerException();
			if (login.isEmpty() || password.isEmpty())
				throw new IllegalArgumentException();
			this.login = login;
			this.password = password;
			User user = login();
			return user;
		} catch (NullPointerException e) {
			logger.error("'login' or 'password' is null");
			return null;
		} catch (IllegalArgumentException e) {
			logger.error("'login' or 'password' is empty");
			return null;
		} catch (AuthorizationException e) {
			logger.error("User is duplicated");
			return null;
		}
	}

	private User generateTicket(User user) {
		try {
			UUID uuid = UUID.randomUUID();
			Ticket ticket = new Ticket();
			ticket.setTicket(uuid.toString());
			ticket.setDate(new Date());
			user.setTicket(ticket);
			int id = userDao.generateTicket(user);
			if (id == 0) throw new AuthorizationException();
			if (logger.isDebugEnabled()) logger.debug("'id':" + id);
			return user;
		} catch (AuthorizationException e) {
			logger.error("It was not possible to creat the ticket");
			return null;
		}
	}

	private User login() throws UnauthorizedException, AuthorizationException {
		User user = new User();
		user.createCriterion("login_", Operator.EQUALS, "'" + login + "'");
		user.createCriterion("password_", Operator.EQUALS, "'" + password + "'");
		List<User> users = userDao.select(user);

		if (users.isEmpty()) {
			throw new UnauthorizedException("Login or password invalid");
		} else if (users.size() > 1) {
			throw new AuthorizationException();
		} else {
			user = users.get(0);
			user = generateTicket(user);
		}
		return user;
	}

	private boolean compareGroups(List<Group> resourceGroups,
			List<Group> userGroups) {
		for (Group userGroup : userGroups) {
			for (Group resourceGroup : resourceGroups) {
				if (userGroup.getId() == resourceGroup.getId()) return true;
			}
		}
		return false;
	}

	@Override
	public boolean getAuthorization(String resource, String ticket,
			Integer userId) {
		return true;
	}

}
