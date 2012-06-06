package hu.bme.mit.inf.evilstore.ViewApplications.interfaces;

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

@Path("/View")
public class ViewServiceHelper implements IViewService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@GET
	@Path("/viewUncheckedApplication")
	@Produces("text/plain")
	@Override
	public String viewUncheckedApplication()
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Mûvelet végrahajtása:
		ArrayList<Application> result =
			hu.bme.mit.inf.evilstore.ViewApplications.implementations.ViewService.viewUncheckedApplication();
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ArrayList<Application>\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/viewValidatedApplication")
	@Produces("text/plain")
	@Override
	public String viewValidatedApplication()
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Mûvelet végrahajtása:
		ArrayList<Application> result =
			hu.bme.mit.inf.evilstore.ViewApplications.implementations.ViewService.viewValidatedApplication();
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ArrayList<Application>\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/viewBuyedApplication/{userID}")
	@Produces("text/plain")
	@Override
	public String viewBuyedApplication(@PathParam("userID") String userIDInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		Long userID;
		try {
			userID = objectMapper.readValue(userIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"userID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"userID\" paraméterbõl egy \"Long\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"userID\"!";
		}
		
		//Mûvelet végrahajtása:
		ArrayList<Application> result =
			hu.bme.mit.inf.evilstore.ViewApplications.implementations.ViewService.viewBuyedApplication(userID);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ArrayList<Application>\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/viewApplicationDetails/{applicationID}")
	@Produces("text/plain")
	@Override
	public String viewApplicationDetails(@PathParam("applicationID") String applicationIDInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		Long applicationID;
		try {
			applicationID = objectMapper.readValue(applicationIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"applicationID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"applicationID\" paraméterbõl egy \"Long\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"applicationID\"!";
		}
		
		//Mûvelet végrahajtása:
		ApplicationDescription result =
			hu.bme.mit.inf.evilstore.ViewApplications.implementations.ViewService.viewApplicationDetails(applicationID);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ApplicationDescription\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
}
