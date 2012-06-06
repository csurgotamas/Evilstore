package codegenerator.entity.persistence

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import evilsystem.Entity

class EntityPersistenceGenerator implements IGenerator {
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def void compile(evilsystem.System system, IFileSystemAccess fsa) {
		fsa.generateFile("persistence.xml", "PERSISTENCE", '''
			<?xml version="1.0" encoding="UTF-8" ?>
			<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" 
			    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			    xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
			    <persistence-unit name="osgi.demo.jpa" transaction-type="RESOURCE_LOCAL">
			        «FOR Entity entity : system.elements.filter(typeof (Entity))»
			        <class>«system.systemNameSpace».entities.«entity.name»</class>
					«ENDFOR»
			        <properties>
			            <!-- Embedded Derby Login -->
			            <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver"/>
			            <property name="javax.persistence.jdbc.url" value="jdbc:derby:books;create=true"/>
			            <!-- don't need userid/password in embedded Derby -->
			            <property name="eclipselink.target-database" value="Derby"/>
			            <property name="eclipselink.jdbc.read-connections.min" value="1"/>
			            <property name="eclipselink.jdbc.write-connections.min" value="1"/>
			            <property name="eclipselink.jdbc.batch-writing" value="JDBC"/>
			 
			            <!-- Database Schema Creation -->
			            <property name="eclipselink.ddl-generation" value="drop-and-create-tables"/>
			            <property name="eclipselink.ddl-generation.output-mode" value="database"/>
			 
			            <!-- Logging Settings -->
			            
			            <property name="eclipselink.logging.level" value="FINEST" />
			            <property name="eclipselink.logging.thread" value="FINEST" />
			            <property name="eclipselink.logging.session" value="FINEST" />
			            <property name="eclipselink.logging.exceptions" value="FINEST" />
			            <property name="eclipselink.logging.timestamp" value="FINEST"/>             
			        </properties>
			    </persistence-unit>
			</persistence>

		''')
	}
}