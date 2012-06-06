package hu.bme.mit.inf.evilstore.UserManagement.interfaces;

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

@Path("/Registration")
public class RegistrationServiceHelper implements IRegistrationService {
	
	public static EntityManager getEntityManager()
	{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
			return factory.createEntityManager();
	}
	
	
	@PUT
	@Path("/registerNewUser/{userName}/{accountId}/{passwordHash}/{birth}")
	@Produces("text/plain")
	@Override
	public String registerNewUser(@PathParam("userName") String userNameInput, @PathParam("accountId") String accountIdInput, @PathParam("passwordHash") String passwordHashInput, @PathParam("birth") String birthInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		String userName;
		try {
			userName = objectMapper.readValue(userNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"userName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"userName\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"userName\"!";
		}
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
		Integer passwordHash;
		try {
			passwordHash = objectMapper.readValue(passwordHashInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"passwordHash\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"passwordHash\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"passwordHash\"!";
		}
		String birth;
		try {
			birth = objectMapper.readValue(birthInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"birth\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"birth\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"birth\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.registerNewUser(userName, accountId, passwordHash, birth);
		
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
	@Path("/deleteProfile/{userID}")
	@Produces("text/plain")
	@Override
	public String deleteProfile(@PathParam("userID") String userIDInput)
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
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.deleteProfile(userID);
		
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
	@Path("/login/{userName}")
	@Produces("text/plain")
	@Override
	public String login(@PathParam("userName") String userNameInput)
	{
		//Objektumok parse-olása a bemenetbõl.
		ObjectMapper objectMapper = new ObjectMapper();
		String userName;
		try {
			userName = objectMapper.readValue(userNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"userName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"userName\" paraméterbõl egy \"String\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"userName\"!";
		}
		
		//Mûvelet végrahajtása:
		Long result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.login(userName);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"Long\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
	
	@GET
	@Path("/IsMatchingPasswordHash/{userID}/{passwordHash}")
	@Produces("text/plain")
	@Override
	public String IsMatchingPasswordHash(@PathParam("userID") String userIDInput, @PathParam("passwordHash") String passwordHashInput)
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
		Integer passwordHash;
		try {
			passwordHash = objectMapper.readValue(passwordHashInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"passwordHash\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült kiolvasni a(z) \"passwordHash\" paraméterbõl egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"passwordHash\"!";
		}
		
		//Mûvelet végrahajtása:
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.IsMatchingPasswordHash(userID, passwordHash);
		
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
	@Path("/userage/{userID}")
	@Produces("text/plain")
	@Override
	public String userage(@PathParam("userID") String userIDInput)
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
		Integer result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.userage(userID);
		
		//Eredmény sorosítása:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
		} catch (JsonMappingException e) {
			return "Error: Nem sikerült írni egy \"Integer\" példányt!";
		} catch (IOException e) {
			return "Error: Nem sikerült kiírni a mûvelet eredményét!";
		}
	}
}
