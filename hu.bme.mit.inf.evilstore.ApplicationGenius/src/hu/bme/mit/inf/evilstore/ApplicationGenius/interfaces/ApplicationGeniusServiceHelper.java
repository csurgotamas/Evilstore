package hu.bme.mit.inf.evilstore.ApplicationGenius.interfaces;

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

@Path("/ApplicationGenius")
public class ApplicationGeniusServiceHelper implements IApplicationGeniusService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@GET
	@Path("/getUsers")
	@Produces("text/plain")
	@Override
	public String getUsers()
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Mûvelet végrahajtása:
		ArrayList<User> result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.getUsers();
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ArrayList<User>\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/getSelectedUser/{userID}")
	@Produces("text/plain")
	@Override
	public String getSelectedUser(@PathParam("userID") String userIDInput)
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
		User result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.getSelectedUser(userID);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"User\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@POST
	@Path("/classifyType/{age}")
	@Produces("text/plain")
	@Override
	public String classifyType(@PathParam("age") String ageInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		Integer age;
		try {
			age = objectMapper.readValue(ageInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"age\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"age\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"age\"!";
		}
		
		//Mûvelet végrahajtása:
		String result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.classifyType(age);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/GetSimilarities")
	@Produces("text/plain")
	@Override
	public String GetSimilarities()
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Mûvelet végrahajtása:
		ArrayList<CustomerSimilarityScore> result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.GetSimilarities();
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"ArrayList<CustomerSimilarityScore>\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
}
