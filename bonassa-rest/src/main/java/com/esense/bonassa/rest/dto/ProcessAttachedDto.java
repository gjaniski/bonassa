package com.esense.bonassa.rest.dto;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessAttached;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessAttachedDto {

	private static final Mapper mapper;
	
	@JsonIgnore
	private Integer Id;
	@JsonIgnore
	private Process parentProcess;
	@JsonIgnore
	private Process childProcess;

	static {

		mapper = new DozerBeanMapper();
	}

	public static ProcessAttached toProcessAttached(ProcessAttachedDto dto) {
		ProcessAttached processAttached = mapper.map(dto, ProcessAttached.class);
		return processAttached;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Process getParentProcess() {
		return parentProcess;
	}
	public void setParentProcess(Process parentProcess) {
		this.parentProcess = parentProcess;
	}
	public Process getChildProcess() {
		return childProcess;
	}
	public void setChildProcess(Process childProcess) {
		this.childProcess = childProcess;
	}	
}
