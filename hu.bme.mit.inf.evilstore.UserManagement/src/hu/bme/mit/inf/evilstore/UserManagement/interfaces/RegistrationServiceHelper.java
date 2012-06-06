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
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		String userName;
		try {
			userName = objectMapper.readValue(userNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"userName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"userName\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"userName\"!";
		}
		String accountId;
		try {
			accountId = objectMapper.readValue(accountIdInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"accountId\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"accountId\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"accountId\"!";
		}
		Integer passwordHash;
		try {
			passwordHash = objectMapper.readValue(passwordHashInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"passwordHash\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"passwordHash\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"passwordHash\"!";
		}
		String birth;
		try {
			birth = objectMapper.readValue(birthInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"birth\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"birth\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"birth\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.registerNewUser(userName, accountId, passwordHash, birth);
		
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
	
	@POST
	@Path("/deleteProfile/{userID}")
	@Produces("text/plain")
	@Override
	public String deleteProfile(@PathParam("userID") String userIDInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Long userID;
		try {
			userID = objectMapper.readValue(userIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"userID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"userID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"userID\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.deleteProfile(userID);
		
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
	
	@GET
	@Path("/login/{userName}")
	@Produces("text/plain")
	@Override
	public String login(@PathParam("userName") String userNameInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		String userName;
		try {
			userName = objectMapper.readValue(userNameInput, String.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"userName\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"userName\" param�terb�l egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"userName\"!";
		}
		
		//M�velet v�grahajt�sa:
		Long result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.login(userName);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
	
	@GET
	@Path("/IsMatchingPasswordHash/{userID}/{passwordHash}")
	@Produces("text/plain")
	@Override
	public String IsMatchingPasswordHash(@PathParam("userID") String userIDInput, @PathParam("passwordHash") String passwordHashInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Long userID;
		try {
			userID = objectMapper.readValue(userIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"userID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"userID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"userID\"!";
		}
		Integer passwordHash;
		try {
			passwordHash = objectMapper.readValue(passwordHashInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"passwordHash\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"passwordHash\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"passwordHash\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.IsMatchingPasswordHash(userID, passwordHash);
		
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
	
	@GET
	@Path("/userage/{userID}")
	@Produces("text/plain")
	@Override
	public String userage(@PathParam("userID") String userIDInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Long userID;
		try {
			userID = objectMapper.readValue(userIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"userID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"userID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"userID\"!";
		}
		
		//M�velet v�grahajt�sa:
		Integer result =
			hu.bme.mit.inf.evilstore.UserManagement.implementations.RegistrationService.userage(userID);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
}
