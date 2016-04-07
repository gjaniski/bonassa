package com.esense.bonassa.core.service.impl;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.bonassa.core.Operator;
import com.esense.bonassa.core.dao.PartnerDao;
import com.esense.bonassa.core.entity.Partner;
import com.esense.bonassa.core.exception.MandatoryFieldException;
import com.esense.bonassa.core.exception.ServiceException;
import com.esense.bonassa.core.service.PartnerService;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerDao customerDao;

	private final Logger logger = Logger.getLogger(PartnerServiceImpl.class);

	@Override
	public void insert(Partner customer) throws MandatoryFieldException {
		try {
			if (customer == null) throw new NullPointerException();
			if (!customer.validateNotNullAttrs())
				throw new MandatoryFieldException();
			customerDao.insert(customer);
		} catch (NullPointerException ex) {
			logger.error("Customer is null");
		}
	}

	@Override
	public List<Partner> customer() {
//		return customerDao.select(new Customer());

		
		Partner query = new Partner();
		query.createCriterion("category_", Operator.EQUALS, "customer");
		List<Partner> requestsList = customerDao
				.select(query);

		return requestsList;
	}

	@Override
	public Partner selectById(Integer id) {
		Partner customer = null;
		try {
			Partner query = new Partner();
			query.createCriterion("id_", Operator.EQUALS, id);
			List<Partner> result = customerDao.select(query);
			if (result.size() > 1) throw new ServiceException();
			if (result.size() == 0) throw new InvalidAttributeValueException();
			customer = result.get(0);
		} catch (ServiceException ex) {
			logger.error("Id is duplicated");
		} catch (InvalidAttributeValueException ex) {
			logger.error("Id is not valid");
		}
		return customer;
	}

	@Override
	public void update(Partner customer) throws MandatoryFieldException {
		try {
			if (customer == null)
				throw new NullPointerException();
			if (!customer.validateNotNullAttrs())
				throw new MandatoryFieldException();
			customerDao.update(customer);
		} catch (NullPointerException ex) {
			logger.error("Customer is null");
		}
	}

	@Override
	public List<Partner> opponent() {
		
		Partner query = new Partner();
		query.createCriterion("category_", Operator.EQUALS, "opponent");
		List<Partner> requestsList = customerDao
				.select(query);

		return requestsList;
	}

	@Override
	public List<Partner> other() {
		
		Partner query = new Partner();
		query.createCriterion("category_", Operator.EQUALS, "other");
		List<Partner> requestsList = customerDao
				.select(query);

		return requestsList;
	}
}
