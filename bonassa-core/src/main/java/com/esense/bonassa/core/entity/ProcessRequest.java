package com.esense.bonassa.core.entity;

import java.util.Date;

import com.esense.bonassa.core.AbstractCondition;

/**
 * 
 * @author Douglas Cardoso
 *
 */

public class ProcessRequest extends AbstractCondition {

	private Integer id;

	private Process process;

	private Value type;

	private Value status;

	private Double initialInterest;

	private Date askedDate;

	private Integer lossProb;

	private String observation;
	
	private Double requestedValue;
	
	private Double updatedValue;
	
	private String updatedDate;
	
	private Double estimatedValue;
	
	private Double deferredValue;
	
	private String lossProbPercentage;

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

	public boolean validateNotNullAttrs() {
		return true;
	}

	@Override
	public String toString() {
		return "ProcessRequest [id=" + id + ", process=" + process + ", type="
				+ type + ", status=" + status + ", initialInterest="
				+ initialInterest + ", askedDate=" + askedDate + ", lossProb="
				+ lossProb + ", observation=" + observation
				+ ", requestedValue=" + requestedValue + ", updatedValue="
				+ updatedValue + ", updatedDate=" + updatedDate
				+ ", estimatedValue=" + estimatedValue + ", deferredValue="
				+ deferredValue + ", lossProbPercentage=" + lossProbPercentage
				+ "]";
	}
}
