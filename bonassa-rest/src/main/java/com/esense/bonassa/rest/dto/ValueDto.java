package com.esense.bonassa.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.esense.bonassa.core.entity.Value;

/**
 * @author Douglas Cardoso
 * 
 * */
public class ValueDto {

	private Integer id;
	private Value parent;
	private String value;
	private Integer status;

	public static ValueDto fromValue(Value value) {
		ValueDto dto = new ValueDto();
		dto.id = value.getId();
		dto.parent = value.getParent();
		dto.status = value.getStatus();
		dto.value = value.getValue();
		return dto;
	}

	public static List<ValueDto> fromListValue(List<Value> values) {
		List<ValueDto> list = new ArrayList<ValueDto>();
		for (Value value : values) {
			ValueDto dto = new ValueDto();
			dto.id = value.getId();
			dto.parent = value.getParent();
			dto.status = value.getStatus();
			dto.value = value.getValue();
			list.add(dto);
		}
		return list;
	}

	public static Value toValue(ValueDto dto) {
		Value value = new Value();
		value.setId(dto.id);
		value.setParent(dto.parent);
		value.setStatus(dto.status);
		value.setValue(dto.value);
		return value;
	}

	public static List<Value> toListValue(List<ValueDto> dtos) {
		List<Value> list = new ArrayList<Value>();
		for (ValueDto dto : dtos) {
			Value value = new Value();
			value.setId(dto.id);
			value.setParent(dto.parent);
			value.setStatus(dto.status);
			value.setValue(dto.value);
			list.add(value);
		}
		return list;
	}

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
		return "ValueDto [id=" + id + ", parent=" + parent + ", value=" + value
				+ ", status=" + status + "]";
	}

}
