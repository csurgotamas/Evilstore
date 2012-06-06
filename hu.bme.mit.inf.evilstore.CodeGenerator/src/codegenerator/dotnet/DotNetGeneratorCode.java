package codegenerator.dotnet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import codegenerator.ProjectGenerator;
import evilsystem.Component;

public class DotNetGeneratorCode {
	
	public static String getProjectName(evilsystem.Component component)
	{
		return component.getSystem().getSystemNameSpace()+"."+component.getName();
	}
	
	/**
	 * System generálása.
	 * 
	 * @param component
	 */
	public static void generateDotNetProject(final evilsystem.Component component) {
		
			Job job = new Job("Generating the .NET services") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						String pn = getProjectName(component);
						IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pn);
						if (p.exists()) {
							p.delete(true, monitor);
						} 
						p.create(monitor);
						p.open(monitor);
						
						EclipseResourceFileSystemAccess2 fsa = ProjectGenerator.getConfiguredFileSystemAccess(p);
						fsa.setMonitor(monitor);
						
						DotNetGeneratorCode.generateDotNetComponent(component,fsa);
						
						//ProjectGenerator.BringTheProjectToLife(p, pn, monitor);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return Status.OK_STATUS;
				}
			};
			job.schedule();
	}
	
	protected static void generateDotNetComponent(Component component,
			EclipseResourceFileSystemAccess2 fsa) {
		ProjectGenerator.addFolder(fsa, "DOTNETCOMPONENT",
				ProjectGenerator.NamespaceToFolders(
					component.getName()+"."+".Services"),true);
		ProjectGenerator.addFolder(fsa, "SERVICEIMPLEMENTATIONS",
				ProjectGenerator.NamespaceToFolders(
					component.getName()+"."+".Implementations"),false);
		
		DotNetGenerator gen = new DotNetGenerator();
		gen.compile(component, fsa);
	}
}