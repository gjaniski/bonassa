package com.esense.bonassa.rest.dto;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessPartner;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessPartnerDto {

//	private static final Mapper mapper;
	
	@JsonIgnore
	private Process process;
	@JsonIgnore
	private PartnerDto partner;
	@JsonIgnore
	private Value processRelationship;
	@JsonIgnore
	private String partnerType;

//	static {
//
//		mapper = new DozerBeanMapper();
//	}

//	public static ProcessPartner toProcessCustomer(ProcessPartnerDto dto) {
//		ProcessPartner processCustomer = mapper.map(dto, ProcessPartner.class);
//		return processCustomer;
//	}
	
	public static ProcessPartner toProcessPartner(ProcessPartnerDto dto) {
		ProcessPartner processPartner = new ProcessPartner();
		processPartner.setProcess(dto.getProcess());
		processPartner.setPartner(PartnerDto.toPartner(dto.getPartner()));
		processPartner.setProcessRelationship(dto.getProcessRelationship());
		processPartner.setPartnerType(dto.getPartnerType());
		return processPartner;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public PartnerDto getPartner() {
		return partner;
	}

	public void setPartner(PartnerDto partner) {
		this.partner = partner;
	}

	public Value getProcessRelationship() {
		return processRelationship;
	}

	public void setProcessRelationship(Value processRelationship) {
		this.processRelationship = processRelationship;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}
}
