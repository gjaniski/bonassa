package com.esense.bonassa.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esense.bonassa.core.entity.User;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public interface UserDao {

	public int insert(User user);

	public void update(User user);
	
	public void deleteUserGroups(User user);

	public List<User> select(User query);

	public int insertSelective(User user);

	public User selectByPrimaryKey(String id);

	public int generateTicket(User user);

	public void insertUserGroup(@Param("userId") Integer userId,
			@Param("groupId") Integer groupId);

	// public String selectTicketByPrimaryKey(int id);

	// public Ticket selectTicket()

}
