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
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
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
		Integer ammount;
		try {
			ammount = objectMapper.readValue(ammountInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"ammount\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"ammount\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"ammount\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.transferMoney(accountId, ammount);
		
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
	@Path("/withdrawMoney/{accountId}/{ammount}")
	@Produces("text/plain")
	@Override
	public String withdrawMoney(@PathParam("accountId") String accountIdInput, @PathParam("ammount") String ammountInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
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
		Integer ammount;
		try {
			ammount = objectMapper.readValue(ammountInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"ammount\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"ammount\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"ammount\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.withdrawMoney(accountId, ammount);
		
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
	@Path("/getAccountOfUser/{userID}")
	@Produces("text/plain")
	@Override
	public String getAccountOfUser(@PathParam("userID") String userIDInput)
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
		String result =
			hu.bme.mit.inf.evilstore.AccountManagement.implementations.AccountManagementService.getAccountOfUser(userID);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"String\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
}
