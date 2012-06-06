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
 * A representation of the model object '<em><b>Developer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link customerBehaviour.Developer#getName <em>Name</em>}</li>
 *   <li>{@link customerBehaviour.Developer#getAuthoredApps <em>Authored Apps</em>}</li>
 * </ul>
 * </p>
 *
 * @see customerBehaviour.CustomerBehaviourPackage#getDeveloper()
 * @model
 * @generated
 */
public interface Developer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see customerBehaviour.CustomerBehaviourPackage#getDeveloper_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link customerBehaviour.Developer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Authored Apps</b></em>' containment reference list.
	 * The list contents are of type {@link customerBehaviour.App}.
	 * It is bidirectional and its opposite is '{@link customerBehaviour.App#getDeveloper <em>Developer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authored Apps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authored Apps</em>' containment reference list.
	 * @see customerBehaviour.CustomerBehaviourPackage#getDeveloper_AuthoredApps()
	 * @see customerBehaviour.App#getDeveloper
	 * @model opposite="developer" containment="true"
	 * @generated
	 */
	EList<App> getAuthoredApps();

} // Developer
