package hu.bme.mit.inf.evilstore.AccountManagement.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AccountManagementService{
	
	public static Boolean transferMoney(String accountId, Integer ammount)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
		
		// Lekérdezi, hogy van-e ilyen id-jû Account:
		List<Account> accountidResult = entityManager.createQuery("SELECT a From Account a Where a.accountId = \"" + accountId+"\"").getResultList();
		
		// Ha nincs vége:
		if(accountidResult.isEmpty()){
			return false;
		}
		
		// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
		entityManager.getTransaction().begin();
		
		// Ha van, akkor 1 darab van ezt ki is szedjük a listából:
		Account account=accountidResult.get(0);
		// Hozzáadunk:
		account.setCash(account.getCash()+ammount);
		
		// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lezárása:
		entityManager.close();
		
		//De ez a függvény még nincs kész:
		return true;
	}
	
	public static Boolean withdrawMoney(String accountId, Integer ammount)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
		
		// Lekérdezi, hogy van-e ilyen id-jû Account:
		List<Account> accountidResult = entityManager.createQuery("SELECT a From Account a Where a.accountId = \"" + accountId +"\"").getResultList();
		
		// Ha nincs vége:
		if(accountidResult.isEmpty()){
			return false;
		}
		
		// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
		entityManager.getTransaction().begin();
		
		// Ha van, akkor 1 darab van ezt ki is szedjük a listából:
		Account account=accountidResult.get(0);
		
		//Ha nincs elegendõ pénz
		if(account.getCash() < ammount)
		{
			return false;
		}
		// Levonunk:
		account.setCash(account.getCash()-ammount);
		
		// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lezárása:
		entityManager.close();
		
		//De ez a függvény még nincs kész:
		return true;
	}

	public static String getAccountOfUser(Long userID) {
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
				
		//A modell szerint az alábbi query-ket használja a függvény:
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		if(userWithIDResult.isEmpty()) return null;
		else return userWithIDResult.get(0).getAccount().getAccountId();
	}
}
