package fr.obeo.smartea.archimate.occi.tests;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.cmf.occi.core.Link;
import org.eclipse.cmf.occi.core.OCCIFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.ArchimateFactory;
import fr.obeo.smartea.archimate.AssignmentRelationship;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.archimate.occi.Archi2OCCI;
import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.reconciler.ArchiReconciler;
import fr.obeo.smartea.archimate.occi.reconciler.OCCIReconciler;
import fr.obeo.smartea.archimate.occi.tests.utils.ITestsConstants;
import fr.obeo.smartea.archimate.occi.tests.utils.TestUtils;
import fr.obeo.smartea.core.basemm.Folder;
import fr.obeo.smartea.core.basemm.util.PropertiesUtil;
import junit.framework.TestCase;

public class SyncTest extends TestCase implements ITestsConstants {

	// TODO test link related issues, get through incorrect impleme of archimate derived methods ?
	/*
	 * Convenience variables, reset before each test & initialized by setup:
	 */
	private Configuration sourceConfig;
	private Folder targetFolder;
	private Resource targetResource;

	@Override
	protected void setUp() throws Exception {
		// load OCCI configuration
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(OCCI_SAMPLE_FILE_PATH), true);
		sourceConfig = (Configuration) resource.getContents().get(0);

		// init the ARCHI target with a first conversion
		targetFolder = new OCCI2Archi().convert(sourceConfig);
		targetResource = resourceSet.createResource(URI.createFileURI(OUTPUT_DIR + "TMP" + ARCHI_EXTENSION));
		targetResource.getContents().add(targetFolder);
		super.setUp();
	}

	private void synchronize() {
		Folder conversionResult = new OCCI2Archi().convert(sourceConfig);
		new ArchiReconciler().reconcile(conversionResult, targetFolder, sourceConfig.getDescription());
	}

	private void synchronizeBackwards() {
		Configuration conversionResult = new Archi2OCCI().convert(targetFolder);
		new OCCIReconciler().reconcile(conversionResult, sourceConfig, sourceConfig.getDescription());
	}

	private void addArchimateElement(ArchimateElement newElement) {
		targetFolder.getElements().add(newElement);
	}

	private ArchimateElement createArchimateElement() {
		ArchimateElement unmanaged = ArchimateFactory.eINSTANCE.createTechnologyCollaboration();
		addArchimateElement(unmanaged);
		return unmanaged;
	}

	private ArchimateElement createArchimateNode() {
		ArchimateElement unmanaged = ArchimateFactory.eINSTANCE.createNode();
		addArchimateElement(unmanaged);
		return unmanaged;
	}

	private Relationship createArchimateLink(String end1ID, String end2ID) {
		AssignmentRelationship link = ArchimateFactory.eINSTANCE.createAssignmentRelationship();
		ArchimateElement end1 = (ArchimateElement) getArchimateComponent(end1ID);
		link.setSourceElement(end1);
		link.setTargetElement(getArchimateComponent(end2ID));
		end1.getOwnedUnidirectionalRelationships().add(link);
		return link;
	}

	private ArchimateComponent getArchimateComponent(String id) {
		return TestUtils.getArchimateComponent(targetResource, id);
	}

	/**
	 * An attribute change in OCCI must be applied in the matching ARCHI
	 * element.
	 */
	@Test
	public void testOCCIAttributeChange() {
		org.eclipse.cmf.occi.core.Resource occiResource = TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID);
		TestUtils.changeAttribute(occiResource, "hostname", "newHost");
		synchronize();
		assertEquals("newHost", PropertiesUtil.getProperty(getArchimateComponent(RESOURCE1_ID), "hostname").getValue());
	}

	/**
	 * A deletion in OCCI must be impacted in ARCHI.
	 */
	@Test
	public void testOCCIDeleteResource() {
		org.eclipse.cmf.occi.core.Resource occiResource = TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID);
		EcoreUtil.delete(occiResource);
		synchronize();
		assertNull(getArchimateComponent(RESOURCE1_ID));
	}

	/**
	 * The elements & the link must be added in archi.
	 */
	@Test
	public void testOCCIAdd2LinkedResources() {
		org.eclipse.cmf.occi.core.Resource new1 = OCCIFactory.eINSTANCE.createResource();
		org.eclipse.cmf.occi.core.Resource new2 = OCCIFactory.eINSTANCE.createResource();
		sourceConfig.getResources().add(new1);
		sourceConfig.getResources().add(new2);
		Link occiLink = OCCIFactory.eINSTANCE.createLink();
		occiLink.setSource(new1);
		occiLink.setTarget(new2);
		new1.getLinks().add(occiLink);
		synchronize();
		ArchimateComponent archiNew1 = getArchimateComponent(new1.getId());
		assertNotNull(archiNew1);
		ArchimateComponent archiNew2 = getArchimateComponent(new2.getId());
		assertNotNull(archiNew2);
		AssignmentRelationship archiLink = (AssignmentRelationship) getArchimateComponent(occiLink.getId());
		assertNotNull(archiLink);
		assertEquals(archiLink.getSourceElement(), archiNew1);
		assertEquals(archiLink.getTargetElement(), archiNew2);
	}

	/**
	 * The link must be deleted in Archi.
	 */
	@Test
	public void testOCCIDeleteLink() {
		EcoreUtil.delete(TestUtils.getOCCILink(sourceConfig, LINK_ID));
		synchronize();
		assertNull(getArchimateComponent(LINK_ID));
	}


	/**
	 * An addition in ARCHI, which is not present in OCCI must be kept after
	 * sync.
	 */
	@Test
	public void testArchiAddElement() {
		ArchimateElement newElement = ArchimateFactory.eINSTANCE.createTechnologyCollaboration();
		String newElementId = newElement.getId();
		addArchimateElement(newElement);
		synchronize();
		assertNotNull(getArchimateComponent(newElementId));
	}

	/**
	 * The link must be kept because it has not been created by the sync.
	 */
	@Test
	public void testArchiLinkBetweenManagedElements() {
		Relationship link = createArchimateLink(RESOURCE1_ID, RESOURCE2_ID);
		String linkId = link.getId();
		synchronize();
		assertNotNull(getArchimateComponent(linkId));
	}

	/**
	 * The link must be kept.
	 */
	@Test
	public void testArchiLinkFromUnmanagedToManaged() {
		ArchimateElement unmanaged = createArchimateElement();
		String unmanagedId = unmanaged.getId();
		Relationship link = createArchimateLink(unmanagedId, RESOURCE1_ID);
		String linkId = link.getId();
		synchronize();
		Relationship archiLink = (Relationship) getArchimateComponent(linkId);
		assertNotNull(archiLink);
		assertEquals(archiLink.getSourceElement(), unmanaged);
		assertEquals(archiLink.getTargetElement(), getArchimateComponent(RESOURCE1_ID));
	}

	/**
	 * Tests the reexport into the origin configuration.
	 */
	@Test
	public void testExport() {
		ArchimateElement node1 = createArchimateNode();
		node1.setName("node1");
		ArchimateElement node2 = createArchimateNode();
		node2.setName("node2");
		createArchimateLink(node1.getId(), node2.getId());
		synchronizeBackwards();
		TestUtils.display(sourceConfig);
	}
}
