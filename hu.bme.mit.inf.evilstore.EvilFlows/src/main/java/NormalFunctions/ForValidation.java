package NormalFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ForValidation {
	public static void Step1()
	{
		System.out.println("Hahó");
	}
	public static Object pickApp(Object applist){
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
		if(apps.isEmpty())
			return null;
		return apps.get(0).get("id");
	}
	public static Object validtobool(Object validated)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		Boolean ret=false;
		try {
			ret  = objectMapper.readValue(validated.toString(),Boolean.class);
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
		return ret;
	}
	public static Object decision(Object progdata){
		System.out.println("A programdata: "+progdata.toString());
		System.out.println("Megfelelő-e?(Igen/Nem)");
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		String d="";
		Boolean result=false;
		Boolean done=false;
		while(!done){
			try {
				d = in.readLine();
			}catch (IOException e1) {
			  // TODO Auto-generated catch block
			  e1.printStackTrace();
			}
			if(d.equals("Igen")){
				result=true;
				done=true;
			}else if(d.equals("Nem")){
				result=false;
				done=true;
			}else{
				System.out.println("Csak Igen/Nem választ fogad el!");
			}
		}
		return result;
	}
}
