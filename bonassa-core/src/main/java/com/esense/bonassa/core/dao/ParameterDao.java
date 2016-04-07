package com.esense.bonassa.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esense.bonassa.core.entity.Parameter;

/**
 * @author douglas
 *
 */
public interface ParameterDao {

	public List<Parameter> select(Parameter parameter);

//	public List<Parameter> list(Parameter parameter);

	public int insert(Parameter parameter);

	public void insertValue(@Param("paramId") Integer paramId,
			@Param("parentId") Integer parentId, @Param("value") String value);

	public void updateValue(@Param("paramId") Integer paramId,
			@Param("parentId") Integer parentId, @Param("value") String value);
}