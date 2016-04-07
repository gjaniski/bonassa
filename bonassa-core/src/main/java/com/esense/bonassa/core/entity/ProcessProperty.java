package com.esense.bonassa.core.entity;

import com.esense.bonassa.core.AbstractCondition;
import com.esense.bonassa.core.ValidadeAttrs;

/**
 * 
 * @author Douglas Cardoso
 *
 */

public class ProcessProperty extends AbstractCondition implements ValidadeAttrs {

	private Integer id;

	private Process process;

	private String type;

	private Value status;

	private Value brand;

	private Value model;

	private String numContract;

	private Value color;

	private String year;

	private Double value;

	private String dateEnv;

	private String dateInad;

	private String dateSeizure;

	private String dateSentence;

	private String dateAuction;

	private String dateSale;

	private Value deposit;

	private String observation;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getStatus() {
		return status;
	}

	public void setStatus(Value status) {
		this.status = status;
	}

	public Value getBrand() {
		return brand;
	}

	public void setBrand(Value brand) {
		this.brand = brand;
	}

	public Value getModel() {
		return model;
	}

	public void setModel(Value model) {
		this.model = model;
	}

	public String getNumContract() {
		return numContract;
	}

	public void setNumContract(String numContract) {
		this.numContract = numContract;
	}

	public Value getColor() {
		return color;
	}

	public void setColor(Value color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDateEnv() {
		return dateEnv;
	}

	public void setDateEnv(String dateEnv) {
		this.dateEnv = dateEnv;
	}

	public String getDateInad() {
		return dateInad;
	}

	public void setDateInad(String dateInad) {
		this.dateInad = dateInad;
	}

	public String getDateSeizure() {
		return dateSeizure;
	}

	public void setDateSeizure(String dateSeizure) {
		this.dateSeizure = dateSeizure;
	}

	public String getDateSentence() {
		return dateSentence;
	}

	public void setDateSentence(String dateSentence) {
		this.dateSentence = dateSentence;
	}

	public String getDateAuction() {
		return dateAuction;
	}

	public void setDateAuction(String dateAuction) {
		this.dateAuction = dateAuction;
	}

	public String getDateSale() {
		return dateSale;
	}

	public void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}

	public Value getDeposit() {
		return deposit;
	}

	public void setDeposit(Value deposit) {
		this.deposit = deposit;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public boolean validateNotNullAttrs() {
		return true;
	}

	@Override
	public boolean validateFiles() {
		return true;
	}
}
