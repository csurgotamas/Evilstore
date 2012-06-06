/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour.impl;

import customerBehaviour.Customer;
import customerBehaviour.CustomerBehaviour;
import customerBehaviour.CustomerBehaviourPackage;
import customerBehaviour.CustomerSimilarityScore;
import customerBehaviour.Developer;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link customerBehaviour.impl.CustomerBehaviourImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link customerBehaviour.impl.CustomerBehaviourImpl#getDevelopers <em>Developers</em>}</li>
 *   <li>{@link customerBehaviour.impl.CustomerBehaviourImpl#getSimilarityScores <em>Similarity Scores</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerBehaviourImpl extends EObjectImpl implements CustomerBehaviour {
	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;

	/**
	 * The cached value of the '{@link #getDevelopers() <em>Developers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevelopers()
	 * @generated
	 * @ordered
	 */
	protected EList<Developer> developers;

	/**
	 * The cached value of the '{@link #getSimilarityScores() <em>Similarity Scores</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimilarityScores()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomerSimilarityScore> similarityScores;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomerBehaviourPackage.Literals.CUSTOMER_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentEList<Customer>(Customer.class, this, CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Developer> getDevelopers() {
		if (developers == null) {
			developers = new EObjectContainmentEList<Developer>(Developer.class, this, CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS);
		}
		return developers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CustomerSimilarityScore> getSimilarityScores() {
		if (similarityScores == null) {
			similarityScores = new EObjectContainmentEList<CustomerSimilarityScore>(CustomerSimilarityScore.class, this, CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES);
		}
		return similarityScores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS:
				return ((InternalEList<?>)getCustomers()).basicRemove(otherEnd, msgs);
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS:
				return ((InternalEList<?>)getDevelopers()).basicRemove(otherEnd, msgs);
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES:
				return ((InternalEList<?>)getSimilarityScores()).basicRemove(otherEnd, msgs);
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
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS:
				return getCustomers();
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS:
				return getDevelopers();
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES:
				return getSimilarityScores();
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
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection<? extends Customer>)newValue);
				return;
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS:
				getDevelopers().clear();
				getDevelopers().addAll((Collection<? extends Developer>)newValue);
				return;
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES:
				getSimilarityScores().clear();
				getSimilarityScores().addAll((Collection<? extends CustomerSimilarityScore>)newValue);
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
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS:
				getCustomers().clear();
				return;
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS:
				getDevelopers().clear();
				return;
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES:
				getSimilarityScores().clear();
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
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__CUSTOMERS:
				return customers != null && !customers.isEmpty();
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__DEVELOPERS:
				return developers != null && !developers.isEmpty();
			case CustomerBehaviourPackage.CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES:
				return similarityScores != null && !similarityScores.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CustomerBehaviourImpl
