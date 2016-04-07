package com.esense.bonassa.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class CustomerServiceTest {

	@Autowired
	private PartnerService customerService;

	@Test
	public void init() {
		Assert.notNull(customerService);
	}

	@Test
	public void insert() {
//		Customer customer = new Customer();
//
//		customer.setType('F');
//		customer.setAddress("address");
//		customer.setBirthDate(new Date());
//		customer.setCategory("category");
//		customer.setCellPhoneNumber("cellPhoneNumber");
//		customer.setCity("city");
//		customer.setCivilStatus("civilStatus");
//		customer.setEmail("email");
//		customer.setFederalId("federalId");
//		customer.setName("name");
//		customer.setPhoneNumber("phoneNumber");
//		customer.setState("state");
//		customer.setStateId("stateId");
//		customer.setWebsiteUrl("websiteUrl");
//		customer.setZipCode("zipCode");
//		customer.setStatus(1);
//
//		customerService.insert(customer);

	}

}
