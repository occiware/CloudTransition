package fr.obeo.smartea.archimate.occi.connector.ui.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.cmf.occi.core.Configuration;

import fr.obeo.smartea.archimate.occi.connector.ui.wizard.ConnectionWizard;
import fr.obeo.smartea.archimate.occi.connector.ui.wizard.ConnectionWizardDialog;

public abstract class AbstractSmartEAAction implements IObjectActionDelegate {

	private ISelection selection;

	private boolean readonly;

	/**
	 * Constructor.
	 */
	public AbstractSmartEAAction(boolean readonly) {
		super();
		this.readonly = readonly;
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
		IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
		ConnectionWizardDialog.launch(new ConnectionWizard(readonly, file) {
			@Override
			protected void connectAndWork(Configuration configuration, Resource semanticResource) {
				work(configuration, semanticResource);
			}
		});
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	protected abstract void work(Configuration configuration, Resource semanticResource);
}
