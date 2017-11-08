package fr.obeo.smartea.archimate.occi.connector.ui.popup.actions;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.emf.ecore.resource.Resource;

import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.archimate.occi.reconciler.ArchiReconciler;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Folder;

public class ExportToSmartEAAction extends AbstractSmartEAAction {

	public ExportToSmartEAAction() {
		super(false);
	}

	@Override
	protected void work(Configuration configuration, Resource semanticResource, MappingConfig mapping) {
		Folder targetTechFolder = ModelUtils.getSubFolder(semanticResource, ModelUtils.TECHNOLOGY_FOLDER_NAME);
		Folder converted = null;
		if (mapping != null) {
			converted = new OCCI2Archi().convert(configuration, mapping);
		} else {
			converted = new OCCI2Archi().convert(configuration);
		}
		new ArchiReconciler().reconcile(converted, targetTechFolder, configuration.getDescription());
	}

}
