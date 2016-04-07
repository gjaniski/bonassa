package com.esense.bonassa.core.entity;

import java.util.List;

import com.esense.bonassa.core.AbstractCondition;

/**
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * @author Marcelino Ulica
 */

public class Process extends AbstractCondition {

	private Integer id;

	private String numProcess;
	
	private String contCob;

	private Value fileLocale;

	private Value fileFolder;

	private Value state;

	private Value city;

	private Value county;

	private Value notarysOffice;

	private Value court;

	private Boolean recoveredProperty;

	private Boolean relatedProcess;

	private Boolean checkedToExport;

	private Boolean sentence;

	private Boolean acordao;

	private Boolean transit;

	private String observation;

	private Integer instance;

	private Value actionType;

	private Value objectTitle;

	private Value office;

	private String object;

	private Value costCenter;

	private String processRapporteur;

	private Value placeFile;

	private String dateField;

	private String observation2;

	private Double lawSuitValue;

	private Double contingencyValue;

	private Integer activePassiveProcess;

	private Integer lossProb;
	
	private Value motivation;

	private Double finalValue;

	private User creator;

	private List<ProcessPartner> processCustomer;

//	private String processCustomerType;

	private List<ProcessPartner> processOpponent;

//	private String processOpponentType;

	private List<ProcessPartner> processOther;

//	private String processOtherType;

	private Value link;

	private Value phase;

	private Value extra;

	private String tableUpdatedValue;

	private Double lawSuitValueUpdated;

	private String tableContingencyValue;

	private Double contingencyValueUpdated;

	private Integer endResult;
	
//	private String areaProcess;

	private List<ProcessOwner> owners;

	public Process() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumProcess() {
		return numProcess;
	}

	public void setNumProcess(String numProcess) {
		this.numProcess = numProcess;
	}

	public String getContCob() {
		return contCob;
	}

	public void setContCob(String contCob) {
		this.contCob = contCob;
	}	

	public Value getFileLocale() {
		return fileLocale;
	}

	public void setFileLocale(Value fileLocale) {
		this.fileLocale = fileLocale;
	}

	public Value getFileFolder() {
		return fileFolder;
	}

	public void setFileFolder(Value fileFolder) {
		this.fileFolder = fileFolder;
	}

	public Value getState() {
		return state;
	}

	public void setState(Value state) {
		this.state = state;
	}

	public Value getCity() {
		return city;
	}

	public void setCity(Value city) {
		this.city = city;
	}

	public Value getCounty() {
		return county;
	}

	public void setCounty(Value county) {
		this.county = county;
	}

	public Value getNotarysOffice() {
		return notarysOffice;
	}

	public void setNotarysOffice(Value notarysOffice) {
		this.notarysOffice = notarysOffice;
	}

	public Value getCourt() {
		return court;
	}

	public void setCourt(Value court) {
		this.court = court;
	}

	public Boolean getRecoveredProperty() {
		return recoveredProperty;
	}

	public void setRecoveredProperty(Boolean recoveredProperty) {
		this.recoveredProperty = recoveredProperty;
	}

	public Boolean getRelatedProcess() {
		return relatedProcess;
	}

	public void setRelatedProcess(Boolean relatedProcess) {
		this.relatedProcess = relatedProcess;
	}

	public Boolean getCheckedToExport() {
		return checkedToExport;
	}

	public void setCheckedToExport(Boolean checkedToExport) {
		this.checkedToExport = checkedToExport;
	}

	public Boolean getSentence() {
		return sentence;
	}

	public void setSentence(Boolean sentence) {
		this.sentence = sentence;
	}

	public Boolean getAcordao() {
		return acordao;
	}

	public void setAcordao(Boolean acordao) {
		this.acordao = acordao;
	}

	public Boolean getTransit() {
		return transit;
	}

	public void setTransit(Boolean transit) {
		this.transit = transit;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Integer getInstance() {
		return instance;
	}

	public void setInstance(Integer instance) {
		this.instance = instance;
	}

	public Value getActionType() {
		return actionType;
	}

	public void setActionType(Value actionType) {
		this.actionType = actionType;
	}

	public Value getObjectTitle() {
		return objectTitle;
	}

	public void setObjectTitle(Value objectTitle) {
		this.objectTitle = objectTitle;
	}

	public Value getOffice() {
		return office;
	}

	public void setOffice(Value office) {
		this.office = office;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Value getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Value costCenter) {
		this.costCenter = costCenter;
	}

	public String getProcessRapporteur() {
		return processRapporteur;
	}

	public void setProcessRapporteur(String processRapporteur) {
		this.processRapporteur = processRapporteur;
	}

	public Value getPlaceFile() {
		return placeFile;
	}

	public void setPlaceFile(Value placeFile) {
		this.placeFile = placeFile;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

	public String getObservation2() {
		return observation2;
	}

	public void setObservation2(String observation2) {
		this.observation2 = observation2;
	}

	public Double getLawSuitValue() {
		return lawSuitValue;
	}

	public void setLawSuitValue(Double lawSuitValue) {
		this.lawSuitValue = lawSuitValue;
	}

	public Double getContingencyValue() {
		return contingencyValue;
	}

	public void setContingencyValue(Double contingencyValue) {
		this.contingencyValue = contingencyValue;
	}

	public Integer getActivePassiveProcess() {
		return activePassiveProcess;
	}

	public void setActivePassiveProcess(Integer activePassiveProcess) {
		this.activePassiveProcess = activePassiveProcess;
	}

	public Integer getLossProb() {
		return lossProb;
	}

	public void setLossProb(Integer lossProb) {
		this.lossProb = lossProb;
	}

	public Value getMotivation() {
		return motivation;
	}

	public void setMotivation(Value motivation) {
		this.motivation = motivation;
	}

	public Double getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(Double finalValue) {
		this.finalValue = finalValue;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<ProcessPartner> getProcessCustomer() {
		return processCustomer;
	}

	public void setProcessCustomer(List<ProcessPartner> processCustomer) {
		this.processCustomer = processCustomer;
	}

	public List<ProcessPartner> getProcessOpponent() {
		return processOpponent;
	}

	public void setProcessOpponent(List<ProcessPartner> processOpponent) {
		this.processOpponent = processOpponent;
	}

	public List<ProcessPartner> getProcessOther() {
		return processOther;
	}

	public void setProcessOther(List<ProcessPartner> processOther) {
		this.processOther = processOther;
	}
	public Value getLink() {
		return link;
	}

	public void setLink(Value link) {
		this.link = link;
	}

	public Value getPhase() {
		return phase;
	}

	public void setPhase(Value phase) {
		this.phase = phase;
	}

	public Value getExtra() {
		return extra;
	}

	public void setExtra(Value extra) {
		this.extra = extra;
	}

	public String getTableUpdatedValue() {
		return tableUpdatedValue;
	}

	public void setTableUpdatedValue(String tableUpdatedValue) {
		this.tableUpdatedValue = tableUpdatedValue;
	}

	public Double getLawSuitValueUpdated() {
		return lawSuitValueUpdated;
	}

	public void setLawSuitValueUpdated(Double lawSuitValueUpdated) {
		this.lawSuitValueUpdated = lawSuitValueUpdated;
	}

	public String getTableContingencyValue() {
		return tableContingencyValue;
	}

	public void setTableContingencyValue(String tableContingencyValue) {
		this.tableContingencyValue = tableContingencyValue;
	}

	public Double getContingencyValueUpdated() {
		return contingencyValueUpdated;
	}

	public void setContingencyValueUpdated(Double contingencyValueUpdated) {
		this.contingencyValueUpdated = contingencyValueUpdated;
	}

	public Integer getEndResult() {
		return endResult;
	}

	public void setEndResult(Integer endResult) {
		this.endResult = endResult;
	}

	public List<ProcessOwner> getOwners() {
		return owners;
	}

	public void setOwners(List<ProcessOwner> owners) {
		this.owners = owners;
	}

	public boolean validateNotNullAttrs() {
		for(Integer i = 0; i < processCustomer.size(); i++){
			if(processCustomer.get(i).getPartner().getId() == null)
				return false;
		}
		for(Integer i = 0; i < processOpponent.size(); i++){
			if(processOpponent.get(i).getPartner().getId() == null)
				return false;
		}
		for(Integer i = 0; i < processOther.size(); i++){
			if(processOther.get(i).getPartner().getId() == null)
				return false;
		}
		for(Integer i = 0; i < owners.size(); i++){
			if(owners.get(i).getOwner().getId() == null)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", numProcess=" + numProcess
				+ ", contCob=" + contCob + ", fileLocale=" + fileLocale
				+ ", fileFolder=" + fileFolder + ", state=" + state + ", city="
				+ city + ", county=" + county + ", notarysOffice="
				+ notarysOffice + ", court=" + court + ", recoveredProperty="
				+ recoveredProperty + ", relatedProcess=" + relatedProcess
				+ ", checkedToExport=" + checkedToExport + ", sentence="
				+ sentence + ", acordao=" + acordao + ", transit=" + transit
				+ ", observation=" + observation + ", instance=" + instance
				+ ", actionType=" + actionType + ", objectTitle=" + objectTitle
				+ ", office=" + office + ", object=" + object + ", costCenter="
				+ costCenter + ", processRapporteur=" + processRapporteur
				+ ", placeFile=" + placeFile + ", dateField=" + dateField
				+ ", observation2=" + observation2 + ", lawSuitValue="
				+ lawSuitValue + ", contingencyValue=" + contingencyValue
				+ ", activePassiveProcess=" + activePassiveProcess
				+ ", lossProb=" + lossProb + ", motivation=" + motivation
				+ ", finalValue=" + finalValue + ", creator=" + creator
				+ ", processCustomer=" + processCustomer + ", processOpponent="
				+ processOpponent + ", processOther=" + processOther
				+ ", link=" + link + ", phase=" + phase + ", extra=" + extra
				+ ", tableUpdatedValue=" + tableUpdatedValue
				+ ", lawSuitValueUpdated=" + lawSuitValueUpdated
				+ ", tableContingencyValue=" + tableContingencyValue
				+ ", contingencyValueUpdated=" + contingencyValueUpdated
				+ ", endResult=" + endResult + ", owners=" + owners + "]";
	}
}
