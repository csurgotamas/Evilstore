package hu.bme.mit.evilflows;


import hu.bme.mit.evilflows.handlers.DownloadAppHandler;
import hu.bme.mit.evilflows.handlers.SetValidatedHandler;
import hu.bme.mit.evilflows.handlers.ValidateAppHandler;
import hu.bme.mit.evilflows.handlers.ViewUncheckedAppsHandler;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class ValidateMain {
	public static void main(String[] args) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.getWorkItemManager().registerWorkItemHandler("ViewUncheckedApps", new ViewUncheckedAppsHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("DownloadApp", new DownloadAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("ValidateApp", new ValidateAppHandler());
		ksession.getWorkItemManager().registerWorkItemHandler("SetValidated", new SetValidatedHandler());
		ksession.startProcess("hu.bme.mit.wf.validation");
	}
		private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("validation.bpmn"), ResourceType.BPMN2);
		return kbuilder.newKnowledgeBase();
	}
}
