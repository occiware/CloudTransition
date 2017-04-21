package fr.obeo.smartea.archimate.occi.tests;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.occiware.clouddesigner.occi.Configuration;

import fr.obeo.smartea.archimate.occi.Archi2OCCI;
import fr.obeo.smartea.archimate.occi.tests.utils.ITestsConstants;
import fr.obeo.smartea.core.basemm.Folder;

public class ArchiToOCCITest implements ITestsConstants {

	@Test
	public void testArchiToOCCI() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(ARCHI_SAMPLE_FILE_PATH), true);
		Folder folder = (Folder) resource.getContents().get(2);
		Configuration configuration = new Archi2OCCI().convert(folder);
		Resource output = resourceSet.createResource(URI.createFileURI(OUTPUT_DIR + SAMPLE_NAME + OCCI_EXTENSION));
		output.getContents().add(configuration);
		output.save(Collections.EMPTY_MAP);
	}

}
