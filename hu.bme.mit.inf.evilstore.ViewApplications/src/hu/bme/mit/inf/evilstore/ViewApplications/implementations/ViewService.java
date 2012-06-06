package hu.bme.mit.inf.evilstore.ViewApplications.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ViewService{
	
	public static ArrayList<Application> viewUncheckedApplication()
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lekérdezzük a nem felülvizsgált Alkalmazásokat:
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.checked = false").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		// Visszaadjuk a listát:
		return new ArrayList<Application>(appResult);
	}
	
	public static ArrayList<Application> viewValidatedApplication()
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lekérdezzük a validált alkalmazásokat:
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.validated = true And a.checked = true").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		// Visszaadjuk a listát:
		return new ArrayList<Application>(appResult);
	}
	
	public static ArrayList<Application> viewBuyedApplication(Long userID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lekérdezzük a Usert az id alapján:
		List<User> userResult = entityManager.createQuery("SELECT u From User u Where u.id = \"" + userID+ "\"").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		// Ha nincs találat:
				if (userResult.isEmpty())
					return null;
		
		// Visszadjuk a listát:
		ArrayList<Application> applications= new ArrayList<Application>();
		for(Purchase purchase : userResult.get(0).getPurchasedApplications())
			applications.add(purchase.getApplication());
		
		return applications;
	}
	
	public static ApplicationDescription viewApplicationDetails(Long applicationID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lekérdezzük az App-t az id alapján.
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+ "\"").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		// Ha nincs találat:
				if (appResult.isEmpty())
					return null;
		
		//De ez a függvény még nincs kész:
		return appResult.get(0).getDescription();
	}
}
