/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem.impl;

import evilsystem.EvilsystemPackage;
import evilsystem.PackageElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link evilsystem.impl.SystemImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link evilsystem.impl.SystemImpl#getSystemNameSpace <em>System Name Space</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EObjectImpl implements evilsystem.System {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageElement> elements;

	/**
	 * The default value of the '{@link #getSystemNameSpace() <em>System Name Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemNameSpace()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_NAME_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemNameSpace() <em>System Name Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemNameSpace()
	 * @generated
	 * @ordered
	 */
	protected String systemNameSpace = SYSTEM_NAME_SPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvilsystemPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<PackageElement>(PackageElement.class, this, EvilsystemPackage.SYSTEM__ELEMENTS, EvilsystemPackage.PACKAGE_ELEMENT__SYSTEM);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemNameSpace() {
		return systemNameSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemNameSpace(String newSystemNameSpace) {
		String oldSystemNameSpace = systemNameSpace;
		systemNameSpace = newSystemNameSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvilsystemPackage.SYSTEM__SYSTEM_NAME_SPACE, oldSystemNameSpace, systemNameSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				return getElements();
			case EvilsystemPackage.SYSTEM__SYSTEM_NAME_SPACE:
				return getSystemNameSpace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends PackageElement>)newValue);
				return;
			case EvilsystemPackage.SYSTEM__SYSTEM_NAME_SPACE:
				setSystemNameSpace((String)newValue);
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
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				getElements().clear();
				return;
			case EvilsystemPackage.SYSTEM__SYSTEM_NAME_SPACE:
				setSystemNameSpace(SYSTEM_NAME_SPACE_EDEFAULT);
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
			case EvilsystemPackage.SYSTEM__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case EvilsystemPackage.SYSTEM__SYSTEM_NAME_SPACE:
				return SYSTEM_NAME_SPACE_EDEFAULT == null ? systemNameSpace != null : !SYSTEM_NAME_SPACE_EDEFAULT.equals(systemNameSpace);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (systemNameSpace: ");
		result.append(systemNameSpace);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
