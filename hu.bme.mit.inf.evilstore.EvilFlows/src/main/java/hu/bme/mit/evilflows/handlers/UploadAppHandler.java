package hu.bme.mit.evilflows.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class UploadAppHandler implements WorkItemHandler {

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWorkItem(WorkItem wi, WorkItemManager wim) {
		String address = wi.getParameter("URL").toString();
		String appname =   wi.getParameter("AppName").toString();
		String developerid =   wi.getParameter("DeveloperId").toString();
		String version =   wi.getParameter("Version").toString();
		String desc =   wi.getParameter("Desc").toString();
		String cost =   wi.getParameter("Cost").toString();
		String progfile =   wi.getParameter("ProgFile").toString();
		String apptype =   wi.getParameter("AppType").toString();
		String method =  wi.getParameter("Method").toString();
		String agerestrict =  wi.getParameter("AgeRestriction").toString();

		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		try {
			
			System.out.println("Applikáció neve:");
			appname = in.readLine();
			System.out.println("DeveloperId");
			developerid = in.readLine();
			System.out.println("Version:");
			version = in.readLine();
			System.out.println("Leírás:");
			desc = in.readLine();
			System.out.println("Ára:");
			cost = in.readLine();
			System.out.println("Programfile:");
			progfile = in.readLine();
			System.out.println("Applikáció típusai(vége-vel zár):");
			ArrayList<String> s=new ArrayList<String>();
			String temp = in.readLine();
			while(!temp.equals("vége")){
				s.add(temp);
				temp = in.readLine();
			}
			ObjectMapper objectMapper = new ObjectMapper();
			apptype=objectMapper.writeValueAsString(s);
			Client client = Client.create();
			appname=URLEncoder.encode("\""+appname+"\"", "UTF-8");
			desc=URLEncoder.encode("\""+desc+"\"", "UTF-8");
			progfile=URLEncoder.encode("\""+progfile+"\"", "UTF-8");
			apptype=URLEncoder.encode(apptype, "UTF-8");
			agerestrict=URLEncoder.encode(agerestrict, "UTF-8");
			String addr="/"+appname+"/"+developerid+"/"+version+
			"/"+desc+"/"+cost+"/"+progfile+"/"+apptype+"/"+agerestrict;
			WebResource webResource = client.resource(address+addr);
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
			results.put("ret", ret);

			wim.completeWorkItem(wi.getId(), results);

		} catch (Exception e) {
			e.printStackTrace();
			wim.completeWorkItem(wi.getId(), null);
		}


	}

}
