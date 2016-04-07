package com.esense.bonassa.core.entity;

import com.esense.bonassa.core.AbstractCondition;

public class Group extends AbstractCondition {
	
	private Integer id;
	private String name;
	private Integer status;
	private Integer userId;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", status=" + status
				+ ", userId=" + userId + "]";
	}

	public boolean validateNullAttrs() {

		if (name == null) return true;
		// if (status == null)
		// return true;
		return false;
	}

}
