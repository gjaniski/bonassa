package com.esense.bonassa.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.esense.bonassa.core.entity.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class GroupSeviceTest {

	@Autowired
	private GroupService groupService;

	@Test
	public void init() {
		Assert.notNull(groupService);
	}

	@Test
	public void insert() {

		Group group = new Group();

		group.setName("Marcelino");
		group.setStatus(1);

		//groupService.insert(group);
	}
}
