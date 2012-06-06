package hu.bme.mit.inf.evilstore.UploadApplication.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import java.sql.Date;

import hu.bme.mit.inf.evilstore.entities.*;
import hu.bme.mit.inf.evilstore.entitycollections.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Path("/UploadApplication")
public class UploadApplicationServiceHelper implements IUploadApplicationService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@PUT
	@Path("/upload/{appName}/{developerId}/{version}/{desc}/{cost}/{progfile}/{appType}/{ageRestriction}")
	@Produces("text/plain")
	@Override
	public String upload(@PathParam("appName") String appNameInput, @PathParam("developerId") String developerIdInput, @PathParam("version") String versionInput, @PathParam("desc") String descInput, @PathParam("cost") String costInput, @PathParam("progfile") String progfileInput, @PathParam("appType") String appTypeInput, @PathParam("ageRestriction") String ageRestrictionInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		String appName;
		try {
			appName = objectMapper.readValue(appNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"appName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"appName\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"appName\"!";
		}
		Long developerId;
		try {
			developerId = objectMapper.readValue(developerIdInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"developerId\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"developerId\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"developerId\"!";
		}
		Integer version;
		try {
			version = objectMapper.readValue(versionInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"version\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"version\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"version\"!";
		}
		String desc;
		try {
			desc = objectMapper.readValue(descInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"desc\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"desc\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"desc\"!";
		}
		Integer cost;
		try {
			cost = objectMapper.readValue(costInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"cost\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"cost\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"cost\"!";
		}
		String progfile;
		try {
			progfile = objectMapper.readValue(progfileInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"progfile\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"progfile\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"progfile\"!";
		}
		ArrayList<String> appType;
		try {
			appType = objectMapper.readValue(appTypeInput, ArrayListvStringv.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"appType\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"appType\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"appType\"!";
		}
		Integer ageRestriction;
		try {
			ageRestriction = objectMapper.readValue(ageRestrictionInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"ageRestriction\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"ageRestriction\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"ageRestriction\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.UploadApplication.implementations.UploadApplicationService.upload(appName, developerId, version, desc, cost, progfile, appType, ageRestriction);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"Boolean\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
	
	@PUT
	@Path("/setValidated/{ApplicationID}/{isValid}")
	@Produces("text/plain")
	@Override
	public String setValidated(@PathParam("ApplicationID") String ApplicationIDInput, @PathParam("isValid") String isValidInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Long ApplicationID;
		try {
			ApplicationID = objectMapper.readValue(ApplicationIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"ApplicationID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"ApplicationID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"ApplicationID\"!";
		}
		Boolean isValid;
		try {
			isValid = objectMapper.readValue(isValidInput, Boolean.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"isValid\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"isValid\" param�terb�l egy \"Boolean\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"isValid\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.UploadApplication.implementations.UploadApplicationService.setValidated(ApplicationID, isValid);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"Boolean\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
}
