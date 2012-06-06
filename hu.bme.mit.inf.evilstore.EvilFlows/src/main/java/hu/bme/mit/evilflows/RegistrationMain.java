package hu.bme.mit.evilflows;

import hu.bme.mit.evilflows.handlers.DownloadAppHandler;
import hu.bme.mit.evilflows.handlers.GetLoginDataHandler;
import hu.bme.mit.evilflows.handlers.PasswordHashHandler;
import hu.bme.mit.evilflows.handlers.RegistrateHandler;
import hu.bme.mit.evilflows.handlers.SetValidatedHandler;
import hu.bme.mit.evilflows.handlers.TransferMoneyHandler;
import hu.bme.mit.evilflows.handlers.UserLoginHandler;
import hu.bme.mit.evilflows.handlers.ValidateAppHandler;
import hu.bme.mit.evilflows.handlers.ViewUncheckedAppsHandler;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class RegistrationMain {
	public static void main(String[] args) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.getWorkItemManager().registerWorkItemHandler("ViewUncheckedApps", new ViewUncheckedAppsHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("DownloadApp", new DownloadAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("ValidateApp", new ValidateAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("SetValidated", new SetValidatedHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("Registrate", new RegistrateHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("GetLoginData", new GetLoginDataHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("PasswordHash", new PasswordHashHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("UserLogin", new UserLoginHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("TransferMoney", new TransferMoneyHandler());
		ksession.startProcess("hu.bme.mit.wf.registration");
	}
		private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("validation.bpmn"), ResourceType.BPMN2);
		kbuilder.add(ResourceFactory.newClassPathResource("registration.bpmn"), ResourceType.BPMN2);
		return kbuilder.newKnowledgeBase();
	}
}
