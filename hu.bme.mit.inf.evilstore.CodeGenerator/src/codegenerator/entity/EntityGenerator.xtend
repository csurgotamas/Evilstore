package codegenerator.entity

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import evilsystem.Entity
import evilsystem.TypeReference
import evilsystem.Attribute
import evilsystem.Type
import evilsystem.SimpleType

class EntityGenerator implements IGenerator {
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (Entity : input.contents) {
			Entity.compile(fsa)
		}
	}
	
	def dispatch void compile(EObject m, IFileSystemAccess fsa) { 	}
	
	def dispatch void compile(evilsystem.System system, IFileSystemAccess fsa) {
		for (entity : system.elements.filter(typeof(Entity))) {
			entity.compile(fsa)
			compileTypeCollection(system,entity,fsa)
		}
		for (SimpleType simpleType : system.elements.filter(typeof(SimpleType)))
		{
			compileTypeCollection(system,simpleType,fsa)
		}
		compileDatabaseTesters(system, fsa)
	}
	
	def writeTypeInJava(TypeReference typeReference){
		if(typeReference.collection) '''List<«typeReference.type.name»>'''
		else '''«typeReference.type.name»'''
	}
	
	def defaultVauledVariable(Attribute attribute)
	{
		if(attribute.collection) ''' = new ArrayList<«attribute.type.name»>()'''
		else ''''''
	}
	
	// OSGi szolgáltatás osztály generátor
	def compile(Entity entity, IFileSystemAccess fsa) {
		fsa.generateFile(entity.name + ".java", "SOURCES", '''
		package «entity.system.systemNameSpace».entities;
		
		import java.util.List;
		import java.util.ArrayList;
		
		import java.sql.Date;

		import javax.persistence.Column;
		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.Id;
		import javax.persistence.NamedQuery;
		import javax.persistence.Table;
		import javax.xml.bind.annotation.XmlRootElement;
		
		@Entity
		@Table(name="«entity.name»_Table")
		@XmlRootElement
		public class «entity.name»«if(entity.superClass!=null)''' extends «entity.superClass.name»'''»{
			
			@Id
			@GeneratedValue
			@Column(name="«entity.name»_ID")
			protected long id;
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id=id;
			}
		«FOR attribute : entity.attributes»
		
			protected «writeTypeInJava(attribute)» «attribute.name»«defaultVauledVariable(attribute)»;
			public «writeTypeInJava(attribute)» get«attribute.name.toFirstUpper»(){
				return this.«attribute.name»;
			}
			public void set«attribute.name.toFirstUpper»(«writeTypeInJava(attribute)» «attribute.name»){
				this.«attribute.name» = «attribute.name»;
			}
		«ENDFOR»
		}
		''')
	}
	
	def compileTypeCollection(evilsystem.System system, Type type, IFileSystemAccess fsa)
	{
		fsa.generateFile("ArrayListv" + type.name + "v.java", "SOURCESCOLLECTION",'''
		package «system.systemNameSpace».entitycollections;
		
		import java.util.ArrayList;
		
		import java.sql.Date;
		
		import javax.xml.bind.annotation.XmlRootElement;
		
		import «system.systemNameSpace».entities.*;
		
		@XmlRootElement
		public class ArrayListv«type.name»v extends ArrayList<«type.name»>{
		}
		''')
	}
	
	def compileDatabaseTesters(evilsystem.System system, IFileSystemAccess fsa)
	{
		fsa.generateFile(EntityGeneratorCode::DataBaseTesterInterfaceName+".java", "TESTER", '''
		package «system.systemNameSpace».entitytester;
		
		//Interface for testing the entity project
		public interface «EntityGeneratorCode::DataBaseTesterInterfaceName» {
			
			public String Test();
		}
		
		''')
		
		fsa.generateFile(EntityGeneratorCode::DataBaseTesterClassName+".java", "TESTER", '''
		package «system.systemNameSpace».entitytester;
		
		import javax.ws.rs.*;
		
		//Interface for testing the entity project
		@Path("/entitytester")
		public class «EntityGeneratorCode::DataBaseTesterClassName» implements «EntityGeneratorCode::DataBaseTesterInterfaceName» {
			@GET
			@Path("/test")
			@Produces("text/plain")
			@Override
			public String Test()
			{
				return "The entity project is working.";
			}
		}
		
		''')
	}
}