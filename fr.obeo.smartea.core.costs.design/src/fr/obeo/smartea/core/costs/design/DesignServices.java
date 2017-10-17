package fr.obeo.smartea.core.costs.design;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.smartea.core.costs.AbstractCost;
import fr.obeo.smartea.core.costs.CostUtils;
import fr.obeo.smartea.core.costs.CostsContainer;

public class DesignServices {

	public String computeCost(EObject element) {
		String res = null;
		if (element instanceof AbstractCost) {
			res = String.valueOf(CostUtils.computeCost((AbstractCost) element));
		} else if (element instanceof CostsContainer) {
			double initial = CostUtils.computeInitialCosts((CostsContainer) element);
			double regular = CostUtils.computeRegularCosts((CostsContainer) element);
			if (initial != 0 && regular != 0) {
				res = String.valueOf("Initial: " + initial + " + Regular: " + regular + " = " + (initial + regular));
			} else if (initial != 0 && regular == 0) {
				res = String.valueOf("Initial: " + initial);
			} else if (initial == 0 && regular != 0) {
				res = String.valueOf(regular);
			}
		}
		return res;
	}

}
