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

public class Tester {

	private static CostsContainer createModel() {
		CostsContainer res = CostsFactory.eINSTANCE.createCostsContainer();
		Cost cost1 = CostsFactory.eINSTANCE.createCost();
		cost1.setValue(10);
		cost1.setTimeUnit(TimeUnit.MONTH);
		Cost cost2 = CostsFactory.eINSTANCE.createCost();
		cost2.setValue(100);
		cost1.setTimeUnit(TimeUnit.YEAR);
		InitialCost cost3 = CostsFactory.eINSTANCE.createInitialCost();
		cost3.setValue(50);
		cost3.setCurrency(CostUtils.EURO);
		Issue cost4 = CostsFactory.eINSTANCE.createIssue();
		cost4.setValue(5);
		cost4.setTimeUnit(TimeUnit.MONTH);
		cost4.setCount(6);

		res.getCosts().add(cost1);
		res.getCosts().add(cost2);
		res.getCosts().add(cost3);
		res.getCosts().add(cost4);
		return res;
	}

	public static void main(String[] args) {
		CostsContainer model = createModel();
		System.err.println(CostUtils.computeRegularCosts(model));
	}

}
