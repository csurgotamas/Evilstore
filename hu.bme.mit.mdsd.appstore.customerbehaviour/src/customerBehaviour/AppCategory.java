/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>App Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see customerBehaviour.CustomerBehaviourPackage#getAppCategory()
 * @model
 * @generated
 */
public enum AppCategory implements Enumerator {
	/**
	 * The '<em><b>PRODUCTIVITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCTIVITY_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCTIVITY(1, "PRODUCTIVITY", "PRODUCTIVITY"),

	/**
	 * The '<em><b>NEWS AND WEATHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWS_AND_WEATHER_VALUE
	 * @generated
	 * @ordered
	 */
	NEWS_AND_WEATHER(2, "NEWS_AND_WEATHER", "NEWS_AND_WEATHER"),

	/**
	 * The '<em><b>TOOLS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOLS_VALUE
	 * @generated
	 * @ordered
	 */
	TOOLS(3, "TOOLS", "TOOLS"),

	/**
	 * The '<em><b>MULTIMEDIA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIMEDIA_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIMEDIA(4, "MULTIMEDIA", "MULTIMEDIA"),

	/**
	 * The '<em><b>SOCIAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOCIAL_VALUE
	 * @generated
	 * @ordered
	 */
	SOCIAL(5, "SOCIAL", "SOCIAL"),

	/**
	 * The '<em><b>GAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GAME_VALUE
	 * @generated
	 * @ordered
	 */
	GAME(6, "GAME", "GAME"),

	/**
	 * The '<em><b>OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(0, "OTHER", "OTHER");

	/**
	 * The '<em><b>PRODUCTIVITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRODUCTIVITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCTIVITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCTIVITY_VALUE = 1;

	/**
	 * The '<em><b>NEWS AND WEATHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEWS AND WEATHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEWS_AND_WEATHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEWS_AND_WEATHER_VALUE = 2;

	/**
	 * The '<em><b>TOOLS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOOLS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOOLS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOOLS_VALUE = 3;

	/**
	 * The '<em><b>MULTIMEDIA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULTIMEDIA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIMEDIA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULTIMEDIA_VALUE = 4;

	/**
	 * The '<em><b>SOCIAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOCIAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOCIAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOCIAL_VALUE = 5;

	/**
	 * The '<em><b>GAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GAME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GAME_VALUE = 6;

	/**
	 * The '<em><b>OTHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OTHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 0;

	/**
	 * An array of all the '<em><b>App Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AppCategory[] VALUES_ARRAY =
		new AppCategory[] {
			PRODUCTIVITY,
			NEWS_AND_WEATHER,
			TOOLS,
			MULTIMEDIA,
			SOCIAL,
			GAME,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>App Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AppCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>App Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AppCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>App Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AppCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>App Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppCategory get(int value) {
		switch (value) {
			case PRODUCTIVITY_VALUE: return PRODUCTIVITY;
			case NEWS_AND_WEATHER_VALUE: return NEWS_AND_WEATHER;
			case TOOLS_VALUE: return TOOLS;
			case MULTIMEDIA_VALUE: return MULTIMEDIA;
			case SOCIAL_VALUE: return SOCIAL;
			case GAME_VALUE: return GAME;
			case OTHER_VALUE: return OTHER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AppCategory(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AppCategory
