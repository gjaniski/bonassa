package com.esense.bonassa.rest.dto;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessAppointment;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Gerson Janiski
 * 
 * */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessAppointmentDto {

	private static final Mapper mapper;

	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Process process;
	@JsonIgnore
	private String realDate;
	@JsonIgnore
	private String limitDate;
	@JsonIgnore
	private String hour;
	@JsonIgnore
	private Value type;
	@JsonIgnore
	private Value city;
	@JsonIgnore
	private Value notarysOffice;
	@JsonIgnore
	private List<User> owners;
	@JsonIgnore
	private String description;
	@JsonIgnore
	private Integer requiredTime;
	@JsonIgnore
	private Date date;
	@JsonIgnore
	private Boolean hasTerm;
	@JsonIgnore
	private Boolean hearing;
	@JsonIgnore
	private Boolean providence;
	@JsonIgnore
	private Boolean emailAlert;
	@JsonIgnore
	private Boolean remember;
	@JsonIgnore
	private Boolean progressReleased;
	@JsonIgnore
	private Integer status;
	@JsonIgnore
	private User creator;

	static {

		mapper = new DozerBeanMapper();
	}

	public static ProcessAppointment toProcessAppointment(ProcessAppointmentDto dto) {
		ProcessAppointment processAppointment = mapper.map(dto, ProcessAppointment.class);
		return processAppointment;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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

	public String getRealDate() {
		return realDate;
	}

	public void setRealDate(String realDate) {
		this.realDate = realDate;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}	

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Value getType() {
		return type;
	}

	public void setType(Value type) {
		this.type = type;
	}

	public Value getCity() {
		return city;
	}

	public void setCity(Value city) {
		this.city = city;
	}

	public Value getNotarysOffice() {
		return notarysOffice;
	}

	public void setNotarysOffice(Value notarysOffice) {
		this.notarysOffice = notarysOffice;
	}

	public List<User> getOwners() {
		return owners;
	}

	public void setOwners(List<User> owners) {
		this.owners = owners;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(Integer requiredTime) {
		this.requiredTime = requiredTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getHasTerm() {
		return hasTerm;
	}

	public void setHasTerm(Boolean hasTerm) {
		this.hasTerm = hasTerm;
	}

	public Boolean getHearing() {
		return hearing;
	}

	public void setHearing(Boolean hearing) {
		this.hearing = hearing;
	}

	public Boolean getProvidence() {
		return providence;
	}

	public void setProvidence(Boolean providence) {
		this.providence = providence;
	}

	public Boolean getEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(Boolean emailAlert) {
		this.emailAlert = emailAlert;
	}

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

	public Boolean getProgressReleased() {
		return progressReleased;
	}

	public void setProgressReleased(Boolean progressReleased) {
		this.progressReleased = progressReleased;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
