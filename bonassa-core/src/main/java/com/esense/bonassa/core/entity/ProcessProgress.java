package com.esense.bonassa.core.entity;

import java.util.List;

import com.esense.bonassa.core.AbstractCondition;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public class ProcessProgress extends AbstractCondition {

	private Integer id;

	private Process process;

	private User creator;

	private String creationDate;
	
	private String hour;

	private Value actionType;

	private Value phase;

	private String description;

	private Boolean showRepoClient;

	private Boolean sendEmail;
	
	private List<User> owners;
	
	private Integer eventHours;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Value getActionType() {
		return actionType;
	}

	public void setActionType(Value actionType) {
		this.actionType = actionType;
	}

	public Value getPhase() {
		return phase;
	}

	public void setPhase(Value phase) {
		this.phase = phase;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getShowRepoClient() {
		return showRepoClient;
	}

	public void setShowRepoClient(Boolean showRepoClient) {
		this.showRepoClient = showRepoClient;
	}

	public Boolean getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(Boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	public List<User> getOwners() {
		return owners;
	}

	public void setOwners(List<User> owners) {
		this.owners = owners;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Integer getEventHours() {
		return eventHours;
	}

	public void setEventHours(Integer eventHours) {
		this.eventHours = eventHours;
	}

	@Override
	public String toString() {
		return "ProcessProgress [id=" + id + ", process=" + process
				+ ", creator=" + creator + ", creationDate=" + creationDate
				+ ", hour=" + hour + ", actionType=" + actionType + ", phase="
				+ phase + ", description=" + description + ", showRepoClient="
				+ showRepoClient + ", sendEmail=" + sendEmail + ", owners="
				+ owners + ", eventHours=" + eventHours + "]";
	}
	
	public boolean validateNotNullAttrs() {
		for(Integer i = 0; i < owners.size(); i++){
			if(owners.get(i).getId() == null)
				return false;
		}
		return true;
	}

}
