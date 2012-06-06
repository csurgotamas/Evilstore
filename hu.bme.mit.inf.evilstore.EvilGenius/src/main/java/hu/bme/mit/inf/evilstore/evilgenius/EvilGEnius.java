package hu.bme.mit.inf.evilstore.evilgenius;

import hu.bme.mit.evilsystem.entities.Application;
import hu.bme.mit.evilsystem.entities.CustomerSimilarityScore;
import hu.bme.mit.evilsystem.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class EvilGEnius {
	public static ArrayList<Application> EvilGenius(
			SelectedUser selectedUser, Collection<User> users, Collection<Application> applications, ArrayList<CustomerSimilarityScore> customerSimilarityScores, int count)
	{
		KnowledgeBase kbase = readKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        for(User user : users)
        {
        	ksession.insert(user);
        }
        for(Application application : applications)
        {
        	System.out.println(
        			"Lehetõség: "+application.getApplicationName() +
        			" ("+application.getDescription().getAgeRestriction()+")");
        	ksession.insert(application);
        }
        for(CustomerSimilarityScore customerSimilarityScore : customerSimilarityScores)
        {
        	ksession.insert(customerSimilarityScore);
        }
        SelectedUser su=selectedUser;
        ksession.insert(su);
                
        ksession.setGlobal("downloadLimit", new Double(200.0));
        ksession.setGlobal("costLimit", new Double(50.0));
        
        ksession.fireAllRules();
        
        //próbaobjektum
        ArrayList<Application> returnList = new ArrayList<Application>();
        
        Map<Long, Double> scoredApplications = su.getScore();
        for (Entry<Long, Double> entry : scoredApplications.entrySet()) {
        	
        	Application app = null;
        	for (Application application : applications) {
				if (application.getId() == entry.getKey()) {
					app = application;
					break;
				}
			}
        	
			//System.out.println(entry.getKey().getApplicationName() + ": " + entry.getValue());
        	if (app != null) {
        		System.out.println(app.getApplicationName() + ": " + entry.getValue());
        		returnList.add(app);
        	}
		}
        return getBestApplications(scoredApplications, returnList, count);
        //return returnList;
	}
	
	private static ArrayList<Application> getBestApplications(Map<Long, Double> applicationIds, ArrayList<Application> applications, int count)
	{
		//inicializálás
		ArrayList<Application> resultList = new ArrayList<Application>();
		
		//amíg van elem az alkalmazás azonosítók halmazában
		int i = 0;
		while (applicationIds.size() > 0 && i < count) {
			double max = 0.0;
			long id = 0;
			//mindig a legnagyobb double azonosító-pontszám párt keresi ki
			for (Entry<Long, Double> entry : applicationIds.entrySet()) {
				if (entry.getValue() > max) {
					id = entry.getKey();
					max = entry.getValue();
				}
			}
			
			for (Application app : applications) {
				if (app.getId() == id) {
					resultList.add(app);
					break;
				}
			}
			applicationIds.remove(id);
			i++;
		}
		
		return resultList;
		
		/*SortedSet<Entry<Application, Double>> entries = 
			new TreeSet<Map.Entry<Application,Double>>(new Comparator<Map.Entry<Application,Double>>() {
				@Override
				public int compare(Entry<Application, Double> o1,
						Entry<Application, Double> o2) {
					if(o1.getValue()<o2.getValue()) return 1;
					else if(o1.getValue()==o2.getValue()) return 0;
					else return -1;
				}
			});
		for(Entry<Application, Double> entry : applications.entrySet())
			entries.add(entry);
		int i=1;
		ArrayList<Application> ret = new ArrayList<Application>();
		for(Entry<Application, Double> entry : entries)
		{
			ret.add(entry.getKey());
			if(i>=count) return ret;
			i++;
		}
		return ret;*/
	}
	
	private static KnowledgeBase readKnowledgeBase() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Genius.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
