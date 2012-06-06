package hu.bme.mit.evilflows.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.WebResource;

public class RegistrateHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeWorkItem(WorkItem arg0, WorkItemManager arg1) {
		String name = (String)arg0.getParameter("name");
		
		String address = (String)arg0.getParameter("registerURL");
		String method =  (String)arg0.getParameter("registerMethod");
		Integer passwordHash = (Integer)arg0.getParameter("passwordHash");
		String birth = null;
		String accountID=null;
		boolean correct = true;
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		do{
		try {
			System.out.println("Számlaszám:");
			accountID = in.readLine();
			System.out.println("Születési dátum(2012-12-30):");
			birth = in.readLine();
		} catch (IOException e1) {
			correct = false;
		}
		}while(!correct);
		try {
			ObjectMapper o = new ObjectMapper();
			Client client = Client.create(); ;
			WebResource webResource = client.resource(
				address+"/"+
				URLEncoder.encode(o.writeValueAsString(name), "UTF-8") + "/" +
				URLEncoder.encode(o.writeValueAsString(accountID), "UTF-8") + "/" +
				URLEncoder.encode(o.writeValueAsString(passwordHash), "UTF-8") + "/" +
				URLEncoder.encode(o.writeValueAsString(birth), "UTF-8"));
			String ret = "";

			if (method.equalsIgnoreCase("GET")) {
				System.out.println("Executing via GET...");
				ret = webResource.get(String.class);
			} else if (method.equalsIgnoreCase("PUT")) {
				System.out.println("Executing via PUT...");
				ret = webResource.put(String.class);
			} else if (method.equalsIgnoreCase("POST")) {
				System.out.println("Executing via POST...");
				ret = webResource.post(String.class);
			}
			
			Map<String, Object> results = new HashMap<String, Object>();
			Boolean result = (new ObjectMapper()).readValue(ret, Boolean.class);
			//System.out.println("A regisztráció eredménye: " + result);
			results.put("registrationResult", result);

			arg1.completeWorkItem(arg0.getId(), results);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
