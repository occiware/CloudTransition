/*******************************************************************************
 * Copyright (c) 2017 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.smartea.core.costs;

public final class CostUtils {

	public static final String DOLLAR = "dollar";

	public static final String EURO = "euro";

	private static final double CONVERSION_RATE = 1.12;

	public static double computeCost(AbstractCost cost) {
		CostsContainer container = (CostsContainer)cost.eContainer();
		return CostUtils.computeCost(cost, container.getCurrency(), container.getTimeUnit());
	}

	public static double computeCost(AbstractCost cost, String currency, TimeUnit timeUnit) {
		double res = cost.getValue();
		if (!cost.getCurrency().equals(currency)) {
			res = convert(res, cost.getCurrency(), currency);
		}
		if (cost instanceof TimeElement) {
			TimeElement timeElement = (TimeElement)cost;
			if (!timeElement.getTimeUnit().equals(timeUnit)) {
				res = convert(res, timeElement.getTimeUnit(), timeUnit);
			}
			if (cost instanceof Issue) {
				Issue issue = (Issue)cost;
				res = res * issue.getCount();
			}
		}
		return res;
	}

	public static double computeInitialCosts(CostsContainer costContainer) {
		double res = 0;
		for (AbstractCost cost : costContainer.getCosts()) {
			if (cost instanceof InitialCost) {
				res += computeCost(cost, costContainer.getCurrency(), costContainer.getTimeUnit());
			}
		}
		return res;
	}

	public static double computeRegularCosts(CostsContainer costContainer) {
		double res = 0;
		for (AbstractCost cost : costContainer.getCosts()) {
			if (cost instanceof TimeElement) {
				res += computeCost(cost, costContainer.getCurrency(), costContainer.getTimeUnit());
			}
		}
		return res;
	}

	private static double convert(double value, String sourceCurrency, String targetCurrency) {
		double res = value;
		if (sourceCurrency.equals(EURO) && targetCurrency.equals(DOLLAR)) {
			res *= CONVERSION_RATE;
		} else if (sourceCurrency.equals(DOLLAR) && targetCurrency.equals(EURO)) {
			res /= CONVERSION_RATE;
		}
		return res;
	}

	private static double convert(double value, TimeUnit source, TimeUnit target) {
		double res = value;
		switch (source) {
			case MONTH:
				res /= 30;
				break;
			case YEAR:
				res /= 12;
				res /= 30;
				break;
			default:
				break;
		}
		switch (target) {
			case MONTH:
				res *= 30;
				break;
			case YEAR:
				res *= 12;
				res *= 30;
				break;
			default:
				break;
		}
		return res;
	}

}
