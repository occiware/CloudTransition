package fr.obeo.smartea.archimate.occi.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.smartea.archimate.occi.Archi2OCCI;
import fr.obeo.smartea.archimate.occi.ui.Activator;
import fr.obeo.smartea.core.basemm.Folder;

public class Archi2OCCIAction implements IObjectActionDelegate {

	private ISelection selection;

	/**
	 * Constructor for Action1.
	 */
	public Archi2OCCIAction() {
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
		IFile archiFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
		try {
			convertToOCCI(archiFile);
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

	private void convertToOCCI(IFile archiFile) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(archiFile.getLocation().toString()), true);

		Folder folder = getFolder(resource);
		if (folder != null) {
			Configuration configuration = new Archi2OCCI().convert(folder);
			Resource output = resourceSet.createResource(URI
					.createFileURI(archiFile.getLocation().removeFileExtension().addFileExtension("occic").toString()));
			output.getContents().add(configuration);
			output.save(Collections.EMPTY_MAP);
		}
	}

	private Folder getFolder(Resource resource) {
		for (EObject content : resource.getContents()) {
			if (content instanceof Folder) {
				return (Folder) content;
			}
		}
		return null;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
