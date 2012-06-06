package codegenerator.entity;

import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class EntityGeneratorSetup implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		// TODO Auto-generated method stub
		return Guice.createInjector(new EntityGeneratorModule());
	}

}
