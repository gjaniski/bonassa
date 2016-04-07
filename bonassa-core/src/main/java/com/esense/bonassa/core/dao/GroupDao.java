package com.esense.bonassa.core.dao;

import java.util.List;

import com.esense.bonassa.core.entity.Group;

public interface GroupDao {

	public int insert(Group group);

	public List<Group> select(Group query);

	public Group selectByName(String name);

}