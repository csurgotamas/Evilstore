package NormalFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ForBuy {

	public static Object ListApps(Object applist){
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Map<String,Object>> apps = null;
		try {
			apps  = objectMapper.readValue(applist.toString(),ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!apps.isEmpty()){
			for (Map<String,Object> app : apps)
			{
				System.out.println(app.toString());
			}
			return false;
		}else
			return true;
	}
	public static Object ChooseApp()
	{
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		
		System.out.println("Kérem adja meg a választott alkalmazás azonosítóját:");
		Integer id = null;
		try {
			id = Integer.parseInt(in.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return id;
		
	}
	public static Object CheckNotBuyed(Object userapplist,Object choosedappid){
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Map<String,Object>> apps = null;
		try {
			apps  = objectMapper.readValue(userapplist.toString(),ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean found=false;
		for (Map<String,Object> app : apps){
			if(app.get("id").equals(choosedappid))
				found=true;
		}
		return !found;
	}
	
	public static Object GetAppPrice(Object applist,Object choosedappid){
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Map<String,Object>> apps = null;
		try {
			apps  = objectMapper.readValue(applist.toString(),ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer costs=0;
		for (Map<String,Object> app : apps){
			if(app.get("id").equals(choosedappid))
				costs=(Integer)app.get("cost");
		}
		return costs;
	}
	public static Object GetAppAgeRest(Object applist,Object choosedappid){
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Map<String,Object>> apps = null;
		try {
			apps  = objectMapper.readValue(applist.toString(),ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer agerest=0;
		for (Map<String,Object> app : apps){
			if(app.get("id").equals(choosedappid))
				agerest=(Integer) ((Map<String, Object>) app.get("description")).get("ageRestriction");
		}
		return agerest;
	}
}
