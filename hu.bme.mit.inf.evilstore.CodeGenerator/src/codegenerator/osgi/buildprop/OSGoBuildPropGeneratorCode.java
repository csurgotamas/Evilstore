package codegenerator.osgi.buildprop;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

public class OSGoBuildPropGeneratorCode {
	public static void generateBuildProperties(
			EclipseResourceFileSystemAccess2 fsa, IProject p) {
		/*
		 * ProjectGenerator.addFolder(fsa, "BUILDPROP", "./");
		 * EntityBuildPropGenerator gen = new EntityBuildPropGenerator();
		 * gen.compile(system, fsa);
		 */

		IFile newfile = p.getFile("/build.properties");
		try {
			InputStream iStream = new ByteArrayInputStream(prop.getBytes());
			newfile.create(iStream, false, new NullProgressMonitor());
		} catch (CoreException e) {
			//Ha már létezik, nem kell mást csinálni.
		}

	}

	private final static String prop = "output.. = bin/\n"
			+ "bin.includes = META-INF/,\\\n" + "           .,\\\n"
			+ "           OSGI-INF/component.xml,\\\n"
			+ "           OSGI-INF/\n" + "source.. = src/,\\\n"
			+ "       OSGI-INF/";
}
