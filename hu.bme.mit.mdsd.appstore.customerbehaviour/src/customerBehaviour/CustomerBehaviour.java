/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link customerBehaviour.CustomerBehaviour#getCustomers <em>Customers</em>}</li>
 *   <li>{@link customerBehaviour.CustomerBehaviour#getDevelopers <em>Developers</em>}</li>
 *   <li>{@link customerBehaviour.CustomerBehaviour#getSimilarityScores <em>Similarity Scores</em>}</li>
 * </ul>
 * </p>
 *
 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerBehaviour()
 * @model
 * @generated
 */
public interface CustomerBehaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link customerBehaviour.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerBehaviour_Customers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Developers</b></em>' containment reference list.
	 * The list contents are of type {@link customerBehaviour.Developer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Developers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Developers</em>' containment reference list.
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerBehaviour_Developers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Developer> getDevelopers();

	/**
	 * Returns the value of the '<em><b>Similarity Scores</b></em>' containment reference list.
	 * The list contents are of type {@link customerBehaviour.CustomerSimilarityScore}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Similarity Scores</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Similarity Scores</em>' containment reference list.
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerBehaviour_SimilarityScores()
	 * @model containment="true"
	 * @generated
	 */
	EList<CustomerSimilarityScore> getSimilarityScores();

} // CustomerBehaviour
