package com.esense.bonassa.core.entity;

import java.util.List;

import com.esense.bonassa.core.AbstractCondition;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public class User extends AbstractCondition {

	private Integer id;

	private String name;

	private String login;

	private String email;

	private String pwd;

	private Integer status;

	private List<Group> groups;

	private String pictureId;

	private Ticket ticket;

	private String address;

	private String homeNumber;

	private String zipCode;

	private Value city;

	private Value state;

	private String phoneNumber;

	private String cellPhoneNumber;

	private String federalId;

	private String birthDate;

	private Value civilStatus;

	private String rg;

	private String neighborhood;

	private String observation;

	private String profession;

	private String function;

	public User() {
	}

	public User(boolean distinct) {
		super(distinct);
	}

	public User(List<Criterion> criterions) {
		super(criterions);
	}

	public User(boolean distinct, List<Criterion> criterions) {
		super(distinct, criterions);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((pictureId == null) ? 0 : pictureId.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pictureId == null) {
			if (other.pictureId != null)
				return false;
		} else if (!pictureId.equals(other.pictureId))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login
				+ ", email=" + email + ", pwd=" + pwd + ", status=" + status
				+ ", groups=" + groups + ", pictureId=" + pictureId
				+ ", ticket=" + ticket + ", address=" + address
				+ ", homeNumber=" + homeNumber + ", zipCode=" + zipCode
				+ ", city=" + city + ", state=" + state + ", phoneNumber="
				+ phoneNumber + ", cellPhoneNumber=" + cellPhoneNumber
				+ ", federalId=" + federalId + ", birthDate=" + birthDate
				+ ", civilStatus=" + civilStatus + ", rg=" + rg
				+ ", neighborhood=" + neighborhood + ", observation="
				+ observation + ", profession=" + profession + ", function="
				+ function + "]";
	}

	public boolean validateNullAttrs() {
		if (login == null || login == "")
			return false;
		if (email == null || email == "")
			return false;
		// if (id == null)
		// return false;
		for (Integer i = 0; i < groups.size(); i++) {
			if (groups.get(i).getId() == null)
				return false;
		}
		return true;
	}

}
