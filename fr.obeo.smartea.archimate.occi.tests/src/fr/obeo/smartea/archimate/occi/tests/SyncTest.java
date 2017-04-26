package fr.obeo.smartea.archimate.occi.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.OCCIFactory;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.ArchimateElement;
import fr.obeo.smartea.archimate.ArchimateFactory;
import fr.obeo.smartea.archimate.AssociationRelationship;
import fr.obeo.smartea.archimate.occi.Archi2OCCI;
import fr.obeo.smartea.archimate.occi.OCCI2Archi;
import fr.obeo.smartea.archimate.occi.reconciler.ArchiReconciler;
import fr.obeo.smartea.archimate.occi.reconciler.OCCIReconciler;
import fr.obeo.smartea.archimate.occi.tests.utils.ITestsConstants;
import fr.obeo.smartea.archimate.occi.tests.utils.TestUtils;
import fr.obeo.smartea.archimate.occi.utils.ModelUtils;
import fr.obeo.smartea.core.basemm.Folder;
import junit.framework.TestCase;

public class SyncTest extends TestCase implements ITestsConstants {

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
		new ArchiReconciler().reconcile(conversionResult, targetFolder);
	}

	private void synchronizeBackwards() {
		Configuration conversionResult = new Archi2OCCI().convert(targetFolder);
		new OCCIReconciler().reconcile(conversionResult, sourceConfig);
	}

	private void addArchimateElement(ArchimateElement newElement) {
		ModelUtils.getFolderFor(targetFolder, newElement).getElements().add(newElement);
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

	private AssociationRelationship createArchimateLink(String end1ID, String end2ID) {
		AssociationRelationship link = ArchimateFactory.eINSTANCE.createAssociationRelationship();
		ArchimateComponent end1 = getArchimateComponent(end1ID);
		link.setSourceElement(end1);
		link.setTargetElement(getArchimateComponent(end2ID));
		end1.getOwnedBidirectionalRelationships().add(link);
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
		org.occiware.clouddesigner.occi.Resource occiResource = TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID);
		TestUtils.changeAttribute(occiResource, ModelUtils.OCCI_TITLE_ATTR_NAME, NEW_TITLE);
		synchronize();
		assertEquals(NEW_TITLE, getArchimateComponent(RESOURCE1_ID).getName());
	}

	/**
	 * A deletion in OCCI must be impacted in ARCHI.
	 */
	@Test
	public void testOCCIDeleteResource() {
		org.occiware.clouddesigner.occi.Resource occiResource = TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID);
		EcoreUtil.delete(occiResource);
		synchronize();
		assertNull(getArchimateComponent(RESOURCE1_ID));
	}

	/**
	 * The link must be added to Archi.
	 */
	@Test
	public void testOCCILinkBetweenResources() {
		org.occiware.clouddesigner.occi.Resource occiResource1 = TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID);
		org.occiware.clouddesigner.occi.Resource occiResource2 = TestUtils.getOCCIResource(sourceConfig, RESOURCE2_ID);
		Link link = OCCIFactory.eINSTANCE.createLink();
		link.setSource(occiResource1);
		link.setTarget(occiResource2);
		occiResource1.getLinks().add(link);
		synchronize();
		AssociationRelationship archiLink = (AssociationRelationship) getArchimateComponent(link.getId());
		assertNotNull(archiLink);
		assertEquals(archiLink.getSourceElement(), getArchimateComponent(RESOURCE1_ID));
		assertEquals(archiLink.getTargetElement(), getArchimateComponent(RESOURCE2_ID));

	}

	/**
	 * The elements & the link must be added in archi.
	 */
	@Test
	public void testOCCIAdd2LinkedResources() {
		org.occiware.clouddesigner.occi.Resource new1 = OCCIFactory.eINSTANCE.createResource();
		org.occiware.clouddesigner.occi.Resource new2 = OCCIFactory.eINSTANCE.createResource();
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
		AssociationRelationship archiLink = (AssociationRelationship) getArchimateComponent(occiLink.getId());
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
	 * The element & the link must be deleted in archi.
	 */
	@Test
	public void testOCCIDeleteResourceWLinkFromUnmanagedElement() {
		ArchimateElement unmanaged = createArchimateElement();
		String unmanagedId = unmanaged.getId();
		AssociationRelationship link = createArchimateLink(unmanagedId, RESOURCE1_ID);
		String linkId = link.getId();
		EcoreUtil.delete(TestUtils.getOCCIResource(sourceConfig, RESOURCE1_ID));
		synchronize();
		assertNull(getArchimateComponent(RESOURCE1_ID));
		assertNotNull(getArchimateComponent(unmanagedId));
		assertNull(getArchimateComponent(linkId));
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
		AssociationRelationship link = createArchimateLink(RESOURCE1_ID, RESOURCE2_ID);
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
		AssociationRelationship link = createArchimateLink(unmanagedId, RESOURCE1_ID);
		String linkId = link.getId();
		synchronize();
		AssociationRelationship archiLink = (AssociationRelationship) getArchimateComponent(linkId);
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
		AssociationRelationship link = createArchimateLink(node1.getId(), node2.getId());
		synchronizeBackwards();
		TestUtils.display(sourceConfig);
	}
}
