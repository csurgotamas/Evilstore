package codegenerator.osgi

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import evilsystem.Component
import evilsystem.NamedQuery
import evilsystem.Parameter
import evilsystem.Function
import evilsystem.TypeReference
import evilsystem.MethodType

class OSGiGenerator implements IGenerator {

	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def compile(Component component, IFileSystemAccess fsa) {
		for (service : component.services) {
			service.compileInt(fsa, component)
			service.compileImplHelper(fsa, component)
			service.compileImpl(fsa, component)
		}
	}
	
	def writeStringParameter(Parameter parameter)
	{
		'''String «parameter.name»'''
	}
	
	def writeStringParameters(evilsystem.Function function){
		'''«FOR parameter : function.parameters»«writeStringParameter(parameter)»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''
		
	}
	
	// OSGi szolgáltatás interfész generátor
	def compileInt(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile("I"+service.path + "Service.java", "SERVICEINTERFACES", '''
		package «component.system.systemNameSpace».«component.name».interfaces;
		
		public interface I«service.path»Service {
			«FOR function : service.functions»
				public String «function.name»(«function.writeStringParameters»);
			«ENDFOR»
		}
		''')
	}
	
	def writePathParameters(evilsystem.Function function){
		'''«FOR parameter : function.parameters»/{«parameter.name»}«ENDFOR»'''
	}
	
	def writeAnnotedStringParameters(evilsystem.Function function){
		'''«FOR parameter : function.parameters»@PathParam("«parameter.name»") String «parameter.name»Input«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''	
	}
	
	def writeEvaluatedParameters(evilsystem.Function function){
		'''«FOR parameter : function.parameters»«parameter.name»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''	
	}
	
	def writeTypeReferenceType(TypeReference typeReference)
	{
		'''«IF typeReference.collection»ArrayList<«typeReference.type.name»>«ELSE»«typeReference.type.name»«ENDIF»'''
	}
	
	def writeTypeReferenceTypeStrong(TypeReference typeReference)
	{
		'''«IF typeReference.collection»ArrayListv«typeReference.type.name»v«ELSE»«typeReference.type.name»«ENDIF»'''
	}
	
	// OSGi szolgáltatás segédosztályának generátora
	def compileImplHelper(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile(service.path + "ServiceHelper.java", "SERVICEINTERFACES", '''
		package «component.system.systemNameSpace».«component.name».interfaces;
		
		import java.io.IOException;
		import java.util.ArrayList;
		
		import java.sql.Date;
		
		import «component.system.systemNameSpace».entities.*;
		import «component.system.systemNameSpace».entitycollections.*;
		
		import javax.persistence.EntityManager;
		import javax.persistence.EntityManagerFactory;
		import javax.persistence.Persistence;
		import javax.ws.rs.*;
		
		import org.codehaus.jackson.JsonGenerationException;
		import org.codehaus.jackson.JsonParseException;
		import org.codehaus.jackson.map.JsonMappingException;
		import org.codehaus.jackson.map.ObjectMapper;
		
		@Path("/«service.path»")
		public class «service.path»ServiceHelper implements I«service.path»Service {
			
			public static EntityManager getEntityManager()
			{
					EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
					return factory.createEntityManager();
			}
			
			«FOR function : service.functions»
			
			@«function.methodType»
			@Path("/«function.name»«function.writePathParameters»")
			@Produces("text/plain")
			@Override
			public String «function.name»(«writeAnnotedStringParameters(function)»)
			{
				//Objektumok parse-olása a bemenetbõl.
				ObjectMapper objectMapper = new ObjectMapper();
				«FOR Parameter p : function.parameters»
				«writeTypeReferenceType(p)» «p.name»;
				try {
					«p.name» = objectMapper.readValue(«p.name»Input, «writeTypeReferenceTypeStrong(p)».class);
				} catch (JsonParseException e) {
					return "Error: Nem sikerült kiolvasni az alábbi Json paramétert: \"«p.name»\"!";
				} catch (JsonMappingException e) {
					return "Error: Nem sikerült kiolvasni a(z) \"«p.name»\" paraméterbõl egy \"«p.type.name»\" példányt!";
				} catch (IOException e) {
					return "Error: Nem sikerült kiolvasni az alábbi paramétert: \"«p.name»\"!";
				}
				«ENDFOR»
				
				//Mûvelet végrahajtása:
				«writeTypeReferenceType(function)» result =
					«component.system.systemNameSpace».«component.name».implementations.«service.path»Service.«function.name»(«writeEvaluatedParameters(function)»);
				
				//Eredmény sorosítása:
				try {
					return objectMapper.writeValueAsString(result);
				} catch (JsonParseException e) {
					return "Error: Nem sikerült Json-ba írni a mûvelet eredményét!";
				} catch (JsonMappingException e) {
					return "Error: Nem sikerült írni egy \"«writeTypeReferenceType(function)»\" példányt!";
				} catch (IOException e) {
					return "Error: Nem sikerült kiírni a mûvelet eredményét!";
				}
			}
			«ENDFOR»
		}
		''')
	}
	
	def writeParameter(TypeReference parameter){
		'''«writeTypeReferenceType(parameter)» «parameter.name»'''
	}
	
	def writeParameters(Function function){
		'''«FOR parameter : function.parameters»«writeParameter(parameter)»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''
	}
	
	// OSGi szolgáltatás megvalósítás osztályának generátora
	def compileImpl(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile(service.path + "Service.java", "SERVICEIMPLEMENTATIONS", '''
		package «component.system.systemNameSpace».«component.name».implementations;
		
		import java.util.List;
		import java.util.ArrayList;
		
		import «component.system.systemNameSpace».entities.*;
		
		import javax.persistence.EntityManager;
		import javax.persistence.EntityManagerFactory;
		
		public class «service.path»Service{
			«FOR function : service.functions»
			
			public static «writeParameter(function)»(«function.writeParameters»)
			{
				//EntityManager létrehozása:
				EntityManager entityManager =
					«component.system.systemNameSpace».«component.name».interfaces.«service.path»ServiceHelper.getEntityManager();
				«IF !function.queries.empty»
				
				//A modell szerint az alábbi query-ket használja a függvény:
				«ENDIF»
				«FOR NamedQuery nq : function.queries»
				List«IF nq.referred != null»<«nq.referred.name»>«ENDIF» «nq.name»Result = entityManager.createQuery("«nq.query»").getResultList();
				«ENDFOR»
				
				«IF function.methodType != MethodType::GET»
				// Ha tranzakciószerû a függvény, akkor elkezdjük a tranzakciót:
				entityManager.getTransaction().begin();
				
				«ENDIF»
				// Ide kerül mûvelet.
				
				«IF function.methodType != MethodType::GET»
				// Új elem létrehozása és mentése a következõképpen történik:
				// entityManager.persist(...);
				
				// Ha tranzakciószerû a függvény, akkor egyszer befejezzük azt:
				entityManager.getTransaction().commit();
				
				«ENDIF»				
				// EntityManager lezárása:
				entityManager.close();
				
				//De ez a függvény még nincs kész:
				throw new UnsupportedOperationException();
			}
			«ENDFOR»
		}
		''')
	}
}