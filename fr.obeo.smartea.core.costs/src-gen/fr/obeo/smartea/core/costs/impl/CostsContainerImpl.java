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
import fr.obeo.smartea.core.costs.CostsContainer;
import fr.obeo.smartea.core.costs.CostsPackage;
import fr.obeo.smartea.core.costs.CurrencyElement;
import fr.obeo.smartea.core.costs.TimeElement;
import fr.obeo.smartea.core.costs.TimeUnit;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Container</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl#getCurrency <em>Currency</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl#getTimeUnit <em>Time Unit</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.CostsContainerImpl#getCosts <em>Costs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CostsContainerImpl extends CDOObjectImpl implements CostsContainer {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCurrency() <em>Currency</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENCY_EDEFAULT = "euro"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected static final TimeUnit TIME_UNIT_EDEFAULT = TimeUnit.YEAR;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CostsContainerImpl() {
		super();
		this.setId(EcoreUtil.generateUUID());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CostsPackage.Literals.COSTS_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(CostsPackage.COSTS_CONTAINER__ID, BasePackage.Literals.IDENTIFIED__ID,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(CostsPackage.COSTS_CONTAINER__ID, BasePackage.Literals.IDENTIFIED__ID, newId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCurrency() {
		return (String)eDynamicGet(CostsPackage.COSTS_CONTAINER__CURRENCY,
				CostsPackage.Literals.CURRENCY_ELEMENT__CURRENCY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrency(String newCurrency) {
		eDynamicSet(CostsPackage.COSTS_CONTAINER__CURRENCY, CostsPackage.Literals.CURRENCY_ELEMENT__CURRENCY,
				newCurrency);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeUnit getTimeUnit() {
		return (TimeUnit)eDynamicGet(CostsPackage.COSTS_CONTAINER__TIME_UNIT,
				CostsPackage.Literals.TIME_ELEMENT__TIME_UNIT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTimeUnit(TimeUnit newTimeUnit) {
		eDynamicSet(CostsPackage.COSTS_CONTAINER__TIME_UNIT, CostsPackage.Literals.TIME_ELEMENT__TIME_UNIT,
				newTimeUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractCost> getCosts() {
		return (EList<AbstractCost>)eDynamicGet(CostsPackage.COSTS_CONTAINER__COSTS,
				CostsPackage.Literals.COSTS_CONTAINER__COSTS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CostsPackage.COSTS_CONTAINER__COSTS:
				return ((InternalEList<?>)getCosts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CostsPackage.COSTS_CONTAINER__ID:
				return getId();
			case CostsPackage.COSTS_CONTAINER__CURRENCY:
				return getCurrency();
			case CostsPackage.COSTS_CONTAINER__TIME_UNIT:
				return getTimeUnit();
			case CostsPackage.COSTS_CONTAINER__COSTS:
				return getCosts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CostsPackage.COSTS_CONTAINER__ID:
				setId((String)newValue);
				return;
			case CostsPackage.COSTS_CONTAINER__CURRENCY:
				setCurrency((String)newValue);
				return;
			case CostsPackage.COSTS_CONTAINER__TIME_UNIT:
				setTimeUnit((TimeUnit)newValue);
				return;
			case CostsPackage.COSTS_CONTAINER__COSTS:
				getCosts().clear();
				getCosts().addAll((Collection<? extends AbstractCost>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CostsPackage.COSTS_CONTAINER__ID:
				setId(ID_EDEFAULT);
				return;
			case CostsPackage.COSTS_CONTAINER__CURRENCY:
				setCurrency(CURRENCY_EDEFAULT);
				return;
			case CostsPackage.COSTS_CONTAINER__TIME_UNIT:
				setTimeUnit(TIME_UNIT_EDEFAULT);
				return;
			case CostsPackage.COSTS_CONTAINER__COSTS:
				getCosts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CostsPackage.COSTS_CONTAINER__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case CostsPackage.COSTS_CONTAINER__CURRENCY:
				return CURRENCY_EDEFAULT == null ? getCurrency() != null
						: !CURRENCY_EDEFAULT.equals(getCurrency());
			case CostsPackage.COSTS_CONTAINER__TIME_UNIT:
				return getTimeUnit() != TIME_UNIT_EDEFAULT;
			case CostsPackage.COSTS_CONTAINER__COSTS:
				return !getCosts().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CurrencyElement.class) {
			switch (derivedFeatureID) {
				case CostsPackage.COSTS_CONTAINER__CURRENCY:
					return CostsPackage.CURRENCY_ELEMENT__CURRENCY;
				default:
					return -1;
			}
		}
		if (baseClass == TimeElement.class) {
			switch (derivedFeatureID) {
				case CostsPackage.COSTS_CONTAINER__TIME_UNIT:
					return CostsPackage.TIME_ELEMENT__TIME_UNIT;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CurrencyElement.class) {
			switch (baseFeatureID) {
				case CostsPackage.CURRENCY_ELEMENT__CURRENCY:
					return CostsPackage.COSTS_CONTAINER__CURRENCY;
				default:
					return -1;
			}
		}
		if (baseClass == TimeElement.class) {
			switch (baseFeatureID) {
				case CostsPackage.TIME_ELEMENT__TIME_UNIT:
					return CostsPackage.COSTS_CONTAINER__TIME_UNIT;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // CostsContainerImpl
