/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Purchase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link customerBehaviour.Purchase#getDate <em>Date</em>}</li>
 *   <li>{@link customerBehaviour.Purchase#getCustomer <em>Customer</em>}</li>
 *   <li>{@link customerBehaviour.Purchase#getApp <em>App</em>}</li>
 *   <li>{@link customerBehaviour.Purchase#getAtPrice <em>At Price</em>}</li>
 * </ul>
 * </p>
 *
 * @see customerBehaviour.CustomerBehaviourPackage#getPurchase()
 * @model
 * @generated
 */
public interface Purchase extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see customerBehaviour.CustomerBehaviourPackage#getPurchase_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link customerBehaviour.Purchase#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link customerBehaviour.Customer#getPurchases <em>Purchases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' container reference.
	 * @see #setCustomer(Customer)
	 * @see customerBehaviour.CustomerBehaviourPackage#getPurchase_Customer()
	 * @see customerBehaviour.Customer#getPurchases
	 * @model opposite="purchases" transient="false"
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link customerBehaviour.Purchase#getCustomer <em>Customer</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' container reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>App</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link customerBehaviour.App#getPurchases <em>Purchases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>App</em>' reference.
	 * @see #setApp(App)
	 * @see customerBehaviour.CustomerBehaviourPackage#getPurchase_App()
	 * @see customerBehaviour.App#getPurchases
	 * @model opposite="purchases"
	 * @generated
	 */
	App getApp();

	/**
	 * Sets the value of the '{@link customerBehaviour.Purchase#getApp <em>App</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App</em>' reference.
	 * @see #getApp()
	 * @generated
	 */
	void setApp(App value);

	/**
	 * Returns the value of the '<em><b>At Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Price</em>' attribute.
	 * @see #setAtPrice(double)
	 * @see customerBehaviour.CustomerBehaviourPackage#getPurchase_AtPrice()
	 * @model
	 * @generated
	 */
	double getAtPrice();

	/**
	 * Sets the value of the '{@link customerBehaviour.Purchase#getAtPrice <em>At Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Price</em>' attribute.
	 * @see #getAtPrice()
	 * @generated
	 */
	void setAtPrice(double value);

} // Purchase
