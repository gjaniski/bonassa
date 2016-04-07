package com.esense.bonassa.core.service;

import java.util.List;

import com.esense.bonassa.core.entity.Partner;
import com.esense.bonassa.core.exception.MandatoryFieldException;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public interface PartnerService {

	public void insert(Partner customer) throws MandatoryFieldException;

	public List<Partner> customer();
	
	public List<Partner> opponent();
	
	public List<Partner> other();

	public Partner selectById(Integer id);
	
	public void update(Partner customer) throws MandatoryFieldException;

}
