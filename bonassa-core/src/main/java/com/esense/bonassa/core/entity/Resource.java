package com.esense.bonassa.core.entity;

import java.util.List;

import com.esense.bonassa.core.AbstractCondition;

public class Resource extends AbstractCondition {

	private Integer id;

	private String name;

	private Integer status;

	private List<Group> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Resource [name=" + name + ", status=" + status + ", groups="
				+ groups + "]";
	}

}
