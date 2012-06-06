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
import com.sun.jersey.api.client.WebResource;

public class TransferMoneyHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeWorkItem(WorkItem arg0, WorkItemManager arg1) {
		Integer UserID = (Integer)arg0.getParameter("userID");
	
		String address1 = (String)arg0.getParameter("getAccountOfUserURL");
		String method1 =  (String)arg0.getParameter("getAccountOfUserMethod");
		String address2 = (String)arg0.getParameter("transferMoneyURL");
		String method2 =  (String)arg0.getParameter("transferMoneyMethod");
		String accountID=null;
		
		int value=0;
		boolean correct = true;
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		do{
		try {
			System.out.println("Mekkora összeget kíván feltölteni a számlájára:");
			value = Integer.parseInt(in.readLine());
		} catch (IOException e1) {
			correct = false;
		}
		}while(!correct);
		try {
			ObjectMapper o = new ObjectMapper();
			Client client = Client.create(); ;
			WebResource webResource1 = client.resource(
				address1+"/"+
				URLEncoder.encode("\"" + o.writeValueAsString(UserID)+ "\"", "UTF-8"));
			String ret1 = "";

			if (method1.equalsIgnoreCase("GET")) {
				System.out.println("Executing via GET...");
				ret1 = webResource1.get(String.class);
			} else if (method1.equalsIgnoreCase("PUT")) {
				System.out.println("Executing via PUT...");
				ret1 = webResource1.put(String.class);
			} else if (method1.equalsIgnoreCase("POST")) {
				System.out.println("Executing via POST...");
				ret1 = webResource1.post(String.class);
			}
			
			accountID =  o.readValue(ret1, String.class);
			
			WebResource webResource2 = client.resource(
					address2+"/"+
					URLEncoder.encode(o.writeValueAsString(accountID), "UTF-8")+"/"+
					URLEncoder.encode(o.writeValueAsString(value), "UTF-8"));
			
			String ret2 = "";
			if (method2.equalsIgnoreCase("GET")) {
				System.out.println("Executing via GET...");
				ret2 = webResource2.get(String.class);
			} else if (method2.equalsIgnoreCase("PUT")) {
				System.out.println("Executing via PUT...");
				ret2 = webResource2.put(String.class);
			} else if (method2.equalsIgnoreCase("POST")) {
				System.out.println("Executing via POST...");
				ret2 = webResource2.post(String.class);
			}
			
			Map<String, Object> results = new HashMap<String, Object>();
			Boolean result = o.readValue(ret2, Boolean.class);
			System.out.println("A tranzakció eredménye: " + result);
			results.put("transferResult", result);

			arg1.completeWorkItem(arg0.getId(), results);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
