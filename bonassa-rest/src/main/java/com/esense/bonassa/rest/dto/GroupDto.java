package com.esense.bonassa.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDto {

//	private static final Mapper mapper;

	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private String name;
	@JsonIgnore
	private Integer status;
	@JsonIgnore
	private Integer userId;

//	static {
//
//		mapper = new DozerBeanMapper();
//	}

	private static Logger logger = Logger.getLogger(GroupDto.class);

//	public static Group toGroup(GroupDto dto) {
//		Group group = mapper.map(dto, Group.class);
//		return group;
//	}
	
	public static Group toGroup(GroupDto groupDto){
		Group group = new Group();
		group.setId(groupDto.getId());
		group.setName(groupDto.getName());
		group.setStatus(groupDto.getStatus());
		group.setUserId(groupDto.getUserId());
		return group;
	}

	public static List<Group> toGroup(UserDto dto) {

		ArrayList<Group> groups = new ArrayList<Group>();		
		
		for (Integer i = 0; i < dto.getGroups().size(); i++) {
			
			Group group = new Group();
			
			group.setId(dto.getGroups().get(i).getId());
			group.setName(dto.getGroups().get(i).getName());
			group.setStatus(dto.getGroups().get(i).getStatus());
			group.setUserId(dto.getId());
			groups.add(i, group);
		}

		return groups;
	}

	public static GroupDto fromUser(Group group) {
		GroupDto dto = new GroupDto();
		dto.id = group.getId();
		dto.name = group.getName();
		dto.status = group.getStatus();
		return dto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
