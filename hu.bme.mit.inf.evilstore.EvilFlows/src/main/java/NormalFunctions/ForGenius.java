package NormalFunctions;

import hu.bme.mit.evilsystem.entities.Application;
import hu.bme.mit.evilsystem.entities.CustomerSimilarityScore;
import hu.bme.mit.evilsystem.entities.User;
import hu.bme.mit.evilsystem.entitycollections.ArrayListvApplicationv;
import hu.bme.mit.evilsystem.entitycollections.ArrayListvCustomerSimilarityScorev;
import hu.bme.mit.evilsystem.entitycollections.ArrayListvUserv;
import hu.bme.mit.inf.evilstore.evilgenius.EvilGEnius;
import hu.bme.mit.inf.evilstore.evilgenius.SelectedUser;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class ForGenius {
	public static String GeniusFunc(Object userlist,Object applist,Object userid, Object similarities){
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<User> users = null;
		ArrayList<Application> applications = null;
		Integer selectedUserId = null;
		ArrayList<CustomerSimilarityScore> customerSimilarityScores = null;
		try {
			 users= objectMapper.readValue((String)userlist, ArrayListvUserv.class);
			 applications= objectMapper.readValue((String)applist, ArrayListvApplicationv.class);
			 selectedUserId= (Integer) userid;
			 customerSimilarityScores=objectMapper.readValue((String)similarities, ArrayListvCustomerSimilarityScorev.class);
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
		
		User selectedUser=null;
		for(User user : users)
		{
			if(user.getId()==selectedUserId)
			{
				selectedUser=user;
				break;
			}
		}
		
		System.out.println("The Evil Genius is on the loose: "+selectedUser.getUserName());
		
		SelectedUser su = new SelectedUser(selectedUser);
		ArrayList<Application> bests = EvilGEnius.EvilGenius(su, users, applications,customerSimilarityScores, 5);
		
		System.out.println("The Evil Genius ended.");
		System.out.println();
		
		int i=1;
		for(Application application : bests)
		{
			System.out.println(i+". "+application.getApplicationName());
			System.out.print("Age Restriction: "+application.getDescription().getAgeRestriction()+
					           ", Cost: "+application.getCost()+" Credit, Type: ");
			for(String type : application.getDescription().getApplicationType()) System.out.print(type+" ");
			System.out.println();
			i++;
		}
		return "Done";
	}
}
