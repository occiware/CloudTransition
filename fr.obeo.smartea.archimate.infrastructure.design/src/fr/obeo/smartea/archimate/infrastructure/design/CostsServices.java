package fr.obeo.smartea.archimate.infrastructure.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import fr.obeo.smartea.core.basemm.BaseFactory;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.costs.AbstractCost;
import fr.obeo.smartea.core.costs.Cost;
import fr.obeo.smartea.core.costs.CostsContainer;
import fr.obeo.smartea.core.costs.CostsFactory;
import fr.obeo.smartea.core.costs.CostsPackage;
import fr.obeo.smartea.core.costs.InitialCost;
import fr.obeo.smartea.core.costs.Issue;

public class CostsServices extends AbstractUIPlugin {

	private static final String COSTS_FOLDER_NAME = "Costs";

	public Collection<AbstractCost> getCosts(EObject context) {
		List<AbstractCost> res = new ArrayList<AbstractCost>();
		for (Setting setting : EcoreUtil.UsageCrossReferencer.find(context, context.eResource())) {
			if (setting.getEStructuralFeature().equals(CostsPackage.eINSTANCE.getAbstractCost_Ref())) {
				res.add((AbstractCost) setting.getEObject());
			}
		}
		return res;
	}

	public void createInitialCost(EObject context) {
		InitialCost cost = CostsFactory.eINSTANCE.createInitialCost();
		cost.setRef(context);
		getCostsContainer(context).getCosts().add(cost);
	}

	public void createRegularCost(EObject context) {
		Cost cost = CostsFactory.eINSTANCE.createCost();
		cost.setRef(context);
		getCostsContainer(context).getCosts().add(cost);
	}

	public void createIssue(EObject context) {
		Issue cost = CostsFactory.eINSTANCE.createIssue();
		cost.setRef(context);
		getCostsContainer(context).getCosts().add(cost);
	}

	private CostsContainer getCostsContainer(EObject context) {
		Resource resource = context.eResource();
		for (EObject content : resource.getContents()) {
			if (content instanceof Folder && ((Folder) content).getName().equals(COSTS_FOLDER_NAME)) {
				for (EObject sub : ((Folder) content).getElements()) {
					if (sub instanceof CostsContainer) {
						return (CostsContainer) sub;
					}
				}
			}
		}
		CostsContainer res = CostsFactory.eINSTANCE.createCostsContainer();
		Folder costsFolder = BaseFactory.eINSTANCE.createFolder();
		costsFolder.setName(COSTS_FOLDER_NAME);
		costsFolder.getElements().add(res);
		resource.getContents().add(costsFolder);
		return res;
	}
}
