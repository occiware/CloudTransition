package fr.obeo.smartea.archimate.occi.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.cmf.occi.core.Extension;
import org.eclipse.cmf.occi.core.Kind;
import org.eclipse.cmf.occi.core.util.OcciRegistry;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import fr.obeo.smartea.archimate.ArchimateComponent;
import fr.obeo.smartea.archimate.ArchimatePackage;
import fr.obeo.smartea.archimate.Relationship;
import fr.obeo.smartea.core.basemm.Property;

public class MappingConfig {
	
	private static final String LINK_SCHEME = "http://schemas.ogf.org/occi/core#link";
	private static final String RESOURCE_SCHEME = "http://schemas.ogf.org/occi/core#resource";

	public static final String OCCI_KIND_SCHEME_KEY = "occi.core.kind";
	public static final String OCCI_SOURCE_ID_KEY = "occi.core.sourceid";

	private Map<String, EClass> mapping = new HashMap<String, EClass>();

	public Kind getOCCIKind(ArchimateComponent element) {
		String kindScheme = null;

		// 1) lookup in the element properties
		for (Property property : element.getProperties()) {
			if (OCCI_KIND_SCHEME_KEY.equals(property.getName())) {
				kindScheme = property.getValue();
				break;
			}
		}
		// 2) lookup in the mapping config
		if (kindScheme == null) {
			for (Entry<String, EClass> entry : mapping.entrySet()) {
				if (element.eClass().equals(entry.getValue())) {
					kindScheme = entry.getKey();
					break;
				}
			}
		}
		// 3) default
		if (kindScheme == null) {
			if (element instanceof Relationship) {
				kindScheme = LINK_SCHEME;
			} else {
				kindScheme = RESOURCE_SCHEME;
			}
		}
		String term = kindScheme.split("#")[1];
		String extensionURI = OcciRegistry.getInstance().getExtensionURI(kindScheme.split("#")[0] + "#");
		final org.eclipse.emf.ecore.resource.Resource extensionResource = element.eResource().getResourceSet()
				.getResource(URI.createURI(extensionURI, true), true);
		final Extension extension = (Extension) extensionResource.getContents().get(0);
		for (Kind kind : extension.getKinds()) {
			if (kind.getTerm().equalsIgnoreCase(term)) {
				return kind;
			}
		}
		return null;
	}

	public EClass getArchiType(Kind kind) {
		String kindScheme = kind.getScheme() + kind.getTerm();
		EClass type = mapping.get(kindScheme);
		if (type == null) {
			Kind parent = kind.getParent();
			while (parent != null && type == null) {
				parent = kind.getParent();
				type = getArchiType(parent);
			}
		}
		return type;
	}

	public void load(Properties properties) {
		for (Entry<Object, Object> entry : properties.entrySet()) {
			String typeName = String.valueOf(entry.getValue());
			EClass type = (EClass) ArchimatePackage.eINSTANCE.getEClassifier(typeName);
			mapping.put(String.valueOf(entry.getKey()), type);
		}
	}

	public MappingConfig(Properties properties) {
		load(properties);
	}

	public MappingConfig() {
		Properties props = new Properties();
		InputStream is = getClass().getResourceAsStream("default.mapping");
		try {
			props.load(is);
			is.close();
		} catch (IOException e) {
			// should not happen
			throw new IllegalStateException();
		}
		load(props);
	}

}
