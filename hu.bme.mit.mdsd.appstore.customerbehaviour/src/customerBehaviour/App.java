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
 * A representation of the model object '<em><b>App</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link customerBehaviour.App#getTitle <em>Title</em>}</li>
 *   <li>{@link customerBehaviour.App#getAgeRestriction <em>Age Restriction</em>}</li>
 *   <li>{@link customerBehaviour.App#getCategory <em>Category</em>}</li>
 *   <li>{@link customerBehaviour.App#getDeveloper <em>Developer</em>}</li>
 *   <li>{@link customerBehaviour.App#getCurrentPrice <em>Current Price</em>}</li>
 *   <li>{@link customerBehaviour.App#getPurchases <em>Purchases</em>}</li>
 * </ul>
 * </p>
 *
 * @see customerBehaviour.CustomerBehaviourPackage#getApp()
 * @model
 * @generated
 */
public interface App extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link customerBehaviour.App#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Age Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age Restriction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age Restriction</em>' attribute.
	 * @see #setAgeRestriction(int)
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_AgeRestriction()
	 * @model
	 * @generated
	 */
	int getAgeRestriction();

	/**
	 * Sets the value of the '{@link customerBehaviour.App#getAgeRestriction <em>Age Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age Restriction</em>' attribute.
	 * @see #getAgeRestriction()
	 * @generated
	 */
	void setAgeRestriction(int value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link customerBehaviour.AppCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see customerBehaviour.AppCategory
	 * @see #setCategory(AppCategory)
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_Category()
	 * @model
	 * @generated
	 */
	AppCategory getCategory();

	/**
	 * Sets the value of the '{@link customerBehaviour.App#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see customerBehaviour.AppCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(AppCategory value);

	/**
	 * Returns the value of the '<em><b>Developer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link customerBehaviour.Developer#getAuthoredApps <em>Authored Apps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Developer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Developer</em>' container reference.
	 * @see #setDeveloper(Developer)
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_Developer()
	 * @see customerBehaviour.Developer#getAuthoredApps
	 * @model opposite="authoredApps" transient="false"
	 * @generated
	 */
	Developer getDeveloper();

	/**
	 * Sets the value of the '{@link customerBehaviour.App#getDeveloper <em>Developer</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Developer</em>' container reference.
	 * @see #getDeveloper()
	 * @generated
	 */
	void setDeveloper(Developer value);

	/**
	 * Returns the value of the '<em><b>Current Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Price</em>' attribute.
	 * @see #setCurrentPrice(double)
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_CurrentPrice()
	 * @model
	 * @generated
	 */
	double getCurrentPrice();

	/**
	 * Sets the value of the '{@link customerBehaviour.App#getCurrentPrice <em>Current Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Price</em>' attribute.
	 * @see #getCurrentPrice()
	 * @generated
	 */
	void setCurrentPrice(double value);

	/**
	 * Returns the value of the '<em><b>Purchases</b></em>' reference list.
	 * The list contents are of type {@link customerBehaviour.Purchase}.
	 * It is bidirectional and its opposite is '{@link customerBehaviour.Purchase#getApp <em>App</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purchases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purchases</em>' reference list.
	 * @see customerBehaviour.CustomerBehaviourPackage#getApp_Purchases()
	 * @see customerBehaviour.Purchase#getApp
	 * @model opposite="app"
	 * @generated
	 */
	EList<Purchase> getPurchases();

} // App
