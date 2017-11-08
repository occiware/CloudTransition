package fr.obeo.smartea.archimate.occi.connector.ui.popup.actions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.smartea.archimate.occi.conf.MappingConfig;
import fr.obeo.smartea.archimate.occi.connector.ui.Activator;
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
		final IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
		ConnectionWizardDialog.launch(new ConnectionWizard(readonly, file) {
			@Override
			protected void connectAndWork(Configuration configuration, Resource semanticResource) {
				MappingConfig mapping = null;
				IFile mappingFile = file.getProject().getWorkspace().getRoot()
						.getFile(file.getFullPath().removeFileExtension().addFileExtension("mapping"));
				if (mappingFile.exists()) {
					Properties properties = new Properties();
					try {
						InputStream contents = mappingFile.getContents();
						properties.load(contents);
						mapping = new MappingConfig(properties);
						contents.close();
					} catch (CoreException e) {
						Activator.getDefault().getLog()
								.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
					} catch (IOException e) {
						Activator.getDefault().getLog()
								.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
					}
				}
				work(configuration, semanticResource, mapping);
			}
		});
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	protected abstract void work(Configuration configuration, Resource semanticResource, MappingConfig mapping);
}
