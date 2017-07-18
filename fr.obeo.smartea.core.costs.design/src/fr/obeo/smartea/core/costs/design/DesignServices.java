package fr.obeo.smartea.core.costs.design;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.smartea.core.costs.Category;
import fr.obeo.smartea.core.costs.Cost;
import fr.obeo.smartea.core.costs.CostUtils;
import fr.obeo.smartea.core.costs.CostsContainer;

public class DesignServices {

	public Double computeCost(EObject element) {
		if (element instanceof Cost) {
			return CostUtils.computeCost((Cost) element);
		} else if (element instanceof CostsContainer) {
			return CostUtils.computeCosts((CostsContainer) element);
		} else if (element instanceof Category) {
			return CostUtils.computeCosts((CostsContainer) ((Category) element).eContainer(), (Category) element);
		}
		return 0.;
	}

}
