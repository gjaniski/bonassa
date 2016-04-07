package com.esense.bonassa.rest.dto;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessOwner;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Gerson Janiski
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessOwnerDto {

//	private static final Mapper mapper;
	
	@JsonIgnore
	private Process process;	
	@JsonIgnore
	private User owner;
	@JsonIgnore
	private Value area;

//	static {
//
//		mapper = new DozerBeanMapper();
//	}

	public static ProcessOwner toProcessOwner(ProcessOwnerDto dto) {
		ProcessOwner processOwner = new ProcessOwner();
		processOwner.setProcess(dto.process);
		processOwner.setOwner(dto.owner);
		processOwner.setArea(dto.area);
		return processOwner;
	}	
	
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public Value getArea() {
		return area;
	}
	
	public void setArea(Value area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ProcessOwnerDto [process=" + process + ", owner=" + owner
				+ ", area=" + area + "]";
	}
		
}
