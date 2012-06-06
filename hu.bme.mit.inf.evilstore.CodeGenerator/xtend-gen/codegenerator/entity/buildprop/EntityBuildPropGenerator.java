package codegenerator.entity.buildprop;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class EntityBuildPropGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final evilsystem.System system, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("output.. = bin/");
    _builder.newLine();
    _builder.append("bin.includes = META-INF/,\\");
    _builder.newLine();
    _builder.append("               ");
    _builder.append(".,\\");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("OSGI-INF/component.xml,\\");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("OSGI-INF/");
    _builder.newLine();
    _builder.append("source.. = src/,\\");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("OSGI-INF/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    fsa.generateFile("build.properties", _builder);
  }
}
