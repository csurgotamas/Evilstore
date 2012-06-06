package codegenerator;

import codegenerator.dotnet.DotNetGeneratorCode;
import codegenerator.entity.EntityGeneratorCode;
import codegenerator.osgi.OSGiGeneratorCode;
//evilsystem-et ne importáljuk, evilsystem.XXX-et használunk névtérütközések elkerülése végett.

public class Generator  {
	
	public void generateCodeFromInstance(evilsystem.System system) {
		
		//Új szervezés
		//Komponensek generálása
		for(evilsystem.PackageElement packageElement : system.getElements())
		{
			if(packageElement instanceof evilsystem.Component)
			{
				evilsystem.Component component = (evilsystem.Component) packageElement; 
				if(component.getPlatform() == evilsystem.Platform.OS_GI)
				{
					generateOSGiComponent(component);
				}
				else if(component.getPlatform() == evilsystem.Platform.DOT_NET)
				{
					generateDotNetComponent(component);
				}
			}
		}
		//Entitások generálása
		this.generateOSGiEntities(system);
	}
	
	private void generateOSGiEntities(final evilsystem.System system)
	{
		EntityGeneratorCode.generateEntityProject(system);
	}
	
	private void generateOSGiComponent(final evilsystem.Component component)
	{
		OSGiGeneratorCode.generateOSGiProject(component);
	}
	
	private void generateDotNetComponent(final evilsystem.Component component)
	{
		DotNetGeneratorCode.generateDotNetProject(component);
	}
}
