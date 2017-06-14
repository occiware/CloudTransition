package fr.obeo.smartea.archimate.infrastructure.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import fr.obeo.smartea.core.costs.Cost;
import fr.obeo.smartea.core.costs.CostsContainer;
import fr.obeo.smartea.core.costs.CostsFactory;
import fr.obeo.smartea.core.costs.CostsPackage;

public class CostsServices extends AbstractUIPlugin {

	public Collection<Cost> getCosts(EObject context) {
		List<Cost> res = new ArrayList<Cost>();
		for (Setting setting : EcoreUtil.UsageCrossReferencer.find(context, context.eResource())) {
			if (setting.getEStructuralFeature().equals(CostsPackage.eINSTANCE.getCost_Ref())) {
				res.add((Cost) setting.getEObject());
			}
		}
		return res;
	}

	public void createCost(EObject context) {
		Cost cost = CostsFactory.eINSTANCE.createCost();
		cost.setRef(context);
		getCostsContainer(context).getCosts().add(cost);
	}

	private CostsContainer getCostsContainer(EObject context) {
		Resource resource = context.eResource();
		for (EObject content : resource.getContents()) {
			if (content instanceof CostsContainer) {
				return (CostsContainer) content;
			}
		}
		CostsContainer res = CostsFactory.eINSTANCE.createCostsContainer();
		resource.getContents().add(res);
		return res;
	}
}