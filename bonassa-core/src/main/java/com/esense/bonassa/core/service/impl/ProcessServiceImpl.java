package com.esense.bonassa.core.service.impl;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.ProcessDao;
import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessAppointment;
import com.esense.bonassa.core.entity.ProcessAttached;
import com.esense.bonassa.core.entity.ProcessOwner;
import com.esense.bonassa.core.entity.ProcessPartner;
import com.esense.bonassa.core.entity.ProcessProgress;
import com.esense.bonassa.core.entity.ProcessProperty;
import com.esense.bonassa.core.entity.ProcessRequest;
import com.esense.bonassa.core.entity.User;
import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.core.exception.ServiceException;
import com.esense.bonassa.core.service.ProcessService;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * @author Marcelino Ulica
 *
 */

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessDao processDao;

	private final Logger logger = Logger.getLogger(ProcessServiceImpl.class);

	@Override
	public Process selectById(Integer id) {
		Process process = null;
		try {
			Process query = new Process();
			query.createCriterion("a.id_", Operator.EQUALS, id);
			List<Process> result = processDao.select(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			process = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return process;
	}

	@Override
	public List<Process> selectAll() {
		return processDao.select(new Process());
	}

	@Override
	public void update(Process process) throws MandatoryFieldException {
		try {
			if (process == null)
				throw new NullPointerException();
			if (!process.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.update(process);
			processDao.deleteProcessPartners(process);
			processDao.deleteProcessOwners(process);
			insertProcessCustomer(process);
			insertProcessOpponent(process);
			insertProcessOther(process);
			insertProcessOwners(process);
		} catch (NullPointerException ex) {
			logger.error("Process is null");
		}
	}

	@Override
	public ProcessProgress selectProgressById(Integer id) {
		ProcessProgress processProgress = null;
		try {
			ProcessProgress query = new ProcessProgress();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<ProcessProgress> result = processDao.selectProgress(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			processProgress = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return processProgress;
	}

	@Override
	public List<ProcessProgress> selectProgress(Integer id) {

		ProcessProgress query = new ProcessProgress();
		query.createCriterion("process_id_", Operator.EQUALS, id);
		List<ProcessProgress> progressesList = processDao
				.selectProgress(query);
		for(Integer i = 0; i < progressesList.size(); i++){			
			progressesList.get(i).setOwners(listProgressOwners(progressesList.get(i).getId()));
			logger.error(progressesList.get(i).getId());
			logger.error(progressesList.get(i).getOwners().size());
		}
		
		return progressesList;
	}
	
	private List<User> listProgressOwners(Integer id) {
		
		List<User> ownersList = processDao
				.selectOwnerByProgress(id);
		
		return ownersList;
	}

	@Override
	public ProcessRequest selectProcessRequestById(Integer id) {
		ProcessRequest processRequest = null;
		try {
			ProcessRequest query = new ProcessRequest();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<ProcessRequest> result = processDao
					.selectProcessRequest(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			processRequest = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return processRequest;
	}

	@Override
	public List<ProcessRequest> selectProcessRequest(Integer id) {
		
		ProcessRequest query = new ProcessRequest();
		query.createCriterion("process_id_", Operator.EQUALS, id);
		List<ProcessRequest> requestsList = processDao
				.selectProcessRequest(query);

		return requestsList;
	}

	@Override
	public ProcessProperty selectProcessPropertyById(Integer id) {
		ProcessProperty processProperty = null;
		try {
			ProcessProperty query = new ProcessProperty();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<ProcessProperty> result = processDao
					.selectProcessProperty(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			processProperty = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return processProperty;
	}

	@Override
	public void insertProgress(ProcessProgress processProgress) throws MandatoryFieldException {
		try {
			if (processProgress == null)
				throw new NullPointerException();
			if (!processProgress.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insertProgress(processProgress);
			insertProgressOwners(processProgress);
		} catch (NullPointerException ex) {
			logger.error("Process Progress is null");
		}
	}

	@Override
	public void insertProcessRequest(ProcessRequest processRequest) throws MandatoryFieldException{
		try {
			if (processRequest == null)
				throw new NullPointerException();
			if (!processRequest.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insertProcessRequest(processRequest);
		} catch (NullPointerException ex) {
			logger.error("Process Request is null");
		}
	}

	@Override
	public void insert(Process process) throws MandatoryFieldException {
		try {
			if (process == null)
				throw new NullPointerException();
			if (!process.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insert(process);
			insertProcessCustomer(process);
			insertProcessOpponent(process);
			insertProcessOther(process);
			insertProcessOwners(process);
		} catch (NullPointerException ex) {
			logger.error("Process is null");
		}
	}

	private void insertProcessCustomer(Process process) {
		for (ProcessPartner processPartner : process.getProcessCustomer()) {
			processPartner.setProcess(process);
			processDao.insertProcessPartner(processPartner);
		}
	}
	
	private void insertProcessOpponent(Process process) {
		for (ProcessPartner processPartner : process.getProcessOpponent()) {
			processPartner.setProcess(process);
			processDao.insertProcessPartner(processPartner);
		}
	}
	
	private void insertProcessOther(Process process) {
		for (ProcessPartner processPartner : process.getProcessOther()) {
			processPartner.setProcess(process);
			processDao.insertProcessPartner(processPartner);
		}
	}

	private void insertProcessOwners(Process process) {
		for (ProcessOwner processOwner : process.getOwners()) {
//			processDao.insertProcessOwner(process, user);
			processOwner.setProcess(process);
			processDao.insertProcessOwner(processOwner);
		}
	}
	
//	private void insertProcessOwners(Process process) {
//		for (ProcessOwner processOwner : process.getOwners()) {
//			processDao.insertProcessOwner(process, processOwner);
//		}
//	}

	private void insertProgressOwners(ProcessProgress processProgress) {
		for (User user : processProgress.getOwners()) {
			processDao.insertProgressOwner(processProgress, user);
		}
	}
	
	@Override
	public void insertProcessProperty(ProcessProperty processProperty) throws MandatoryFieldException {
		try {
//			ValidadeAttrs validate = processProperty;

			if (processProperty == null)
				throw new NullPointerException();
			if (!processProperty.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insertProcessProperty(processProperty);
		} catch (NullPointerException ex) {
			logger.error("processProperty is null");

		}
	}

	@Override
	public List<ProcessProperty> selectProcessProperty(Integer id) {

		ProcessProperty query = new ProcessProperty();
		query.createCriterion("process_id_", Operator.EQUALS, id);
		List<ProcessProperty> propertiesList = processDao
				.selectProcessProperty(query);

		return propertiesList;
	}

	@Override
	public ProcessAppointment selectProcessAppointmentById(Integer id) {
		ProcessAppointment processAppointment = null;
		try {
			ProcessAppointment query = new ProcessAppointment();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<ProcessAppointment> result = processDao.selectProcessAppointment(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			processAppointment = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return processAppointment;
	}

	@Override
	public List<ProcessAppointment> selectProcessAppointment(Integer id) {
		
		ProcessAppointment query = new ProcessAppointment();
		query.createCriterion("process_id_", Operator.EQUALS, id);
		List<ProcessAppointment> appointmentList = processDao
				.selectProcessAppointment(query);

		return appointmentList;
	}

	@Override
	public ProcessAttached selectProcessAttachedById(Integer id) {
		ProcessAttached processAttached = null;
		try {
			ProcessAttached query = new ProcessAttached();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<ProcessAttached> result = processDao.selectProcessAttached(query);
			if (result.size() > 1)
				throw new ServiceException();
			if (result.size() == 0)
				throw new InvalidAttributeValueException();
			processAttached = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return processAttached;
	}

	@Override
	public List<ProcessAttached> selectProcessAttached(Integer id) {
		
		ProcessAttached query = new ProcessAttached();
		query.createCriterion("parent_process_id_", Operator.EQUALS, id);
		List<ProcessAttached> attachedList = processDao
				.selectProcessAttached(query);

		return attachedList;
	}

	@Override
	public void insertProcessAppointment(ProcessAppointment processAppointment) throws MandatoryFieldException {
		try {
			if (processAppointment == null)
				throw new NullPointerException();
			if (!processAppointment.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insertProcessAppointment(processAppointment);
			insertAppointmentOwners(processAppointment);
		} catch (NullPointerException ex) {
			logger.error("ProcessAppointment is null");
		}
	}

	private void insertAppointmentOwners(ProcessAppointment processAppointment) {
		for (User user : processAppointment.getOwners()) {
			processDao.insertAppointmentOwner(processAppointment, user);
		}
	}

	@Override
	public void insertProcessAttached(ProcessAttached processAttached) throws MandatoryFieldException {
		try {
			if (processAttached == null)
				throw new NullPointerException();
			if (!processAttached.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.insertProcessAttached(processAttached);
		} catch (NullPointerException ex) {
			logger.error("ProcessAttached is null");
		}		
	}

	@Override
	public void updateProcessProgress(ProcessProgress processProgress) throws MandatoryFieldException {		
		try {
			if (processProgress == null)
				throw new NullPointerException();
			if (!processProgress.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.updateProcessProgress(processProgress);
			processDao.deleteProcessProgressOwners(processProgress);
			insertProgressOwners(processProgress);
		} catch (NullPointerException ex) {
			logger.error("ProcessProgress is null");
		}
	}

	@Override
	public void updateProcessAppointment(ProcessAppointment processAppointment) throws MandatoryFieldException {		
		try {
			if (processAppointment == null)
				throw new NullPointerException();
			if (!processAppointment.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.updateProcessAppointment(processAppointment);
			processDao.deleteProcessAppointmentOwners(processAppointment);
			insertAppointmentOwners(processAppointment);
		} catch (NullPointerException ex) {
			logger.error("ProcessAppointment is null");
		}
		
	}

	@Override
	public void updateProcessRequest(ProcessRequest processRequest) throws MandatoryFieldException {
		try {
			if (processRequest == null)
				throw new NullPointerException();
			if (!processRequest.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.updateProcessRequest(processRequest);
		} catch (NullPointerException ex) {
			logger.error("ProcessRequest is null");
		}
	}

	@Override
	public void updateProcessProperty(ProcessProperty processProperty) throws MandatoryFieldException {
		try {
			if (processProperty == null)
				throw new NullPointerException();
			if (!processProperty.validateNotNullAttrs())
				throw new MandatoryFieldException();
			processDao.updateProcessProperty(processProperty);
		} catch (NullPointerException ex) {
			logger.error("ProcessProperty is null");
		}
	}

	@Override
	public void deleteProcessAttached(ProcessAttached processAttached) {
		
		try {
			if (processAttached == null)
				throw new NullPointerException();
			processDao.deleteProcessAttached(processAttached);
		} catch (NullPointerException ex) {
			logger.error("ProcessAttached is null");
		}		
	}
}