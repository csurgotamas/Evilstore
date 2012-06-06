/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.PackageElement#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getPackageElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniquePackageElementName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot UniquePackageElementName='PackageElement.allInstances()->forAll(p1 : PackageElement, p2 : PackageElement | p1 <> p2 implies p1.name <> p2.name)'"
 * @generated
 */
public interface PackageElement extends NamedObject {
	/**
	 * Returns the value of the '<em><b>System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link evilsystem.System#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' container reference.
	 * @see #setSystem(evilsystem.System)
	 * @see evilsystem.EvilsystemPackage#getPackageElement_System()
	 * @see evilsystem.System#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	evilsystem.System getSystem();

	/**
	 * Sets the value of the '{@link evilsystem.PackageElement#getSystem <em>System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' container reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(evilsystem.System value);

} // PackageElement
