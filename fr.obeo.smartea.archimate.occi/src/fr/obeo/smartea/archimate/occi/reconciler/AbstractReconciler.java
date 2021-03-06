package fr.obeo.smartea.archimate.occi.reconciler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;

public abstract class AbstractReconciler {

	public void reconcile(EObject source, EObject target, String sourceId) {
		// delete managed elements no more in source
		List<EObject> toDelete = new ArrayList<EObject>();
		for (Iterator<EObject> iterator = target.eAllContents(); iterator.hasNext();) {
			EObject targetElement = (EObject) iterator.next();
			if (isManagedElement(targetElement, sourceId)) {
				EObject sourceElement = ModelUtils.findExisting(source, targetElement);
				if (sourceElement == null) {
					toDelete.add(targetElement);
				}
			}
		}
		for (EObject eObject : toDelete) {
			delete(eObject);
		}

		// add managed elements not yet in target, updates if existing
		List<EObject> toAdd = new ArrayList<EObject>();
		for (Iterator<EObject> iterator = source.eAllContents(); iterator.hasNext();) {
			EObject sourceElement = (EObject) iterator.next();
			if (isManagedElement(sourceElement, sourceId)) {
				EObject targetElement = ModelUtils.findExisting(target, sourceElement);
				if (targetElement == null) {
					toAdd.add(sourceElement);
				} else {
					updateElement(sourceElement, targetElement);
				}
			}
		}
		for (EObject sourceElement : toAdd) {
			add(sourceElement, target);
		}

		// resolve links
		for (Iterator<EObject> iterator = target.eAllContents(); iterator.hasNext();) {
			EObject targetElement = (EObject) iterator.next();
			if (isManagedElement(targetElement, sourceId)) {
				EObject sourceElement = ModelUtils.findExisting(source, targetElement);
				if (isManagedRelationship(sourceElement, sourceId)) {
					updateRelationship(sourceElement, targetElement);
				}
			}
		}
	}

	protected void add(EObject sourceElement, EObject target) {
		StringBuffer log = new StringBuffer();
		log.append("Addition");
		EObject container = sourceElement.eContainer();
		EStructuralFeature feature = sourceElement.eContainingFeature();
		EObject copy = EcoreUtil.copy(sourceElement);
		if (copy instanceof ArchimateElement) {
			ArchimateElement ac = (ArchimateElement) copy;
			log.append(" ");
			log.append(ac.getName());
			ac.getOwnedBidirectionalRelationships().clear();
			ac.getOwnedUnidirectionalRelationships().clear();
		}
		EObject findExisting = ModelUtils.findExisting(target, container);
		if (findExisting == null) {
			findExisting = target;
		}
		List list = (List) findExisting.eGet(feature);
		list.add(copy);
		System.err.println(log);
	}

	protected abstract boolean isManagedRelationship(EObject element, String sourceId);

	protected abstract void delete(EObject eObject);

	protected abstract boolean isManagedElement(EObject targetElement, String sourceId);

	protected abstract void updateElement(EObject sourceElement, EObject targetElement);

	protected abstract void updateRelationship(EObject sourceRelationship, EObject targetRelationship);
}
