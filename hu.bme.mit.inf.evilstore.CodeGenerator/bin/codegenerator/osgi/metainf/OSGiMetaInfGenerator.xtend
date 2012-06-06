package codegenerator.osgi.metainf

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class OSGiMetaInfGenerator implements IGenerator {
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def void compile(evilsystem.System thisSystem, String simbolicname, evilsystem.System useThisSystemsEntities, IFileSystemAccess fsa) {
		fsa.generateFile("MANIFEST.MF", "METAINF", '''
		Manifest-Version: 1.0
		Bundle-ManifestVersion: 2
		Bundle-Name: Entity
		Bundle-SymbolicName: «simbolicname»
		Bundle-Version: 1.0.0.qualifier«/*Bundle-Activator: hu.bme.mit.szolgint.osgi.demo.Activator*/»
		Bundle-ActivationPolicy: lazy
		Bundle-RequiredExecutionEnvironment: JavaSE-1.6
		Import-Package: org.osgi.framework;version="1.3.0"
		Require-Bundle: com.sun.jersey.jersey-core;bundle-version="1.11.0",
		 com.sun.jersey.jersey-server;bundle-version="1.11.0",
		 com.sun.jersey.jersey-servlet;bundle-version="1.11.0",
		 org.apache.derby;bundle-version="10.5.1",
		 org.eclipse.persistence.jpa;bundle-version="2.3.2",
		 javax.persistence;bundle-version="2.0.3",
		 com.eclipsesource.jaxrs.connector;bundle-version="1.0.0",
		 jackson-mapper-asl;bundle-version="1.9.6",
		 jackson-core-asl;bundle-version="1.9.6"«IF useThisSystemsEntities!=null»,
		 «useThisSystemsEntities.systemNameSpace».entities;bundle-version="1.0.0"«ENDIF»
		Service-Component: OSGI-INF/component.xml
		JPA-PersistenceUnits: osgi.demo.jpa
		«IF useThisSystemsEntities == null »Export-Package: «thisSystem.systemNameSpace».entities,
		 «thisSystem.systemNameSpace».entitycollections«ENDIF»
		''')
	}
}