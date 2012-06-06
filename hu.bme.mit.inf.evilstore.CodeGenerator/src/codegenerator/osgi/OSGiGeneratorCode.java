package codegenerator.osgi;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

import codegenerator.EvilGenerationException;
import codegenerator.ProjectGenerator;
import codegenerator.entity.persistence.EntityPersistenceGeneratorCode;
import codegenerator.osgi.buildprop.OSGoBuildPropGeneratorCode;
import codegenerator.osgi.component.OSGiComponentGeneratorCode;
import codegenerator.osgi.metainf.OSGiMetaInfGeneratorCode;
import evilsystem.Component;

public class OSGiGeneratorCode {
	
	public static String getProjectName(evilsystem.Component component)
	{
		return component.getSystem().getSystemNameSpace()+"."+component.getName();
	}
	
	/**
	 * System generálása.
	 * 
	 * @param component
	 */
	public static void generateOSGiProject(final evilsystem.Component component) {
		
			Job job = new Job("Generating the OSGi services") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						String pn = getProjectName(component);
						IProject p = ProjectGenerator.getProject(pn, monitor);
						
						EclipseResourceFileSystemAccess2 fsa = ProjectGenerator.getConfiguredFileSystemAccess(p);
						fsa.setMonitor(monitor);
						
						OSGiGeneratorCode.generateOSGiComponent(component,fsa);
						OSGiMetaInfGeneratorCode.generateMetaInf(component.getSystem(), component.getSystem().getSystemNameSpace()+"."+component.getName(),component.getSystem(), fsa);
						OSGiComponentGeneratorCode.generateOSGiComponent(component, component.getSystem(), fsa);
						OSGoBuildPropGeneratorCode.generateBuildProperties(fsa, p);
						
						//Nem tudom miért, de néha kell a persistence.xml a service-knek is.
						EntityPersistenceGeneratorCode.generateEntityPersistence(component.getSystem(), fsa);
						
						ProjectGenerator.BringTheProjectToLife(p, pn, monitor);
						
					} catch (EvilGenerationException e) {
						codegenerator.handlers.GeneratorHandler.showErrorMessage(e.getReason());
					}
					return Status.OK_STATUS;
				}
			};
			job.schedule();
	}
	
	protected static void generateOSGiComponent(Component component,
			EclipseResourceFileSystemAccess2 fsa) {
		ProjectGenerator.addFolder(fsa, "SERVICEINTERFACES",
				ProjectGenerator.NamespaceToFolders(
					"src/"+component.getSystem().getSystemNameSpace()+"."+component.getName()+".interfaces"), false);
		ProjectGenerator.addFolder(fsa, "SERVICEIMPLEMENTATIONS",
				ProjectGenerator.NamespaceToFolders(
						"src/"+component.getSystem().getSystemNameSpace()+"."+component.getName()+".implementations"), true);
		OSGiGenerator gen = new OSGiGenerator();
		gen.compile(component, fsa);
	}
}
