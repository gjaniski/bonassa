package com.esense.bonassa.rest;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class MapperRest {

	private static final List<String> dozerMapperXmlList;

	static {
		dozerMapperXmlList = new ArrayList<String>();
		dozerMapperXmlList.add("dozerMapping.xml");
	}

	protected Object createMapper(Object sourceObject, Class<?> sourceClass,
			String mapperId) {
		Mapper mapper = new DozerBeanMapper(dozerMapperXmlList);
		Object object = mapper.map(sourceObject, sourceClass, mapperId);
		return object;
	}
}
