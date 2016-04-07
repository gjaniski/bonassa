package com.esense.bonassa.core.service;

import java.util.List;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessAppointment;
import com.esense.bonassa.core.entity.ProcessAttached;
import com.esense.bonassa.core.entity.ProcessProgress;
import com.esense.bonassa.core.entity.ProcessProperty;
import com.esense.bonassa.core.entity.ProcessRequest;
import com.esense.bonassa.core.exception.MandatoryFieldException;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * @author Marcelino Ulica
 *
 */

public interface ProcessService {

	public Process selectById(Integer id);

	public List<Process> selectAll();

	public ProcessProgress selectProgressById(Integer id);
	
	public List<ProcessProgress> selectProgress(Integer id);

	public ProcessAppointment selectProcessAppointmentById(Integer id);
	
	public List<ProcessAppointment> selectProcessAppointment(Integer id);

	public ProcessAttached selectProcessAttachedById(Integer id);
	
	public List<ProcessAttached> selectProcessAttached(Integer id);

	public ProcessRequest selectProcessRequestById(Integer id);

	public List<ProcessRequest> selectProcessRequest(Integer id);

	public ProcessProperty selectProcessPropertyById(Integer id);

	public List<ProcessProperty> selectProcessProperty(Integer id);

	public void insertProcessProperty(ProcessProperty processProperty) throws MandatoryFieldException;

	public void insertProgress(ProcessProgress processProgress) throws MandatoryFieldException;

	public void insertProcessAppointment(ProcessAppointment processAppointment) throws MandatoryFieldException;

	public void insertProcessAttached(ProcessAttached processAttached) throws MandatoryFieldException;

	public void insert(Process process) throws MandatoryFieldException;

	public void insertProcessRequest(ProcessRequest processRequest) throws MandatoryFieldException;

	public void update(Process process) throws MandatoryFieldException;
	
	public void updateProcessProgress(ProcessProgress processProgress) throws MandatoryFieldException;
	
	public void updateProcessAppointment(ProcessAppointment processAppointment) throws MandatoryFieldException;
	
	public void updateProcessRequest(ProcessRequest processRequest) throws MandatoryFieldException;
	
	public void updateProcessProperty(ProcessProperty processProperty) throws MandatoryFieldException;
	
	public void deleteProcessAttached(ProcessAttached processAttached);

}
