package hu.bme.mit.inf.evilstore.AccountManagement.interfaces;

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

@Path("/AccountManagement")
public class AccountManagementServiceHelper implements IAccountManagementService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@POST
	@Path("/transferMoney/{accountId}/{ammount}")
	@Produces("text/plain")
	@Override
	public String transferMoney(@PathParam("accountId") String accountIdInput, @PathParam("ammount") String ammountInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		String accountId;
		try {
			accountId = objectMapper.readValue(accountIdInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"accountId\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"accountId\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"accountId\"!";
		}
		Integer ammount;
		try {
			ammount = objectMapper.readValue(ammountInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"ammount\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"ammount\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"ammount\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.transferMoney(accountId, ammount);
		
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
	
	@POST
	@Path("/withdrawMoney/{accountId}/{ammount}")
	@Produces("text/plain")
	@Override
	public String withdrawMoney(@PathParam("accountId") String accountIdInput, @PathParam("ammount") String ammountInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		String accountId;
		try {
			accountId = objectMapper.readValue(accountIdInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"accountId\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"accountId\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"accountId\"!";
		}
		Integer ammount;
		try {
			ammount = objectMapper.readValue(ammountInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"ammount\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"ammount\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"ammount\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.withdrawMoney(accountId, ammount);
		
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
	@Path("/getAccountOfUser/{userID}")
	@Produces("text/plain")
	@Override
	public String getAccountOfUser(@PathParam("userID") String userIDInput)
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
		String result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.getAccountOfUser(userID);
		
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
