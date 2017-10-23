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
import fr.obeo.smartea.core.basemm.Identified;
import fr.obeo.smartea.core.basemm.Nameable;
import fr.obeo.smartea.core.costs.AbstractCost;
import fr.obeo.smartea.core.costs.CostUtils;
import fr.obeo.smartea.core.costs.CostsPackage;
import fr.obeo.smartea.core.costs.CurrencyElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Cost</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getDocumentation <em>Documentation</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getCurrency <em>Currency</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getRef <em>Ref</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getValue <em>Value</em>}</li>
 * <li>{@link fr.obeo.smartea.core.costs.impl.AbstractCostImpl#getCost <em>Cost</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractCostImpl extends CDOObjectImpl implements AbstractCost {
	/**
	 * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENTATION_EDEFAULT = ""; //$NON-NLS-1$

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = ""; //$NON-NLS-1$

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 1;

	/**
	 * The default value of the '{@link #getCost() <em>Cost</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected static final double COST_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected AbstractCostImpl() {
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
		return CostsPackage.Literals.ABSTRACT_COST;
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
	public String getDocumentation() {
		return (String)eDynamicGet(CostsPackage.ABSTRACT_COST__DOCUMENTATION,
				BasePackage.Literals.DOCUMENTABLE__DOCUMENTATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDocumentation(String newDocumentation) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__DOCUMENTATION,
				BasePackage.Literals.DOCUMENTABLE__DOCUMENTATION, newDocumentation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(CostsPackage.ABSTRACT_COST__ID, BasePackage.Literals.IDENTIFIED__ID, true,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__ID, BasePackage.Literals.IDENTIFIED__ID, newId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(CostsPackage.ABSTRACT_COST__NAME, BasePackage.Literals.NAMEABLE__NAME,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__NAME, BasePackage.Literals.NAMEABLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCurrency() {
		return (String)eDynamicGet(CostsPackage.ABSTRACT_COST__CURRENCY,
				CostsPackage.Literals.CURRENCY_ELEMENT__CURRENCY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrency(String newCurrency) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__CURRENCY, CostsPackage.Literals.CURRENCY_ELEMENT__CURRENCY,
				newCurrency);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getRef() {
		return (EObject)eDynamicGet(CostsPackage.ABSTRACT_COST__REF, CostsPackage.Literals.ABSTRACT_COST__REF,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject basicGetRef() {
		return (EObject)eDynamicGet(CostsPackage.ABSTRACT_COST__REF, CostsPackage.Literals.ABSTRACT_COST__REF,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRef(EObject newRef) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__REF, CostsPackage.Literals.ABSTRACT_COST__REF, newRef);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return (Integer)eDynamicGet(CostsPackage.ABSTRACT_COST__VALUE,
				CostsPackage.Literals.ABSTRACT_COST__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(int newValue) {
		eDynamicSet(CostsPackage.ABSTRACT_COST__VALUE, CostsPackage.Literals.ABSTRACT_COST__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getCost() {
		return CostUtils.computeCost(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CostsPackage.ABSTRACT_COST__DOCUMENTATION:
				return getDocumentation();
			case CostsPackage.ABSTRACT_COST__ID:
				return getId();
			case CostsPackage.ABSTRACT_COST__NAME:
				return getName();
			case CostsPackage.ABSTRACT_COST__CURRENCY:
				return getCurrency();
			case CostsPackage.ABSTRACT_COST__REF:
				if (resolve)
					return getRef();
				return basicGetRef();
			case CostsPackage.ABSTRACT_COST__VALUE:
				return getValue();
			case CostsPackage.ABSTRACT_COST__COST:
				return getCost();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CostsPackage.ABSTRACT_COST__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case CostsPackage.ABSTRACT_COST__ID:
				setId((String)newValue);
				return;
			case CostsPackage.ABSTRACT_COST__NAME:
				setName((String)newValue);
				return;
			case CostsPackage.ABSTRACT_COST__CURRENCY:
				setCurrency((String)newValue);
				return;
			case CostsPackage.ABSTRACT_COST__REF:
				setRef((EObject)newValue);
				return;
			case CostsPackage.ABSTRACT_COST__VALUE:
				setValue((Integer)newValue);
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
			case CostsPackage.ABSTRACT_COST__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case CostsPackage.ABSTRACT_COST__ID:
				setId(ID_EDEFAULT);
				return;
			case CostsPackage.ABSTRACT_COST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CostsPackage.ABSTRACT_COST__CURRENCY:
				setCurrency(CURRENCY_EDEFAULT);
				return;
			case CostsPackage.ABSTRACT_COST__REF:
				setRef((EObject)null);
				return;
			case CostsPackage.ABSTRACT_COST__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case CostsPackage.ABSTRACT_COST__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? getDocumentation() != null
						: !DOCUMENTATION_EDEFAULT.equals(getDocumentation());
			case CostsPackage.ABSTRACT_COST__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case CostsPackage.ABSTRACT_COST__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case CostsPackage.ABSTRACT_COST__CURRENCY:
				return CURRENCY_EDEFAULT == null ? getCurrency() != null
						: !CURRENCY_EDEFAULT.equals(getCurrency());
			case CostsPackage.ABSTRACT_COST__REF:
				return basicGetRef() != null;
			case CostsPackage.ABSTRACT_COST__VALUE:
				return getValue() != VALUE_EDEFAULT;
			case CostsPackage.ABSTRACT_COST__COST:
				return getCost() != COST_EDEFAULT;
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
		if (baseClass == Identified.class) {
			switch (derivedFeatureID) {
				case CostsPackage.ABSTRACT_COST__ID:
					return BasePackage.IDENTIFIED__ID;
				default:
					return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case CostsPackage.ABSTRACT_COST__NAME:
					return BasePackage.NAMEABLE__NAME;
				default:
					return -1;
			}
		}
		if (baseClass == CurrencyElement.class) {
			switch (derivedFeatureID) {
				case CostsPackage.ABSTRACT_COST__CURRENCY:
					return CostsPackage.CURRENCY_ELEMENT__CURRENCY;
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
		if (baseClass == Identified.class) {
			switch (baseFeatureID) {
				case BasePackage.IDENTIFIED__ID:
					return CostsPackage.ABSTRACT_COST__ID;
				default:
					return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMEABLE__NAME:
					return CostsPackage.ABSTRACT_COST__NAME;
				default:
					return -1;
			}
		}
		if (baseClass == CurrencyElement.class) {
			switch (baseFeatureID) {
				case CostsPackage.CURRENCY_ELEMENT__CURRENCY:
					return CostsPackage.ABSTRACT_COST__CURRENCY;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // AbstractCostImpl
