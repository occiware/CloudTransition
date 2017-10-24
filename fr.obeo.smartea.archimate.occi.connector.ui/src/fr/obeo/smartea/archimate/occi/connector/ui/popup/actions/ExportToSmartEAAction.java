package fr.obeo.smartea.archimate.occi.connector.ui.popup.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.cmf.occi.core.Configuration;

import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.reconciler.ArchiReconciler;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Folder;

public class ExportToSmartEAAction extends AbstractSmartEAAction {

	public ExportToSmartEAAction() {
		super(false);
	}

	@Override
	protected void work(Configuration configuration, Resource semanticResource) {
		Folder targetTechFolder = ModelUtils.getSubFolder(semanticResource, ModelUtils.TECHNOLOGY_FOLDER_NAME);
		Folder converted = new OCCI2Archi().convert(configuration);
		
		Resource r = semanticResource.getResourceSet().createResource(URI.createURI("tmp"));
		r.getContents().add(converted);
		try {
			r.save(System.out, Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		new ArchiReconciler().reconcile(converted, targetTechFolder);
	}

}
