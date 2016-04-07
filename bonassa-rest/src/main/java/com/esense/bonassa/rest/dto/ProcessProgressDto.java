package com.esense.bonassa.rest.dto;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessProgress;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Gerson Janiski
 * 
 * */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessProgressDto {

	private static final Mapper mapper;

	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Process process;
	@JsonIgnore
	private User creator;
	@JsonIgnore
	private String creationDate;
	@JsonIgnore
	private String hour;
	@JsonIgnore
	private Value actionType;
	@JsonIgnore
	private Value phase;
	@JsonIgnore
	private String description;
	@JsonIgnore
	private Boolean showRepoClient;
	@JsonIgnore
	private Boolean sendEmail;
	@JsonIgnore
	private List<UserDto> owners;
	@JsonIgnore
	private Integer eventHours;

	static {

		mapper = new DozerBeanMapper();
	}

	public static ProcessProgress toProcessProgress(ProcessProgressDto dto) {
		ProcessProgress processProgress = mapper.map(dto, ProcessProgress.class);
		return processProgress;
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

	public List<UserDto> getOwners() {
		return owners;
	}

	public void setOwners(List<UserDto> owners) {
		this.owners = owners;
	}

	public Integer getEventHours() {
		return eventHours;
	}

	public void setEventHours(Integer eventHours) {
		this.eventHours = eventHours;
	}

	@Override
	public String toString() {
		return "ProcessProgressDto [id=" + id + ", process=" + process
				+ ", creator=" + creator + ", creationDate=" + creationDate
				+ ", hour=" + hour + ", actionType=" + actionType + ", phase="
				+ phase + ", description=" + description + ", showRepoClient="
				+ showRepoClient + ", sendEmail=" + sendEmail + ", owners="
				+ owners + ", eventHours=" + eventHours + "]";
	}
}
