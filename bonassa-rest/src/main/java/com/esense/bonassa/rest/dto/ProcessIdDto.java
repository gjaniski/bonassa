package com.esense.bonassa.rest.dto;

import com.esense.bonassa.core.entity.ProcessId;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessIdDto {
//	@JsonIgnore
	private UserDto userDto;
//	@JsonIgnore
	private ProcessDto processDto;

	public static ProcessId toProcessId(ProcessIdDto dto) {
		ProcessId processId = new ProcessId();
		processId.setUser(UserDto.toUserFromDto(dto.userDto));
		processId.setProcess(ProcessDto.toProcess(dto.processDto));
		return processId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public ProcessDto getProcessDto() {
		return processDto;
	}

	public void setProcessDto(ProcessDto processDto) {
		this.processDto = processDto;
	}
}
