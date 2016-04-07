package com.esense.bonassa.core.service;

import java.util.List;

import com.esense.bonassa.core.entity.Parameter;

public interface ParameterService {

	public List<Parameter> list();

	public void insert(Parameter param);

	public void insertValue(Integer paramId, Integer parentId, String value);

	public void updateValue(Integer paramId, Integer parentId, String value);

	public Parameter selectByName(String paramName);
	
	public Parameter selectById(Integer id);

//	public Parameter selectByParentValue(Integer parentId);

}
