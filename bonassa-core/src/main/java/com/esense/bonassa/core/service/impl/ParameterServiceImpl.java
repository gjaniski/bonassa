package com.esense.bonassa.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.ParameterDao;
import com.esense.bonassa.core.entity.Parameter;
import com.esense.bonassa.core.exception.ResultNotFoundException;
import com.esense.bonassa.core.service.ParameterService;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterDao parameterDao;

	private Logger logger = Logger.getLogger(ParameterServiceImpl.class);

	@Override
	public List<Parameter> list() {
		return parameterDao.select(new Parameter());
	}

	@Override
	public void insert(Parameter param) {
		try {
			if (param.validateNullAttrs())
				throw new IllegalArgumentException();
			parameterDao.insert(param);
		} catch (IllegalArgumentException ex) {
			logger.error("Mandatory fields is null");
		}
	}

	@Override
	public void insertValue(Integer paramId, Integer parentId, String value) {
		try {
			if (paramId == null || value == null)
				throw new IllegalArgumentException();
			parameterDao.insertValue(paramId, parentId, value);
		} catch (IllegalArgumentException ex) {
			logger.error("Mandatory fields is null");
		}
	}

	@Override
	public void updateValue(Integer paramId, Integer parentId, String value) {
		try {
			if (paramId == null || value == null)
				throw new IllegalArgumentException();
			parameterDao.updateValue(paramId, parentId, value);
		} catch (IllegalArgumentException ex) {
			logger.error("Mandatory fields is null");
		}
	}

	@Override
	public Parameter selectByName(String paramName) {
		Parameter parameter = null;
		try {
			if (paramName == null) throw new IllegalArgumentException();
			Parameter query = new Parameter();
			query.createCriterion("name_", Operator.EQUALS, paramName);
			List<Parameter> parameters = parameterDao.select(query);
			if (parameters.size() == 0) throw new ResultNotFoundException();
			parameter = parameters.get(0);
		} catch (IllegalArgumentException ex) {
			logger.error("Mandatory fields is null");
		} catch (ResultNotFoundException e) {
			logger.error("parameter not found");
		}
		return parameter;
	}

	@Override
	public Parameter selectById(Integer id) {
		Parameter parameter = null;
		try {
			if (id == null) throw new IllegalArgumentException();
			Parameter query = new Parameter();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<Parameter> parameters = parameterDao.select(query);
			if (parameters.size() == 0) throw new ResultNotFoundException();
			parameter = parameters.get(0);
		} catch (IllegalArgumentException ex) {
			logger.error("Mandatory fields is null");
		} catch (ResultNotFoundException e) {
			logger.error("parameter not found");
		}
		return parameter;
	}
	
//	@Override
//	public Parameter selectByParent(Integer parentId){
//		Parameter parameter = null;
//		try {
//			if ((parentId == null) || (parentId == 0)) throw new IllegalArgumentException();
//			Parameter query = new Parameter();
//			query.createCriterion("parent_id_", Operator.EQUALS, parentId);
//			List<Parameter> parameters = parameterDao.select(query);
//			if (parameters.size() == 0) throw new ResultNotFoundException();
//			parameter = parameters.get(0);
//		} catch (IllegalArgumentException ex) {
//			logger.error("Mandatory fields is null");
//		} catch (ResultNotFoundException e) {
//			logger.error("parameter not found");
//		}
//		return parameter;
//	}
}
