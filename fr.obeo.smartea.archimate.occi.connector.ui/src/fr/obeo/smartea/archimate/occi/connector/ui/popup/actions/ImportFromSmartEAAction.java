package fr.obeo.smartea.archimate.occi.connector.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.cmf.occi.core.Configuration;

import fr.obeo.smartea.archimate.occi.Archi2OCCI;
import fr.obeo.smartea.archimate.occi.reconciler.OCCIReconciler;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Folder;

public class ImportFromSmartEAAction extends AbstractSmartEAAction {

	public ImportFromSmartEAAction() {
		super(true);
	}

	@Override
	protected void work(Configuration configuration, Resource semanticResource) {
		Folder targetTechFolder = ModelUtils.getSubFolder(semanticResource, ModelUtils.TECHNOLOGY_FOLDER_NAME);
		Configuration converted = new Archi2OCCI().convert(targetTechFolder);
		new OCCIReconciler().reconcile(converted, configuration, null);
		try {
			configuration.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			MessageDialog.openError(new Shell(Display.getCurrent()), "Error saving " + configuration.eResource(),
					e.getMessage());
		}
	}

}
