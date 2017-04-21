package fr.obeo.smartea.archimate.occi.tests.utils;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Link;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;

public class TestUtils {

	public static void changeAttribute(org.occiware.clouddesigner.occi.Resource occiResource, String name,
			String value) {
		for (AttributeState attributeState : occiResource.getAttributes()) {
			if (attributeState.getName().equals(name)) {
				System.err.println("[Test] changing from " + attributeState.getValue() + " to " + value);
				attributeState.setValue(value);
				return;
			}
		}
	}

	public static Link getOCCILink(Configuration configuration, String id) {
		for (Iterator<EObject> iterator = configuration.eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Link && id.equals(ModelUtils.getId(element))) {
				return (Link) element;
			}
		}
		return null;
	}

	public static org.occiware.clouddesigner.occi.Resource getOCCIResource(Configuration configuration, String id) {
		for (org.occiware.clouddesigner.occi.Resource resource : configuration.getResources()) {
			if (resource.getId().equals(id)) {
				return resource;
			}
		}
		return null;
	}

	public static ArchimateComponent getArchimateComponent(org.eclipse.emf.ecore.resource.Resource resource,
			String id) {
		for (Iterator<EObject> iterator = resource.getAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (ModelUtils.getId(element).equals(id)) {
				return (ArchimateComponent) element;
			}
		}
		return null;
	}

	public static void display(EObject object) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI("tmp"));
		resource.getContents().add(EcoreUtil.copy(object));
		try {
			resource.save(System.err, Collections.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
