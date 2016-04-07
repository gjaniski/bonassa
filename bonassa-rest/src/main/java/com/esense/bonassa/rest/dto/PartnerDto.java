package com.esense.bonassa.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Partner;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * 
 * */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerDto {

	private static final Mapper mapper;
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private char type;
	@JsonIgnore
	private String name;
	@JsonIgnore
	private String address;
	@JsonIgnore
	private String homeNumber;
	@JsonIgnore
	private String zipCode;
	@JsonIgnore
	private Value city;
	@JsonIgnore
	private Value state;
	@JsonIgnore
	private String phoneNumber;
	@JsonIgnore
	private String cellPhoneNumber;
	@JsonIgnore
	private String stateId; // I.E
	@JsonIgnore
	private String federalId; // CNPJ or CPF
	@JsonIgnore
	private String email;
	@JsonIgnore
	private String websiteUrl;
	@JsonIgnore
	private String category;
	@JsonIgnore
	private String birthDate;
	@JsonIgnore
	private Value civilStatus;
	@JsonIgnore
	private String rg;
	@JsonIgnore
	private Integer status;
	@JsonIgnore
	private String neighborhood;
	@JsonIgnore
	private String observation;
	@JsonIgnore
	private String ticket;
	@JsonIgnore
	private UserDto userDto;

	static {

		mapper = new DozerBeanMapper();
	}

	public static Partner toCustomer(PartnerDto dto) {
		Partner customer = mapper.map(dto, Partner.class);
		return customer;
	}
	
	public static Partner toPartner(PartnerDto dto) {
		Partner partner = new Partner();
		partner.setId(dto.getId());
		return partner;
	}

	public static PartnerDto fromCustomer(Partner customer) {
		PartnerDto dto = mapper.map(customer, PartnerDto.class);
		return dto;
	}

	public static List<PartnerDto> fromListCustomer(List<Partner> customers) {
		List<PartnerDto> dtos = new ArrayList<PartnerDto>();
		for (Partner custumer : customers) {
			PartnerDto dto = mapper.map(custumer, PartnerDto.class);
			dtos.add(dto);
		}
		return dtos;
	}

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

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
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

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", type=" + type + ", name=" + name
				+ ", address=" + address + ", homeNumber=" + homeNumber
				+ ", zipCode=" + zipCode + ", city=" + city + ", state="
				+ state + ", phoneNumber=" + phoneNumber + ", cellPhoneNumber="
				+ cellPhoneNumber + ", stateId=" + stateId + ", federalId="
				+ federalId + ", email=" + email + ", websiteUrl=" + websiteUrl
				+ ", category=" + category + ", birthDate=" + birthDate
				+ ", civilStatus=" + civilStatus + ", rg=" + rg + ", status="
				+ status + ", neighborhood=" + neighborhood + ", observation="
				+ observation + ", ticket=" + ticket + ", userDto=" + userDto
				+ "]";
	}

}
