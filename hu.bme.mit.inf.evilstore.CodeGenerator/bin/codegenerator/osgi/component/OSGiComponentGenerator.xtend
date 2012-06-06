package codegenerator.osgi.component

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import evilsystem.Component
import codegenerator.entity.EntityGeneratorCode

class OSGiComponentGenerator implements IGenerator {
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def void compile(Component component, evilsystem.System system, IFileSystemAccess fsa) {
		fsa.generateFile("component.xml", "COMPONENT", '''
			<?xml version="1.0" encoding="UTF-8"?>
			<scr:component xmlns:scr="http://www.osgi.org/xmlns/scr/v1.1.0" name="«IF component != null»«component.system.systemNameSpace».«component.name»«ELSE»«system.systemNameSpace».entities«ENDIF»">
				«IF component != null»«FOR service : component.services»
				<implementation class="«component.system.systemNameSpace».«component.name».interfaces.«service.path»ServiceHelper"/>
				<service>
					<provide interface="«system.systemNameSpace».«component.name».interfaces.I«service.path»Service"/>
				</service>
			   «ENDFOR»«ELSE»
				<implementation class="«system.systemNameSpace».entitytester.«EntityGeneratorCode::DataBaseTesterClassName»"/>
				<service>
					<provide interface="«system.systemNameSpace».entitytester.«EntityGeneratorCode::DataBaseTesterInterfaceName»"/>
				</service>
			   «ENDIF»
			</scr:component>

		''')
	}
}