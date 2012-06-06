package hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces;

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

@Path("/BuyApplication")
public class BuyApplicationServiceHelper implements IBuyApplicationService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@PUT
	@Path("/buy/{userID}/{applicationID}")
	@Produces("text/plain")
	@Override
	public String buy(@PathParam("userID") String userIDInput, @PathParam("applicationID") String applicationIDInput)
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
		Boolean result =
			hu.bme.mit.inf.evilstore.ApplicationBuy.implementations.BuyApplicationService.buy(userID, applicationID);
		
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
	
	@GET
	@Path("/download/{applicationID}")
	@Produces("text/plain")
	@Override
	public String download(@PathParam("applicationID") String applicationIDInput)
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
		String result =
			hu.bme.mit.inf.evilstore.ApplicationBuy.implementations.BuyApplicationService.download(applicationID);
		
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
}
