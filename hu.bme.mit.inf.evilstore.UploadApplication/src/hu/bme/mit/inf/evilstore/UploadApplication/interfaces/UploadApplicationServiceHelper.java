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
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		String appName;
		try {
			appName = objectMapper.readValue(appNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"appName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"appName\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"appName\"!";
		}
		Long developerId;
		try {
			developerId = objectMapper.readValue(developerIdInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"developerId\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"developerId\" paraméterbõl egy \"Long\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"developerId\"!";
		}
		Integer version;
		try {
			version = objectMapper.readValue(versionInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"version\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"version\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"version\"!";
		}
		String desc;
		try {
			desc = objectMapper.readValue(descInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"desc\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"desc\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"desc\"!";
		}
		Integer cost;
		try {
			cost = objectMapper.readValue(costInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"cost\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"cost\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"cost\"!";
		}
		String progfile;
		try {
			progfile = objectMapper.readValue(progfileInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"progfile\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"progfile\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"progfile\"!";
		}
		ArrayList<String> appType;
		try {
			appType = objectMapper.readValue(appTypeInput, ArrayListvStringv.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"appType\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"appType\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"appType\"!";
		}
		Integer ageRestriction;
		try {
			ageRestriction = objectMapper.readValue(ageRestrictionInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"ageRestriction\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"ageRestriction\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"ageRestriction\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.UploadApplication.implementations.UploadApplicationService.upload(appName, developerId, version, desc, cost, progfile, appType, ageRestriction);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"Boolean\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@PUT
	@Path("/setValidated/{ApplicationID}/{isValid}")
	@Produces("text/plain")
	@Override
	public String setValidated(@PathParam("ApplicationID") String ApplicationIDInput, @PathParam("isValid") String isValidInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		Long ApplicationID;
		try {
			ApplicationID = objectMapper.readValue(ApplicationIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"ApplicationID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"ApplicationID\" paraméterbõl egy \"Long\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"ApplicationID\"!";
		}
		Boolean isValid;
		try {
			isValid = objectMapper.readValue(isValidInput, Boolean.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"isValid\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"isValid\" paraméterbõl egy \"Boolean\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"isValid\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.UploadApplication.implementations.UploadApplicationService.setValidated(ApplicationID, isValid);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"Boolean\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
}
