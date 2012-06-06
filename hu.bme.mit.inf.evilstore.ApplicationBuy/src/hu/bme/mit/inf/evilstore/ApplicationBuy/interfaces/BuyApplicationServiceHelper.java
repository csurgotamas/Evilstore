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
		Long applicationID;
		try {
			applicationID = objectMapper.readValue(applicationIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"applicationID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"applicationID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"applicationID\"!";
		}
		
		//M�velet v�grahajt�sa:
		Boolean result =
			hu.bme.mit.inf.evilstore.ApplicationBuy.implementations.BuyApplicationService.buy(userID, applicationID);
		
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
	@Path("/download/{applicationID}")
	@Produces("text/plain")
	@Override
	public String download(@PathParam("applicationID") String applicationIDInput)
	{
		//Objektumok parse-ol�sa a bemenetb�l.
		ObjectMapper objectMapper = new ObjectMapper();
		Long applicationID;
		try {
			applicationID = objectMapper.readValue(applicationIDInput, Long.class);
		} catch (JsonParseException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"applicationID\"!";
		} catch (JsonMappingException e) {
			return "Error: Nem siker�lt kiolvasni a(z) \"applicationID\" param�terb�l egy \"Long\" p�ld�nyt!";
		} catch (IOException e) {
			return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"applicationID\"!";
		}
		
		//M�velet v�grahajt�sa:
		String result =
			hu.bme.mit.inf.evilstore.ApplicationBuy.implementations.BuyApplicationService.download(applicationID);
		
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
