/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour.impl;

import customerBehaviour.App;
import customerBehaviour.AppCategory;
import customerBehaviour.CustomerBehaviourPackage;
import customerBehaviour.Developer;
import customerBehaviour.Purchase;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link customerBehaviour.impl.AppImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link customerBehaviour.impl.AppImpl#getAgeRestriction <em>Age Restriction</em>}</li>
 *   <li>{@link customerBehaviour.impl.AppImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link customerBehaviour.impl.AppImpl#getDeveloper <em>Developer</em>}</li>
 *   <li>{@link customerBehaviour.impl.AppImpl#getCurrentPrice <em>Current Price</em>}</li>
 *   <li>{@link customerBehaviour.impl.AppImpl#getPurchases <em>Purchases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppImpl extends EObjectImpl implements App {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgeRestriction() <em>Age Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgeRestriction()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_RESTRICTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAgeRestriction() <em>Age Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgeRestriction()
	 * @generated
	 * @ordered
	 */
	protected int ageRestriction = AGE_RESTRICTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final AppCategory CATEGORY_EDEFAULT = AppCategory.PRODUCTIVITY;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected AppCategory category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentPrice() <em>Current Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double CURRENT_PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCurrentPrice() <em>Current Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentPrice()
	 * @generated
	 * @ordered
	 */
	protected double currentPrice = CURRENT_PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPurchases() <em>Purchases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurchases()
	 * @generated
	 * @ordered
	 */
	protected EList<Purchase> purchases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomerBehaviourPackage.Literals.APP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.APP__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAgeRestriction() {
		return ageRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgeRestriction(int newAgeRestriction) {
		int oldAgeRestriction = ageRestriction;
		ageRestriction = newAgeRestriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.APP__AGE_RESTRICTION, oldAgeRestriction, ageRestriction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(AppCategory newCategory) {
		AppCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.APP__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Developer getDeveloper() {
		if (eContainerFeatureID() != CustomerBehaviourPackage.APP__DEVELOPER) return null;
		return (Developer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeveloper(Developer newDeveloper, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeveloper, CustomerBehaviourPackage.APP__DEVELOPER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeveloper(Developer newDeveloper) {
		if (newDeveloper != eInternalContainer() || (eContainerFeatureID() != CustomerBehaviourPackage.APP__DEVELOPER && newDeveloper != null)) {
			if (EcoreUtil.isAncestor(this, newDeveloper))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeveloper != null)
				msgs = ((InternalEObject)newDeveloper).eInverseAdd(this, CustomerBehaviourPackage.DEVELOPER__AUTHORED_APPS, Developer.class, msgs);
			msgs = basicSetDeveloper(newDeveloper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.APP__DEVELOPER, newDeveloper, newDeveloper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentPrice(double newCurrentPrice) {
		double oldCurrentPrice = currentPrice;
		currentPrice = newCurrentPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.APP__CURRENT_PRICE, oldCurrentPrice, currentPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Purchase> getPurchases() {
		if (purchases == null) {
			purchases = new EObjectWithInverseResolvingEList<Purchase>(Purchase.class, this, CustomerBehaviourPackage.APP__PURCHASES, CustomerBehaviourPackage.PURCHASE__APP);
		}
		return purchases;
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
			case CustomerBehaviourPackage.APP__DEVELOPER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeveloper((Developer)otherEnd, msgs);
			case CustomerBehaviourPackage.APP__PURCHASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPurchases()).basicAdd(otherEnd, msgs);
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
			case CustomerBehaviourPackage.APP__DEVELOPER:
				return basicSetDeveloper(null, msgs);
			case CustomerBehaviourPackage.APP__PURCHASES:
				return ((InternalEList<?>)getPurchases()).basicRemove(otherEnd, msgs);
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
			case CustomerBehaviourPackage.APP__DEVELOPER:
				return eInternalContainer().eInverseRemove(this, CustomerBehaviourPackage.DEVELOPER__AUTHORED_APPS, Developer.class, msgs);
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
			case CustomerBehaviourPackage.APP__TITLE:
				return getTitle();
			case CustomerBehaviourPackage.APP__AGE_RESTRICTION:
				return getAgeRestriction();
			case CustomerBehaviourPackage.APP__CATEGORY:
				return getCategory();
			case CustomerBehaviourPackage.APP__DEVELOPER:
				return getDeveloper();
			case CustomerBehaviourPackage.APP__CURRENT_PRICE:
				return getCurrentPrice();
			case CustomerBehaviourPackage.APP__PURCHASES:
				return getPurchases();
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
			case CustomerBehaviourPackage.APP__TITLE:
				setTitle((String)newValue);
				return;
			case CustomerBehaviourPackage.APP__AGE_RESTRICTION:
				setAgeRestriction((Integer)newValue);
				return;
			case CustomerBehaviourPackage.APP__CATEGORY:
				setCategory((AppCategory)newValue);
				return;
			case CustomerBehaviourPackage.APP__DEVELOPER:
				setDeveloper((Developer)newValue);
				return;
			case CustomerBehaviourPackage.APP__CURRENT_PRICE:
				setCurrentPrice((Double)newValue);
				return;
			case CustomerBehaviourPackage.APP__PURCHASES:
				getPurchases().clear();
				getPurchases().addAll((Collection<? extends Purchase>)newValue);
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
			case CustomerBehaviourPackage.APP__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case CustomerBehaviourPackage.APP__AGE_RESTRICTION:
				setAgeRestriction(AGE_RESTRICTION_EDEFAULT);
				return;
			case CustomerBehaviourPackage.APP__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case CustomerBehaviourPackage.APP__DEVELOPER:
				setDeveloper((Developer)null);
				return;
			case CustomerBehaviourPackage.APP__CURRENT_PRICE:
				setCurrentPrice(CURRENT_PRICE_EDEFAULT);
				return;
			case CustomerBehaviourPackage.APP__PURCHASES:
				getPurchases().clear();
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
			case CustomerBehaviourPackage.APP__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case CustomerBehaviourPackage.APP__AGE_RESTRICTION:
				return ageRestriction != AGE_RESTRICTION_EDEFAULT;
			case CustomerBehaviourPackage.APP__CATEGORY:
				return category != CATEGORY_EDEFAULT;
			case CustomerBehaviourPackage.APP__DEVELOPER:
				return getDeveloper() != null;
			case CustomerBehaviourPackage.APP__CURRENT_PRICE:
				return currentPrice != CURRENT_PRICE_EDEFAULT;
			case CustomerBehaviourPackage.APP__PURCHASES:
				return purchases != null && !purchases.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(", ageRestriction: ");
		result.append(ageRestriction);
		result.append(", category: ");
		result.append(category);
		result.append(", currentPrice: ");
		result.append(currentPrice);
		result.append(')');
		return result.toString();
	}

} //AppImpl
