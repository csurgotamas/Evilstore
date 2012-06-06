package codegenerator.osgi.component;

import codegenerator.entity.EntityGeneratorCode;
import com.google.common.base.Objects;
import evilsystem.Component;
import evilsystem.Service;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class OSGiComponentGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final Component component, final evilsystem.System system, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" name=\"");
    {
      boolean _notEquals = (!Objects.equal(component, null));
      if (_notEquals) {
        evilsystem.System _system = component.getSystem();
        String _systemNameSpace = _system.getSystemNameSpace();
        _builder.append(_systemNameSpace, "");
        _builder.append(".");
        String _name = component.getName();
        _builder.append(_name, "");
      } else {
        String _systemNameSpace_1 = system.getSystemNameSpace();
        _builder.append(_systemNameSpace_1, "");
        _builder.append(".entities");
      }
    }
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      boolean _notEquals_1 = (!Objects.equal(component, null));
      if (_notEquals_1) {
        {
          EList<Service> _services = component.getServices();
          for(final Service service : _services) {
            _builder.append("\t");
            _builder.append("<implementation class=\"");
            evilsystem.System _system_1 = component.getSystem();
            String _systemNameSpace_2 = _system_1.getSystemNameSpace();
            _builder.append(_systemNameSpace_2, "	");
            _builder.append(".");
            String _name_1 = component.getName();
            _builder.append(_name_1, "	");
            _builder.append(".interfaces.");
            String _path = service.getPath();
            _builder.append(_path, "	");
            _builder.append("ServiceHelper\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<service>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<provide interface=\"");
            String _systemNameSpace_3 = system.getSystemNameSpace();
            _builder.append(_systemNameSpace_3, "		");
            _builder.append(".");
            String _name_2 = component.getName();
            _builder.append(_name_2, "		");
            _builder.append(".interfaces.I");
            String _path_1 = service.getPath();
            _builder.append(_path_1, "		");
            _builder.append("Service\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("</service>");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t");
        _builder.append("<implementation class=\"");
        String _systemNameSpace_4 = system.getSystemNameSpace();
        _builder.append(_systemNameSpace_4, "	");
        _builder.append(".entitytester.");
        _builder.append(EntityGeneratorCode.DataBaseTesterClassName, "	");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<service>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<provide interface=\"");
        String _systemNameSpace_5 = system.getSystemNameSpace();
        _builder.append(_systemNameSpace_5, "		");
        _builder.append(".entitytester.");
        _builder.append(EntityGeneratorCode.DataBaseTesterInterfaceName, "		");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</service>");
        _builder.newLine();
      }
    }
    _builder.append("</scr:component>");
    _builder.newLine();
    _builder.newLine();
    fsa.generateFile("component.xml", "COMPONENT", _builder);
  }
}
