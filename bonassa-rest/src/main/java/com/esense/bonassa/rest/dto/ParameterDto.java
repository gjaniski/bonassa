package com.esense.bonassa.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.esense.bonassa.core.entity.Parameter;
import com.esense.bonassa.core.entity.Value;
import com.esense.bonassa.rest.AbstractSecurityRequest;

/**
 * @author Douglas Cardoso
 * 
 * */
public class ParameterDto extends AbstractSecurityRequest {

	private Integer id;
	private String name;
	private Integer status;
	private String description;
	private Parameter parent;
	private List<Value> values;

	public static ParameterDto fromParameter(Parameter param) {
		ParameterDto dto = new ParameterDto();
		dto.id = param.getId();
		dto.name = param.getName();
		dto.status = param.getStatus();
		if (param.getParent() != null) dto.parent = param.getParent();
		dto.description = param.getDescription();
		dto.values = param.getValues();
		return dto;
	}

	public static List<ParameterDto> fromListParameter(List<Parameter> params) {
		List<ParameterDto> list = new ArrayList<ParameterDto>();
		for (Parameter param : params) {
			ParameterDto dto = new ParameterDto();
			dto.id = param.getId();
			dto.name = param.getName();
			dto.status = param.getStatus();
			dto.description = param.getDescription();
			dto.parent = param.getParent();
			dto.values = param.getValues();
			list.add(dto);
		}
		return list;
	}

	public static Parameter toParameter(ParameterDto dto) {
		Parameter param = new Parameter();
		param.setName(dto.name);
		param.setStatus(dto.status);
		param.setDescription(dto.description);
		param.setId(dto.id);
		// param.setValues(ValueDto.toListValue(dto.values));
		param.setValues(dto.values);
		return param;
	}

	public static List<Parameter> toListParameter(List<ParameterDto> dtos) {
		List<Parameter> list = new ArrayList<Parameter>();
		for (ParameterDto dto : dtos) {
			Parameter param = new Parameter();
			param.setId(dto.id);
			param.setName(dto.name);
			param.setStatus(dto.status);
			param.setDescription(dto.description);
			// param.setValues(ValueDto.toListValue(dto.values));
			param.setValues(dto.values);
			list.add(param);
		}
		return list;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public Parameter getParent() {
		return parent;
	}

	public void setParent(Parameter parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "ParameterDto [id=" + id + ", name=" + name + ", status="
				+ status + ", description=" + description + ", values="
				+ values + "]";
	}

}
