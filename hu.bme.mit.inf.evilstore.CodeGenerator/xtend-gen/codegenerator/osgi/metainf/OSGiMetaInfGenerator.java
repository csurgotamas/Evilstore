package codegenerator.osgi.metainf;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class OSGiMetaInfGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final evilsystem.System thisSystem, final String simbolicname, final evilsystem.System useThisSystemsEntities, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: Entity");
    _builder.newLine();
    _builder.append("Bundle-SymbolicName: ");
    _builder.append(simbolicname, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-Version: 1.0.0.qualifier");
    _builder.newLine();
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    _builder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
    _builder.newLine();
    _builder.append("Import-Package: org.osgi.framework;version=\"1.3.0\"");
    _builder.newLine();
    _builder.append("Require-Bundle: com.sun.jersey.jersey-core;bundle-version=\"1.11.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("com.sun.jersey.jersey-server;bundle-version=\"1.11.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("com.sun.jersey.jersey-servlet;bundle-version=\"1.11.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.apache.derby;bundle-version=\"10.5.1\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.persistence.jpa;bundle-version=\"2.3.2\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("javax.persistence;bundle-version=\"2.0.3\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("com.eclipsesource.jaxrs.connector;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("jackson-mapper-asl;bundle-version=\"1.9.6\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("jackson-core-asl;bundle-version=\"1.9.6\"");
    {
      boolean _notEquals = (!Objects.equal(useThisSystemsEntities, null));
      if (_notEquals) {
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        String _systemNameSpace = useThisSystemsEntities.getSystemNameSpace();
        _builder.append(_systemNameSpace, " ");
        _builder.append(".entities;bundle-version=\"1.0.0\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("Service-Component: OSGI-INF/component.xml");
    _builder.newLine();
    _builder.append("JPA-PersistenceUnits: osgi.demo.jpa");
    _builder.newLine();
    {
      boolean _equals = Objects.equal(useThisSystemsEntities, null);
      if (_equals) {
        _builder.append("Export-Package: ");
        String _systemNameSpace_1 = thisSystem.getSystemNameSpace();
        _builder.append(_systemNameSpace_1, "");
        _builder.append(".entities,");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        String _systemNameSpace_2 = thisSystem.getSystemNameSpace();
        _builder.append(_systemNameSpace_2, " ");
        _builder.append(".entitycollections");
      }
    }
    _builder.newLineIfNotEmpty();
    fsa.generateFile("MANIFEST.MF", "METAINF", _builder);
  }
}
