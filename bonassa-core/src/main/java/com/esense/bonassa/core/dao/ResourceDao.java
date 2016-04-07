package com.esense.bonassa.core.dao;

import java.util.List;

import com.esense.bonassa.core.entity.Resource;

/**
 * 
 * @author Douglas Cardoso
 *
 */
public interface ResourceDao {

	public List<Resource> select(Resource resource);

}
