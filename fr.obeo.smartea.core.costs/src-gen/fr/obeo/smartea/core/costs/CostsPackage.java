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
package fr.obeo.smartea.core.costs;

import fr.obeo.smartea.core.basemm.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.smartea.core.costs.CostsFactory
 * @model kind="package"
 * @generated
 */
public interface CostsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "costs"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/smartea/costs/2.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "costs"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CostsPackage eINSTANCE = fr.obeo.smartea.core.costs.impl.CostsPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.CostsContainerImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCostsContainer()
	 * @generated
	 */
	int COSTS_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__ID = BasePackage.IDENTIFIED__ID;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__CURRENCY = BasePackage.IDENTIFIED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__TIME_UNIT = BasePackage.IDENTIFIED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Costs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__COSTS = BasePackage.IDENTIFIED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Regular Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__REGULAR_COST = BasePackage.IDENTIFIED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER__INITIAL_COST = BasePackage.IDENTIFIED_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COSTS_CONTAINER_FEATURE_COUNT = BasePackage.IDENTIFIED_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl <em>Abstract Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.AbstractCostImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getAbstractCost()
	 * @generated
	 */
	int ABSTRACT_COST = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__DOCUMENTATION = BasePackage.DOCUMENTABLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__ID = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__NAME = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__CURRENCY = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__REF = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__VALUE = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST__COST = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Abstract Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COST_FEATURE_COUNT = BasePackage.DOCUMENTABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.InitialCostImpl <em>Initial Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.InitialCostImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getInitialCost()
	 * @generated
	 */
	int INITIAL_COST = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__DOCUMENTATION = ABSTRACT_COST__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__ID = ABSTRACT_COST__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__NAME = ABSTRACT_COST__NAME;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__CURRENCY = ABSTRACT_COST__CURRENCY;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__REF = ABSTRACT_COST__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__VALUE = ABSTRACT_COST__VALUE;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST__COST = ABSTRACT_COST__COST;

	/**
	 * The number of structural features of the '<em>Initial Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_COST_FEATURE_COUNT = ABSTRACT_COST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.CostImpl <em>Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.CostImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCost()
	 * @generated
	 */
	int COST = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__DOCUMENTATION = ABSTRACT_COST__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__ID = ABSTRACT_COST__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__NAME = ABSTRACT_COST__NAME;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__CURRENCY = ABSTRACT_COST__CURRENCY;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__REF = ABSTRACT_COST__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__VALUE = ABSTRACT_COST__VALUE;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__COST = ABSTRACT_COST__COST;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__TIME_UNIT = ABSTRACT_COST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_FEATURE_COUNT = ABSTRACT_COST_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.IssueImpl <em>Issue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.IssueImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getIssue()
	 * @generated
	 */
	int ISSUE = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__DOCUMENTATION = ABSTRACT_COST__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__ID = ABSTRACT_COST__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__NAME = ABSTRACT_COST__NAME;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__CURRENCY = ABSTRACT_COST__CURRENCY;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__REF = ABSTRACT_COST__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__VALUE = ABSTRACT_COST__VALUE;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__COST = ABSTRACT_COST__COST;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__TIME_UNIT = ABSTRACT_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__COUNT = ABSTRACT_COST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE_FEATURE_COUNT = ABSTRACT_COST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.CurrencyElementImpl <em>Currency Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.CurrencyElementImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCurrencyElement()
	 * @generated
	 */
	int CURRENCY_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_ELEMENT__CURRENCY = 0;

	/**
	 * The number of structural features of the '<em>Currency Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.impl.TimeElementImpl <em>Time Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.impl.TimeElementImpl
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getTimeElement()
	 * @generated
	 */
	int TIME_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ELEMENT__TIME_UNIT = 0;

	/**
	 * The number of structural features of the '<em>Time Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.smartea.core.costs.TimeUnit <em>Time Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.smartea.core.costs.TimeUnit
	 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 7;


	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.CostsContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see fr.obeo.smartea.core.costs.CostsContainer
	 * @generated
	 */
	EClass getCostsContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.smartea.core.costs.CostsContainer#getCosts <em>Costs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Costs</em>'.
	 * @see fr.obeo.smartea.core.costs.CostsContainer#getCosts()
	 * @see #getCostsContainer()
	 * @generated
	 */
	EReference getCostsContainer_Costs();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.CostsContainer#getRegularCost <em>Regular Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regular Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.CostsContainer#getRegularCost()
	 * @see #getCostsContainer()
	 * @generated
	 */
	EAttribute getCostsContainer_RegularCost();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.CostsContainer#getInitialCost <em>Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.CostsContainer#getInitialCost()
	 * @see #getCostsContainer()
	 * @generated
	 */
	EAttribute getCostsContainer_InitialCost();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.AbstractCost <em>Abstract Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.AbstractCost
	 * @generated
	 */
	EClass getAbstractCost();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.smartea.core.costs.AbstractCost#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see fr.obeo.smartea.core.costs.AbstractCost#getRef()
	 * @see #getAbstractCost()
	 * @generated
	 */
	EReference getAbstractCost_Ref();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.AbstractCost#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.obeo.smartea.core.costs.AbstractCost#getValue()
	 * @see #getAbstractCost()
	 * @generated
	 */
	EAttribute getAbstractCost_Value();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.AbstractCost#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.AbstractCost#getCost()
	 * @see #getAbstractCost()
	 * @generated
	 */
	EAttribute getAbstractCost_Cost();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.InitialCost <em>Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.InitialCost
	 * @generated
	 */
	EClass getInitialCost();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.Cost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cost</em>'.
	 * @see fr.obeo.smartea.core.costs.Cost
	 * @generated
	 */
	EClass getCost();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.Issue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Issue</em>'.
	 * @see fr.obeo.smartea.core.costs.Issue
	 * @generated
	 */
	EClass getIssue();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.Issue#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see fr.obeo.smartea.core.costs.Issue#getCount()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_Count();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.CurrencyElement <em>Currency Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Currency Element</em>'.
	 * @see fr.obeo.smartea.core.costs.CurrencyElement
	 * @generated
	 */
	EClass getCurrencyElement();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.CurrencyElement#getCurrency <em>Currency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Currency</em>'.
	 * @see fr.obeo.smartea.core.costs.CurrencyElement#getCurrency()
	 * @see #getCurrencyElement()
	 * @generated
	 */
	EAttribute getCurrencyElement_Currency();

	/**
	 * Returns the meta object for class '{@link fr.obeo.smartea.core.costs.TimeElement <em>Time Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Element</em>'.
	 * @see fr.obeo.smartea.core.costs.TimeElement
	 * @generated
	 */
	EClass getTimeElement();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.smartea.core.costs.TimeElement#getTimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Unit</em>'.
	 * @see fr.obeo.smartea.core.costs.TimeElement#getTimeUnit()
	 * @see #getTimeElement()
	 * @generated
	 */
	EAttribute getTimeElement_TimeUnit();

	/**
	 * Returns the meta object for enum '{@link fr.obeo.smartea.core.costs.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit</em>'.
	 * @see fr.obeo.smartea.core.costs.TimeUnit
	 * @generated
	 */
	EEnum getTimeUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CostsFactory getCostsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.CostsContainerImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCostsContainer()
		 * @generated
		 */
		EClass COSTS_CONTAINER = eINSTANCE.getCostsContainer();

		/**
		 * The meta object literal for the '<em><b>Costs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COSTS_CONTAINER__COSTS = eINSTANCE.getCostsContainer_Costs();

		/**
		 * The meta object literal for the '<em><b>Regular Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COSTS_CONTAINER__REGULAR_COST = eINSTANCE.getCostsContainer_RegularCost();

		/**
		 * The meta object literal for the '<em><b>Initial Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COSTS_CONTAINER__INITIAL_COST = eINSTANCE.getCostsContainer_InitialCost();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl <em>Abstract Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.AbstractCostImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getAbstractCost()
		 * @generated
		 */
		EClass ABSTRACT_COST = eINSTANCE.getAbstractCost();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COST__REF = eINSTANCE.getAbstractCost_Ref();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_COST__VALUE = eINSTANCE.getAbstractCost_Value();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_COST__COST = eINSTANCE.getAbstractCost_Cost();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.InitialCostImpl <em>Initial Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.InitialCostImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getInitialCost()
		 * @generated
		 */
		EClass INITIAL_COST = eINSTANCE.getInitialCost();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.CostImpl <em>Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.CostImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCost()
		 * @generated
		 */
		EClass COST = eINSTANCE.getCost();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.IssueImpl <em>Issue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.IssueImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getIssue()
		 * @generated
		 */
		EClass ISSUE = eINSTANCE.getIssue();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__COUNT = eINSTANCE.getIssue_Count();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.CurrencyElementImpl <em>Currency Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.CurrencyElementImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getCurrencyElement()
		 * @generated
		 */
		EClass CURRENCY_ELEMENT = eINSTANCE.getCurrencyElement();

		/**
		 * The meta object literal for the '<em><b>Currency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURRENCY_ELEMENT__CURRENCY = eINSTANCE.getCurrencyElement_Currency();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.impl.TimeElementImpl <em>Time Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.impl.TimeElementImpl
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getTimeElement()
		 * @generated
		 */
		EClass TIME_ELEMENT = eINSTANCE.getTimeElement();

		/**
		 * The meta object literal for the '<em><b>Time Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_ELEMENT__TIME_UNIT = eINSTANCE.getTimeElement_TimeUnit();

		/**
		 * The meta object literal for the '{@link fr.obeo.smartea.core.costs.TimeUnit <em>Time Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.smartea.core.costs.TimeUnit
		 * @see fr.obeo.smartea.core.costs.impl.CostsPackageImpl#getTimeUnit()
		 * @generated
		 */
		EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

	}

} //CostsPackage
