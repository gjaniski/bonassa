package com.esense.bonassa.core.entity;

import com.esense.bonassa.core.AbstractCondition;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public class Partner extends AbstractCondition {

	private Integer id;
	
	private char type;
	
	private String name;
	
	private String address;
	
	private String homeNumber;
	
	private String zipCode;
	
	private Value city;
	
	private Value state;
	
	private String phoneNumber;
	
	private String cellPhoneNumber;
	
	private String stateId; // I.E
	
	private String federalId; // CNPJ or CPF
	
	private String email;
	
	private String websiteUrl;
	
	private String category;
	
	private String birthDate;
	
	private Value civilStatus;
	
	private String rg;
	
	private Integer status;
	
	private String neighborhood;
	
	private String observation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Value getCity() {
		return city;
	}

	public void setCity(Value city) {
		this.city = city;
	}

	public Value getState() {
		return state;
	}

	public void setState(Value state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Value getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(Value civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public boolean validateNotNullAttrs() {
		if (name == null || name == "")
			return false;
		if (federalId == null || federalId == "")
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", type=" + type + ", name=" + name
				+ ", address=" + address + ", homeNumber=" + homeNumber
				+ ", zipCode=" + zipCode + ", city=" + city + ", state="
				+ state + ", phoneNumber=" + phoneNumber + ", cellPhoneNumber="
				+ cellPhoneNumber + ", stateId=" + stateId + ", federalId="
				+ federalId + ", email=" + email + ", websiteUrl=" + websiteUrl
				+ ", category=" + category + ", birthDate=" + birthDate
				+ ", civilStatus=" + civilStatus + ", rg=" + rg + ", status="
				+ status + ", neighborhood=" + neighborhood + ", observation="
				+ observation + "]";
	}

}
