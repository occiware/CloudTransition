package fr.obeo.smartea.archimate.occi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.cmf.occi.core.AttributeState;
import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.cmf.occi.core.Entity;
import org.eclipse.cmf.occi.core.Kind;
import org.eclipse.cmf.occi.core.Link;
import org.eclipse.cmf.occi.core.OCCIFactory;
import org.eclipse.cmf.occi.core.Resource;

import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.BidirectionalRelationship;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.UnidirectionalRelationship;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.Property;

public class Archi2OCCI {

	public Configuration convert(Folder folder) {
		return convert(folder, new MappingConfig());
	}

	public Configuration convert(Folder folder, MappingConfig mappingConfig) {
		Configuration configuration = OCCIFactory.eINSTANCE.createConfiguration();

		Map<ArchimateElement, Resource> elementsTraces = new HashMap<>();
		Map<Relationship, Link> relationshipsTraces = new HashMap<>();

		for (Iterator<EObject> iterator = folder.eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof ArchimateElement) {
				ArchimateElement archimateElement = (ArchimateElement) element;
				Kind kind = mappingConfig.getOCCIKind(archimateElement);
				Resource resource = OCCIFactory.eINSTANCE.createResource();
				resource.setKind(kind);
				for (Property property : archimateElement.getProperties()) {
					convertProperty(resource, property);
				}
				resource.setId(archimateElement.getId());
				resource.setTitle(archimateElement.getName());
				configuration.getResources().add(resource);
				elementsTraces.put(archimateElement, resource);
				for (UnidirectionalRelationship relationship : archimateElement.getOwnedUnidirectionalRelationships()) {
					Kind linkKind = mappingConfig.getOCCIKind(relationship);
					Link link = (Link) OCCIFactory.eINSTANCE.createLink();
					link.setId(relationship.getId());
					link.setKind(linkKind);
					link.setTitle(relationship.getName());
					resource.getLinks().add(link);
					relationshipsTraces.put(relationship, link);
					for (Property property : relationship.getProperties()) {
						convertProperty(link, property);
					}
				}
				for (BidirectionalRelationship relationship : archimateElement.getOwnedBidirectionalRelationships()) {
					Kind linkKind = mappingConfig.getOCCIKind(relationship);
					Link link = (Link) OCCIFactory.eINSTANCE.createLink();
					link.setId(relationship.getId());
					link.setKind(linkKind);
					link.setTitle(relationship.getName());
					resource.getLinks().add(link);
					relationshipsTraces.put(relationship, link);
					for (Property property : relationship.getProperties()) {
						convertProperty(link, property);
					}
				}
			}
		}
		for (Relationship relationship : relationshipsTraces.keySet()) {
			Link link = relationshipsTraces.get(relationship);
			Resource target = elementsTraces.get(relationship.getTargetElement());
			if (target != null) {
				link.setTarget(target);	
			} else {
				EcoreUtil.delete(link);
			}
		}
		return configuration;
	}

	private void convertProperty(Entity entity, Property property) {
		AttributeState attributeState = OCCIFactory.eINSTANCE.createAttributeState();
		attributeState.setName(property.getName());
		attributeState.setValue(property.getValue());
		entity.getAttributes().add(attributeState);
	}

}
