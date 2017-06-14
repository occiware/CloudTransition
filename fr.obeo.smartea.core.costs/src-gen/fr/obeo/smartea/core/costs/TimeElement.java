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

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.smartea.core.costs.TimeElement#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @see fr.obeo.smartea.core.costs.CostsPackage#getTimeElement()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface TimeElement extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Time Unit</b></em>' attribute.
	 * The default value is <code>"YEAR"</code>.
	 * The literals are from the enumeration {@link fr.obeo.smartea.core.costs.TimeUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Unit</em>' attribute.
	 * @see fr.obeo.smartea.core.costs.TimeUnit
	 * @see #setTimeUnit(TimeUnit)
	 * @see fr.obeo.smartea.core.costs.CostsPackage#getTimeElement_TimeUnit()
	 * @model default="YEAR"
	 * @generated
	 */
	TimeUnit getTimeUnit();

	/**
	 * Sets the value of the '{@link fr.obeo.smartea.core.costs.TimeElement#getTimeUnit <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Unit</em>' attribute.
	 * @see fr.obeo.smartea.core.costs.TimeUnit
	 * @see #getTimeUnit()
	 * @generated
	 */
	void setTimeUnit(TimeUnit value);

} // TimeElement
