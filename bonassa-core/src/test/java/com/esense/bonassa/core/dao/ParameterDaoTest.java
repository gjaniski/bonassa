package com.esense.bonassa.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author Douglas Cardoso
 * 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class ParameterDaoTest {

	@Autowired
	private ParameterDao parameterDao;

	@Test
	public void init() {
		Assert.notNull(parameterDao);
	}

	// @Test
	// public void insert() {
	// Parameter param = new Parameter();
	// param.setName("Douglas");
	// param.setDescription("qualquer");
	// param.setStatus(1);
	// int id = parameterDao.insert(param);
	// System.out.println("Generated key:" + id);
	// }

//	@Test
//	public void list() {
//		List<Parameter> parameters = parameterDao.list();
//		Assert.notEmpty(parameters);
//		for (Parameter param : parameters) {
//			System.out.println("name: " + param.getName());
//			if (param.getParent() != null)
//				System.out.println("parent: " + param.getParent().getName());
//			for (Value value : param.getValues()) {
//				System.out.println("value: " + value.getValue());
//			}
//		}
//	}

	// @Test
	// public void insertValue() {
	// parameterDao.insertValue(2, null, "teste2");
	// }
}
