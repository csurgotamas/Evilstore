package codegenerator.osgi;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class OSGiGeneratorSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		// TODO Auto-generated method stub
		return new OSGiGeneratorModule();
	}

}
