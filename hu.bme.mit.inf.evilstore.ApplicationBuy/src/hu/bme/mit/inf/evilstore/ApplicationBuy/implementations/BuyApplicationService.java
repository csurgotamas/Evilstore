package hu.bme.mit.inf.evilstore.ApplicationBuy.implementations;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BuyApplicationService{
	
	public static Boolean buy(Long userID, Long applicationID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces.BuyApplicationServiceHelper.getEntityManager();
		
		// Lekérdezzük a User-t és az App-t
		List<User> userResult = entityManager.createQuery("SELECT u From User u Where u.id = \"" + userID+"\"").getResultList();
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+"\"").getResultList();
		
		// Eredmény
		Boolean result;
		
		// Ha bármelyik üres lista, akkor vége
		if(userResult.isEmpty() || appResult.isEmpty())
			result=false;
		else
		{
			// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
			entityManager.getTransaction().begin();
			
			// User-t és App-t kiszedjük:
			User u=userResult.get(0);
			Application a=appResult.get(0);
			// Userhez berakjuk megvásároltként az appot:
			Purchase purchase = new Purchase();
			purchase.setApplication(a);
			purchase.setAtPrice(a.getCost());
			purchase.setDate(new java.util.Date().getTime());
			
			entityManager.persist(purchase);
			u.getPurchasedApplications().add(purchase);
			
			// Új elem létrehozása és mentése a következõképpen történik:
			entityManager.persist(u);
			
			// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
			entityManager.getTransaction().commit();
			
			result=true;
		}	
		// EntityManager lezárása:
		entityManager.close();
			
		return result;
	}
	
	public static String download(Long applicationID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces.BuyApplicationServiceHelper.getEntityManager();
		
		// Lekérdezzük az App-t
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+"\"").getResultList();
		
		// App-t kiszedjük
		Application a=appResult.get(0);		
		
		// Lekérdezzük a ProgramData-t
		List<ProgramData> progdataResult = entityManager.createQuery("SELECT p From ProgramData p Where p.id = \"" + a.getProgramDataID()+"\"").getResultList();
		
		String result;
		// Van-e eredmény:
		if(progdataResult.isEmpty())
			result=null;
		else
			result=progdataResult.get(0).getProgramFile();
		// EntityManager lezárása:
		entityManager.close();
		
		//De ez a függvény még nincs kész:
		return result;
	}
}
