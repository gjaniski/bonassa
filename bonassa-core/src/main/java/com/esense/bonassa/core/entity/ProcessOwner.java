package com.esense.bonassa.core.entity;

/**
 * 
 * @author Gerson Janiski
 *
 */

public class ProcessOwner {
	
	private Process process;
	private User owner;
	private Value area;
		
	
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Value getArea() {
		return area;
	}
	public void setArea(Value area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "ProcessOwner [process=" + process + ", owner=" + owner
				+ ", area=" + area + "]";
	}
	
}
