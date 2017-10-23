/**
 * Copyright (c) 2016 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 */
package fr.obeo.smartea.core.costs.impl;

import fr.obeo.smartea.core.basemm.BasePackage;

import fr.obeo.smartea.core.costs.AbstractCost;
import fr.obeo.smartea.core.costs.Cost;
import fr.obeo.smartea.core.costs.CostsContainer;
import fr.obeo.smartea.core.costs.CostsFactory;
import fr.obeo.smartea.core.costs.CostsPackage;
import fr.obeo.smartea.core.costs.CurrencyElement;
import fr.obeo.smartea.core.costs.InitialCost;
import fr.obeo.smartea.core.costs.Issue;
import fr.obeo.smartea.core.costs.TimeElement;
import fr.obeo.smartea.core.costs.TimeUnit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CostsPackageImpl extends EPackageImpl implements CostsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costsContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass issueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass currencyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum timeUnitEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.obeo.smartea.core.costs.CostsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CostsPackageImpl() {
		super(eNS_URI, CostsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CostsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CostsPackage init() {
		if (isInited) return (CostsPackage)EPackage.Registry.INSTANCE.getEPackage(CostsPackage.eNS_URI);

		// Obtain or create and register package
		CostsPackageImpl theCostsPackage = (CostsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CostsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CostsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCostsPackage.createPackageContents();

		// Initialize created meta-data
		theCostsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCostsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CostsPackage.eNS_URI, theCostsPackage);
		return theCostsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCostsContainer() {
		return costsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCostsContainer_Costs() {
		return (EReference)costsContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCostsContainer_RegularCost() {
		return (EAttribute)costsContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCostsContainer_InitialCost() {
		return (EAttribute)costsContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCost() {
		return abstractCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCost_Ref() {
		return (EReference)abstractCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCost_Value() {
		return (EAttribute)abstractCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCost_Cost() {
		return (EAttribute)abstractCostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialCost() {
		return initialCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCost() {
		return costEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIssue() {
		return issueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIssue_Count() {
		return (EAttribute)issueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurrencyElement() {
		return currencyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurrencyElement_Currency() {
		return (EAttribute)currencyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeElement() {
		return timeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeElement_TimeUnit() {
		return (EAttribute)timeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTimeUnit() {
		return timeUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostsFactory getCostsFactory() {
		return (CostsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		costsContainerEClass = createEClass(COSTS_CONTAINER);
		createEReference(costsContainerEClass, COSTS_CONTAINER__COSTS);
		createEAttribute(costsContainerEClass, COSTS_CONTAINER__REGULAR_COST);
		createEAttribute(costsContainerEClass, COSTS_CONTAINER__INITIAL_COST);

		abstractCostEClass = createEClass(ABSTRACT_COST);
		createEReference(abstractCostEClass, ABSTRACT_COST__REF);
		createEAttribute(abstractCostEClass, ABSTRACT_COST__VALUE);
		createEAttribute(abstractCostEClass, ABSTRACT_COST__COST);

		initialCostEClass = createEClass(INITIAL_COST);

		costEClass = createEClass(COST);

		issueEClass = createEClass(ISSUE);
		createEAttribute(issueEClass, ISSUE__COUNT);

		currencyElementEClass = createEClass(CURRENCY_ELEMENT);
		createEAttribute(currencyElementEClass, CURRENCY_ELEMENT__CURRENCY);

		timeElementEClass = createEClass(TIME_ELEMENT);
		createEAttribute(timeElementEClass, TIME_ELEMENT__TIME_UNIT);

		// Create enums
		timeUnitEEnum = createEEnum(TIME_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		costsContainerEClass.getESuperTypes().add(theBasePackage.getIdentified());
		costsContainerEClass.getESuperTypes().add(this.getCurrencyElement());
		costsContainerEClass.getESuperTypes().add(this.getTimeElement());
		abstractCostEClass.getESuperTypes().add(theBasePackage.getDocumentable());
		abstractCostEClass.getESuperTypes().add(theBasePackage.getIdentified());
		abstractCostEClass.getESuperTypes().add(theBasePackage.getNameable());
		abstractCostEClass.getESuperTypes().add(this.getCurrencyElement());
		initialCostEClass.getESuperTypes().add(this.getAbstractCost());
		costEClass.getESuperTypes().add(this.getAbstractCost());
		costEClass.getESuperTypes().add(this.getTimeElement());
		issueEClass.getESuperTypes().add(this.getAbstractCost());
		issueEClass.getESuperTypes().add(this.getTimeElement());

		// Initialize classes and features; add operations and parameters
		initEClass(costsContainerEClass, CostsContainer.class, "CostsContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCostsContainer_Costs(), this.getAbstractCost(), null, "costs", null, 0, -1, CostsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCostsContainer_RegularCost(), ecorePackage.getEDouble(), "regularCost", null, 0, 1, CostsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCostsContainer_InitialCost(), ecorePackage.getEDouble(), "initialCost", null, 0, 1, CostsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractCostEClass, AbstractCost.class, "AbstractCost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractCost_Ref(), theEcorePackage.getEObject(), null, "ref", null, 1, 1, AbstractCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractCost_Value(), theEcorePackage.getEInt(), "value", "1", 1, 1, AbstractCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAbstractCost_Cost(), ecorePackage.getEDouble(), "cost", null, 0, 1, AbstractCost.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(initialCostEClass, InitialCost.class, "InitialCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(costEClass, Cost.class, "Cost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(issueEClass, Issue.class, "Issue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIssue_Count(), theEcorePackage.getEInt(), "count", null, 0, 1, Issue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(currencyElementEClass, CurrencyElement.class, "CurrencyElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCurrencyElement_Currency(), theEcorePackage.getEString(), "currency", "euro", 1, 1, CurrencyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(timeElementEClass, TimeElement.class, "TimeElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTimeElement_TimeUnit(), this.getTimeUnit(), "timeUnit", "YEAR", 0, 1, TimeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Initialize enums and add enum literals
		initEEnum(timeUnitEEnum, TimeUnit.class, "TimeUnit"); //$NON-NLS-1$
		addEEnumLiteral(timeUnitEEnum, TimeUnit.MONTH);
		addEEnumLiteral(timeUnitEEnum, TimeUnit.YEAR);

		// Create resource
		createResource(eNS_URI);
	}

} //CostsPackageImpl
