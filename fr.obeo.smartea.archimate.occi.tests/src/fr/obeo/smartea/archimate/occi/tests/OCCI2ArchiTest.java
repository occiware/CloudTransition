package fr.obeo.smartea.archimate.occi.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.occiware.clouddesigner.occi.Configuration;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.AssociationRelationship;
import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.tests.utils.ITestsConstants;
import fr.obeo.smartea.archimate.occi.tests.utils.TestUtils;
import fr.obeo.smartea.core.basemm.Folder;

public class OCCI2ArchiTest implements ITestsConstants {

	@Test
	public void testOCCI2Archi() throws Exception {
		// load OCCI sample
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(OCCI_SAMPLE_FILE_PATH), true);
		Configuration configuration = (Configuration) resource.getContents().get(0);

		// run conversion
		Folder folder = new OCCI2Archi().convert(configuration);
		Resource output = resourceSet.createResource(URI.createFileURI(OUTPUT_DIR + SAMPLE_NAME + ARCHI_EXTENSION));
		output.getContents().add(folder);

		// trace for debug
		output.save(Collections.EMPTY_MAP);

		// check output model linking
		ArchimateComponent object1 = TestUtils.getArchimateComponent(output, RESOURCE1_ID);
		assertNotNull(object1);
		ArchimateComponent object2 = TestUtils.getArchimateComponent(output, RESOURCE2_ID);
		assertNotNull(object2);
		AssociationRelationship link = (AssociationRelationship) TestUtils.getArchimateComponent(output, LINK_ID);
		assertNotNull(link);
		assertEquals(link.getSourceElement(), object2);
		assertEquals(link.getTargetElement(), object1);
	}

}
