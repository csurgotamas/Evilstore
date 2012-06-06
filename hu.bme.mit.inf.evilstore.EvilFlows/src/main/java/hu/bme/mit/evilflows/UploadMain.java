package hu.bme.mit.evilflows;


import hu.bme.mit.evilflows.handlers.UploadAppHandler;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class UploadMain {
	public static void main(String[] args) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.getWorkItemManager().registerWorkItemHandler("UploadApp", new UploadAppHandler());
		ksession.startProcess("hu.bme.mit.wf.upload");
	}
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("upload.bpmn"), ResourceType.BPMN2);
		return kbuilder.newKnowledgeBase();
	}
}
