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

import fr.obeo.smartea.core.basemm.Identified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.smartea.core.costs.CostsContainer#getCosts <em>Costs</em>}</li>
 *   <li>{@link fr.obeo.smartea.core.costs.CostsContainer#getRegularCost <em>Regular Cost</em>}</li>
 *   <li>{@link fr.obeo.smartea.core.costs.CostsContainer#getInitialCost <em>Initial Cost</em>}</li>
 * </ul>
 *
 * @see fr.obeo.smartea.core.costs.CostsPackage#getCostsContainer()
 * @model
 * @generated
 */
public interface CostsContainer extends Identified, CurrencyElement, TimeElement {
	/**
	 * Returns the value of the '<em><b>Costs</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.smartea.core.costs.AbstractCost}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Costs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Costs</em>' containment reference list.
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getCostsContainer_Costs()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractCost> getCosts();

	/**
	 * Returns the value of the '<em><b>Regular Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regular Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regular Cost</em>' attribute.
	 * @see #setRegularCost(double)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getCostsContainer_RegularCost()
	 * @model
	 * @generated
	 */
	double getRegularCost();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.CostsContainer#getRegularCost <em>Regular Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regular Cost</em>' attribute.
	 * @see #getRegularCost()
	 * @generated
	 */
	void setRegularCost(double value);

	/**
	 * Returns the value of the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Cost</em>' attribute.
	 * @see #setInitialCost(double)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getCostsContainer_InitialCost()
	 * @model
	 * @generated
	 */
	double getInitialCost();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.CostsContainer#getInitialCost <em>Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Cost</em>' attribute.
	 * @see #getInitialCost()
	 * @generated
	 */
	void setInitialCost(double value);

} // CostsContainer
