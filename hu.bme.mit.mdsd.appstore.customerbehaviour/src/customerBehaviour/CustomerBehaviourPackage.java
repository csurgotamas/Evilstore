/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package customerBehaviour;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see customerBehaviour.CustomerBehaviourFactory
 * @model kind="package"
 * @generated
 */
public interface CustomerBehaviourPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "customerBehaviour";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mit.bme.hu/mdsd/appstore/customer-behaviour";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "customerBehaviour";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomerBehaviourPackage eINSTANCE = customerBehaviour.impl.CustomerBehaviourPackageImpl.init();

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.CustomerBehaviourImpl <em>Customer Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.CustomerBehaviourImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomerBehaviour()
	 * @generated
	 */
	int CUSTOMER_BEHAVIOUR = 0;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_BEHAVIOUR__CUSTOMERS = 0;

	/**
	 * The feature id for the '<em><b>Developers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_BEHAVIOUR__DEVELOPERS = 1;

	/**
	 * The feature id for the '<em><b>Similarity Scores</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES = 2;

	/**
	 * The number of structural features of the '<em>Customer Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_BEHAVIOUR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.DeveloperImpl <em>Developer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.DeveloperImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getDeveloper()
	 * @generated
	 */
	int DEVELOPER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Authored Apps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER__AUTHORED_APPS = 1;

	/**
	 * The number of structural features of the '<em>Developer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.AppImpl <em>App</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.AppImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getApp()
	 * @generated
	 */
	int APP = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Age Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__AGE_RESTRICTION = 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__CATEGORY = 2;

	/**
	 * The feature id for the '<em><b>Developer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__DEVELOPER = 3;

	/**
	 * The feature id for the '<em><b>Current Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__CURRENT_PRICE = 4;

	/**
	 * The feature id for the '<em><b>Purchases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__PURCHASES = 5;

	/**
	 * The number of structural features of the '<em>App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.CustomerImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 3;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__DATE_OF_BIRTH = 2;

	/**
	 * The feature id for the '<em><b>Purchases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PURCHASES = 3;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.PurchaseImpl <em>Purchase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.PurchaseImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getPurchase()
	 * @generated
	 */
	int PURCHASE = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE__DATE = 0;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE__CUSTOMER = 1;

	/**
	 * The feature id for the '<em><b>App</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE__APP = 2;

	/**
	 * The feature id for the '<em><b>At Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE__AT_PRICE = 3;

	/**
	 * The number of structural features of the '<em>Purchase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link customerBehaviour.impl.CustomerSimilarityScoreImpl <em>Customer Similarity Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.impl.CustomerSimilarityScoreImpl
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomerSimilarityScore()
	 * @generated
	 */
	int CUSTOMER_SIMILARITY_SCORE = 5;

	/**
	 * The feature id for the '<em><b>Customer1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SIMILARITY_SCORE__CUSTOMER1 = 0;

	/**
	 * The feature id for the '<em><b>Customer2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SIMILARITY_SCORE__CUSTOMER2 = 1;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SIMILARITY_SCORE__SCORE = 2;

	/**
	 * The number of structural features of the '<em>Customer Similarity Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_SIMILARITY_SCORE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link customerBehaviour.AppCategory <em>App Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see customerBehaviour.AppCategory
	 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getAppCategory()
	 * @generated
	 */
	int APP_CATEGORY = 6;


	/**
	 * Returns the meta object for class '{@link customerBehaviour.CustomerBehaviour <em>Customer Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Behaviour</em>'.
	 * @see customerBehaviour.CustomerBehaviour
	 * @generated
	 */
	EClass getCustomerBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link customerBehaviour.CustomerBehaviour#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see customerBehaviour.CustomerBehaviour#getCustomers()
	 * @see #getCustomerBehaviour()
	 * @generated
	 */
	EReference getCustomerBehaviour_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link customerBehaviour.CustomerBehaviour#getDevelopers <em>Developers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Developers</em>'.
	 * @see customerBehaviour.CustomerBehaviour#getDevelopers()
	 * @see #getCustomerBehaviour()
	 * @generated
	 */
	EReference getCustomerBehaviour_Developers();

	/**
	 * Returns the meta object for the containment reference list '{@link customerBehaviour.CustomerBehaviour#getSimilarityScores <em>Similarity Scores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Similarity Scores</em>'.
	 * @see customerBehaviour.CustomerBehaviour#getSimilarityScores()
	 * @see #getCustomerBehaviour()
	 * @generated
	 */
	EReference getCustomerBehaviour_SimilarityScores();

	/**
	 * Returns the meta object for class '{@link customerBehaviour.Developer <em>Developer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Developer</em>'.
	 * @see customerBehaviour.Developer
	 * @generated
	 */
	EClass getDeveloper();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Developer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see customerBehaviour.Developer#getName()
	 * @see #getDeveloper()
	 * @generated
	 */
	EAttribute getDeveloper_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link customerBehaviour.Developer#getAuthoredApps <em>Authored Apps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Authored Apps</em>'.
	 * @see customerBehaviour.Developer#getAuthoredApps()
	 * @see #getDeveloper()
	 * @generated
	 */
	EReference getDeveloper_AuthoredApps();

	/**
	 * Returns the meta object for class '{@link customerBehaviour.App <em>App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App</em>'.
	 * @see customerBehaviour.App
	 * @generated
	 */
	EClass getApp();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.App#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see customerBehaviour.App#getTitle()
	 * @see #getApp()
	 * @generated
	 */
	EAttribute getApp_Title();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.App#getAgeRestriction <em>Age Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age Restriction</em>'.
	 * @see customerBehaviour.App#getAgeRestriction()
	 * @see #getApp()
	 * @generated
	 */
	EAttribute getApp_AgeRestriction();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.App#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see customerBehaviour.App#getCategory()
	 * @see #getApp()
	 * @generated
	 */
	EAttribute getApp_Category();

	/**
	 * Returns the meta object for the container reference '{@link customerBehaviour.App#getDeveloper <em>Developer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Developer</em>'.
	 * @see customerBehaviour.App#getDeveloper()
	 * @see #getApp()
	 * @generated
	 */
	EReference getApp_Developer();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.App#getCurrentPrice <em>Current Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Price</em>'.
	 * @see customerBehaviour.App#getCurrentPrice()
	 * @see #getApp()
	 * @generated
	 */
	EAttribute getApp_CurrentPrice();

	/**
	 * Returns the meta object for the reference list '{@link customerBehaviour.App#getPurchases <em>Purchases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Purchases</em>'.
	 * @see customerBehaviour.App#getPurchases()
	 * @see #getApp()
	 * @generated
	 */
	EReference getApp_Purchases();

	/**
	 * Returns the meta object for class '{@link customerBehaviour.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see customerBehaviour.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Customer#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see customerBehaviour.Customer#getFirstName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Customer#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see customerBehaviour.Customer#getLastName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_LastName();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Customer#getDateOfBirth <em>Date Of Birth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Of Birth</em>'.
	 * @see customerBehaviour.Customer#getDateOfBirth()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_DateOfBirth();

	/**
	 * Returns the meta object for the containment reference list '{@link customerBehaviour.Customer#getPurchases <em>Purchases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Purchases</em>'.
	 * @see customerBehaviour.Customer#getPurchases()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Purchases();

	/**
	 * Returns the meta object for class '{@link customerBehaviour.Purchase <em>Purchase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Purchase</em>'.
	 * @see customerBehaviour.Purchase
	 * @generated
	 */
	EClass getPurchase();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Purchase#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see customerBehaviour.Purchase#getDate()
	 * @see #getPurchase()
	 * @generated
	 */
	EAttribute getPurchase_Date();

	/**
	 * Returns the meta object for the container reference '{@link customerBehaviour.Purchase#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Customer</em>'.
	 * @see customerBehaviour.Purchase#getCustomer()
	 * @see #getPurchase()
	 * @generated
	 */
	EReference getPurchase_Customer();

	/**
	 * Returns the meta object for the reference '{@link customerBehaviour.Purchase#getApp <em>App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>App</em>'.
	 * @see customerBehaviour.Purchase#getApp()
	 * @see #getPurchase()
	 * @generated
	 */
	EReference getPurchase_App();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.Purchase#getAtPrice <em>At Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Price</em>'.
	 * @see customerBehaviour.Purchase#getAtPrice()
	 * @see #getPurchase()
	 * @generated
	 */
	EAttribute getPurchase_AtPrice();

	/**
	 * Returns the meta object for class '{@link customerBehaviour.CustomerSimilarityScore <em>Customer Similarity Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Similarity Score</em>'.
	 * @see customerBehaviour.CustomerSimilarityScore
	 * @generated
	 */
	EClass getCustomerSimilarityScore();

	/**
	 * Returns the meta object for the reference '{@link customerBehaviour.CustomerSimilarityScore#getCustomer1 <em>Customer1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer1</em>'.
	 * @see customerBehaviour.CustomerSimilarityScore#getCustomer1()
	 * @see #getCustomerSimilarityScore()
	 * @generated
	 */
	EReference getCustomerSimilarityScore_Customer1();

	/**
	 * Returns the meta object for the reference '{@link customerBehaviour.CustomerSimilarityScore#getCustomer2 <em>Customer2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer2</em>'.
	 * @see customerBehaviour.CustomerSimilarityScore#getCustomer2()
	 * @see #getCustomerSimilarityScore()
	 * @generated
	 */
	EReference getCustomerSimilarityScore_Customer2();

	/**
	 * Returns the meta object for the attribute '{@link customerBehaviour.CustomerSimilarityScore#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see customerBehaviour.CustomerSimilarityScore#getScore()
	 * @see #getCustomerSimilarityScore()
	 * @generated
	 */
	EAttribute getCustomerSimilarityScore_Score();

	/**
	 * Returns the meta object for enum '{@link customerBehaviour.AppCategory <em>App Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>App Category</em>'.
	 * @see customerBehaviour.AppCategory
	 * @generated
	 */
	EEnum getAppCategory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomerBehaviourFactory getCustomerBehaviourFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.CustomerBehaviourImpl <em>Customer Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.CustomerBehaviourImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomerBehaviour()
		 * @generated
		 */
		EClass CUSTOMER_BEHAVIOUR = eINSTANCE.getCustomerBehaviour();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_BEHAVIOUR__CUSTOMERS = eINSTANCE.getCustomerBehaviour_Customers();

		/**
		 * The meta object literal for the '<em><b>Developers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_BEHAVIOUR__DEVELOPERS = eINSTANCE.getCustomerBehaviour_Developers();

		/**
		 * The meta object literal for the '<em><b>Similarity Scores</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_BEHAVIOUR__SIMILARITY_SCORES = eINSTANCE.getCustomerBehaviour_SimilarityScores();

		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.DeveloperImpl <em>Developer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.DeveloperImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getDeveloper()
		 * @generated
		 */
		EClass DEVELOPER = eINSTANCE.getDeveloper();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER__NAME = eINSTANCE.getDeveloper_Name();

		/**
		 * The meta object literal for the '<em><b>Authored Apps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVELOPER__AUTHORED_APPS = eINSTANCE.getDeveloper_AuthoredApps();

		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.AppImpl <em>App</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.AppImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getApp()
		 * @generated
		 */
		EClass APP = eINSTANCE.getApp();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP__TITLE = eINSTANCE.getApp_Title();

		/**
		 * The meta object literal for the '<em><b>Age Restriction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP__AGE_RESTRICTION = eINSTANCE.getApp_AgeRestriction();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP__CATEGORY = eINSTANCE.getApp_Category();

		/**
		 * The meta object literal for the '<em><b>Developer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP__DEVELOPER = eINSTANCE.getApp_Developer();

		/**
		 * The meta object literal for the '<em><b>Current Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP__CURRENT_PRICE = eINSTANCE.getApp_CurrentPrice();

		/**
		 * The meta object literal for the '<em><b>Purchases</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP__PURCHASES = eINSTANCE.getApp_Purchases();

		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.CustomerImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__FIRST_NAME = eINSTANCE.getCustomer_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__LAST_NAME = eINSTANCE.getCustomer_LastName();

		/**
		 * The meta object literal for the '<em><b>Date Of Birth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__DATE_OF_BIRTH = eINSTANCE.getCustomer_DateOfBirth();

		/**
		 * The meta object literal for the '<em><b>Purchases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__PURCHASES = eINSTANCE.getCustomer_Purchases();

		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.PurchaseImpl <em>Purchase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.PurchaseImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getPurchase()
		 * @generated
		 */
		EClass PURCHASE = eINSTANCE.getPurchase();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURCHASE__DATE = eINSTANCE.getPurchase_Date();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PURCHASE__CUSTOMER = eINSTANCE.getPurchase_Customer();

		/**
		 * The meta object literal for the '<em><b>App</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PURCHASE__APP = eINSTANCE.getPurchase_App();

		/**
		 * The meta object literal for the '<em><b>At Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURCHASE__AT_PRICE = eINSTANCE.getPurchase_AtPrice();

		/**
		 * The meta object literal for the '{@link customerBehaviour.impl.CustomerSimilarityScoreImpl <em>Customer Similarity Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.impl.CustomerSimilarityScoreImpl
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getCustomerSimilarityScore()
		 * @generated
		 */
		EClass CUSTOMER_SIMILARITY_SCORE = eINSTANCE.getCustomerSimilarityScore();

		/**
		 * The meta object literal for the '<em><b>Customer1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_SIMILARITY_SCORE__CUSTOMER1 = eINSTANCE.getCustomerSimilarityScore_Customer1();

		/**
		 * The meta object literal for the '<em><b>Customer2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER_SIMILARITY_SCORE__CUSTOMER2 = eINSTANCE.getCustomerSimilarityScore_Customer2();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER_SIMILARITY_SCORE__SCORE = eINSTANCE.getCustomerSimilarityScore_Score();

		/**
		 * The meta object literal for the '{@link customerBehaviour.AppCategory <em>App Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see customerBehaviour.AppCategory
		 * @see customerBehaviour.impl.CustomerBehaviourPackageImpl#getAppCategory()
		 * @generated
		 */
		EEnum APP_CATEGORY = eINSTANCE.getAppCategory();

	}

} //CustomerBehaviourPackage
