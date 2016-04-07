package com.esense.bonassa.rest.security;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CORSResponseFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		ResponseBuilder respBuilder = Response.fromResponse(response
				.getResponse());
		respBuilder.header("Access-Control-Allow-Origin", "*").header(
				"Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		String reqHead = request
				.getHeaderValue("Access-Control-Request-Headers");
		if (null != reqHead && !reqHead.equals("")) {
			respBuilder.header("Access-Control-Allow-Headers", reqHead);
		}
		response.setResponse(respBuilder.build());
		return response;
	}

}
