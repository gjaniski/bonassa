package com.esense.bonassa.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.esense.bonassa.core.entity.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class ResourceServiceTest {

	@Autowired
	private ResourceService resourceService;

	@Test
	public void init() {
		Assert.notNull(resourceService);
	}

	@Test
	public void select() {
		Resource resource = resourceService.selectByName("new_customer");
		System.out.println(resource);
	}

}
