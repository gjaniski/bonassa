package com.esense.bonassa.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas Cardoso
 *
 */
public abstract class AbstractCondition {

	private boolean distinct;
	private List<Criterion> criterions = new ArrayList<Criterion>();

	public AbstractCondition() {
	}

	public AbstractCondition(boolean distinct) {
		this.distinct = distinct;
	}

	public AbstractCondition(List<Criterion> criterions) {
		this.criterions = criterions;
	}

	public AbstractCondition(boolean distinct, List<Criterion> criterions) {
		this.distinct = distinct;
		this.criterions = criterions;
	}

	public Criterion createCriterion(String condition, Object value) {
		Criterion criterion = new Criterion(condition, value);
		this.addCriterion(criterion);
		return criterion;
	}

	public Criterion createCriterion(String condition, String operator,
			Object value) {
		if (value instanceof String) {
			if (value.toString().indexOf("'") < 0)
				value = "'" + value.toString() + "'";
		}
		condition = condition + " " + operator + " ";
		Criterion criterion = new Criterion(condition, value);
		this.addCriterion(criterion);
		return criterion;
	}

	private void addCriterion(Criterion criterion) {
		criterions.add(criterion);
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public List<Criterion> getCriterions() {
		return criterions;
	}

	public void setCriterions(List<Criterion> criterions) {
		this.criterions = criterions;
	}

	public static class Criterion {

		private String condition;
		private Object value;

		public Criterion() {

		}

		public Criterion(String condition, Object value) {
			this.condition = condition;
			this.value = value;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

	}
}
