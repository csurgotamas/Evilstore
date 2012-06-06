package hu.bme.mit.inf.evilstore.DataBaseFiller.implementations;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import customerBehaviour.Customer;
import customerBehaviour.CustomerBehaviour;
import customerBehaviour.CustomerBehaviourFactory;
import customerBehaviour.CustomerBehaviourPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FillDataService{
	
	
	private static CustomerBehaviour getCustomerBehaviour(String uri)
	{
		try{		
		CustomerBehaviourPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg =
				Resource.Factory.Registry.INSTANCE;
		
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		//String dataBasePath="file:///D:/MDSDEclipse/runtime-EclipseApplication/hu.bme.mit.evilsystem.DataBaseFiller/model/genius.customerbehaviour";
		// Pl: -> http://localhost:8081/FillData/fill/%22file:%2F%2F%2FD%3A%2FMDSDEclipse%2Fruntime-EclipseApplication%2Fhu.bme.mit.evilsystem.DataBaseFiller%2Fmodel%2Fgenius.customerbehaviour%22
		URI u = URI.createURI(uri);
		u.isFile();
		
		// Get the resource
		Resource resource = resSet.getResource(u, true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		CustomerBehaviour ret = (CustomerBehaviour) resource.getContents().get(0);
		return ret;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	private static Integer getPasswordHash(String password)
	{
		Client client = Client.create();
		ObjectMapper objectMapper= new ObjectMapper();
		String data=password;
		try {
			data = objectMapper.writeValueAsString(password);
		} catch (JsonGenerationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (JsonMappingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			data = URLEncoder.encode(password, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebResource webResource = client.resource(
				"http://localhost:8082/PasswordManagement/Services/PasswordManagement.svc/generatePasswordHash/%22"+data+"%22");
		String ret = webResource.get(String.class);
		
		Integer hash = null;
		try {
			hash = objectMapper.readValue(ret, Integer.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
	
	//Minden kisorosítandó objektumot itt állítjuk elõ.
	private static ArrayList<Object> getTestData(EntityManager e, String uri)
	{
		CustomerBehaviour c = getCustomerBehaviour(uri);
		ArrayList<Object> ret = new ArrayList<Object>();
		Map<customerBehaviour.App, Application> appmap=new HashMap<customerBehaviour.App, Application>();
		Map<customerBehaviour.Customer,User> usermap=new HashMap<customerBehaviour.Customer,User>();
		for(customerBehaviour.Developer dev: c.getDevelopers())
		{
			Developer developer=new Developer();
			developer.setName(dev.getName());
			Account account = new Account();
			account.setAccountId("00000000-00000001-"+developer.getName().hashCode());
			account.setCash(0);
			developer.setAccount(account);
			e.persist(account);
			ret.add(developer);e.persist(developer);
			List<Application> apps=new ArrayList<Application>();
			for(customerBehaviour.App app: dev.getAuthoredApps())
			{
				Application application=new Application();
				ApplicationDescription appdesc=new ApplicationDescription();
				
				appdesc.setAgeRestriction(app.getAgeRestriction());
				ArrayList<String> cat=new ArrayList<String>();
				cat.add((app.getCategory().getName()));
				appdesc.setApplicationType(cat);
				
				appdesc.setDescriptionText(app.getCategory().getName());
				e.persist(appdesc);
				application.setDescription(appdesc);
				
				application.setCost((int)(app.getCurrentPrice()+0.5));
				application.setApplicationName(app.getTitle());
				application.setChecked(true);
				
				application.setDeveloperId(developer.getId());
				
				ProgramData pdata = new ProgramData();
				pdata.setProgramFile("This is evil");
				e.persist(pdata);
				application.setProgramDataID(pdata.getId());
				
				application.setValidated(true);
				application.setVersion(1);
				
				appmap.put(app, application);
				apps.add(application);
				e.persist(application);
			}
			developer.setUploadedApplications(apps);
			
			
		}
		
		for(Customer customer : c.getCustomers())
		{
			User user = new User();
			user.setUserName(customer.getFirstName()+customer.getLastName());
			user.setBirth(customer.getDateOfBirth().getTime());
			user.setPasswordHash(getPasswordHash(customer.getLastName()));
			List<Purchase> purchases=new ArrayList<Purchase>();
			for(customerBehaviour.Purchase purch:customer.getPurchases())
			{
				Purchase purchase=new Purchase();
				purchase.setAtPrice((int)(purch.getAtPrice()+0.5));
				purchase.setDate((purch.getDate().getTime()));
				purchase.setApplication(appmap.get(purch.getApp()));
				e.persist(purchase);
				purchases.add(purchase);
			}
			user.setPurchasedApplications(purchases);
			Account account = new Account();
			account.setAccountId("00000000-00000000-"+user.getPasswordHash());
			account.setCash(0);
			user.setAccount(account);
			e.persist(account);
			e.persist(user);
			usermap.put(customer, user);
			ret.add(user);
		}
		for(customerBehaviour.CustomerSimilarityScore custsim:c.getSimilarityScores())
		{
			CustomerSimilarityScore simscore=new CustomerSimilarityScore();
			simscore.setScore(custsim.getScore());
			simscore.setUser1ID(usermap.get(custsim.getCustomer1()).getId());
			simscore.setUser2ID(usermap.get(custsim.getCustomer2()).getId());
			e.persist(simscore);
			ret.add(simscore);
		}
		
		return ret;
	}
	
	public static String fill(String uri)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.DataBaseFiller.interfaces.FillDataServiceHelper.getEntityManager();
		
		ArrayList<Object> datas;
		
		// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
		entityManager.getTransaction().begin();
		
		datas = getTestData(entityManager, uri);
		
		// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lezárása:
		entityManager.close();
		
		try {
			return new ObjectMapper().writeValueAsString(datas);
		} catch (Exception e) {
			return "Exception történt a tesztfeltöltés során";
		}
	}
}
