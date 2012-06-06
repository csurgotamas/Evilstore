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
		'''String �parameter.name�'''
	}
	
	def writeStringParameters(evilsystem.Function function){
		'''�FOR parameter : function.parameters��writeStringParameter(parameter)��IF function.parameters.last!=parameter�, �ENDIF��ENDFOR�'''
		
	}
	
	// OSGi szolg�ltat�s interf�sz gener�tor
	def compileInt(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile("I"+service.path + "Service.java", "SERVICEINTERFACES", '''
		package �component.system.systemNameSpace�.�component.name�.interfaces;
		
		public interface I�service.path�Service {
			�FOR function : service.functions�
				public String �function.name�(�function.writeStringParameters�);
			�ENDFOR�
		}
		''')
	}
	
	def writePathParameters(evilsystem.Function function){
		'''�FOR parameter : function.parameters�/{�parameter.name�}�ENDFOR�'''
	}
	
	def writeAnnotedStringParameters(evilsystem.Function function){
		'''�FOR parameter : function.parameters�@PathParam("�parameter.name�") String �parameter.name�Input�IF function.parameters.last!=parameter�, �ENDIF��ENDFOR�'''	
	}
	
	def writeEvaluatedParameters(evilsystem.Function function){
		'''�FOR parameter : function.parameters��parameter.name��IF function.parameters.last!=parameter�, �ENDIF��ENDFOR�'''	
	}
	
	def writeTypeReferenceType(TypeReference typeReference)
	{
		'''�IF typeReference.collection�ArrayList<�typeReference.type.name�>�ELSE��typeReference.type.name��ENDIF�'''
	}
	
	def writeTypeReferenceTypeStrong(TypeReference typeReference)
	{
		'''�IF typeReference.collection�ArrayListv�typeReference.type.name�v�ELSE��typeReference.type.name��ENDIF�'''
	}
	
	// OSGi szolg�ltat�s seg�doszt�ly�nak gener�tora
	def compileImplHelper(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile(service.path + "ServiceHelper.java", "SERVICEINTERFACES", '''
		package �component.system.systemNameSpace�.�component.name�.interfaces;
		
		import java.io.IOException;
		import java.util.ArrayList;
		
		import java.sql.Date;
		
		import �component.system.systemNameSpace�.entities.*;
		import �component.system.systemNameSpace�.entitycollections.*;
		
		import javax.persistence.EntityManager;
		import javax.persistence.EntityManagerFactory;
		import javax.persistence.Persistence;
		import javax.ws.rs.*;
		
		import org.codehaus.jackson.JsonGenerationException;
		import org.codehaus.jackson.JsonParseException;
		import org.codehaus.jackson.map.JsonMappingException;
		import org.codehaus.jackson.map.ObjectMapper;
		
		@Path("/�service.path�")
		public class �service.path�ServiceHelper implements I�service.path�Service {
			
			public static EntityManager getEntityManager()
			{
					EntityManagerFactory factory = Persistence.createEntityManagerFactory("osgi.demo.jpa");
					return factory.createEntityManager();
			}
			
			�FOR function : service.functions�
			
			@�function.methodType�
			@Path("/�function.name��function.writePathParameters�")
			@Produces("text/plain")
			@Override
			public String �function.name�(�writeAnnotedStringParameters(function)�)
			{
				//Objektumok parse-ol�sa a bemenetb�l.
				ObjectMapper objectMapper = new ObjectMapper();
				�FOR Parameter p : function.parameters�
				�writeTypeReferenceType(p)� �p.name�;
				try {
					�p.name� = objectMapper.readValue(�p.name�Input, �writeTypeReferenceTypeStrong(p)�.class);
				} catch (JsonParseException e) {
					return "Error: Nem siker�lt kiolvasni az al�bbi Json param�tert: \"�p.name�\"!";
				} catch (JsonMappingException e) {
					return "Error: Nem siker�lt kiolvasni a(z) \"�p.name�\" param�terb�l egy \"�p.type.name�\" p�ld�nyt!";
				} catch (IOException e) {
					return "Error: Nem siker�lt kiolvasni az al�bbi param�tert: \"�p.name�\"!";
				}
				�ENDFOR�
				
				//M�velet v�grahajt�sa:
				�writeTypeReferenceType(function)� result =
					�component.system.systemNameSpace�.�component.name�.implementations.�service.path�Service.�function.name�(�writeEvaluatedParameters(function)�);
				
				//Eredm�ny soros�t�sa:
				try {
					return objectMapper.writeValueAsString(result);
				} catch (JsonParseException e) {
					return "Error: Nem siker�lt Json-ba �rni a m�velet eredm�ny�t!";
				} catch (JsonMappingException e) {
					return "Error: Nem siker�lt �rni egy \"�writeTypeReferenceType(function)�\" p�ld�nyt!";
				} catch (IOException e) {
					return "Error: Nem siker�lt ki�rni a m�velet eredm�ny�t!";
				}
			}
			�ENDFOR�
		}
		''')
	}
	
	def writeParameter(TypeReference parameter){
		'''�writeTypeReferenceType(parameter)� �parameter.name�'''
	}
	
	def writeParameters(Function function){
		'''�FOR parameter : function.parameters��writeParameter(parameter)��IF function.parameters.last!=parameter�, �ENDIF��ENDFOR�'''
	}
	
	// OSGi szolg�ltat�s megval�s�t�s oszt�ly�nak gener�tora
	def compileImpl(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		fsa.generateFile(service.path + "Service.java", "SERVICEIMPLEMENTATIONS", '''
		package �component.system.systemNameSpace�.�component.name�.implementations;
		
		import java.util.List;
		import java.util.ArrayList;
		
		import �component.system.systemNameSpace�.entities.*;
		
		import javax.persistence.EntityManager;
		import javax.persistence.EntityManagerFactory;
		
		public class �service.path�Service{
			�FOR function : service.functions�
			
			public static �writeParameter(function)�(�function.writeParameters�)
			{
				//EntityManager l�trehoz�sa:
				EntityManager entityManager =
					�component.system.systemNameSpace�.�component.name�.interfaces.�service.path�ServiceHelper.getEntityManager();
				�IF !function.queries.empty�
				
				//A modell szerint az al�bbi query-ket haszn�lja a f�ggv�ny:
				�ENDIF�
				�FOR NamedQuery nq : function.queries�
				List�IF nq.referred != null�<�nq.referred.name�>�ENDIF� �nq.name�Result = entityManager.createQuery("�nq.query�").getResultList();
				�ENDFOR�
				
				�IF function.methodType != MethodType::GET�
				// Ha tranzakci�szer� a f�ggv�ny, akkor elkezdj�k a tranzakci�t:
				entityManager.getTransaction().begin();
				
				�ENDIF�
				// Ide ker�l m�velet.
				
				�IF function.methodType != MethodType::GET�
				// �j elem l�trehoz�sa �s ment�se a k�vetkez�k�ppen t�rt�nik:
				// entityManager.persist(...);
				
				// Ha tranzakci�szer� a f�ggv�ny, akkor egyszer befejezz�k azt:
				entityManager.getTransaction().commit();
				
				�ENDIF�				
				// EntityManager lez�r�sa:
				entityManager.close();
				
				//De ez a f�ggv�ny m�g nincs k�sz:
				throw new UnsupportedOperationException();
			}
			�ENDFOR�
		}
		''')
	}
}