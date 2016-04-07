package com.esense.bonassa.core.service;

import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.UnauthorizedException;

/**
 * @author douglas
 *
 */
public interface AuthorizationService {

	public boolean getAuthorization(String resource, User user);
	
	public boolean getAuthorization(String resource, String ticket, Integer userId);

	public User authentication(String login, String pwd)
			throws UnauthorizedException;

}
