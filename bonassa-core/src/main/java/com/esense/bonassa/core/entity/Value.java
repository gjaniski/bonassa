package com.esense.bonassa.core.entity;

/**
 * @author Douglas Cardoso
 * 
 * */
public class Value {

	private Integer id;

	private Value parent;

	private String value;

	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Value getParent() {
		return parent;
	}

	public void setParent(Value parent) {
		this.parent = parent;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", parent=" + parent + ", value=" + value
				+ ", status=" + status + "]";
	}

}
