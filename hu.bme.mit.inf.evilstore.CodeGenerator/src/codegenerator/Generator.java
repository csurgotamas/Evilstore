package codegenerator;

import codegenerator.dotnet.DotNetGeneratorCode;
import codegenerator.entity.EntityGeneratorCode;
import codegenerator.osgi.OSGiGeneratorCode;
//evilsystem-et ne import�ljuk, evilsystem.XXX-et haszn�lunk n�vt�r�tk�z�sek elker�l�se v�gett.

public class Generator  {
	
	public void generateCodeFromInstance(evilsystem.System system) {
		
		//�j szervez�s
		//Komponensek gener�l�sa
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
		//Entit�sok gener�l�sa
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
