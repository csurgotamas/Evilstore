/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.Component#getPlatform <em>Platform</em>}</li>
 *   <li>{@link evilsystem.Component#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Platform</b></em>' attribute.
	 * The literals are from the enumeration {@link evilsystem.Platform}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' attribute.
	 * @see evilsystem.Platform
	 * @see #setPlatform(Platform)
	 * @see evilsystem.EvilsystemPackage#getComponent_Platform()
	 * @model required="true"
	 * @generated
	 */
	Platform getPlatform();

	/**
	 * Sets the value of the '{@link evilsystem.Component#getPlatform <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' attribute.
	 * @see evilsystem.Platform
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(Platform value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link evilsystem.Service}.
	 * It is bidirectional and its opposite is '{@link evilsystem.Service#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see evilsystem.EvilsystemPackage#getComponent_Services()
	 * @see evilsystem.Service#getComponent
	 * @model opposite="component" containment="true"
	 * @generated
	 */
	EList<Service> getServices();

} // Component
