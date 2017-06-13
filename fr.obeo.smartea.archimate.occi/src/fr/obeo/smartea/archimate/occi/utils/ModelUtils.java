package fr.obeo.smartea.archimate.occi.utils;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.emfgen.Ecore2OCCI;

import fr.obeo.smartea.archimate.Node;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.Identified;

public class ModelUtils {
	public static final String TECHNOLOGY_FOLDER_NAME = "Technology";
	public static final String OCCI_TITLE_ATTR_NAME = "occi.core.title";
	public static final String OCCI_ID_ATTR_NAME = "occi.core.id";
	public static final String NODES_FOLDER_NAME = "Logical Technology Components";

	public static Folder getFolderFor(Folder targetTechFolder, EObject element) {
		if (element instanceof Node) {
			return getSubFolder(targetTechFolder, NODES_FOLDER_NAME);
		}
		return targetTechFolder;
	}

	public static String getId(EObject element) {
		if (element instanceof Entity) {
			return ((Entity) element).getId();
		}
		if (element instanceof Identified) {
			return ((Identified) element).getId();
		}
		return EcoreUtil.getID(element);
	}

	public static Folder getSubFolder(Notifier object, String name) {
		if (object instanceof Resource) {
			for (EObject content : ((Resource) object).getContents()) {
				if (content instanceof Folder) {
					Folder folder = (Folder) content;
					if (name.equals(folder.getName())) {
						return folder;
					}
				}
			}
		} else {
			for (EObject content : ((EObject) object).eContents()) {
				if (content instanceof Folder) {
					Folder folder = (Folder) content;
					if (name.equals(folder.getName())) {
						return folder;
					}
				}
			}
		}
		return null;
	}

	public static EObject findExisting(Notifier container, EObject referenceElement) {
		Iterator<EObject> iterator = null;
		if (container instanceof Resource) {
			iterator = ((Resource) container).getAllContents();
		} else {
			iterator = ((EObject) container).eAllContents();
		}
		if (container instanceof Configuration && referenceElement instanceof Configuration) {
			return (EObject) container;
		}
		while (iterator.hasNext()) {
			EObject eo = (EObject) iterator.next();
			if (eo.eClass().equals(referenceElement.eClass())) {
				if (getId(referenceElement).equals(getId(eo))) {
					return eo;
				}
			}
		}
		return null;
	}

	public static Configuration getOCCIConfiguration(String configFile, ResourceSet resourceSet) {
		Configuration configuration = null;
		if (configFile.endsWith(".docker")) {
			EObject root = resourceSet.getResource(URI.createFileURI(configFile), true).getContents().get(0);
			configuration = new Ecore2OCCI().convertConfig((Configuration) root);
			Resource resource = resourceSet.createResource(URI.createURI("tmp-occic"));
			resource.getContents().add(configuration);
		} else {
			Resource resource = resourceSet.getResource(URI.createFileURI(configFile), true);
			configuration = (Configuration) resource.getContents().get(0);
		}
		return configuration;
	}
}
