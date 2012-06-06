package hu.bme.mit.inf.evilstore.UploadApplication.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UploadApplicationService{
	
	public static Boolean upload(String appName, Long developerId, Integer version, String desc, Integer cost, String progfile, ArrayList<String> appType, Integer ageRestriction)
	{
		//EntityManager létrehozása:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UploadApplication.interfaces.UploadApplicationServiceHelper.getEntityManager();
		
		// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
		entityManager.getTransaction().begin();
		
		// Applikáció létrehozása:
		Application a=new Application();
		a.setApplicationName(appName);
		a.setDeveloperId(developerId);
		a.setVersion(version);
		ApplicationDescription adesc=new ApplicationDescription();
		adesc.setDescriptionText(desc);
		adesc.setApplicationType(appType);
		adesc.setAgeRestriction(ageRestriction);
		a.setDescription(adesc);
		a.setCost(cost);
		ProgramData pdata=new ProgramData();
		pdata.setProgramFile(progfile);
		a.setChecked(false);
		a.setValidated(false);
		
		// Új elem létrehozása és mentése a következõképpen történik:
		entityManager.persist(adesc);
		entityManager.persist(pdata);
		a.setProgramDataID(pdata.getId());
		entityManager.persist(a);
		
		// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lezárása:
		entityManager.close();
		
		//De ez a függvény még nincs kész:
		return true;
	}

	public static Boolean setValidated(Long applicationID, Boolean isValid) {
		//EntityManager létrehozása:
		EntityManager entityManager =
				hu.bme.mit.inf.evilstore.UploadApplication.interfaces.UploadApplicationServiceHelper.getEntityManager();
		
		// Lekérdezzük az App-t az id alapján.
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+ "\"").getResultList();
		Boolean result = false;
		if(!appResult.isEmpty())
		{
			Application a = appResult.get(0);
			if(!a.getChecked())
			{
			// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
			entityManager.getTransaction().begin();
			
			a.setChecked(true);
			a.setValidated(isValid);
			result=true;
			
			// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
			entityManager.getTransaction().commit();
			}
		}
		
		// EntityManager lezárása:
		entityManager.close();
		
		return result;
				
	}
}

