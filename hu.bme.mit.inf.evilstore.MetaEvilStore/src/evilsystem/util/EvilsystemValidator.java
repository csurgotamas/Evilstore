/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package evilsystem.util;

import evilsystem.Attribute;
import evilsystem.Component;
import evilsystem.Entity;
import evilsystem.EvilsystemPackage;
import evilsystem.Function;
import evilsystem.MethodType;
import evilsystem.NamedObject;
import evilsystem.NamedQuery;
import evilsystem.PackageElement;
import evilsystem.Parameter;
import evilsystem.Platform;
import evilsystem.Service;
import evilsystem.SimpleType;
import evilsystem.Type;
import evilsystem.TypeReference;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see evilsystem.EvilsystemPackage
 * @generated
 */
public class EvilsystemValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EvilsystemValidator INSTANCE = new EvilsystemValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "evilsystem";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvilsystemValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return EvilsystemPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case EvilsystemPackage.SYSTEM:
				return validateSystem((evilsystem.System)value, diagnostics, context);
			case EvilsystemPackage.SIMPLE_TYPE:
				return validateSimpleType((SimpleType)value, diagnostics, context);
			case EvilsystemPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case EvilsystemPackage.NAMED_OBJECT:
				return validateNamedObject((NamedObject)value, diagnostics, context);
			case EvilsystemPackage.ATTRIBUTE:
				return validateAttribute((Attribute)value, diagnostics, context);
			case EvilsystemPackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case EvilsystemPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case EvilsystemPackage.SERVICE:
				return validateService((Service)value, diagnostics, context);
			case EvilsystemPackage.PACKAGE_ELEMENT:
				return validatePackageElement((PackageElement)value, diagnostics, context);
			case EvilsystemPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case EvilsystemPackage.TYPE_REFERENCE:
				return validateTypeReference((TypeReference)value, diagnostics, context);
			case EvilsystemPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case EvilsystemPackage.NAMED_QUERY:
				return validateNamedQuery((NamedQuery)value, diagnostics, context);
			case EvilsystemPackage.PLATFORM:
				return validatePlatform((Platform)value, diagnostics, context);
			case EvilsystemPackage.METHOD_TYPE:
				return validateMethodType((MethodType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(evilsystem.System system, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(system, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleType(SimpleType simpleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(simpleType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(simpleType, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageElement_UniquePackageElementName(simpleType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageElement_UniquePackageElementName(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntity_UniqueAttributeName(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntity_UniqueFunctionName(entity, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueAttributeName constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENTITY__UNIQUE_ATTRIBUTE_NAME__EEXPRESSION = "self.attributes->forAll(a1 : Attribute, a2 : Attribute | a1 <> a2 implies a1.name <> a2.name)";

	/**
	 * Validates the UniqueAttributeName constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity_UniqueAttributeName(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.ENTITY,
				 entity,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "UniqueAttributeName",
				 ENTITY__UNIQUE_ATTRIBUTE_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueFunctionName constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENTITY__UNIQUE_FUNCTION_NAME__EEXPRESSION = "self.functions->forAll(f1 : Function, f2 : Function | f1 <> f2 implies f1.name <> f2.name)";

	/**
	 * Validates the UniqueFunctionName constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity_UniqueFunctionName(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.ENTITY,
				 entity,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "UniqueFunctionName",
				 ENTITY__UNIQUE_FUNCTION_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedObject(NamedObject namedObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedObject, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(namedObject, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NotEmptyName constraint of '<em>Named Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NAMED_OBJECT__NOT_EMPTY_NAME__EEXPRESSION = "self.name <> ''";

	/**
	 * Validates the NotEmptyName constraint of '<em>Named Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedObject_NotEmptyName(NamedObject namedObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.NAMED_OBJECT,
				 namedObject,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NotEmptyName",
				 NAMED_OBJECT__NOT_EMPTY_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(attribute, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_UniqueParameterName(function, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueParameterName constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION__UNIQUE_PARAMETER_NAME__EEXPRESSION = "self.parameters->forAll(p1 : Parameter, p2 : Parameter | p1 <> p2 implies p1.name <> p2.name)";

	/**
	 * Validates the UniqueParameterName constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_UniqueParameterName(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.FUNCTION,
				 function,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "UniqueParameterName",
				 FUNCTION__UNIQUE_PARAMETER_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(parameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateService(Service service, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(service, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(service, diagnostics, context);
		if (result || diagnostics != null) result &= validateService_UniqueFunctionName(service, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueFunctionName constraint of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SERVICE__UNIQUE_FUNCTION_NAME__EEXPRESSION = "self.functions->forAll(f1 : Function, f2 : Function | f1 <> f2 implies f1.name <> f2.name)";

	/**
	 * Validates the UniqueFunctionName constraint of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateService_UniqueFunctionName(Service service, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.SERVICE,
				 service,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "UniqueFunctionName",
				 SERVICE__UNIQUE_FUNCTION_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageElement(PackageElement packageElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(packageElement, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageElement_UniquePackageElementName(packageElement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniquePackageElementName constraint of '<em>Package Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PACKAGE_ELEMENT__UNIQUE_PACKAGE_ELEMENT_NAME__EEXPRESSION = "PackageElement.allInstances()->forAll(p1 : PackageElement, p2 : PackageElement | p1 <> p2 implies p1.name <> p2.name)";

	/**
	 * Validates the UniquePackageElementName constraint of '<em>Package Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageElement_UniquePackageElementName(PackageElement packageElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(EvilsystemPackage.Literals.PACKAGE_ELEMENT,
				 packageElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "UniquePackageElementName",
				 PACKAGE_ELEMENT__UNIQUE_PACKAGE_ELEMENT_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(type, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(type, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeReference(TypeReference typeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(typeReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(component, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(component, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(component, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageElement_UniquePackageElementName(component, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedQuery(NamedQuery namedQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedQuery, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedQuery, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedObject_NotEmptyName(namedQuery, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlatform(Platform platform, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethodType(MethodType methodType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //EvilsystemValidator
