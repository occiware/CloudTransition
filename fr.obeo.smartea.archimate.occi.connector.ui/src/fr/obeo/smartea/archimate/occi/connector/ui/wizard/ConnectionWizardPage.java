package fr.obeo.smartea.archimate.occi.connector.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fr.obeo.smartea.core.common.api.client.SmartEAProtocol;

public class ConnectionWizardPage extends WizardPage {

	private ConnectionInfos connectionInfos;

	public ConnectionWizardPage(String pageName, ConnectionInfos connectionInfos) {
		super(pageName);
		this.connectionInfos = connectionInfos;
	}

	@Override
	public void createControl(Composite parent) {
		setControl(parent);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		createProtocolField(parent);
		createHostField(parent);
		createPortField(parent);
		createUserField(parent);
		createPasswordField(parent);
		createProjectField(parent);
		createBranchField(parent);
	}

	protected void createHostField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("host");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(connectionInfos.host);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.host = String.valueOf(text.getText());
			}
		});
	}

	protected void createPortField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("port");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(String.valueOf(connectionInfos.port));
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.port = Integer.valueOf(String.valueOf(text.getText()));
			}
		});
	}

	protected void createProtocolField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("protocol");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Combo combo = new Combo(container, SWT.NULL);
		for (SmartEAProtocol value : SmartEAProtocol.values()) {
			combo.add(String.valueOf(value));
		}
		combo.setText(String.valueOf(connectionInfos.protocol));
		combo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.protocol = SmartEAProtocol.valueOf(String.valueOf(combo.getText()));
			}
		});
	}

	protected void createUserField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("user");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(connectionInfos.user);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.user = String.valueOf(text.getText());
			}
		});
	}

	protected void createPasswordField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("password");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.PASSWORD | SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(connectionInfos.password);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.password = String.valueOf(text.getText());
			}
		});
	}

	protected void createProjectField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("project");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(connectionInfos.project);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.project = String.valueOf(text.getText());
			}
		});
	}

	protected void createBranchField(Composite container) {
		Label label = new Label(container, SWT.NONE);
		label.setText("branch");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		final Text text = new Text(container, SWT.BORDER);
		text.setLayoutData(gd);
		text.setText(connectionInfos.branch);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				connectionInfos.branch = String.valueOf(text.getText());
			}
		});
	}

}
