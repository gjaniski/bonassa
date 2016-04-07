package com.esense.bonassa.core.entity;

import java.util.Date;
import java.util.List;

import com.esense.bonassa.core.AbstractCondition;
import com.esense.bonassa.core.ValidadeAttrs;

public class ProcessAppointment extends AbstractCondition implements ValidadeAttrs{

	private Integer id;

	private Process process;

	private String realDate;
	
	private String limitDate;
	
	private String hour;
	
	private Value type;
	
	private Value city;
	
	private Value notarysOffice;
	
	private List<User> owners;
	
	private String description;
	
	private Integer requiredTime;
	
	private Date date;
	
	private Boolean hasTerm;
	
	private Boolean hearing;
		
	private Boolean providence;
	
	private Boolean emailAlert;
	
	private Boolean remember;
	
	private Boolean progressReleased;
	
	private Integer status;

	private User creator;
	
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

	@Override
	public boolean validateFiles() {
		return true;
	}	

	@Override
	public String toString() {
		return "ProcessAppointment [id=" + id + ", process=" + process
				+ ", realDate=" + realDate + ", limitDate=" + limitDate
				+ ", hour=" + hour + ", type=" + type + ", city=" + city
				+ ", notarysOffice=" + notarysOffice + ", owners=" + owners
				+ ", description=" + description + ", requiredTime="
				+ requiredTime + ", date=" + date + ", hasTerm=" + hasTerm
				+ ", hearing=" + hearing + ", providence=" + providence
				+ ", emailAlert=" + emailAlert + ", remember=" + remember
				+ ", progressReleased=" + progressReleased + ", status="
				+ status + ", creator=" + creator + "]";
	}

	public boolean validateNotNullAttrs() {
		for(Integer i = 0; i < owners.size(); i++){
			if(owners.get(i).getId() == null)
				return false;
		}
		return true;
	}
}
