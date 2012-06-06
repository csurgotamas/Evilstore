package codegenerator.entity.persistence;

import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

import codegenerator.ProjectGenerator;

public class EntityPersistenceGeneratorCode {
	public static void generateEntityPersistence(evilsystem.System system, EclipseResourceFileSystemAccess2 fsa)
	{
		ProjectGenerator.addFolder(fsa, "PERSISTENCE", "src/META-INF", false);
		EntityPersistenceGenerator gen = new EntityPersistenceGenerator();
		gen.compile(system,fsa);
	}
}
