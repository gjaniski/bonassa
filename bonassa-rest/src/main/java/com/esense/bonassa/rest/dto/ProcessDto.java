package com.esense.bonassa.rest.dto;

import java.io.Serializable;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.esense.bonassa.core.AbstractCondition;
import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessOwner;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.entity.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessDto extends AbstractCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Mapper mapper;
	
	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private String numProcess;
	@JsonIgnore
	private String contCob;
	@JsonIgnore
	private Value fileLocale;
	@JsonIgnore
	private Value fileFolder;
	@JsonIgnore
	private Value state;
	@JsonIgnore
	private Value city;
	@JsonIgnore
	private Value county;
	@JsonIgnore
	private Value notarysOffice;
	@JsonIgnore
	private Value court;
	@JsonIgnore
	private Boolean recoveredProperty;
	@JsonIgnore
	private Boolean relatedProcess;
	@JsonIgnore
	private Boolean checkedToExport;
	@JsonIgnore
	private Boolean sentence;
	@JsonIgnore
	private Boolean acordao;
	@JsonIgnore
	private Boolean transit;
	@JsonIgnore
	private String observation;
	@JsonIgnore
	private Integer instance;
	@JsonIgnore
	private Value actionType;
	@JsonIgnore
	private Value objectTitle;
	@JsonIgnore
	private Value office;
	@JsonIgnore
	private String object;
	@JsonIgnore
	private Value costCenter;
	@JsonIgnore
	private String processRapporteur;
	@JsonIgnore
	private Value placeFile;
	@JsonIgnore
	private String dateField;
	@JsonIgnore
	private String observation2;
	@JsonIgnore
	private Double lawSuitValue;
	@JsonIgnore
	private Double contingencyValue;
	@JsonIgnore
	private Integer activePassiveProcess;
	@JsonIgnore
	private Integer lossProb;
	@JsonIgnore
	private Value motivation;
	@JsonIgnore
	private Double finalValue;
	@JsonIgnore
	private User creator;
	@JsonIgnore
	private List<ProcessPartnerDto> processCustomer;
	@JsonIgnore
	private List<ProcessPartnerDto> processOpponent;
	@JsonIgnore
	private List<ProcessPartnerDto> processOther;
	@JsonIgnore
	private Value link;
	@JsonIgnore
	private Value phase;
	@JsonIgnore
	private Value extra;
	@JsonIgnore
	private String tableUpdatedValue;
	@JsonIgnore
	private Double lawSuitValueUpdated;
	@JsonIgnore
	private String tableContingencyValue;
	@JsonIgnore
	private Double contingencyValueUpdated;
	@JsonIgnore
	private Integer endResult;
//	@JsonIgnore
//	private String areaProcess;
	@JsonIgnore
	private List<ProcessOwnerDto> owners;

	static {

		mapper = new DozerBeanMapper();
	}

	public static Process toProcess(ProcessDto dto) {
		Process process = mapper.map(dto, Process.class);
		return process;
	}
	
//	public static Process toProcess(ProcessDto processDto) {
//		Process process = new Process();
//		process.setId(processDto.getId());
//		process.setNumProcess(processDto.getNumProcess());
//		process.setContCob(processDto.getContCob());
//		process.setFileLocale(processDto.getFileLocale());
//		process.setFileFolder(processDto.getFileFolder());
//		process.setState(processDto.getState());
//		process.setCity(processDto.getCity());
//		process.setCounty(processDto.getCounty());
//		process.setNotarysOffice(processDto.getNotarysOffice());
//		process.setCourt(processDto.getCourt());
//		process.setRecoveredProperty(processDto.getRecoveredProperty());
//		process.setRelatedProcess(processDto.getRelatedProcess());
//		process.setCheckedToExport(processDto.getCheckedToExport());
//		process.setSentence(processDto.getSentence());
//		process.setAcordao(processDto.getAcordao());
//		process.setTransit(processDto.getTransit());
//		process.setObservation(processDto.getObservation());
//		process.setInstance(processDto.getInstance());
//		process.setActionType(processDto.getActionType());
//		process.setObjectTitle(processDto.getObjectTitle());
//		process.setOffice(processDto.getOffice());
//		process.setObject(processDto.getObject());
//		process.setCostCenter(processDto.getCostCenter());
//		process.setProcessRapporteur(processDto.getProcessRapporteur());
//		process.setPlaceFile(processDto.getPlaceFile());
//		process.setDateField(processDto.getDateField());
//		process.setObservation2(processDto.getObservation2());
//		process.setLawSuitValue(processDto.getLawSuitValue());
//		process.setContingencyValue(processDto.getContingencyValue());
//		process.setActivePassiveProcess(processDto.getActivePassiveProcess());
//		process.setLossProb(processDto.getLossProb());
//		process.setMotivation(processDto.getMotivation());
//		process.setFinalValue(processDto.getFinalValue());
//		process.setCreator(processDto.getCreator());
//		process.setProcessCustomer(ProcessDto.ToProcessPartners(processDto.getProcessCustomer()));
//		process.setProcessOpponent(ProcessDto.ToProcessPartners(processDto.getProcessOpponent()));
//		process.setProcessOther(ProcessDto.ToProcessPartners(processDto.getProcessOther()));
//		process.setLink(processDto.getLink());
//		process.setPhase(processDto.getPhase());
//		process.setExtra(processDto.getExtra());
//		process.setTableUpdatedValue(processDto.getTableUpdatedValue());
//		process.setLawSuitValueUpdated(processDto.getLawSuitValueUpdated());
//		process.setTableContingencyValue(processDto.getTableContingencyValue());
//		process.setContingencyValueUpdated(processDto.getContingencyValueUpdated());
//		process.setEndResult(processDto.getEndResult());
//		process.setOwners(ProcessDto.ToOwners(processDto.getOwners()));				
//		return process;
//	}	
//	
//	private static List<ProcessPartner> ToProcessPartners(List<ProcessPartnerDto> processPartnerDto){
//		List<ProcessPartner> processPartners = new ArrayList<ProcessPartner>();
//		
//		for(Integer i = 0; i < processPartnerDto.size(); i++){		
//			ProcessPartner processPartner = new ProcessPartner();
////			processPartner.setPartner(PartnerDto.toPartner(processPartnerDto.get(i).getPartner()));
//			Partner partner = new Partner();
//			partner.setId(processPartnerDto.get(i).getPartner().getId());
//			processPartner.setPartner(partner);
//			processPartners.add(processPartner);
////			processPartners.add(ProcessPartnerDto.toProcessPartner(processPartnerDto.get(i)));
//		}
//		
//		return processPartners;
//	}
//	
//	private static List<User> ToOwners(List<UserDto> userDto){
//		List<User> users = new ArrayList<User>();
//		
//		for(Integer i = 0; i < userDto.size(); i++){
//			User user = new User();
//			user.setId(userDto.get(i).getId());
//			users.add(user);
//		}
//		
//		return users;
//	}
	
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

	public List<ProcessPartnerDto> getProcessCustomer() {
		return processCustomer;
	}

	public void setProcessCustomer(List<ProcessPartnerDto> processCustomer) {
		this.processCustomer = processCustomer;
	}

	public List<ProcessPartnerDto> getProcessOpponent() {
		return processOpponent;
	}

	public void setProcessOpponent(List<ProcessPartnerDto> processOpponent) {
		this.processOpponent = processOpponent;
	}

	public List<ProcessPartnerDto> getProcessOther() {
		return processOther;
	}

	public void setProcessOther(List<ProcessPartnerDto> processOther) {
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

	public List<ProcessOwnerDto> getOwners() {
		return owners;
	}

	public void setOwners(List<ProcessOwnerDto> owners) {
		this.owners = owners;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProcessDto [id=" + id + ", numProcess=" + numProcess
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
