package com.esense.bonassa.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.esense.bonassa.core.AbstractCondition;
import com.esense.bonassa.core.entity.Group;
import com.esense.bonassa.core.entity.Ticket;
import com.esense.bonassa.core.entity.User;
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
public class UserDto extends AbstractCondition {

//	private static final Mapper mapper;

	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private String login;
	@JsonIgnore
	private String email;
	@JsonIgnore
	private String pwd;
	@JsonIgnore
	private Integer status;
	@JsonIgnore
	private List<GroupDto> groups;
	@JsonIgnore
	private String pictureId;
	@JsonIgnore
	private Ticket ticket;
	@JsonIgnore
	private UserDto userDto;
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
	private String federalId;
	@JsonIgnore
	private String birthDate;
	@JsonIgnore
	private Value civilStatus;
	@JsonIgnore
	private String rg;
	@JsonIgnore
	private String neighborhood;
	@JsonIgnore
	private String observation;
	@JsonIgnore
	private String profession;
	@JsonIgnore
	private String function;

	private static Logger logger = Logger.getLogger(UserDto.class);

//	static {
//
//		mapper = new DozerBeanMapper();
//	}
//
//	public static User toUser(UserDto dto) {
//		User user = mapper.map(dto, User.class);
//		return user;
//	}

	public static User toUserFromDto(UserDto userDto) {
		
		User user = new User();
		user.setId(userDto.getId());
		user.setAddress(userDto.getAddress());
		user.setBirthDate(userDto.getBirthDate());
		user.setCellPhoneNumber(userDto.getCellPhoneNumber());
		user.setCity(userDto.getCity());
		user.setCivilStatus(userDto.getCivilStatus());
		user.setEmail(userDto.getEmail());
		user.setFederalId(userDto.getFederalId());
		user.setFunction(userDto.getFunction());
		user.setGroups(UserDto.getGroups(userDto.getGroups()));
		user.setHomeNumber(userDto.getHomeNumber());
		user.setLogin(userDto.getLogin());
		user.setName(userDto.getName());
		user.setNeighborhood(userDto.getNeighborhood());
		user.setObservation(userDto.getObservation());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setProfession(userDto.getProfession());
		user.setPwd(userDto.getPwd());
		user.setRg(userDto.getRg());
		user.setState(userDto.getState());
		user.setStatus(userDto.getStatus());
		user.setZipCode(userDto.getZipCode());
		
		return user;
	}
	
	private static List<Group> getGroups(List<GroupDto> groupDto){
		List<Group> groups = new ArrayList<Group>();
		
		for(Integer i = 0; i < groupDto.size(); i++){			
			groups.add(GroupDto.toGroup(groupDto.get(i)));
		}
		
		return groups;
	}

	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<GroupDto> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupDto> groups) {
		this.groups = groups;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
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

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", login=" + login + ", email=" + email
				+ ", pwd=" + pwd + ", status=" + status + ", groups=" + groups
				+ ", pictureId=" + pictureId + ", ticket=" + ticket
				+ ", userDto=" + userDto + ", name=" + name + ", address="
				+ address + ", homeNumber=" + homeNumber + ", zipCode="
				+ zipCode + ", city=" + city + ", state=" + state
				+ ", phoneNumber=" + phoneNumber + ", cellPhoneNumber="
				+ cellPhoneNumber + ", federalId=" + federalId + ", birthDate="
				+ birthDate + ", civilStatus=" + civilStatus + ", rg=" + rg
				+ ", neighborhood=" + neighborhood + ", observation="
				+ observation + ", profession=" + profession + ", function="
				+ function + "]";
	}

}
