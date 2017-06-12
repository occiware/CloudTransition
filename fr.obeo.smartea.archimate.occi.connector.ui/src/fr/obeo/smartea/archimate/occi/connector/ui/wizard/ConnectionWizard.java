package fr.obeo.smartea.archimate.occi.connector.ui.wizard;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.occiware.clouddesigner.occi.Configuration;

import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.server.api.IUserProviderExtension;
import fr.obeo.smartea.core.server.api.db.DbProjectContentTx;
import fr.obeo.smartea.core.server.client.SmartEAClient;
import fr.obeo.smartea.core.server.client.SmartEAProjectClient;
import fr.obeo.smartea.core.server.inject.AbstractSmartEAModule;

public abstract class ConnectionWizard extends Wizard {
	private boolean readonly;

	private SmartEAProjectClient projectClient;

	private CDOResource semanticResource;

	private SmartEAClient client;

	private static final String WIZARD_TITLE = "SmartEA Connection";

	private static final String WIZARD_DESCRIPTION = "Connection parameters:";

	private ConnectionInfos connectionInfos = new ConnectionInfos();

	private ConnectionWizardPage page = new ConnectionWizardPage(WIZARD_TITLE, connectionInfos);

	private IProgressMonitor monitor;

	private IFile file;

	public ConnectionWizard(boolean readonly, IFile file) {
		this.readonly = readonly;
		this.file = file;
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		super.addPages();
		setWindowTitle(WIZARD_TITLE);
		page.setDescription(WIZARD_DESCRIPTION);
		addPage(page);
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public boolean performFinish() {
		return internalWork(monitor);
	}

	protected boolean internalWork(IProgressMonitor monitor) {
		monitor.beginTask("Working...", 5);
		ResourceSet resourceSet = new ResourceSetImpl();
		Configuration configuration = ModelUtils.getOCCIConfiguration(file.getLocation().toString(), resourceSet);
		monitor.worked(1);
		try {
			connect(readonly);
			monitor.worked(2);
			connectAndWork(configuration, semanticResource);
			monitor.worked(3);
			if (!readonly) {
				projectClient.commit();
				monitor.worked(4);
			}
		} catch (Throwable e) {
			page.setErrorMessage(e.getMessage());
			return false;
		} finally {
			projectClient.release();
			try {
				client.release();
			} catch (IOException e) {
				MessageDialog.openError(new Shell(Display.getCurrent()), "Error saving " + configuration.eResource(),
						e.getMessage());
			}
			monitor.done();
		}
		page.setErrorMessage(null);
		return true;
	}

	private static class DummyUserProvider implements IUserProviderExtension {

		@Override
		public boolean authenticate(String login, String password) {
			return true;
		}

		@Override
		public UserInfo getUserInfo(String login) {
			return new UserInfo(login, login, login);
		}

	}

	private void connect(boolean readonly) throws IOException {
		client = new SmartEAClient(connectionInfos.protocol, connectionInfos.host, connectionInfos.port,
				connectionInfos.user, connectionInfos.password, true);
		projectClient = client.newProjectClient(connectionInfos.project, false, new AbstractSmartEAModule() {
			@Override
			protected void configure() {
				magicBindImpl(DummyUserProvider.class);
			}
		});
		for (CDOBranch branch : projectClient.getProjectContentCtx().getBranches()) {
			if (connectionInfos.branch.equals(branch.getName())) {
				DbProjectContentTx tx = projectClient.getProjectContentCtx().getTx(branch);
				semanticResource = tx.getSemanticResource();
				semanticResource.cdoPrefetch(CDORevision.DEPTH_INFINITE);
				break;
			}
		}
	}

	protected abstract void connectAndWork(Configuration configuration, Resource semanticResource);
}