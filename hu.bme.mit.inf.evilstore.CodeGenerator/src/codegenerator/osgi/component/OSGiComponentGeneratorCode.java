package codegenerator.osgi.component;

import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

import codegenerator.ProjectGenerator;

public class OSGiComponentGeneratorCode {
	public static void generateOSGiComponent(evilsystem.Component component, evilsystem.System system, EclipseResourceFileSystemAccess2 fsa)
	{
		ProjectGenerator.addFolder(fsa, "COMPONENT", "OSGI-INF", false);
		OSGiComponentGenerator gen = new OSGiComponentGenerator();
		gen.compile(component, system, fsa);
	}
}
