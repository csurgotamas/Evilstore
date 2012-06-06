package hu.bme.mit.inf.evilstore.entitytester;

import javax.ws.rs.*;

//Interface for testing the entity project
@Path("/entitytester")
public class DataBaseTester implements IDataBaseTester {
	@GET
	@Path("/test")
	@Produces("text/plain")
	@Override
	public String Test()
	{
		return "The entity project is working.";
	}
}

