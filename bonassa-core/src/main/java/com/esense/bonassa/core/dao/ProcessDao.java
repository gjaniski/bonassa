package com.esense.bonassa.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esense.bonassa.core.entity.Process;
import com.esense.bonassa.core.entity.ProcessAppointment;
import com.esense.bonassa.core.entity.ProcessAttached;
import com.esense.bonassa.core.entity.ProcessOwner;
import com.esense.bonassa.core.entity.ProcessPartner;
import com.esense.bonassa.core.entity.ProcessProgress;
import com.esense.bonassa.core.entity.ProcessProperty;
import com.esense.bonassa.core.entity.ProcessRequest;
import com.esense.bonassa.core.entity.User;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 * @author Marcelino Ulica
 *
 */

public interface ProcessDao {

	public List<Process> select(Process query);

	public List<ProcessProgress> selectProgress(ProcessProgress query);

	public List<ProcessAppointment> selectProcessAppointment(ProcessAppointment query);

	public List<ProcessAttached> selectProcessAttached(ProcessAttached query);

	public List<ProcessRequest> selectProcessRequest(ProcessRequest query);

	public List<ProcessProperty> selectProcessProperty(ProcessProperty query);

	public int insert(Process process);

	public void insertProgress(ProcessProgress processProgress);
	
	public int insertProgressOwner(@Param("processProgress") ProcessProgress processProgress,
			@Param("user") User user);

	public void insertProcessAppointment(ProcessAppointment processAppointment);
	
	public int insertAppointmentOwner(@Param("processAppointment") ProcessAppointment processAppointment,
			@Param("user") User user);

	public int insertProcessAttached(ProcessAttached processAttached);

	public int insertProcessPartner(ProcessPartner processPartner);

	public int insertProcessRequest(ProcessRequest processRequest);

	public int insertProcessProperty(ProcessProperty processProperty);

//	public int insertProcessOwner(@Param("process") Process process,
//				@Param("user") User user);
	
	public int insertProcessOwner(ProcessOwner processOwner);
	
//	public int insertProcessOwner(@Param("process") Process process, ProcessOwner processOwner);
	
	public int update(Process process);

	public int updateProcessProgress(ProcessProgress processProgress);

	public int updateProcessAppointment(ProcessAppointment processAppointment);

	public int updateProcessRequest(ProcessRequest processRequest);

	public int updateProcessProperty(ProcessProperty processProperty);

	public int deleteProcessAttached(ProcessAttached processAttached);
	
	public void deleteProcessPartners(Process process);
	
	public void deleteProcessOwners(Process process);
	
	public void deleteProcessProgressOwners(ProcessProgress processProgress);
	
	public void deleteProcessAppointmentOwners(ProcessAppointment processAppointment);

	public List<User> selectOwnerByProgress(Integer id);

}
