package com.esense.bonassa.core.dao;

import java.util.List;

import com.esense.bonassa.core.entity.Partner;

/**
 * 
 * @author Douglas Cardoso
 * @author Gerson Janiski
 *
 */

public interface PartnerDao {

	public List<Partner> select(Partner customer);

	public int insert(Partner customer);

	public void update(Partner customer);

	public void delete(Partner customer);

}
