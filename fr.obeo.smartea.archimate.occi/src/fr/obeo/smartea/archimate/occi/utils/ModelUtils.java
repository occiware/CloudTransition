package fr.obeo.smartea.archimate.occi.utils;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Entity;

import fr.obeo.smartea.archimate.Node;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.Identified;

public class ModelUtils {

	public static final String OCCI_TITLE_ATTR_NAME = "occi.core.title";
	public static final String OCCI_ID_ATTR_NAME = "occi.core.id";
	public static final String NODES_FOLDER_NAME = "Nodes";

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

	public static Folder getSubFolder(EObject object, String name) {
		for (EObject content : object.eContents()) {
			if (content instanceof Folder) {
				Folder folder = (Folder) content;
				if (name.equals(folder.getName())) {
					return folder;
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
}