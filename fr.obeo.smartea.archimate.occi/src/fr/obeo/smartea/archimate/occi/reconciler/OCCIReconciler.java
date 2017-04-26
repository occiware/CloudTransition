package fr.obeo.smartea.archimate.occi.reconciler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

import fr.obeo.smartea.archimate.occi.utils.ModelUtils;

public class OCCIReconciler extends AbstractReconciler {

	@Override
	protected boolean isManagedElement(EObject element) {
		return element instanceof Entity;
	}

	@Override
	protected boolean isManagedRelationship(EObject element) {
		return element instanceof Link && ((Link) element).getSource() != null && ((Link) element).getTarget() != null;
	}

	@Override
	protected void delete(EObject eObject) {
		EcoreUtil.remove(eObject);
	}

	@Override
	protected void updateElement(EObject sourceElement, EObject targetElement) {
		if (!((Entity) sourceElement).getTitle().equals(((Entity) targetElement).getTitle())) {
			((Entity) targetElement).setTitle(((Entity) sourceElement).getTitle());
		}
		List<AttributeState> toAdd = new ArrayList<AttributeState>();
		for (AttributeState sourceProperty : ((Entity) sourceElement).getAttributes()) {
			boolean found = false;
			for (AttributeState targetProperty : ((Entity) targetElement).getAttributes()) {
				if (sourceProperty.getName().equals(targetProperty.getName())) {
					found = true;
					if (!targetProperty.getValue().equals(sourceProperty.getValue())) {
						targetProperty.setValue(sourceProperty.getValue());
					}
				}
			}
			if (!found) {
				toAdd.add(sourceProperty);
			}
		}
		((Entity) targetElement).getAttributes().addAll(toAdd);
	}

	@Override
	protected void updateRelationship(EObject sourceRelationship, EObject targetRelationship) {
		org.eclipse.emf.ecore.resource.Resource lookupRoot = targetRelationship.eResource();
		Resource actualSourceElement = (Resource) ModelUtils.findExisting(lookupRoot,
				((Link) sourceRelationship).getSource());
		if (!actualSourceElement.equals(((Link) targetRelationship).getSource())) {
			((Link) targetRelationship).setSource((Resource) actualSourceElement);
		}
		Resource actualTargetElement = (Resource) ModelUtils.findExisting(lookupRoot,
				((Link) sourceRelationship).getTarget());
		if (!actualTargetElement.equals(((Link) targetRelationship).getTarget())) {
			((Link) targetRelationship).setTarget((Resource) actualTargetElement);
		}
	}

}
