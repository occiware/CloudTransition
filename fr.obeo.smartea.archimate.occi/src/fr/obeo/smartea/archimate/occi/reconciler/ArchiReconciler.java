package fr.obeo.smartea.archimate.occi.reconciler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Nameable;
import fr.obeo.smartea.core.basemm.PropertiesContainer;
import fr.obeo.smartea.core.basemm.Property;
import fr.obeo.smartea.core.basemm.util.PropertiesUtil;

public class ArchiReconciler extends AbstractReconciler {

	@Override
	protected boolean isManagedElement(EObject element, String sourceId) {
		if (element instanceof PropertiesContainer) {
			if (PropertiesUtil.getProperty((PropertiesContainer) element, MappingConfig.OCCI_KIND_SCHEME_KEY) != null) {
				Property sourceProperty = PropertiesUtil.getProperty((PropertiesContainer) element,
						MappingConfig.OCCI_SOURCE_ID_KEY);
				if (sourceProperty != null && sourceProperty.getValue().equals(sourceId)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected boolean isManagedRelationship(EObject element, String sourceId) {
		return isManagedElement(element, sourceId) && element instanceof Relationship
				&& ((Relationship) element).getSourceElement() != null
				&& ((Relationship) element).getTargetElement() != null;
	}

	@Override
	protected void delete(EObject eObject) {
		StringBuffer log = new StringBuffer();
		log.append("Deletion");
		List<EObject> toDelete = new ArrayList<EObject>();
		toDelete.add(eObject);
		if (eObject instanceof ArchimateComponent) {
			ArchimateComponent component = (ArchimateComponent) eObject;
			log.append(" ");
			log.append(component.getName());
			toDelete.addAll(component.getIncomingRelationships());
			toDelete.addAll(component.getOutgoingRelationships());
		}
		System.err.println(log);
		for (EObject eo : toDelete) {
			EcoreUtil.delete(eo);
		}
	}

	@Override
	protected void updateElement(EObject sourceElement, EObject targetElement) {
		if (sourceElement instanceof Nameable && ((Nameable) sourceElement).getName() != null
				&& !((Nameable) sourceElement).getName().equals(((Nameable) targetElement).getName())) {
			((Nameable) targetElement).setName(((Nameable) sourceElement).getName());
		}
		if (sourceElement instanceof PropertiesContainer) {
			List<Property> toAdd = new ArrayList<Property>();
			for (Property sourceProperty : ((PropertiesContainer) sourceElement).getProperties()) {
				boolean found = false;
				for (Property targetProperty : ((PropertiesContainer) targetElement).getProperties()) {
					if (sourceProperty.getName().equals(targetProperty.getName())) {
						found = true;
						if (!targetProperty.getValue().equals(sourceProperty.getValue())) {
							System.err.println("Update " + ((Nameable) targetElement).getName() + " : "
									+ targetProperty.getName() + " was " + targetProperty.getValue() + " and is now "
									+ sourceProperty.getValue());
							targetProperty.setValue(sourceProperty.getValue());
						}
					}
				}
				if (!found) {
					toAdd.add(EcoreUtil.copy(sourceProperty));
				}
			}
			for (Property property : toAdd) {
				((PropertiesContainer) targetElement).getProperties().add(property);
			}
		}
	}

	@Override
	protected void updateRelationship(EObject sourceRelationship, EObject targetRelationship) {
		Resource lookupRoot = targetRelationship.eResource();
		ArchimateComponent actualSourceElement = (ArchimateComponent) ModelUtils.findExisting(lookupRoot,
				((Relationship) sourceRelationship).getSourceElement());
		if (!actualSourceElement.equals(((Relationship) targetRelationship).getSourceElement())) {
			((Relationship) targetRelationship).setSourceElement(actualSourceElement);
		}
		ArchimateComponent actualTargetElement = (ArchimateComponent) ModelUtils.findExisting(lookupRoot,
				((Relationship) sourceRelationship).getTargetElement());
		if (!actualTargetElement.equals(((Relationship) targetRelationship).getTargetElement())) {
			((Relationship) targetRelationship).setTargetElement(actualTargetElement);
		}
	}

}
