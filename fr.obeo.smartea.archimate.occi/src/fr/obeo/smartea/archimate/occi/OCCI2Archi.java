package fr.obeo.smartea.archimate.occi;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.cmf.occi.core.AttributeState;
import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.cmf.occi.core.Entity;
import org.eclipse.cmf.occi.core.Link;
import org.eclipse.cmf.occi.core.Resource;
import org.eclipse.emf.ecore.EClass;

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

	private static final String[] IGNORED_PROPERTY_KEYS = new String[] { "occi.core.id", "occi.core.title", };

	public Folder convert(Configuration configuration) {
		return convert(configuration, new MappingConfig());
	}

	public Folder convert(Configuration configuration, MappingConfig mappingConfig) {
		String sourceId = configuration.getDescription();
		Map<Resource, ArchimateElement> resourcesTraces = new HashMap<>();
		Map<Link, Relationship> linksTraces = new HashMap<>();

		Folder techFolder = BaseFactory.eINSTANCE.createFolder();
		techFolder.setName(ModelUtils.TECHNOLOGY_FOLDER_NAME);

		// NOTE unused: configuration.use
		for (Resource resource : configuration.getResources()) {
			EClass elementType = mappingConfig.getArchiType(resource.getKind());
			ArchimateElement element = (ArchimateElement) createArchimateComponentFrom(resource, elementType, sourceId);
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
				Relationship relationship = (Relationship) createArchimateComponentFrom(link, relationshipType,
						sourceId);
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

	private ArchimateComponent createArchimateComponentFrom(Entity entity, EClass elementType, String sourceId) {
		ArchimateComponent element = (ArchimateComponent) ArchimateFactory.eINSTANCE.create(elementType);
		element.setName(entity.getTitle());
		element.setId(entity.getId());

		Property kindProperty = BaseFactory.eINSTANCE.createProperty();
		element.getProperties().add(kindProperty);
		kindProperty.setName(MappingConfig.OCCI_KIND_SCHEME_KEY);
		kindProperty.setValue(entity.getKind().getScheme() + entity.getKind().getTerm());
		element.getProperties().add(kindProperty);

		Property sourceProperty = BaseFactory.eINSTANCE.createProperty();
		element.getProperties().add(sourceProperty);
		sourceProperty.setName(MappingConfig.OCCI_SOURCE_ID_KEY);
		sourceProperty.setValue(sourceId);
		element.getProperties().add(sourceProperty);
		
		return element;
	}

	private void convertAttributeState(ArchimateComponent component, AttributeState attributeState) {
		for (String ignoredProperty : IGNORED_PROPERTY_KEYS) {
			if (attributeState.getName().equals(ignoredProperty)) {
				return;
			}
		}
		Property property = BaseFactory.eINSTANCE.createProperty();
		String key = attributeState.getName();
		component.getProperties().add(property);
		property.setName(key);
		property.setValue(attributeState.getValue());
		component.getProperties().add(property);
	}

}
