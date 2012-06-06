package hu.bme.mit.inf.evilstore.UserManagement.implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RegistrationService{
	
	private static boolean isGoodName(String name)
	{
		Pattern p = Pattern.compile("^[A-Za-z0-9]+$"); 
		return p.matcher(name).matches();
	}
	
	public static Boolean registerNewUser(String userName, String accountId, Integer passwordHash, String birth)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
		
		boolean result;
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		Date date = null ;
		try {
			date = (Date)formatter.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		
		//Ellenõrzöm a felhasználónevet
		if(!isGoodName(userName))
		{
			result=false;
		}
		//Megpróbálunk loginolni
		else if(login(userName)!=null)
		{
			result=false;
		}
		//Különben megpróbálunk csinálni egy User-t
		else
		{
			// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
			entityManager.getTransaction().begin();
			
			Account account = new Account();
			account.setAccountId(accountId);
			account.setCash(0);
			
			User user = new User();
			user.setUserName(userName);
			user.setAccount(account);
			user.setPasswordHash(passwordHash);
			user.setBirth(date.getTime());
			
			entityManager.persist(account);
			entityManager.persist(user);
			
			// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
			entityManager.getTransaction().commit();
			result = true;
		}
		
		// EntityManager lezárása:
		entityManager.close();
		
		return result;
	}
	
	public static Boolean deleteProfile(Long userID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
		
		boolean hasDeleted=true;
		
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		if(userWithIDResult.isEmpty())
		{
			hasDeleted=false;
		}
		else
		{
			User u = userWithIDResult.get(0);
			
			// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
			entityManager.getTransaction().begin();
			
			entityManager.remove(u);
			
			// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
			entityManager.getTransaction().commit();
			
			hasDeleted=true;
		}
		// EntityManager lezárása:
		entityManager.close();
		
		return hasDeleted;
	}
	
	public static Long login(String userName)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
		
		if(!isGoodName(userName))
		{
			// EntityManager lezárása:
			entityManager.close();
			return null;
			}
		else
		{
			//A modell szerint az alábbi query-ket használja a függvény:
			List<User> userWithNameResult = entityManager.createQuery("SELECT u From User u Where u.userName = \"" + userName+"\"").getResultList();
			
			// EntityManager lezárása:
			entityManager.close();
			
			if(userWithNameResult.isEmpty()) return null;
			else return userWithNameResult.get(0).getId();
		}
	}

	public static Boolean IsMatchingPasswordHash(Long userID,
			Integer passwordHash)
	{
		if(userID==null) return false;
		//EntityManager létrehozása:
		EntityManager entityManager =
					hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
				
		//A modell szerint az alábbi query-ket használja a függvény:
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		
		// EntityManager lezárása:
		entityManager.close();
		
		if(userWithIDResult.isEmpty()) return false;
		else return userWithIDResult.get(0).getPasswordHash().equals(passwordHash);
	}
	
	public static Integer userage(Long userID)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
		
		Integer age=0;
		
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		if(!userWithIDResult.isEmpty())
		{
			User u = userWithIDResult.get(0);
			Date birthdate=new Date(u.getBirth());
			Date now=new java.util.Date();
			age=now.getYear()-birthdate.getYear();
			if(now.getMonth()<birthdate.getMonth()){
				age--;
			}else if(now.getMonth()==birthdate.getMonth() && now.getDay()<birthdate.getDay()){
				age--;
			}
		}
		// EntityManager lezárása:
		entityManager.close();
		
		return age;
	}
}
