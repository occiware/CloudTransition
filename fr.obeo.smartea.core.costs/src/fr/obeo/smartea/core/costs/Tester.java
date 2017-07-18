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

	private static final String CATEGORY_1 = "First year";

	private static Category cat;
	static {
		cat = CostsFactory.eINSTANCE.createCategory();
		cat.setName(CATEGORY_1);
	}

	private static CostsContainer createModel() {
		CostsContainer res = CostsFactory.eINSTANCE.createCostsContainer();
		Cost cost1 = CostsFactory.eINSTANCE.createCost();
		cost1.setValue(10000);
		cost1.setTimeUnit(TimeUnit.MONTH);
		Cost cost2 = CostsFactory.eINSTANCE.createCost();
		cost2.setValue(100);
		cost1.setTimeUnit(TimeUnit.YEAR);
		Cost cost3 = CostsFactory.eINSTANCE.createCost();
		cost3.setValue(111);
		cost3.setCurrency(CostUtils.EURO);

		cost3.setCategory(cat);
		res.getCosts().add(cost1);
		res.getCosts().add(cost2);
		res.getCosts().add(cost3);
		return res;
	}

	public static void main(String[] args) {
		CostsContainer model = createModel();
		System.err.println(CostUtils.computeCosts(model));
		System.err.println(CostUtils.computeCosts(model, cat));
	}

}
