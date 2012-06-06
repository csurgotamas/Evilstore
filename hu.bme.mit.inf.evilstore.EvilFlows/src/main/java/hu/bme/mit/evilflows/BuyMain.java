package hu.bme.mit.evilflows;

import hu.bme.mit.evilflows.handlers.AppPayHandler;
import hu.bme.mit.evilflows.handlers.BuyAppHandler;
import hu.bme.mit.evilflows.handlers.GetAccountOfUserHandler;
import hu.bme.mit.evilflows.handlers.GetLoginDataHandler;
import hu.bme.mit.evilflows.handlers.GetUserAppsHandler;
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

public class BuyMain {

	public static void main(String[] args) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
		ksession.getWorkItemManager().registerWorkItemHandler("GetLoginData", new GetLoginDataHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("UserLogin", new UserLoginHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("PasswordHash", new PasswordHashHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("IsMatchingPasswordHash", new IsMatchingPasswordHash());
		ksession.getWorkItemManager().registerWorkItemHandler("ViewApps", new ViewValidatedAppsHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("GetUserApps", new GetUserAppsHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("AppPay", new AppPayHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("BuyApp", new BuyAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("GetAccountOfUser", new GetAccountOfUserHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("AppPay", new AppPayHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("BuyApp", new BuyAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("UserAge", new UserAgeHandler());
		ksession.startProcess("hu.bme.mit.wf.buy");
	}
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("buy.bpmn"), ResourceType.BPMN2);
		return kbuilder.newKnowledgeBase();
	}
}
