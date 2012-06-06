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
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.Function#getParameters <em>Parameters</em>}</li>
 *   <li>{@link evilsystem.Function#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link evilsystem.Function#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getFunction()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueParameterName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot UniqueParameterName='self.parameters->forAll(p1 : Parameter, p2 : Parameter | p1 <> p2 implies p1.name <> p2.name)'"
 * @generated
 */
public interface Function extends TypeReference {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link evilsystem.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see evilsystem.EvilsystemPackage#getFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Method Type</b></em>' attribute.
	 * The literals are from the enumeration {@link evilsystem.MethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Type</em>' attribute.
	 * @see evilsystem.MethodType
	 * @see #setMethodType(MethodType)
	 * @see evilsystem.EvilsystemPackage#getFunction_MethodType()
	 * @model required="true"
	 * @generated
	 */
	MethodType getMethodType();

	/**
	 * Sets the value of the '{@link evilsystem.Function#getMethodType <em>Method Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Type</em>' attribute.
	 * @see evilsystem.MethodType
	 * @see #getMethodType()
	 * @generated
	 */
	void setMethodType(MethodType value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link evilsystem.NamedQuery}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see evilsystem.EvilsystemPackage#getFunction_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedQuery> getQueries();

} // Function
