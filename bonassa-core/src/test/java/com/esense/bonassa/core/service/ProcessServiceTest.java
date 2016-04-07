package com.esense.bonassa.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessPartner;
import com.esense.bonassa.core.entity.ProcessProgress;
import com.esense.bonassa.core.entity.ProcessProperty;
import com.esense.bonassa.core.entity.ProcessRequest;
import com.esense.bonassa.core.entity.User;

/**
 * 
 * @author Marcelino Ulica
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resources/com/esense/bonassa/core/spring-config.xml")
public class ProcessServiceTest {

	@Autowired
	private ProcessService processService;

	@Autowired
	private UserService userService;

	@Autowired
	private PartnerService partnerService;

	@Test
	public void init() {
		Assert.notNull(processService);
	}

	@Test
	public void insert() {

		List<ProcessPartner> processPartners = new ArrayList<ProcessPartner>();
		ProcessPartner processPartner = new ProcessPartner();
		processPartner.setPartner(partnerService.selectById(1));

		processPartners.add(processPartner);

		processPartner = new ProcessPartner();
		processPartner.setPartner(partnerService.selectById(11));

		processPartners.add(processPartner);

		List<User> owners = new ArrayList<User>();

		User user = userService.selectById(2);

		owners.add(user);

//		processPartner.setProcessRelationship("Interessada");

		Process process = new Process();
		process.setNumProcess("1234");
//		process.setFileLocale("fileLocale");
//		process.setFileFolder("fileFolder");
		// process.setState("Parana");
		// process.setCity("Curitiba");
//		process.setCounty("county");
//		process.setNotarysOffice("notarysOffice");
//		process.setCourt("court");
		process.setRecoveredProperty(true);
		process.setRelatedProcess(false);
//		process.setObjectTitle("objectTitle");
//		process.setOffice("office");
		process.setObject("object");
//		process.setCostCenter("costCenter");
		process.setProcessRapporteur("processRapporteur");
		process.setDateField("01/01/2016");
		process.setObservation2("Experiencia Java");
		process.setObservation("observaton");
		process.setCheckedToExport(false);
		process.setSentence(false);
		process.setTransit(false);
		process.setInstance(0);
//		process.setActionType("actionType");
//		process.setPlaceFile("");
		process.setActivePassiveProcess(0);
		process.setLossProb(0);
//		process.setMotivation("Teste");
		process.setLawSuitValue(7899.4);
		process.setContingencyValue(101.01);
		process.setFinalValue(789.45);
		process.setCreator(userService.selectById(2));
		// process.setProcessCustomer(processPartners);
		// process.setOwners(owners);

		// processService.insert(process);
	}

	// @Test
	// public void select() {
	//
	// Process process = processService.selectById(5);
	//
	// Assert.notNull(process);
	//
	// System.out.println("id ::::::" + process.getId());
	//
	// }

	@Test
	public void update() {

		Process process = new Process();
		process.setNumProcess("1234");
//		process.setFileLocale("fileLocale");
//		process.setFileFolder("fileFolder");
		// process.setState("Parana");
		// process.setCity("Curitiba");
//		process.setCounty("county");
//		process.setNotarysOffice("notarysOffice");
//		process.setCourt("court");
		process.setRecoveredProperty(true);
		process.setRelatedProcess(false);
//		process.setObjectTitle("objectTitle");
//		process.setOffice("office");
		process.setObject("object");
//		process.setCostCenter("costCenter");
		process.setProcessRapporteur("processRapporteur");
		process.setDateField("01/01/2016");
		process.setObservation2("Experiencia Java");
		process.setObservation("observaton");
		process.setCheckedToExport(false);
		process.setSentence(false);
		process.setTransit(false);
		process.setInstance(0);
//		process.setActionType("actionType");
//		process.setPlaceFile("");
		process.setActivePassiveProcess(0);
		process.setLossProb(0);
//		process.setMotivation("Teste");
		process.setLawSuitValue(7899.4);
		process.setContingencyValue(101.01);
		process.setFinalValue(789.45);
		process.setCreator(userService.selectById(2));
	}

	@Test
	public void insertProgress() {

		ProcessProgress processProgress = new ProcessProgress();

		List<User> owners = new ArrayList<User>();
		owners.add(userService.selectById(1));

		processProgress.setCreationDate("01/01/2016");
//		processProgress.setActionType("action Type");
		processProgress.setCreator(userService.selectById(1));
		processProgress.setDescription("Description");
		processProgress.setOwners(owners);
//		processProgress.setPhase("Qualquer");
		processProgress.setProcess(processService.selectById(5));
		processProgress.setSendEmail(true);
		processProgress.setShowRepoClient(true);

		// processService.insertProgress(processProgress);

	}

	// @Test
	// public void selectProgress() {
	//
	// ProcessProgress processProgress = processService.selectProgressById(1);
	// Assert.notNull(processProgress);
	//
	// System.out.println(processProgress);
	//
	// }

	@Test
	public void insertProcessProgress() {

		ProcessRequest pr = new ProcessRequest();

		pr.setProcess(processService.selectById(5));
		pr.setLossProb(1);
//		pr.setStatus("Status");
//		pr.setType("type");
		pr.setAskedDate(new Date());
		pr.setObservation("observation");
		pr.setInitialInterest(1955.);

		// processService.insertProcessRequest(pr);

	}

	@Test
	public void insertProcessProperty() {

		ProcessProperty processProperty = new ProcessProperty();

//		processProperty.setColor("Color");
		processProperty.setDateAuction("01/01/2016");
		processProperty.setDateEnv("01/01/2016");
		processProperty.setDateInad("01/01/2016");
		processProperty.setDateSeizure("01/01/2016");
		processProperty.setDateSentence("01/01/2016");
//		processProperty.setBrand("brand");
//		processProperty.setDeposit("Deposit");
//		processProperty.setModel("model");
		processProperty.setDateSale("01/01/2016");
		processProperty.setProcess(processService.selectById(5));

		// processService.insertProcessProperty(processProperty);
	}

	@Test
	public void insertProcessRequest() {

		ProcessRequest processRequest = new ProcessRequest();

		processRequest.setAskedDate(new Date());
		processRequest.setInitialInterest(1950.);
		processRequest.setLossProb(1);
		processRequest.setObservation("observation");
//		processRequest.setStatus("status");
//		processRequest.setType("type");
		processRequest.setProcess(processService.selectById(49));

		// processService.insertProcessRequest(processRequest);
	}

//	@Test
//	public void list() {

		// Process process = new Process();

//		List<Process> process = processService.selectAll();
//
//		for (Process pro : process) {
//			System.out.println(pro.getNumProcess());
//		}
//	}

}
