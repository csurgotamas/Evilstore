package hu.bme.mit.inf.evilstore.ViewApplications.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ViewService{
	
	public static ArrayList<Application> viewUncheckedApplication()
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lek�rdezz�k a nem fel�lvizsg�lt Alkalmaz�sokat:
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.checked = false").getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		// Visszaadjuk a list�t:
		return new ArrayList<Application>(appResult);
	}
	
	public static ArrayList<Application> viewValidatedApplication()
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lek�rdezz�k a valid�lt alkalmaz�sokat:
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.validated = true And a.checked = true").getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		// Visszaadjuk a list�t:
		return new ArrayList<Application>(appResult);
	}
	
	public static ArrayList<Application> viewBuyedApplication(Long userID)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lek�rdezz�k a Usert az id alapj�n:
		List<User> userResult = entityManager.createQuery("SELECT u From User u Where u.id = \"" + userID+ "\"").getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		// Ha nincs tal�lat:
				if (userResult.isEmpty())
					return null;
		
		// Visszadjuk a list�t:
		ArrayList<Application> applications= new ArrayList<Application>();
		for(Purchase purchase : userResult.get(0).getPurchasedApplications())
			applications.add(purchase.getApplication());
		
		return applications;
	}
	
	public static ApplicationDescription viewApplicationDetails(Long applicationID)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ViewApplications.interfaces.ViewServiceHelper.getEntityManager();
		
		// Lek�rdezz�k az App-t az id alapj�n.
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+ "\"").getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		// Ha nincs tal�lat:
				if (appResult.isEmpty())
					return null;
		
		//De ez a f�ggv�ny m�g nincs k�sz:
		return appResult.get(0).getDescription();
	}
}
