package com.esense.bonassa.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.springframework.web.filter.RequestContextFilter;

import com.esense.bonassa.rest.security.CORSResponseFilter;
import com.esense.bonassa.rest.service.impl.AuthorizationRestServiceImpl;
import com.esense.bonassa.rest.service.impl.PartnerRestServiceImpl;
import com.esense.bonassa.rest.service.impl.ParameterRestServiceImpl;
import com.esense.bonassa.rest.service.impl.UserRestServiceImpl;

/**
 * @author douglas
 *
 */
public class BonassaApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(RequestContextFilter.class);
		classes.add(ParameterRestServiceImpl.class);
		classes.add(PartnerRestServiceImpl.class);
		classes.add(UserRestServiceImpl.class);
		classes.add(AuthorizationRestServiceImpl.class);
		classes.add(CORSResponseFilter.class);
		return classes;
	}

}
