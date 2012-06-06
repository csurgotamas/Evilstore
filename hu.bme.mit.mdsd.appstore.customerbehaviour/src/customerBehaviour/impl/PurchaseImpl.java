/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour.impl;

import customerBehaviour.App;
import customerBehaviour.Customer;
import customerBehaviour.CustomerBehaviourPackage;
import customerBehaviour.Purchase;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Purchase</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link customerBehaviour.impl.PurchaseImpl#getDate <em>Date</em>}</li>
 *   <li>{@link customerBehaviour.impl.PurchaseImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link customerBehaviour.impl.PurchaseImpl#getApp <em>App</em>}</li>
 *   <li>{@link customerBehaviour.impl.PurchaseImpl#getAtPrice <em>At Price</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PurchaseImpl extends EObjectImpl implements Purchase {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getApp() <em>App</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApp()
	 * @generated
	 * @ordered
	 */
	protected App app;

	/**
	 * The default value of the '{@link #getAtPrice() <em>At Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double AT_PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAtPrice() <em>At Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtPrice()
	 * @generated
	 * @ordered
	 */
	protected double atPrice = AT_PRICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PurchaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomerBehaviourPackage.Literals.PURCHASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.PURCHASE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer() {
		if (eContainerFeatureID() != CustomerBehaviourPackage.PURCHASE__CUSTOMER) return null;
		return (Customer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCustomer(Customer newCustomer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCustomer, CustomerBehaviourPackage.PURCHASE__CUSTOMER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(Customer newCustomer) {
		if (newCustomer != eInternalContainer() || (eContainerFeatureID() != CustomerBehaviourPackage.PURCHASE__CUSTOMER && newCustomer != null)) {
			if (EcoreUtil.isAncestor(this, newCustomer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCustomer != null)
				msgs = ((InternalEObject)newCustomer).eInverseAdd(this, CustomerBehaviourPackage.CUSTOMER__PURCHASES, Customer.class, msgs);
			msgs = basicSetCustomer(newCustomer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.PURCHASE__CUSTOMER, newCustomer, newCustomer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public App getApp() {
		if (app != null && app.eIsProxy()) {
			InternalEObject oldApp = (InternalEObject)app;
			app = (App)eResolveProxy(oldApp);
			if (app != oldApp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CustomerBehaviourPackage.PURCHASE__APP, oldApp, app));
			}
		}
		return app;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public App basicGetApp() {
		return app;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApp(App newApp, NotificationChain msgs) {
		App oldApp = app;
		app = newApp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.PURCHASE__APP, oldApp, newApp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApp(App newApp) {
		if (newApp != app) {
			NotificationChain msgs = null;
			if (app != null)
				msgs = ((InternalEObject)app).eInverseRemove(this, CustomerBehaviourPackage.APP__PURCHASES, App.class, msgs);
			if (newApp != null)
				msgs = ((InternalEObject)newApp).eInverseAdd(this, CustomerBehaviourPackage.APP__PURCHASES, App.class, msgs);
			msgs = basicSetApp(newApp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.PURCHASE__APP, newApp, newApp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAtPrice() {
		return atPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtPrice(double newAtPrice) {
		double oldAtPrice = atPrice;
		atPrice = newAtPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.PURCHASE__AT_PRICE, oldAtPrice, atPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCustomer((Customer)otherEnd, msgs);
			case CustomerBehaviourPackage.PURCHASE__APP:
				if (app != null)
					msgs = ((InternalEObject)app).eInverseRemove(this, CustomerBehaviourPackage.APP__PURCHASES, App.class, msgs);
				return basicSetApp((App)otherEnd, msgs);
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
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				return basicSetCustomer(null, msgs);
			case CustomerBehaviourPackage.PURCHASE__APP:
				return basicSetApp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				return eInternalContainer().eInverseRemove(this, CustomerBehaviourPackage.CUSTOMER__PURCHASES, Customer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomerBehaviourPackage.PURCHASE__DATE:
				return getDate();
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				return getCustomer();
			case CustomerBehaviourPackage.PURCHASE__APP:
				if (resolve) return getApp();
				return basicGetApp();
			case CustomerBehaviourPackage.PURCHASE__AT_PRICE:
				return getAtPrice();
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
			case CustomerBehaviourPackage.PURCHASE__DATE:
				setDate((Date)newValue);
				return;
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				setCustomer((Customer)newValue);
				return;
			case CustomerBehaviourPackage.PURCHASE__APP:
				setApp((App)newValue);
				return;
			case CustomerBehaviourPackage.PURCHASE__AT_PRICE:
				setAtPrice((Double)newValue);
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
			case CustomerBehaviourPackage.PURCHASE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				setCustomer((Customer)null);
				return;
			case CustomerBehaviourPackage.PURCHASE__APP:
				setApp((App)null);
				return;
			case CustomerBehaviourPackage.PURCHASE__AT_PRICE:
				setAtPrice(AT_PRICE_EDEFAULT);
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
			case CustomerBehaviourPackage.PURCHASE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case CustomerBehaviourPackage.PURCHASE__CUSTOMER:
				return getCustomer() != null;
			case CustomerBehaviourPackage.PURCHASE__APP:
				return app != null;
			case CustomerBehaviourPackage.PURCHASE__AT_PRICE:
				return atPrice != AT_PRICE_EDEFAULT;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", atPrice: ");
		result.append(atPrice);
		result.append(')');
		return result.toString();
	}

} //PurchaseImpl
