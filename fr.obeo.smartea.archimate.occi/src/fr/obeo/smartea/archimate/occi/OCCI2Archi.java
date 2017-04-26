package fr.obeo.smartea.archimate.occi;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.ArchimateFactory;
import fr.obeo.smartea.archimate.BidirectionalRelationship;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.UnidirectionalRelationship;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.BaseFactory;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.Property;

public class OCCI2Archi {

	public Folder convert(Configuration configuration) {
		return convert(configuration, new MappingConfig());
	}

	public Folder convert(Configuration configuration, MappingConfig mappingConfig) {
		Map<Resource, ArchimateElement> resourcesTraces = new HashMap<>();
		Map<Link, Relationship> linksTraces = new HashMap<>();

		Folder techFolder = BaseFactory.eINSTANCE.createFolder();
		techFolder.setName(ModelUtils.TECHNOLOGY_FOLDER_NAME);

		Folder nodesFolder = BaseFactory.eINSTANCE.createFolder();
		nodesFolder.setName(ModelUtils.NODES_FOLDER_NAME);
		techFolder.getFolders().add(nodesFolder);

		// NOTE unused: configuration.use
		for (Resource resource : configuration.getResources()) {
			EClass elementType = mappingConfig.getArchiType(resource.getKind());
			ArchimateElement element = (ArchimateElement) createArchimateComponentFrom(resource, elementType);
			ModelUtils.getFolderFor(techFolder, element).getElements().add(element);
			resourcesTraces.put(resource, element);
			for (AttributeState attributeState : resource.getAttributes()) {
				convertAttributeState(element, attributeState);
			}
			for (Link link : resource.getLinks()) {
				EClass relationshipType = mappingConfig.getArchiType(link.getKind());
				if (relationshipType == null) {
					throw new UnsupportedOperationException(link.getKind().getTerm());
				}
				Relationship relationship = (Relationship) createArchimateComponentFrom(link, relationshipType);
				linksTraces.put(link, relationship);
				for (AttributeState attributeState : link.getAttributes()) {
					convertAttributeState(relationship, attributeState);
				}
			}
		}
		for (Link link : linksTraces.keySet()) {
			ArchimateElement source = resourcesTraces.get(link.getSource());
			ArchimateElement target = resourcesTraces.get(link.getTarget());
			Relationship relationship = linksTraces.get(link);
			if (relationship instanceof UnidirectionalRelationship) {
				UnidirectionalRelationship ur = (UnidirectionalRelationship) relationship;
				source.getOwnedUnidirectionalRelationships().add(ur);
				ur.setTarget(target);
			} else if (relationship instanceof BidirectionalRelationship) {
				BidirectionalRelationship br = (BidirectionalRelationship) relationship;
				source.getOwnedBidirectionalRelationships().add(br);
				br.setSourceElement(source);
				br.setTargetElement(target);
			}
		}
		return techFolder;
	}

	private ArchimateComponent createArchimateComponentFrom(Entity entity, EClass elementType) {
		ArchimateComponent element = (ArchimateComponent) ArchimateFactory.eINSTANCE.create(elementType);
		element.setDocumentation(entity.getKind().getScheme() + entity.getKind().getTerm());
		element.setName(entity.getTitle());
		element.setId(entity.getId());
		return element;
	}

	private void convertAttributeState(ArchimateComponent component, AttributeState attributeState) {
		Property property = BaseFactory.eINSTANCE.createProperty();
		String key = attributeState.getName();
		component.getProperties().add(property);
		property.setName(key);
		property.setValue(attributeState.getValue());
		component.getProperties().add(property);
	}

}
