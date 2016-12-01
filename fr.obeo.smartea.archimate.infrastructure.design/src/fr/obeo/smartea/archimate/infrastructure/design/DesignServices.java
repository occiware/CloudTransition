package fr.obeo.smartea.archimate.infrastructure.design;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.AssignmentRelationship;
import fr.obeo.smartea.archimate.BidirectionalRelationship;
import fr.obeo.smartea.archimate.CompositionRelationship;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.UnidirectionalRelationship;
import fr.obeo.smartea.core.basemm.Folder;

public class DesignServices extends AbstractUIPlugin {

	public Collection<EObject> getSemanticCandidates(EObject context) {
		Set<EObject> res = new HashSet<EObject>();
		if (context instanceof Folder) {

			// folder context
			res.addAll(getAllElements((Folder) context));

		} else if (context instanceof ArchimateElement) {

			for (Relationship relationship : ((ArchimateElement) context).getOwnedUnidirectionalRelationships()) {
				if (isContainment(relationship)) {
					res.add(((UnidirectionalRelationship) relationship).getTarget());
				}
			}
			for (Relationship relationship : ((ArchimateElement) context).getOwnedBidirectionalRelationships()) {
				if (isContainment(relationship)) {
					res.add(((BidirectionalRelationship) relationship).getEnd2());
				}
			}

		}
		return res;
	}

	private Collection<EObject> getAllElements(Folder folder) {
		Set<EObject> res = new HashSet<EObject>();
		for (EObject eObject : folder.getElements()) {
			if (eObject instanceof ArchimateElement && !isPartOfComposition((ArchimateElement) eObject)) {
				res.add((ArchimateElement) eObject);
			}
		}
		for (Folder subFolder : folder.getFolders()) {
			res.addAll(getAllElements(subFolder));
		}
		return res;
	}

	private boolean isPartOfComposition(ArchimateElement eObject) {
		for (Relationship relationship : eObject.getIncomingRelationships()) {
			if (isContainment(relationship)) {
				return true;
			}
		}
		return false;
	}

	private boolean isContainment(Relationship relationship) {
		if (relationship instanceof CompositionRelationship) {
			return true;
		}
		return relationship instanceof CompositionRelationship || relationship instanceof AssignmentRelationship;
	}
}
