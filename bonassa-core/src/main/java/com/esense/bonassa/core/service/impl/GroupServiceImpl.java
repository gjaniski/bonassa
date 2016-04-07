package com.esense.bonassa.core.service.impl;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.GroupDao;
import com.esense.bonassa.core.entity.Group;
import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.core.exception.ServiceException;
import com.esense.bonassa.core.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	private final Logger logger = Logger.getLogger(GroupServiceImpl.class);

	@Override
	public void insert(Group group) {

		try {
			if (group == null)
				throw new NullPointerException();
			if (group.validateNullAttrs())
				throw new MandatoryFieldException();
			groupDao.insert(group);
		} catch (MandatoryFieldException ex) {
			logger.error("Mandatory fields is null");
		} catch (NullPointerException ex) {
			logger.error("Group is null");
		}
	}

	@Override
	public List<Group> selectAll() {
		return groupDao.select(new Group());

	}

	@Override
	public Group selectByName(String name) {
		Group group = null;
		try {
			Group query = new Group();
			query.createCriterion("name_", Operator.EQUALS, name);
			List<Group> result = groupDao.select(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			group = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return group;
	}
}
