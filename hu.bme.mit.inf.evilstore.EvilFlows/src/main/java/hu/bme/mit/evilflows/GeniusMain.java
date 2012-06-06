package hu.bme.mit.evilflows;

import hu.bme.mit.evilflows.handlers.AppPayHandler;
import hu.bme.mit.evilflows.handlers.BuyAppHandler;
import hu.bme.mit.evilflows.handlers.GetAccountOfUserHandler;
import hu.bme.mit.evilflows.handlers.GetLoginDataHandler;
import hu.bme.mit.evilflows.handlers.GetSimilarityHandler;
import hu.bme.mit.evilflows.handlers.GetUserAppsHandler;
import hu.bme.mit.evilflows.handlers.GetUsersHandler;
import hu.bme.mit.evilflows.handlers.IsMatchingPasswordHash;
import hu.bme.mit.evilflows.handlers.PasswordHashHandler;
import hu.bme.mit.evilflows.handlers.UserAgeHandler;
import hu.bme.mit.evilflows.handlers.UserLoginHandler;
import hu.bme.mit.evilflows.handlers.ViewValidatedAppsHandler;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class GeniusMain {

	public static void main(String[] args) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
		ksession.getWorkItemManager().registerWorkItemHandler("GetLoginData", new GetLoginDataHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("UserLogin", new UserLoginHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("PasswordHash", new PasswordHashHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("IsMatchingPasswordHash", new IsMatchingPasswordHash());
		ksession.getWorkItemManager().registerWorkItemHandler("ViewApps", new ViewValidatedAppsHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("GetUsers", new GetUsersHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("GetSimilarity", new GetSimilarityHandler());
		ksession.startProcess("hu.bme.mit.wf.genius");
	}
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("EvilGeniusFlow.bpmn"), ResourceType.BPMN2);
		return kbuilder.newKnowledgeBase();
	}
}
