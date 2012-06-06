/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.System#getElements <em>Elements</em>}</li>
 *   <li>{@link evilsystem.System#getSystemNameSpace <em>System Name Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link evilsystem.PackageElement}.
	 * It is bidirectional and its opposite is '{@link evilsystem.PackageElement#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see evilsystem.EvilsystemPackage#getSystem_Elements()
	 * @see evilsystem.PackageElement#getSystem
	 * @model opposite="system" containment="true"
	 * @generated
	 */
	EList<PackageElement> getElements();

	/**
	 * Returns the value of the '<em><b>System Name Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Name Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Name Space</em>' attribute.
	 * @see #setSystemNameSpace(String)
	 * @see evilsystem.EvilsystemPackage#getSystem_SystemNameSpace()
	 * @model required="true"
	 * @generated
	 */
	String getSystemNameSpace();

	/**
	 * Sets the value of the '{@link evilsystem.System#getSystemNameSpace <em>System Name Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Name Space</em>' attribute.
	 * @see #getSystemNameSpace()
	 * @generated
	 */
	void setSystemNameSpace(String value);

} // System
