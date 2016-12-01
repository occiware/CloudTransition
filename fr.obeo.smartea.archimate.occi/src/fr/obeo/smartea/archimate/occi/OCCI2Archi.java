package fr.obeo.smartea.archimate.occi;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.ArchimateFactory;
import fr.obeo.smartea.archimate.BidirectionalRelationship;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.UnidirectionalRelationship;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.core.basemm.BaseFactory;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.PropertiesContainer;
import fr.obeo.smartea.core.basemm.Property;

public class OCCI2Archi {

	private PropertiesContainer container;

	public Folder convert(Configuration configuration) {
		return convert(configuration, new MappingConfig());
	}

	public Folder convert(Configuration configuration, MappingConfig mappingConfig) {
		container = BaseFactory.eINSTANCE.createFolder();

		Map<Resource, ArchimateElement> resourcesTraces = new HashMap<>();
		Map<Link, Relationship> linksTraces = new HashMap<>();

		Folder rootFolder = BaseFactory.eINSTANCE.createFolder();
		rootFolder.setName("RootFolder");
		rootFolder.getElements().add(container);

		Folder techFolder = BaseFactory.eINSTANCE.createFolder();
		techFolder.setName("Technical Layer");
		rootFolder.getFolders().add(techFolder);

		// NOTE unused: configuration.use
		for (Resource resource : configuration.getResources()) {
			EClass elementType = mappingConfig.getArchiType(resource.getKind());
			ArchimateElement element = (ArchimateElement) ArchimateFactory.eINSTANCE.create(elementType);
			element.setDocumentation(resource.getKind().getScheme() + resource.getKind().getTerm());
			for (AttributeState as : resource.getAttributes()) {
				if (as.getName().equals("name")) {
					element.setName(as.getValue());
				}
				element.setId(resource.getId());
			}

			techFolder.getElements().add(element);
			resourcesTraces.put(resource, element);
			for (AttributeState attributeState : resource.getAttributes()) {
				convertAttributeState(element, attributeState);
			}
			for (Link link : resource.getLinks()) {
				EClass relationshipType = mappingConfig.getArchiType(link.getKind());
				if (relationshipType == null) {
					throw new UnsupportedOperationException(link.getKind().getTerm());
				}
				Relationship relationship = (Relationship) ArchimateFactory.eINSTANCE.create(relationshipType);
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
				br.setEnd1(source);
				br.setEnd2(target);
			}
		}
		return rootFolder;
	}

	private void convertAttributeState(ArchimateComponent component, AttributeState attributeState) {
		Property property = BaseFactory.eINSTANCE.createProperty();
		String key = attributeState.getName();
		container.getProperties().add(property);
		property.setName(key);
		property.setValue(attributeState.getValue());
		component.getProperties().add(property);
	}

}
