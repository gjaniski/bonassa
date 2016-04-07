package com.esense.bonassa.core.entity;

import java.util.List;

import com.esense.bonassa.core.AbstractCondition;

/**
 * @author Douglas Cardoso
 * 
 * */
public class Parameter extends AbstractCondition {
	private Integer id;

	private Parameter parent;

	private String name;

	private Integer status;

	private String description;

	private List<Value> values;

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
		this.name = name == null ? null : name.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Parameter getParent() {
		return parent;
	}

	public void setParent(Parameter parent) {
		this.parent = parent;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public boolean validateNullAttrs() {
		if (name == null) return true;
		if (values == null) return true;
		if (values.size() == 0) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Parameter [id=" + id + ", parent=" + parent + ", name=" + name
				+ ", status=" + status + ", description=" + description
				+ ", values=" + values + "]";
	}

}