/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem.impl;

import evilsystem.Entity;
import evilsystem.EvilsystemPackage;
import evilsystem.NamedQuery;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link evilsystem.impl.NamedQueryImpl#getReferred <em>Referred</em>}</li>
 *   <li>{@link evilsystem.impl.NamedQueryImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedQueryImpl extends NamedObjectImpl implements NamedQuery {
	/**
	 * The cached value of the '{@link #getReferred() <em>Referred</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferred()
	 * @generated
	 * @ordered
	 */
	protected Entity referred;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvilsystemPackage.Literals.NAMED_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getReferred() {
		if (referred != null && referred.eIsProxy()) {
			InternalEObject oldReferred = (InternalEObject)referred;
			referred = (Entity)eResolveProxy(oldReferred);
			if (referred != oldReferred) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvilsystemPackage.NAMED_QUERY__REFERRED, oldReferred, referred));
			}
		}
		return referred;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetReferred() {
		return referred;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferred(Entity newReferred, NotificationChain msgs) {
		Entity oldReferred = referred;
		referred = newReferred;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EvilsystemPackage.NAMED_QUERY__REFERRED, oldReferred, newReferred);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferred(Entity newReferred) {
		if (newReferred != referred) {
			NotificationChain msgs = null;
			if (referred != null)
				msgs = ((InternalEObject)referred).eInverseRemove(this, EvilsystemPackage.ENTITY__QUERIES, Entity.class, msgs);
			if (newReferred != null)
				msgs = ((InternalEObject)newReferred).eInverseAdd(this, EvilsystemPackage.ENTITY__QUERIES, Entity.class, msgs);
			msgs = basicSetReferred(newReferred, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvilsystemPackage.NAMED_QUERY__REFERRED, newReferred, newReferred));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvilsystemPackage.NAMED_QUERY__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				if (referred != null)
					msgs = ((InternalEObject)referred).eInverseRemove(this, EvilsystemPackage.ENTITY__QUERIES, Entity.class, msgs);
				return basicSetReferred((Entity)otherEnd, msgs);
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
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				return basicSetReferred(null, msgs);
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
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				if (resolve) return getReferred();
				return basicGetReferred();
			case EvilsystemPackage.NAMED_QUERY__QUERY:
				return getQuery();
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
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				setReferred((Entity)newValue);
				return;
			case EvilsystemPackage.NAMED_QUERY__QUERY:
				setQuery((String)newValue);
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
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				setReferred((Entity)null);
				return;
			case EvilsystemPackage.NAMED_QUERY__QUERY:
				setQuery(QUERY_EDEFAULT);
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
			case EvilsystemPackage.NAMED_QUERY__REFERRED:
				return referred != null;
			case EvilsystemPackage.NAMED_QUERY__QUERY:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
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
		result.append(" (query: ");
		result.append(query);
		result.append(')');
		return result.toString();
	}

} //NamedQueryImpl
