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
		//EntityManager l�trehoz�sa:
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
		
		//Ellen�rz�m a felhaszn�l�nevet
		if(!isGoodName(userName))
		{
			result=false;
		}
		//Megpr�b�lunk loginolni
		else if(login(userName)!=null)
		{
			result=false;
		}
		//K�l�nben megpr�b�lunk csin�lni egy User-t
		else
		{
			// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
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
			
			// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
			entityManager.getTransaction().commit();
			result = true;
		}
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		return result;
	}
	
	public static Boolean deleteProfile(Long userID)
	{
		//EntityManager l�trehoz�sa:
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
			
			// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
			entityManager.getTransaction().begin();
			
			entityManager.remove(u);
			
			// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
			entityManager.getTransaction().commit();
			
			hasDeleted=true;
		}
		// EntityManager lez�r�sa:
		entityManager.close();
		
		return hasDeleted;
	}
	
	public static Long login(String userName)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
		
		if(!isGoodName(userName))
		{
			// EntityManager lez�r�sa:
			entityManager.close();
			return null;
			}
		else
		{
			//A modell szerint az al�bbi query-ket haszn�lja a f�ggv�ny:
			List<User> userWithNameResult = entityManager.createQuery("SELECT u From User u Where u.userName = \"" + userName+"\"").getResultList();
			
			// EntityManager lez�r�sa:
			entityManager.close();
			
			if(userWithNameResult.isEmpty()) return null;
			else return userWithNameResult.get(0).getId();
		}
	}

	public static Boolean IsMatchingPasswordHash(Long userID,
			Integer passwordHash)
	{
		if(userID==null) return false;
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
					hu.bme.mit.inf.evilstore.UserManagement.interfaces.RegistrationServiceHelper.getEntityManager();
				
		//A modell szerint az al�bbi query-ket haszn�lja a f�ggv�ny:
		List<User> userWithIDResult = entityManager.createQuery("SELECT u From User u Where u.id = " + userID).getResultList();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		if(userWithIDResult.isEmpty()) return false;
		else return userWithIDResult.get(0).getPasswordHash().equals(passwordHash);
	}
	
	public static Integer userage(Long userID)
	{
		//EntityManager l�trehoz�sa:
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
		// EntityManager lez�r�sa:
		entityManager.close();
		
		return age;
	}
}
