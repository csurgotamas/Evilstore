package codegenerator.osgi.metainf;

import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import codegenerator.ProjectGenerator;

public class OSGiMetaInfGeneratorCode {
	public static void generateMetaInf(evilsystem.System thisSystem, String simbolicname, evilsystem.System useThisSystemEntities, EclipseResourceFileSystemAccess2 fsa)
	{
		ProjectGenerator.addFolder(fsa, "METAINF", "META-INF", true);
		OSGiMetaInfGenerator gen = new OSGiMetaInfGenerator();
		gen.compile(thisSystem, simbolicname,useThisSystemEntities,fsa);
	}
}
