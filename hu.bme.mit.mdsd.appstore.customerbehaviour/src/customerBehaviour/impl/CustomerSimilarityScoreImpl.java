/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour.impl;

import customerBehaviour.Customer;
import customerBehaviour.CustomerBehaviourPackage;
import customerBehaviour.CustomerSimilarityScore;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Similarity Score</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link customerBehaviour.impl.CustomerSimilarityScoreImpl#getCustomer1 <em>Customer1</em>}</li>
 *   <li>{@link customerBehaviour.impl.CustomerSimilarityScoreImpl#getCustomer2 <em>Customer2</em>}</li>
 *   <li>{@link customerBehaviour.impl.CustomerSimilarityScoreImpl#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerSimilarityScoreImpl extends EObjectImpl implements CustomerSimilarityScore {
	/**
	 * The cached value of the '{@link #getCustomer1() <em>Customer1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer1()
	 * @generated
	 * @ordered
	 */
	protected Customer customer1;

	/**
	 * The cached value of the '{@link #getCustomer2() <em>Customer2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer2()
	 * @generated
	 * @ordered
	 */
	protected Customer customer2;

	/**
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final double SCORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected double score = SCORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerSimilarityScoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomerBehaviourPackage.Literals.CUSTOMER_SIMILARITY_SCORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer1() {
		if (customer1 != null && customer1.eIsProxy()) {
			InternalEObject oldCustomer1 = (InternalEObject)customer1;
			customer1 = (Customer)eResolveProxy(oldCustomer1);
			if (customer1 != oldCustomer1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1, oldCustomer1, customer1));
			}
		}
		return customer1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomer1() {
		return customer1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer1(Customer newCustomer1) {
		Customer oldCustomer1 = customer1;
		customer1 = newCustomer1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1, oldCustomer1, customer1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer2() {
		if (customer2 != null && customer2.eIsProxy()) {
			InternalEObject oldCustomer2 = (InternalEObject)customer2;
			customer2 = (Customer)eResolveProxy(oldCustomer2);
			if (customer2 != oldCustomer2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2, oldCustomer2, customer2));
			}
		}
		return customer2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomer2() {
		return customer2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer2(Customer newCustomer2) {
		Customer oldCustomer2 = customer2;
		customer2 = newCustomer2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2, oldCustomer2, customer2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(double newScore) {
		double oldScore = score;
		score = newScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1:
				if (resolve) return getCustomer1();
				return basicGetCustomer1();
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2:
				if (resolve) return getCustomer2();
				return basicGetCustomer2();
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__SCORE:
				return getScore();
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
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1:
				setCustomer1((Customer)newValue);
				return;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2:
				setCustomer2((Customer)newValue);
				return;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__SCORE:
				setScore((Double)newValue);
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
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1:
				setCustomer1((Customer)null);
				return;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2:
				setCustomer2((Customer)null);
				return;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__SCORE:
				setScore(SCORE_EDEFAULT);
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
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER1:
				return customer1 != null;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__CUSTOMER2:
				return customer2 != null;
			case CustomerBehaviourPackage.CUSTOMER_SIMILARITY_SCORE__SCORE:
				return score != SCORE_EDEFAULT;
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
		result.append(" (score: ");
		result.append(score);
		result.append(')');
		return result.toString();
	}

} //CustomerSimilarityScoreImpl
