package hu.bme.mit.inf.evilstore.evilgenius;

import java.util.Map;
import java.util.Map.Entry;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class GeniusMain {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            // go !
            
            
            AttilaUser user = new AttilaUser("Nuke", 14);
            AttilaApplication ownedApp1 = new AttilaApplication("Pokemon", "EvilProf", "Game", 12, 20);
            ownedApp1.downloads(400);
            ksession.insert(ownedApp1);
            user.addApplication(ownedApp1);
            AttilaApplication ownedApp2 = new AttilaApplication("Nuke Duke", "Atomic", "Game", 12, 15);
            ownedApp2.downloads(400);
            ksession.insert(ownedApp2);
            user.addApplication(ownedApp2);
            AttilaApplication ownedApp3 = new AttilaApplication("Pokemon: The Last Chanche", "EvilProf", "Movie", 12, 10);
            ownedApp2.downloads(300);
            ksession.insert(ownedApp3);
            user.addApplication(ownedApp3);
            //felhasználó berakása
            ksession.insert(user);
            AttilaSelectedUser sUser = new AttilaSelectedUser(user);
            ksession.insert(sUser);
            
            AttilaApplication app1 = new AttilaApplication("Zombie Apocalypse", "EvilProf", "Game", 18, 10);
            app1.downloads(500);
            ksession.insert(app1);
            AttilaApplication app2 = new AttilaApplication("EvilSims", "EvilProf", "Game", 12, 20);
            app2.downloads(1000);
            ksession.insert(app2);
            AttilaApplication app3 = new AttilaApplication("Movie Maker", "Bollywood", "Editor", 12, 5);
            app3.downloads(100);
            ksession.insert(app3);
            AttilaApplication app4 = new AttilaApplication("Nuke Duke 2", "Atomic", "Game", 12, 15);
            app4.downloads(20);
            ksession.insert(app4);
            AttilaApplication app5 = new AttilaApplication("Big Cooking Book", "Roaster", "Cooking", 8, 3);
            app5.downloads(300);
            ksession.insert(app5);
            AttilaApplication app6 = new AttilaApplication("EvilMaker", "EvilProf", "Editor", 8, 10);
            app6.downloads(600);
            ksession.insert(app6);
            
            AttilaUser otherUser = new AttilaUser("Lolcatz", 18);
            AttilaApplication otherApp1 = new AttilaApplication("Pokemon Blood Edition", "EvilProf", "Game", 18, 15);
            otherApp1.downloads(250);
            ksession.insert(otherApp1);
            otherUser.addApplication(otherApp1);
            AttilaApplication otherApp2 = new AttilaApplication("Evil Cat", "EvilProf", "Game", 12, 10);
            otherApp2.downloads(300);
            ksession.insert(otherApp2);
            otherUser.addApplication(otherApp2);
            ksession.insert(otherUser);
            
            ksession.setGlobal("downloadLimit", new Double(200.0));
            ksession.setGlobal("costLimit", new Double(50.0));
            
            ksession.fireAllRules();
            
            Map<AttilaApplication, Double> scoredApplications = sUser.getScore();
            for (Entry<AttilaApplication, Double> entry : scoredApplications.entrySet()) {
				System.out.println(entry.getKey().getName() + ": " + entry.getValue());
			}
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
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
