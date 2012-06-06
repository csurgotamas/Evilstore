/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link evilsystem.NamedQuery#getReferred <em>Referred</em>}</li>
 *   <li>{@link evilsystem.NamedQuery#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see evilsystem.EvilsystemPackage#getNamedQuery()
 * @model
 * @generated
 */
public interface NamedQuery extends NamedObject {
	/**
	 * Returns the value of the '<em><b>Referred</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link evilsystem.Entity#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred</em>' reference.
	 * @see #setReferred(Entity)
	 * @see evilsystem.EvilsystemPackage#getNamedQuery_Referred()
	 * @see evilsystem.Entity#getQueries
	 * @model opposite="queries" required="true"
	 * @generated
	 */
	Entity getReferred();

	/**
	 * Sets the value of the '{@link evilsystem.NamedQuery#getReferred <em>Referred</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred</em>' reference.
	 * @see #getReferred()
	 * @generated
	 */
	void setReferred(Entity value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see evilsystem.EvilsystemPackage#getNamedQuery_Query()
	 * @model required="true"
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link evilsystem.NamedQuery#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

} // NamedQuery
