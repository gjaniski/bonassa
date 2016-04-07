package com.esense.bonassa.core.entity;

import com.esense.bonassa.core.AbstractCondition;

public class ProcessId extends AbstractCondition {
	
	private User user;
	
	private Process Process;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Process getProcess() {
		return Process;
	}

	public void setProcess(Process process) {
		Process = process;
	}

	@Override
	public String toString() {
		return "ProcessId [user=" + user + ", Process=" + Process + "]";
	}
}
