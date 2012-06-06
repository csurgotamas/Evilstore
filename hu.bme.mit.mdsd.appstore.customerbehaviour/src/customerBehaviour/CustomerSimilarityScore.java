/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Similarity Score</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link customerBehaviour.CustomerSimilarityScore#getCustomer1 <em>Customer1</em>}</li>
 *   <li>{@link customerBehaviour.CustomerSimilarityScore#getCustomer2 <em>Customer2</em>}</li>
 *   <li>{@link customerBehaviour.CustomerSimilarityScore#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerSimilarityScore()
 * @model
 * @generated
 */
public interface CustomerSimilarityScore extends EObject {
	/**
	 * Returns the value of the '<em><b>Customer1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer1</em>' reference.
	 * @see #setCustomer1(Customer)
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerSimilarityScore_Customer1()
	 * @model
	 * @generated
	 */
	Customer getCustomer1();

	/**
	 * Sets the value of the '{@link customerBehaviour.CustomerSimilarityScore#getCustomer1 <em>Customer1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer1</em>' reference.
	 * @see #getCustomer1()
	 * @generated
	 */
	void setCustomer1(Customer value);

	/**
	 * Returns the value of the '<em><b>Customer2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer2</em>' reference.
	 * @see #setCustomer2(Customer)
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerSimilarityScore_Customer2()
	 * @model
	 * @generated
	 */
	Customer getCustomer2();

	/**
	 * Sets the value of the '{@link customerBehaviour.CustomerSimilarityScore#getCustomer2 <em>Customer2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer2</em>' reference.
	 * @see #getCustomer2()
	 * @generated
	 */
	void setCustomer2(Customer value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #setScore(double)
	 * @see customerBehaviour.CustomerBehaviourPackage#getCustomerSimilarityScore_Score()
	 * @model
	 * @generated
	 */
	double getScore();

	/**
	 * Sets the value of the '{@link customerBehaviour.CustomerSimilarityScore#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(double value);

} // CustomerSimilarityScore
