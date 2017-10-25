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

import fr.obeo.smartea.core.basemm.Documentable;
import fr.obeo.smartea.core.basemm.Identified;
import fr.obeo.smartea.core.basemm.Nameable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.smartea.core.costs.AbstractCost#getRef <em>Ref</em>}</li>
 *   <li>{@link fr.obeo.smartea.core.costs.AbstractCost#getValue <em>Value</em>}</li>
 *   <li>{@link fr.obeo.smartea.core.costs.AbstractCost#getCost <em>Cost</em>}</li>
 * </ul>
 *
 * @see fr.obeo.smartea.core.costs.CostsPackage#getAbstractCost()
 * @model abstract="true"
 * @generated
 */
public interface AbstractCost extends Documentable, Identified, Nameable, CurrencyElement {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EObject)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getAbstractCost_Ref()
	 * @model required="true"
	 * @generated
	 */
	EObject getRef();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.AbstractCost#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EObject value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getAbstractCost_Value()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.AbstractCost#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(double)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getAbstractCost_Cost()
	 * @model
	 * @generated
	 */
	double getCost();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.AbstractCost#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(double value);

} // AbstractCost
