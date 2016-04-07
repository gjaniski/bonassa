package com.esense.bonassa.core.service;

import java.util.List;

import com.esense.bonassa.core.entity.Resource;

public interface ResourceService {

	public List<Resource> selectByGroup(String groupName);

	public Resource selectByName(String name);

}
