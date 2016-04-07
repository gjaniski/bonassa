package com.esense.bonassa.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.ResourceDao;
import com.esense.bonassa.core.entity.Resource;
import com.esense.bonassa.core.exception.ResultNotFoundException;
import com.esense.bonassa.core.exception.ServiceException;
import com.esense.bonassa.core.service.ResourceService;

/**
 * 
 * @author Douglas Cardoso
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;

	private final Logger logger = Logger.getLogger(ResourceServiceImpl.class);

	@Override
	public List<Resource> selectByGroup(String groupName) {
		Resource query = new Resource();
		query.createCriterion("", Operator.EQUALS, groupName);
		return null;
	}

	@Override
	public Resource selectByName(String name) {
		Resource resource = null;
		try {
			if (name == null) throw new NullPointerException();
			Resource query = new Resource();
			query.createCriterion("name_", Operator.EQUALS, name);
			List<Resource> result = resourceDao.select(query);
			if (result.size() == 0) throw new ResultNotFoundException();
			if (result.size() > 1) throw new ServiceException();
			resource = result.get(0);
		} catch (NullPointerException ex) {
			logger.error("Name is null");
		} catch (ServiceException ex) {
			logger.error("Name is duplicated");
		} catch (ResultNotFoundException ex) {
			logger.error("Name not found");
		}
		return resource;
	}
}
