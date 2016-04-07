package com.esense.bonassa.core.entity;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */
public class ProcessPartner {

	private Process process;

	private Partner partner;

	private Value processRelationship;
	
	private String partnerType;

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Value getProcessRelationship() {
		return processRelationship;
	}

	public void setProcessRelationship(Value processRelationship) {
		this.processRelationship = processRelationship;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	@Override
	public String toString() {
		return "ProcessPartner [process=" + process + ", partner=" + partner
				+ ", processRelationship=" + processRelationship
				+ ", partnerType=" + partnerType + "]";
	}

}
