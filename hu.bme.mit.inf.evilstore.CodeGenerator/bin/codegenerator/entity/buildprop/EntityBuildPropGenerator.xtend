package codegenerator.entity.buildprop

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class EntityBuildPropGenerator implements IGenerator {
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
	}
	
	def void compile(evilsystem.System system, IFileSystemAccess fsa) {
		fsa.generateFile("build.properties", '''
		output.. = bin/
		bin.includes = META-INF/,\
		               .,\
		               OSGI-INF/component.xml,\
		               OSGI-INF/
		source.. = src/,\
		           OSGI-INF/
				
		''')
	}
}