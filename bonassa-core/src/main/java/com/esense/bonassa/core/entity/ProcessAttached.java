package com.esense.bonassa.core.entity;

import com.esense.bonassa.core.AbstractCondition;
import com.esense.bonassa.core.ValidadeAttrs;

/**
 * 
 * @author Gerson Janiski
 *
 */

public class ProcessAttached extends AbstractCondition implements ValidadeAttrs{
	
	private Integer Id;

	private Process parentProcess;
	
	private Process childProcess;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Process getParentProcess() {
		return parentProcess;
	}

	public void setParentProcess(Process parentProcess) {
		this.parentProcess = parentProcess;
	}

	public Process getChildProcess() {
		return childProcess;
	}

	public void setChildProcess(Process childProcess) {
		this.childProcess = childProcess;
	}

	public boolean validateNotNullAttrs() {
		return true;
	}

	@Override
	public boolean validateFiles() {
		return true;
	}

	@Override
	public String toString() {
		return "ProcessAttached [Id=" + Id + ", parentProcess=" + parentProcess
				+ ", childProcess=" + childProcess + "]";
	}
}
