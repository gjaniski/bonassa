package com.esense.bonassa.core.service.impl;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.UserDao;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.core.exception.ServiceException;
import com.esense.bonassa.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public void insert(User user) throws MandatoryFieldException {	
				
		try {
			if (user == null)
				throw new NullPointerException();
			if (!user.validateNullAttrs())
				throw new MandatoryFieldException();
			
			System.out.println("Aqui");
			
			userDao.insert(user);
			insertUserGroups(user);
		} catch (NullPointerException ex) {
			logger.error("User is null");
		}
	}

	@Override
	public void insertUserGroups(User user) {
		for (Integer i = 0; i <  user.getGroups().size(); i++) {			
			userDao.insertUserGroup(user.getId(), user.getGroups().get(i).getId());
		}
	}

	@Override
	public List<User> selectAll() {
		return userDao.select(new User());
	}

	@Override
	public User selectById(Integer id) {

		User user = null;
		try {
			User query = new User();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<User> result = userDao.select(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			user = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}

		return user;
	}

	@Override
	public void update(User user) throws MandatoryFieldException {
		try {
			if (user == null)
				throw new NullPointerException();
			if (!user.validateNullAttrs())
				throw new MandatoryFieldException();
			userDao.update(user);
			userDao.deleteUserGroups(user);
			insertUserGroups(user);						
		} catch (NullPointerException ex) {
			logger.error("User is null");
		}
	}
}
