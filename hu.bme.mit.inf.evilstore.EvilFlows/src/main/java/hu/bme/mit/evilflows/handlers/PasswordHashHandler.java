package hu.bme.mit.evilflows.handlers;

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

public class PasswordHashHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeWorkItem(WorkItem arg0, WorkItemManager arg1) {
    String password = (String)arg0.getParameter("password");
		String address = (String)arg0.getParameter("passwordCheckerURL");
		String method =  (String)arg0.getParameter("passwordCheckerMethod");
		try {
			Client client = Client.create();
			String data = (new ObjectMapper()).writeValueAsString(password);
			data = URLEncoder.encode(data, "UTF-8");
			WebResource webResource = client.resource(address+"/"+data);
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
			Integer hash = (new ObjectMapper()).readValue(ret, Integer.class);
			System.out.println("A számított hash érték: " + hash);
			results.put("passwordHash", hash);

			arg1.completeWorkItem(arg0.getId(), results);

		}catch (Exception e) {
			e.printStackTrace();
		} 
	}

}