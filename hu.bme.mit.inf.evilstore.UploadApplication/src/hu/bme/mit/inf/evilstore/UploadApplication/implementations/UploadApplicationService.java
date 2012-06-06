package hu.bme.mit.inf.evilstore.UploadApplication.implementations;

import java.util.List;
import java.util.ArrayList;

import hu.bme.mit.inf.evilstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UploadApplicationService{
	
	public static Boolean upload(String appName, Long developerId, Integer version, String desc, Integer cost, String progfile, ArrayList<String> appType, Integer ageRestriction)
	{
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
			hu.bme.mit.inf.evilstore.UploadApplication.interfaces.UploadApplicationServiceHelper.getEntityManager();
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
		entityManager.getTransaction().begin();
		
		// Applik�ci� l�trehoz�sa:
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
		
		// �j elem l�trehoz�sa �s ment�se a k�vetkez�k�ppen t�rt�nik:
		entityManager.persist(adesc);
		entityManager.persist(pdata);
		a.setProgramDataID(pdata.getId());
		entityManager.persist(a);
		
		// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
		entityManager.getTransaction().commit();
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		//De ez a f�ggv�ny m�g nincs k�sz:
		return true;
	}

	public static Boolean setValidated(Long applicationID, Boolean isValid) {
		//EntityManager l�trehoz�sa:
		EntityManager entityManager =
				hu.bme.mit.inf.evilstore.UploadApplication.interfaces.UploadApplicationServiceHelper.getEntityManager();
		
		// Lek�rdezz�k az App-t az id alapj�n.
		List<Application> appResult = entityManager.createQuery("SELECT a From Application a Where a.id = \"" + applicationID+ "\"").getResultList();
		Boolean result = false;
		if(!appResult.isEmpty())
		{
			Application a = appResult.get(0);
			if(!a.getChecked())
			{
			// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
			entityManager.getTransaction().begin();
			
			a.setChecked(true);
			a.setValidated(isValid);
			result=true;
			
			// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
			entityManager.getTransaction().commit();
			}
		}
		
		// EntityManager lez�r�sa:
		entityManager.close();
		
		return result;
				
	}
}

