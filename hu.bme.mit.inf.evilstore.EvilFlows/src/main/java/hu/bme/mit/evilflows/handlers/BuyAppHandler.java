package hu.bme.mit.evilflows.handlers;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BuyAppHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWorkItem(WorkItem wi, WorkItemManager wim) {
		String address = wi.getParameter("URL").toString();
		String userid =   wi.getParameter("UserID").toString();
		Integer appid =   (Integer)wi.getParameter("AppID");
		String method =  wi.getParameter("Method").toString();

		try {
			Client client = Client.create();
			WebResource webResource = client.resource(address+"/"+userid+"/"+
					URLEncoder.encode(new ObjectMapper().writeValueAsString(appid), "UTF-8"));
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
			results.put("ret", (new ObjectMapper()).readValue(ret, Boolean.class));

			wim.completeWorkItem(wi.getId(), results);

		} catch (Exception e) {
			e.printStackTrace();
			wim.completeWorkItem(wi.getId(), null);
		}


	}

}
