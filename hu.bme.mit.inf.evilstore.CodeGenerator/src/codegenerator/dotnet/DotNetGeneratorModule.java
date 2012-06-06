package codegenerator.dotnet;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

import codegenerator.osgi.OSGiGenerator;

public class DotNetGeneratorModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		// TODO Auto-generated method stub
		return "Service";
	}

	@Override
	protected String getFileExtensions() {
		// TODO Auto-generated method stub
		return "Service";
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return OSGiGenerator.class;
	}
	public Class<? extends ResourceSet> bindResourceSet() {
		return ResourceSetImpl.class;
	}

}
