package codegenerator.entity.persistence;

import com.google.common.collect.Iterables;
import evilsystem.Entity;
import evilsystem.PackageElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class EntityPersistenceGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final evilsystem.System system, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    _builder.newLine();
    _builder.append("<persistence version=\"2.0\" xmlns=\"http://java.sun.com/xml/ns/persistence\" ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<persistence-unit name=\"osgi.demo.jpa\" transaction-type=\"RESOURCE_LOCAL\">");
    _builder.newLine();
    {
      EList<PackageElement> _elements = system.getElements();
      Iterable<Entity> _filter = Iterables.<Entity>filter(_elements, Entity.class);
      for(final Entity entity : _filter) {
        _builder.append("        ");
        _builder.append("<class>");
        String _systemNameSpace = system.getSystemNameSpace();
        _builder.append(_systemNameSpace, "        ");
        _builder.append(".entities.");
        String _name = entity.getName();
        _builder.append(_name, "        ");
        _builder.append("</class>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("        ");
    _builder.append("<properties>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<!-- Embedded Derby Login -->");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"javax.persistence.jdbc.driver\" value=\"org.apache.derby.jdbc.EmbeddedDriver\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"javax.persistence.jdbc.url\" value=\"jdbc:derby:books;create=true\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<!-- don\'t need userid/password in embedded Derby -->");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.target-database\" value=\"Derby\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.jdbc.read-connections.min\" value=\"1\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.jdbc.write-connections.min\" value=\"1\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.jdbc.batch-writing\" value=\"JDBC\"/>");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<!-- Database Schema Creation -->");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.ddl-generation\" value=\"drop-and-create-tables\"/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.ddl-generation.output-mode\" value=\"database\"/>");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<!-- Logging Settings -->");
    _builder.newLine();
    _builder.append("            ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.logging.level\" value=\"FINEST\" />");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.logging.thread\" value=\"FINEST\" />");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.logging.session\" value=\"FINEST\" />");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.logging.exceptions\" value=\"FINEST\" />");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<property name=\"eclipselink.logging.timestamp\" value=\"FINEST\"/>             ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</properties>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</persistence-unit>");
    _builder.newLine();
    _builder.append("</persistence>");
    _builder.newLine();
    _builder.newLine();
    fsa.generateFile("persistence.xml", "PERSISTENCE", _builder);
  }
}
