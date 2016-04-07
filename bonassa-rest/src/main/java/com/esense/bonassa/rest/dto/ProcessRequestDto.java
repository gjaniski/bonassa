package com.esense.bonassa.rest.dto;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessRequest;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Gerson Janiski
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessRequestDto {

	private static final Mapper mapper;
	
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Process process;
	@JsonIgnore
	private Value type;
	@JsonIgnore
	private Value status;
	@JsonIgnore
	private Double initialInterest;
	@JsonIgnore
	private Date askedDate;
	@JsonIgnore
	private Integer lossProb;
	@JsonIgnore
	private String observation;
	@JsonIgnore
	private Double requestedValue;
	@JsonIgnore
	private Double updatedValue;
	@JsonIgnore
	private String updatedDate;
	@JsonIgnore
	private Double estimatedValue;
	@JsonIgnore
	private Double deferredValue;
	@JsonIgnore
	private String lossProbPercentage;
	
	static {

		mapper = new DozerBeanMapper();
	}

	public static ProcessRequest toProcessRequest(ProcessRequestDto dto) {
		ProcessRequest processRequest = mapper.map(dto, ProcessRequest.class);
		return processRequest;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Value getType() {
		return type;
	}

	public void setType(Value type) {
		this.type = type;
	}

	public Value getStatus() {
		return status;
	}

	public void setStatus(Value status) {
		this.status = status;
	}

	public Double getInitialInterest() {
		return initialInterest;
	}

	public void setInitialInterest(Double initialInterest) {
		this.initialInterest = initialInterest;
	}

	public Date getAskedDate() {
		return askedDate;
	}

	public void setAskedDate(Date askedDate) {
		this.askedDate = askedDate;
	}

	public Integer getLossProb() {
		return lossProb;
	}

	public void setLossProb(Integer lossProb) {
		this.lossProb = lossProb;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Double getRequestedValue() {
		return requestedValue;
	}

	public void setRequestedValue(Double requestedValue) {
		this.requestedValue = requestedValue;
	}

	public Double getUpdatedValue() {
		return updatedValue;
	}

	public void setUpdatedValue(Double updatedValue) {
		this.updatedValue = updatedValue;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(Double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public Double getDeferredValue() {
		return deferredValue;
	}

	public void setDeferredValue(Double deferredValue) {
		this.deferredValue = deferredValue;
	}

	public String getLossProbPercentage() {
		return lossProbPercentage;
	}

	public void setLossProbPercentage(String lossProbPercentage) {
		this.lossProbPercentage = lossProbPercentage;
	}	
}
