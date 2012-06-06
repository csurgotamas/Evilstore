package hu.bme.mit.evilflows.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.drools.process.instance.WorkItem;
import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

public class GetLoginDataHandler implements WorkItemHandler{

	@Override
	public void abortWorkItem(org.drools.runtime.process.WorkItem arg0,
			WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeWorkItem(org.drools.runtime.process.WorkItem wi,
			WorkItemManager wim) {
		String name=null;
		String password=null;
		
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		System.out.println("Felhasználói adatok elkérése:");
		
		boolean correct = true;
		do{
		try {
			System.out.println("Felhasználónév:");
			name = in.readLine();
			System.out.println("Jelszó:");
			password = in.readLine();
		} catch (IOException e1) {
			correct = false;
		}
		}while(!correct);
		
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("name", name);
		results.put("password", password);

		wim.completeWorkItem(wi.getId(), results);
	}

}
