package com.esense.bonassa.core.service;
import java.util.List;

import com.esense.bonassa.core.entity.Group;

/**
 * 
 * @author marcelino ulica
 *
 */
public interface GroupService {

	public void insert(Group group);

	public List<Group> selectAll();

	public Group selectByName(String name);

}


