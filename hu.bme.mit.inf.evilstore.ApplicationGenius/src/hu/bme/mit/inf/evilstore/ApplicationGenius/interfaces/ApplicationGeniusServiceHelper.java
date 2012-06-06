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
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//M�velet v�grahajt�sa:
		ArrayList<User> result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.getUsers();
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"ArrayList<User>\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
	
	@GET
	@Path("/getSelectedUser/{userID}")
	@Produces("text/plain")
	@Override
	public String getSelectedUser(@PathParam("userID") String userIDInput)
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
		User result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.getSelectedUser(userID);
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"User\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
	
	@POST
	@Path("/classifyType/{age}")
	@Produces("text/plain")
	@Override
	public String classifyType(@PathParam("age") String ageInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Integer age;
		try {
			age = objectMapper.readValue(ageInput, Integer.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"age\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"age\" param�terb�l egy \"Integer\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"age\"!";
		}
		
		//M�velet v�grahajt�sa:
		String result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.classifyType(age);
		
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
	
	@GET
	@Path("/GetSimilarities")
	@Produces("text/plain")
	@Override
	public String GetSimilarities()
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//M�velet v�grahajt�sa:
		ArrayList<CustomerSimilarityScore> result =
			hu.bme.mit.inf.evilstore.ApplicationGenius.implementations.ApplicationGeniusService.GetSimilarities();
		
		//Eredm�ny soros�t�sa:
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt �rni egy \"ArrayList<CustomerSimilarityScore>\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
		}
	}
}
