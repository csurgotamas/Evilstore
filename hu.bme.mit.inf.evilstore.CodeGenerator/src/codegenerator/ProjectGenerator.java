package codegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;

public class ProjectGenerator {
	
	public static IProject getProject(String projectname, IProgressMonitor monitor) throws EvilGenerationException
	{
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		try{
		if (!p.exists()) {
			p.create(monitor);
		}
		p.open(monitor);
		return p;
		}catch(CoreException c)
		{
			throw new EvilGenerationException("The Project \""+projectname+"\" hasn't opened/initialised.");
		}
	}
	
	public static void addFolder(EclipseResourceFileSystemAccess2 fsa, String configName,  String dirname, boolean isEditable)
	{
		Map<String, OutputConfiguration> outputs = fsa.getOutputConfigurations();
		OutputConfiguration out = new OutputConfiguration(configName);
		out.setOutputDirectory(dirname);
		out.setCanClearOutputDirectory(!isEditable);
		out.setCleanUpDerivedResources(true);
		out.setCreateOutputDirectory(true);
		out.setOverrideExistingResources(!isEditable);
		out.setSetDerivedProperty(!isEditable);
		outputs.put(configName, out);
	}
	
	public static EclipseResourceFileSystemAccess2 getConfiguredFileSystemAccess(IProject p) {
		EclipseResourceFileSystemAccess2 fsa = new EclipseResourceFileSystemAccess2();
		fsa.setProject(p);
		
		Map<String, OutputConfiguration> outputs = new HashMap<String, OutputConfiguration>();
		fsa.setOutputConfigurations(outputs);
		addFolder(fsa,IFileSystemAccess.DEFAULT_OUTPUT,"Ez a projekt gyökerébe kéne hogy jöjjön!", true);
		
		fsa.setPostProcessor(new IFileCallback() {
			@Override
			public boolean beforeFileDeletion(IFile file) {
				return false;
			}
			
			@Override
			public void afterFileUpdate(IFile file) {
			}
			
			@Override
			public void afterFileCreation(IFile file) {
			}
		});
		return fsa;
	}
	
	public static String NamespaceToFolders(String namespace)
	{
		return namespace.replace('.', '/');
	}
	
	public static void BringTheProjectToLife(IProject p, String pn/*, String dependentEntry*/, IProgressMonitor monitor) throws EvilGenerationException
	{
		try{
		IProjectDescription desc = p.getDescription();
		List<String> newNatures = new ArrayList<String>();
		newNatures.addAll(Arrays.asList(new String[] {
				"org.eclipse.pde.PluginNature","org.eclipse.jdt.core.javanature" }));
		desc.setNatureIds(newNatures.toArray(new String[newNatures.size()]));
		p.setDescription(desc, monitor);
		
		///build
		IJavaProject javaProject = JavaCore.create(p);
		IClasspathEntry[] newClasspath ={
				JavaCore.newContainerEntry(
						new Path("org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6")),
				JavaCore.newContainerEntry(
						new Path("org.eclipse.pde.core.requiredPlugins")),
				 JavaCore.newSourceEntry(
						new Path("/"+pn+"/src")),
			    JavaCore.newSourceEntry(
					    new Path("/"+pn+"/OSGI-INF"))};
		IClasspathEntry[] newClasspathWithDependencies;
		/*if(dependentEntry!=null)
		{
			newClasspathWithDependencies= new IClasspathEntry[newClasspath.length+1];
			for(int i=0; i<newClasspath.length; i++)
				newClasspathWithDependencies[i]=newClasspath[i];
			newClasspathWithDependencies[newClasspath.length]= JavaCore.new
		}
		else */newClasspathWithDependencies=newClasspath;
		javaProject.setRawClasspath(newClasspathWithDependencies, monitor);
		javaProject.setOutputLocation(new Path("/"+pn+"/bin"), monitor);
		///endbuild
		
		p.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		
		}catch(CoreException e)
		{
			throw new EvilGenerationException("Problem during bringing life into the project!");
		}
	}
}
