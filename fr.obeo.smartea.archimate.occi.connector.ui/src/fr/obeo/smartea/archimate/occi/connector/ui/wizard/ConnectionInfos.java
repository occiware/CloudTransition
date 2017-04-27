package fr.obeo.smartea.archimate.occi.connector.ui.wizard;

import fr.obeo.smartea.core.common.api.client.SmartEAProtocol;

public class ConnectionInfos {
	// values are for default test user
	public SmartEAProtocol protocol = SmartEAProtocol.HTTP;
	public String host = "localhost";
	public int port = 9000;
	public String user = "afontaine";
	public String password = "123";
	public String project = "VoyageDiscount";
	public String branch = "Master";
}
