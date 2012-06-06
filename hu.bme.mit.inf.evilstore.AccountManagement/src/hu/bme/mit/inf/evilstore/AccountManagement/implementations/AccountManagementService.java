package hu.bme.mit.inf.evilstore.AccountManagement.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AccountManagementService{
	
	public static Boolean transferMoney(String accountId, Integer ammount)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
		
		// Lek�rdezi, hogy van-e ilyen id-j� Account:
		List<Account> accountidResult = entityManager.createQuery("SELECT a From Account a Where a.accountId = \"" + accountId+"\"").getResultList();
		
		// Ha nincs v�ge:
		if(accountidResult.isEmpty()){
			return false;
		}
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
		entityManager.getTransaction().begin();
		
		// Ha van, akkor 1 darab van ezt ki is szedj�k a list�b�l:
		Account account=accountidResult.get(0);
		// Hozz�adunk:
		account.setCash(account.getCash()+ammount);
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		//De ez a f�ggv�ny m�g nincs k�sz:
		return true;
	}
	
	public static Boolean withdrawMoney(String accountId, Integer ammount)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
		
		// Lek�rdezi, hogy van-e ilyen id-j� Account:
		List<Account> accountidResult = entityManager.createQuery("SELECT a From Account a Where a.accountId = \"" + accountId +"\"").getResultList();
		
		// Ha nincs v�ge:
		if(accountidResult.isEmpty()){
			return false;
		}
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
		entityManager.getTransaction().begin();
		
		// Ha van, akkor 1 darab van ezt ki is szedj�k a list�b�l:
		Account account=accountidResult.get(0);
		
		//Ha nincs elegend� p�nz
		if(account.getCash() < ammount)
		{
			return false;
		}
		// Levonunk:
		account.setCash(account.getCash()-ammount);
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		//De ez a f�ggv�ny m�g nincs k�sz:
		return true;
	}

	public static String getAccountOfUser(Long userID) {
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.AccountManagement.interfaces.AccountManagementServiceHelper.getEntityManager();
				
		//A modell szerint az al�bbi query-ket haszn�lja a f�ggv�ny:
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		if(userWithIDResult.isEmpty()) return null;
		else return userWithIDResult.get(0).getAccount().getAccountId();
	}
}
