package hu.bme.mit.inf.evilstore.ApplicationGenius.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

//import hu.bme.mit.inf.evilstore.evilgenius.SelectedUser;

public class ApplicationGeniusService{
	
	/*public static ArrayList<Application> getAdvisedApplications(Long userID)
	{
		//Teszteléshez nem kell adatbázis egyelõre...
		
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.evilsystem.ApplicationGenius.interfaces.ApplicationGeniusServiceHelper.getEntityManager();
		
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		User selectedUser = userWithIDResult.get(0);
		List<User> users = entityManager.createQuery("SELECT u From User u").getResultList();
		List<Application> applications = entityManager.createQuery("SELECT a From Application a").getResultList();
		
		SelectedUser su = new SelectedUser(selectedUser);
		
		// EntityManager lezárása:
		entityManager.close();
		ArrayList<Application> bests = null;
		try {
			bests = com.sample.EvilGEnius.EvilGenius(su,users,applications,5);
		} catch (Exception e) {
			System.out.println("HIBA történt, nem lehet betölteni!");
		}
		
		return bests;
	}*/

	public static ArrayList<User> getUsers() {
		//EntityManager létrehozása:
		EntityManager entityManager =
				hu.bme.mit.inf.evilstore.ApplicationGenius.interfaces.ApplicationGeniusServiceHelper.getEntityManager();
		
		List<User> users = entityManager.createQuery("SELECT u From User u").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		ArrayList<User> ret = new ArrayList<User>(users);
		
		return ret;
	}

	public static User getSelectedUser(Long userID) {
		//EntityManager létrehozása:
		EntityManager entityManager =
				hu.bme.mit.inf.evilstore.ApplicationGenius.interfaces.ApplicationGeniusServiceHelper.getEntityManager();

		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		User selectedUser = userWithIDResult.get(0);
		
		// EntityManager lezárása:
		entityManager.close();
				
		return selectedUser;
	}

	public static String classifyType(Integer age) {
		// TODO Auto-generated method stub
		//return hu.bme.mit.evilsystem.Weka.Classify_type(age.toString());
		return null;
	}

	public static ArrayList<CustomerSimilarityScore> GetSimilarities() {
		//EntityManager létrehozása:
		EntityManager entityManager =
				hu.bme.mit.inf.evilstore.ApplicationGenius.interfaces.ApplicationGeniusServiceHelper.getEntityManager();

		List<CustomerSimilarityScore> customerSimilarityScores = entityManager.createQuery("SELECT u From CustomerSimilarityScore u").getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		return new ArrayList<CustomerSimilarityScore>(customerSimilarityScores);
	}
}
