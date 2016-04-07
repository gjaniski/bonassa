package com.esense.bonassa.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.UnauthorizedException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class AuthorizationServiceTest {

	@Autowired
	private AuthorizationService authorizationService;

	@Test
	public void testIsNotNull() {
		Assert.notNull(authorizationService);
	}

	@Test
	public void login() {

		try {
			
//			User user = authorizationService.authentication("douglas",
//					"12341234");
			
			User user = authorizationService.authentication("gerson",
					"12341234");
			
			Assert.isTrue(authorizationService.getAuthorization("new_user", user));

		} catch (UnauthorizedException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void invalidTicket() {
		/*
		 * Ticket ticket = new Ticket(); DateTime dt = new DateTime(new Date());
		 * DateTime before = dt.minusMinutes(31);
		 * ticket.setDate(before.toDate());
		 * Assert.isTrue(!authorizationService.validateTicket(ticket));
		 */
	}

}
