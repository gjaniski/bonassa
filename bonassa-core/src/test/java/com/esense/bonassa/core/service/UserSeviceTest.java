package com.esense.bonassa.core.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.esense.bonassa.core.entity.Group;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.MandatoryFieldException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class UserSeviceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private GroupService groupService;

	@Test
	public void init() {
		Assert.notNull(userService);
	}

	@Test
	public void insert() throws MandatoryFieldException {

		List<Group> groups = new ArrayList<Group>();

		groups.add(groupService.selectByName("ROLE_ADMINISTRATOR"));
		groups.add(groupService.selectByName("ROLE_USER"));

		User user = new User();

		user.setName("firstName");
		user.setEmail("email");
		user.setLogin("login");
		user.setPwd("password");
		user.setFederalId("federalId");
		user.setStatus(1);
		user.setGroups(groups);
//		user.setGroups(groupService.selectByName("ROLE_USER"));

		userService.insert(user);
		System.out.println(user);
	}
	
//	@Test
//	public void list(){
//		
//		List<User> users = userService.selectAll();
//		
//		for(User user : users){
//			if(user.getCity() != null)
				//System.out.println(user.getCity().getValue());
			
//		}
		
//	}
}
