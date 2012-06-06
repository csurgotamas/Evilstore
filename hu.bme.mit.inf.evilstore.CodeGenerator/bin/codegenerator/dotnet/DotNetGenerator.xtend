package codegenerator.dotnet

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import evilsystem.Component
import evilsystem.MethodType
import evilsystem.Parameter
import evilsystem.Function
import evilsystem.TypeReference
import evilsystem.Type
import evilsystem.SimpleType


class DotNetGenerator implements IGenerator {
	

	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def compile(Component component, IFileSystemAccess fsa) {
		for (service : component.services) {
			service.compileDotnet(fsa, component)
		}
	}
	
	// .NET szolgáltatás generátor
	def compileDotnet(evilsystem.Service service, IFileSystemAccess fsa, Component component) {
		//Interface generálás
		fsa.generateFile("I" + service.path + ".cs","DOTNETCOMPONENT", '''
		using System;
		using System.ServiceModel;
		using System.ServiceModel.Web;
		
		
		namespace Appstore.«component.name».Services 
		{
			
			[ServiceContract]
			public interface I«service.path»Service
			{
				«FOR function : service.functions»
					[OperationContract(Name = "«function.name»")]
					«IF (function.methodType == MethodType::GET)»[WebGet(UriTemplate = "/«function.name»«function.writePathParams»"«ELSE»[WebInvoke(UriTemplate = "/«function.name»«function.writePathParams»", Method = "«function.methodType»"«ENDIF», ResponseFormat = WebMessageFormat.Json)]
					String «function.name»(«function.writeStringParameters»);
				«ENDFOR»
			}
		}
		
		''')
		
		//osztály generálás
		fsa.generateFile(service.path + ".svc.cs","DOTNETCOMPONENT", '''
		using System;
		using System.Collections.Generic;
		using System.Linq;
		using System.Runtime.Serialization;
		using System.Text;
		using Newtonsoft.Json;
		
		
		namespace Appstore.«component.name».Services 
		{
			
			public class «service.path»Service : I«service.path»Service
			{
				«FOR function : service.functions»
					public String «function.name»(«function.writeStringParameters2»)
					{
						//Objektumok parse-olása a bemenetbõl.
						«FOR Parameter p : function.parameters»
						«writeTypeReferenceType(p)» «p.name»;
						«ENDFOR»
						try 
						{
							«FOR Parameter p : function.parameters»
							«p.name» = JsonConvert.DeserializeObject<«writeType(p)»>(«p.name»Input);
							«ENDFOR»
						}
						catch (JsonReaderException)
						{
							return "Hiba történt a JSON parseolásakor";
						}
						
						«writeTypeReferenceType(function)» result;
						try
						{
							result = «service.path»Helper.«function.name»(«writeEvaluatedParameters(function)»);
						}
						catch (Exception e)
						{
							return e.ToString();
						}
						
						try
						{
							return JsonConvert.SerializeObject(result);
						}
						catch (JsonReaderException)
						{
							return "Hiba történt a JSON parseolásakor";
						}
					}
				«ENDFOR»
			}
		}
		
		''')
		
		//svc fájl generálás
		fsa.generateFile(service.path + ".svc","DOTNETCOMPONENT", '''
		<%@ ServiceHost Language="C#" Debug="true" Service="Appstore.«component.name».Services.«service.path»Service" CodeBehind="«service.path».svc.cs"
		Factory ="System.ServiceModel.Activation.WebServiceHostFactory" %>
		''')
		
		//tényleges funkciót megvalósító osztály generálás
		fsa.generateFile(service.path + "Helper.cs","SERVICEIMPLEMENTATIONS", '''
		using System;
		using System.Collections.Generic;
		using System.Linq;
		using System.Runtime.Serialization;
		using System.Text;
		using Newtonsoft.Json;
		
		
		namespace Appstore.«component.name».Services 
		{
			
			public class «service.path»Helper
			{
				«FOR function : service.functions»
					public static «writeParameter(function)»(«function.writeParameters»)
					{
						«writeTypeReferenceType(function)» ret;
						
						throw new NotImplementedException();
						/* Implement function *
						ret = ;
						/* */
						
						return ret;
					}
				«ENDFOR»
			}
		}
		
		''')
	
	}
	
	
	def writeTypeReferenceType(TypeReference typeReference)
	{
		'''«IF typeReference.collection»List<«writeType(typeReference)»>«ELSE»«writeType(typeReference)»«ENDIF»'''
	}
	
	def writeType(TypeReference typeReference)
	{
		'''«IF typeReference.type.name == "Integer"»Int32«ELSE»«typeReference.type.name»«ENDIF»'''
	}
	
	def writePathParams(Function function)
	{
		'''«FOR parameter : function.parameters»/{«parameter.name»}«ENDFOR»'''
	}
	
	def writeStringParameter(Parameter parameter)
	{
		'''String «parameter.name»'''
	}
	
	def writeStringParameters(Function function)
	{
		'''«FOR parameter : function.parameters»«writeStringParameter(parameter)»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''
	}
	
	def writeStringParameters2(Function function)
	{
		'''«FOR parameter : function.parameters»«writeStringParameter(parameter)»Input«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''
	}
	
	def writeEvaluatedParameters(evilsystem.Function function)
	{
		'''«FOR parameter : function.parameters»«parameter.name»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''	
	}
	
	def writeParameter(TypeReference parameter)
	{
		'''«writeTypeReferenceType(parameter)» «parameter.name»'''
	}
	
	def writeParameters(Function function)
	{
		'''«FOR parameter : function.parameters»«writeParameter(parameter)»«IF function.parameters.last!=parameter», «ENDIF»«ENDFOR»'''
	}
	
	
}