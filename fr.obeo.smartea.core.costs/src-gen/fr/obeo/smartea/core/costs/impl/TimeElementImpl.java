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

import fr.obeo.smartea.core.costs.CostsPackage;
import fr.obeo.smartea.core.costs.TimeElement;
import fr.obeo.smartea.core.costs.TimeUnit;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.smartea.core.costs.impl.TimeElementImpl#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeElementImpl extends CDOObjectImpl implements TimeElement {
	/**
	 * The default value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected static final TimeUnit TIME_UNIT_EDEFAULT = TimeUnit.YEAR;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CostsPackage.Literals.TIME_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnit getTimeUnit() {
		return (TimeUnit)eDynamicGet(CostsPackage.TIME_ELEMENT__TIME_UNIT, CostsPackage.Literals.TIME_ELEMENT__TIME_UNIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeUnit(TimeUnit newTimeUnit) {
		eDynamicSet(CostsPackage.TIME_ELEMENT__TIME_UNIT, CostsPackage.Literals.TIME_ELEMENT__TIME_UNIT, newTimeUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CostsPackage.TIME_ELEMENT__TIME_UNIT:
				return getTimeUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CostsPackage.TIME_ELEMENT__TIME_UNIT:
				setTimeUnit((TimeUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CostsPackage.TIME_ELEMENT__TIME_UNIT:
				setTimeUnit(TIME_UNIT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CostsPackage.TIME_ELEMENT__TIME_UNIT:
				return getTimeUnit() != TIME_UNIT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //TimeElementImpl
