package com.esense.bonassa.rest.dto;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessProperty;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Gerson janiski
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessPropertyDto {

	private static final Mapper mapper;
	
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Process process;
	@JsonIgnore
	private String type;
	@JsonIgnore
	private Value status;
	@JsonIgnore
	private Value brand;
	@JsonIgnore
	private Value model;
	@JsonIgnore
	private String numContract;
	@JsonIgnore
	private Value color;
	@JsonIgnore
	private String year;
	@JsonIgnore
	private Double value;	
	@JsonIgnore
	private String dateEnv;
	@JsonIgnore
	private String dateInad;
	@JsonIgnore
	private String dateSeizure;
	@JsonIgnore
	private String dateSentence;
	@JsonIgnore
	private String dateAuction;
	@JsonIgnore
	private String dateSale;
	@JsonIgnore
	private Value deposit;
	@JsonIgnore
	private String observation;

	static {

		mapper = new DozerBeanMapper();
	}

	public static ProcessProperty toProcessProperty(ProcessPropertyDto dto) {
		ProcessProperty processProperty = mapper.map(dto, ProcessProperty.class);
		return processProperty;
	}

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
}
