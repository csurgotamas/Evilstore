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
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces.BuyApplicationServiceHelper.getEntityManager();
		
		// Lek�rdezz�k a User-t �s az App-t
		List<User> userResult = entityManager.createQuery("SELECT u From User u Where u.id = \"" + userID+"\"").getResultList();
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+"\"").getResultList();
		
		// Eredm�ny
		Boolean result;
		
		// Ha b�rmelyik �res lista, akkor v�ge
		if(userResult.isEmpty() || appResult.isEmpty())
			result=false;
		else
		{
			// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
			entityManager.getTransaction().begin();
			
			// User-t �s App-t kiszedj�k:
			User u=userResult.get(0);
			Application a=appResult.get(0);
			// Userhez berakjuk megv�s�roltk�nt az appot:
			Purchase purchase = new Purchase();
			purchase.setApplication(a);
			purchase.setAtPrice(a.getCost());
			purchase.setDate(new java.util.Date().getTime());
			
			entityManager.persist(purchase);
			u.getPurchasedApplications().add(purchase);
			
			// �j elem l�trehoz�sa �s ment�se a k�vetkez�k�ppen t�rt�nik:
			entityManager.persist(u);
			
			// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
			entityManager.getTransaction().commit();
			
			result=true;
		}	
		// EntityManager lez�r�sa:
		entityManager.close();
			
		return result;
	}
	
	public static String download(Long applicationID)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces.BuyApplicationServiceHelper.getEntityManager();
		
		// Lek�rdezz�k az App-t
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+"\"").getResultList();
		
		// App-t kiszedj�k
		Application a=appResult.get(0);		
		
		// Lek�rdezz�k a ProgramData-t
		List<ProgramData> progdataResult = entityManager.createQuery("SELECT p From ProgramData p Where p.id = \"" + a.getProgramDataID()+"\"").getResultList();
		
		String result;
		// Van-e eredm�ny:
		if(progdataResult.isEmpty())
			result=null;
		else
			result=progdataResult.get(0).getProgramFile();
		// EntityManager lez�r�sa:
		entityManager.close();
		
		//De ez a f�ggv�ny m�g nincs k�sz:
		return result;
	}
}
