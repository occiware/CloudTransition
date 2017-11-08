package fr.obeo.smartea.archimate.occi.ui.popup.actions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.archimate.occi.ui.Activator;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Folder;

public class OCCI2ArchiAction implements IObjectActionDelegate {

	private ISelection selection;

	/**
	 * Constructor for Action1.
	 */
	public OCCI2ArchiAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IFile occicFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
		try {
			convertToArchi(occicFile);
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

	private void convertToArchi(IFile configFile) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Configuration configuration = ModelUtils.getOCCIConfiguration(configFile.getLocation().toString(), resourceSet);
		Folder folder = null;
		IFile mappingFile = configFile.getProject().getWorkspace().getRoot().getFile(configFile.getFullPath().removeFileExtension().addFileExtension("mapping"));
		if (mappingFile.exists()) {
			Properties properties = new Properties();
			try {
				InputStream contents = mappingFile.getContents();
				properties.load(contents);
				folder = new OCCI2Archi().convert(configuration, new MappingConfig(properties));
				contents.close();
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
			}
		} else {
			folder = new OCCI2Archi().convert(configuration);
		}

		Resource output = resourceSet.createResource(
				URI.createFileURI(configFile.getLocation().removeFileExtension().addFileExtension("archi").toString()));
		output.getContents().add(folder);

		output.save(Collections.EMPTY_MAP);
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
