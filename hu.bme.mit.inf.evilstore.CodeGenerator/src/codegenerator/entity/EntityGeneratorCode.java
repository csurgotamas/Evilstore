package codegenerator.entity;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

import codegenerator.EvilGenerationException;
import codegenerator.ProjectGenerator;
import codegenerator.entity.buildprop.EntityBuildPropGeneratorCode;
import codegenerator.entity.persistence.EntityPersistenceGeneratorCode;
import codegenerator.osgi.component.OSGiComponentGeneratorCode;
import codegenerator.osgi.metainf.OSGiMetaInfGeneratorCode;

public class EntityGeneratorCode {

	public final static String DataBaseTesterClassName = "DataBaseTester";
	public final static String DataBaseTesterInterfaceName = "IDataBaseTester";
	
	
	public static String getProjectName(evilsystem.System system)
	{
		return system.getSystemNameSpace()+".entities";
	}
	
	/**
	 * System generálása.
	 * 
	 * @param system
	 */
	public static void generateEntityProject(final evilsystem.System system) {
		
			Job job = new Job("Generatin the entities of the system: "+system.getSystemNameSpace()) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						//Creating Project
						String pn = getProjectName(system);
						IProject p = ProjectGenerator.getProject(pn, monitor);
						
						EclipseResourceFileSystemAccess2 fsa = ProjectGenerator.getConfiguredFileSystemAccess(p);
						fsa.setMonitor(monitor);
						
						EntityGeneratorCode.generateEntities(system,fsa);
						OSGiMetaInfGeneratorCode.generateMetaInf(system, system.getSystemNameSpace()+".entities",null, fsa);
						EntityBuildPropGeneratorCode.generateBuildProperties(system, fsa,p);
						EntityPersistenceGeneratorCode.generateEntityPersistence(system, fsa);
						OSGiComponentGeneratorCode.generateOSGiComponent(null, system, fsa);
						
						ProjectGenerator.BringTheProjectToLife(p, pn, monitor);
						
					} catch (EvilGenerationException e) {
						codegenerator.handlers.GeneratorHandler.showErrorMessage(e.getReason());
					}
					return Status.OK_STATUS;
				}
			};
			job.schedule();
	}
	
	public static void generateEntities(evilsystem.System system, EclipseResourceFileSystemAccess2 fsa)
	{
		ProjectGenerator.addFolder(fsa, "SOURCES", "src/"+ProjectGenerator.NamespaceToFolders(system.getSystemNameSpace()+".entities"), false);
		ProjectGenerator.addFolder(fsa, "SOURCESCOLLECTION", "src/"+ProjectGenerator.NamespaceToFolders(system.getSystemNameSpace()+".entitycollections"), false);
		ProjectGenerator.addFolder(fsa, "TESTER", "src/"+ProjectGenerator.NamespaceToFolders(system.getSystemNameSpace()+".entitytester"), false);
		EntityGenerator gen = new EntityGenerator();
		gen.doGenerate(system.eResource(), fsa);
	}
}
