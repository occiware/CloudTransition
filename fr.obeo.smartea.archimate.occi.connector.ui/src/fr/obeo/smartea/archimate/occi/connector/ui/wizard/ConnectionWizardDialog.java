package fr.obeo.smartea.archimate.occi.connector.ui.wizard;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public final class ConnectionWizardDialog extends WizardDialog {
	ProgressMonitorPart part;

	public ConnectionWizardDialog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
	}

	@Override
	protected ProgressMonitorPart createProgressMonitorPart(Composite composite, GridLayout pmlayout) {
		part = super.createProgressMonitorPart(composite, pmlayout);
		return part;
	}

	@Override
	public void create() {
		super.create();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control ret = super.createContents(parent);
		part.setVisible(true);
		return ret;
	}

	public IProgressMonitor getMonitor() {
		return super.getProgressMonitor();
	}

	public static void launch(ConnectionWizard connectionWizard) {
		final ConnectionWizardDialog dialog = new ConnectionWizardDialog(new Shell(Display.getCurrent()),
				connectionWizard);
		dialog.create();
		connectionWizard.setMonitor(dialog.getMonitor());
		dialog.setBlockOnOpen(true);
		dialog.open();
	}
}