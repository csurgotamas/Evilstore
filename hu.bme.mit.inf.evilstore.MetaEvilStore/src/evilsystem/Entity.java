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
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.Entity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link evilsystem.Entity#getQueries <em>Queries</em>}</li>
 *   <li>{@link evilsystem.Entity#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getEntity()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueAttributeName UniqueFunctionName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot UniqueAttributeName='self.attributes->forAll(a1 : Attribute, a2 : Attribute | a1 <> a2 implies a1.name <> a2.name)' UniqueFunctionName='self.functions->forAll(f1 : Function, f2 : Function | f1 <> f2 implies f1.name <> f2.name)'"
 * @generated
 */
public interface Entity extends PackageElement, Type {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link evilsystem.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see evilsystem.EvilsystemPackage#getEntity_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' reference list.
	 * The list contents are of type {@link evilsystem.NamedQuery}.
	 * It is bidirectional and its opposite is '{@link evilsystem.NamedQuery#getReferred <em>Referred</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' reference list.
	 * @see evilsystem.EvilsystemPackage#getEntity_Queries()
	 * @see evilsystem.NamedQuery#getReferred
	 * @model opposite="referred" required="true"
	 * @generated
	 */
	EList<NamedQuery> getQueries();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(Entity)
	 * @see evilsystem.EvilsystemPackage#getEntity_SuperClass()
	 * @model
	 * @generated
	 */
	Entity getSuperClass();

	/**
	 * Sets the value of the '{@link evilsystem.Entity#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(Entity value);

} // Entity
