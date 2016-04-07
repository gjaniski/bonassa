package com.esense.bonassa.core.service;

import java.util.List;

import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.MandatoryFieldException;

/**
 * 
 * @author Gerson Janiski
 * @author Marcelino Ulica
 *
 */
  public interface UserService {

	public void insert(User user) throws MandatoryFieldException;
	
	public void update(User user) throws MandatoryFieldException;

	public List<User> selectAll();

	public User selectById(Integer id);

	public void insertUserGroups(User user);
}
