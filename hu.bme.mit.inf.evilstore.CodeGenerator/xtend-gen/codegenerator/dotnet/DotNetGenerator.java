package codegenerator.dotnet;

import com.google.common.base.Objects;
import evilsystem.Component;
import evilsystem.Function;
import evilsystem.MethodType;
import evilsystem.Parameter;
import evilsystem.Service;
import evilsystem.Type;
import evilsystem.TypeReference;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DotNetGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final Component component, final IFileSystemAccess fsa) {
    EList<Service> _services = component.getServices();
    for (final Service service : _services) {
      this.compileDotnet(service, fsa, component);
    }
  }
  
  public void compileDotnet(final Service service, final IFileSystemAccess fsa, final Component component) {
    String _path = service.getPath();
    String _plus = ("I" + _path);
    String _plus_1 = (_plus + ".cs");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("using System;");
    _builder.newLine();
    _builder.append("using System.ServiceModel;");
    _builder.newLine();
    _builder.append("using System.ServiceModel.Web;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("namespace Appstore.");
    String _name = component.getName();
    _builder.append(_name, "");
    _builder.append(".Services ");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[ServiceContract]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public interface I");
    String _path_1 = service.getPath();
    _builder.append(_path_1, "	");
    _builder.append("Service");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    {
      EList<Function> _functions = service.getFunctions();
      for(final Function function : _functions) {
        _builder.append("\t\t");
        _builder.append("[OperationContract(Name = \"");
        String _name_1 = function.getName();
        _builder.append(_name_1, "		");
        _builder.append("\")]");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        {
          MethodType _methodType = function.getMethodType();
          boolean _equals = Objects.equal(_methodType, MethodType.GET);
          if (_equals) {
            _builder.append("[WebGet(UriTemplate = \"/");
            String _name_2 = function.getName();
            _builder.append(_name_2, "		");
            CharSequence _writePathParams = this.writePathParams(function);
            _builder.append(_writePathParams, "		");
            _builder.append("\"");
          } else {
            _builder.append("[WebInvoke(UriTemplate = \"/");
            String _name_3 = function.getName();
            _builder.append(_name_3, "		");
            CharSequence _writePathParams_1 = this.writePathParams(function);
            _builder.append(_writePathParams_1, "		");
            _builder.append("\", Method = \"");
            MethodType _methodType_1 = function.getMethodType();
            _builder.append(_methodType_1, "		");
            _builder.append("\"");
          }
        }
        _builder.append(", ResponseFormat = WebMessageFormat.Json)]");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("String ");
        String _name_4 = function.getName();
        _builder.append(_name_4, "		");
        _builder.append("(");
        CharSequence _writeStringParameters = this.writeStringParameters(function);
        _builder.append(_writeStringParameters, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    fsa.generateFile(_plus_1, "DOTNETCOMPONENT", _builder);
    String _path_2 = service.getPath();
    String _plus_2 = (_path_2 + ".svc.cs");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("using System;");
    _builder_1.newLine();
    _builder_1.append("using System.Collections.Generic;");
    _builder_1.newLine();
    _builder_1.append("using System.Linq;");
    _builder_1.newLine();
    _builder_1.append("using System.Runtime.Serialization;");
    _builder_1.newLine();
    _builder_1.append("using System.Text;");
    _builder_1.newLine();
    _builder_1.append("using Newtonsoft.Json;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("namespace Appstore.");
    String _name_5 = component.getName();
    _builder_1.append(_name_5, "");
    _builder_1.append(".Services ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public class ");
    String _path_3 = service.getPath();
    _builder_1.append(_path_3, "	");
    _builder_1.append("Service : I");
    String _path_4 = service.getPath();
    _builder_1.append(_path_4, "	");
    _builder_1.append("Service");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("{");
    _builder_1.newLine();
    {
      EList<Function> _functions_1 = service.getFunctions();
      for(final Function function_1 : _functions_1) {
        _builder_1.append("\t\t");
        _builder_1.append("public String ");
        String _name_6 = function_1.getName();
        _builder_1.append(_name_6, "		");
        _builder_1.append("(");
        CharSequence _writeStringParameters2 = this.writeStringParameters2(function_1);
        _builder_1.append(_writeStringParameters2, "		");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("//Objektumok parse-ol\u00E1sa a bemenetb\u0151l.");
        _builder_1.newLine();
        {
          EList<Parameter> _parameters = function_1.getParameters();
          for(final Parameter p : _parameters) {
            _builder_1.append("\t\t");
            _builder_1.append("\t");
            CharSequence _writeTypeReferenceType = this.writeTypeReferenceType(p);
            _builder_1.append(_writeTypeReferenceType, "			");
            _builder_1.append(" ");
            String _name_7 = p.getName();
            _builder_1.append(_name_7, "			");
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("try ");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        {
          EList<Parameter> _parameters_1 = function_1.getParameters();
          for(final Parameter p_1 : _parameters_1) {
            _builder_1.append("\t\t");
            _builder_1.append("\t\t");
            String _name_8 = p_1.getName();
            _builder_1.append(_name_8, "				");
            _builder_1.append(" = JsonConvert.DeserializeObject<");
            CharSequence _writeType = this.writeType(p_1);
            _builder_1.append(_writeType, "				");
            _builder_1.append(">(");
            String _name_9 = p_1.getName();
            _builder_1.append(_name_9, "				");
            _builder_1.append("Input);");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("catch (JsonReaderException)");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t\t");
        _builder_1.append("return \"Hiba t\u00F6rt\u00E9nt a JSON parseol\u00E1sakor\";");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        CharSequence _writeTypeReferenceType_1 = this.writeTypeReferenceType(function_1);
        _builder_1.append(_writeTypeReferenceType_1, "			");
        _builder_1.append(" result;");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("try");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t\t");
        _builder_1.append("result = ");
        String _path_5 = service.getPath();
        _builder_1.append(_path_5, "				");
        _builder_1.append("Helper.");
        String _name_10 = function_1.getName();
        _builder_1.append(_name_10, "				");
        _builder_1.append("(");
        CharSequence _writeEvaluatedParameters = this.writeEvaluatedParameters(function_1);
        _builder_1.append(_writeEvaluatedParameters, "				");
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("catch (Exception e)");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t\t");
        _builder_1.append("return e.ToString();");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("try");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t\t");
        _builder_1.append("return JsonConvert.SerializeObject(result);");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("catch (JsonReaderException)");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t\t");
        _builder_1.append("return \"Hiba t\u00F6rt\u00E9nt a JSON parseol\u00E1sakor\";");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("}");
        _builder_1.newLine();
      }
    }
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    fsa.generateFile(_plus_2, "DOTNETCOMPONENT", _builder_1);
    String _path_6 = service.getPath();
    String _plus_3 = (_path_6 + ".svc");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("<%@ ServiceHost Language=\"C#\" Debug=\"true\" Service=\"Appstore.");
    String _name_11 = component.getName();
    _builder_2.append(_name_11, "");
    _builder_2.append(".Services.");
    String _path_7 = service.getPath();
    _builder_2.append(_path_7, "");
    _builder_2.append("Service\" CodeBehind=\"");
    String _path_8 = service.getPath();
    _builder_2.append(_path_8, "");
    _builder_2.append(".svc.cs\"");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("Factory =\"System.ServiceModel.Activation.WebServiceHostFactory\" %>");
    _builder_2.newLine();
    fsa.generateFile(_plus_3, "DOTNETCOMPONENT", _builder_2);
    String _path_9 = service.getPath();
    String _plus_4 = (_path_9 + "Helper.cs");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("using System;");
    _builder_3.newLine();
    _builder_3.append("using System.Collections.Generic;");
    _builder_3.newLine();
    _builder_3.append("using System.Linq;");
    _builder_3.newLine();
    _builder_3.append("using System.Runtime.Serialization;");
    _builder_3.newLine();
    _builder_3.append("using System.Text;");
    _builder_3.newLine();
    _builder_3.append("using Newtonsoft.Json;");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("namespace Appstore.");
    String _name_12 = component.getName();
    _builder_3.append(_name_12, "");
    _builder_3.append(".Services ");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("{");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("public class ");
    String _path_10 = service.getPath();
    _builder_3.append(_path_10, "	");
    _builder_3.append("Helper");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("\t");
    _builder_3.append("{");
    _builder_3.newLine();
    {
      EList<Function> _functions_2 = service.getFunctions();
      for(final Function function_2 : _functions_2) {
        _builder_3.append("\t\t");
        _builder_3.append("public static ");
        CharSequence _writeParameter = this.writeParameter(function_2);
        _builder_3.append(_writeParameter, "		");
        _builder_3.append("(");
        CharSequence _writeParameters = this.writeParameters(function_2);
        _builder_3.append(_writeParameters, "		");
        _builder_3.append(")");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t\t");
        _builder_3.append("{");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        CharSequence _writeTypeReferenceType_2 = this.writeTypeReferenceType(function_2);
        _builder_3.append(_writeTypeReferenceType_2, "			");
        _builder_3.append(" ret;");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.append("throw new NotImplementedException();");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.append("/* Implement function *");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.append("ret = ;");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.append("/* */");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("\t");
        _builder_3.append("return ret;");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("}");
        _builder_3.newLine();
      }
    }
    _builder_3.append("\t");
    _builder_3.append("}");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    _builder_3.newLine();
    fsa.generateFile(_plus_4, "SERVICEIMPLEMENTATIONS", _builder_3);
  }
  
  public CharSequence writeTypeReferenceType(final TypeReference typeReference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCollection = typeReference.isCollection();
      if (_isCollection) {
        _builder.append("List<");
        CharSequence _writeType = this.writeType(typeReference);
        _builder.append(_writeType, "");
        _builder.append(">");
      } else {
        CharSequence _writeType_1 = this.writeType(typeReference);
        _builder.append(_writeType_1, "");
      }
    }
    return _builder;
  }
  
  public CharSequence writeType(final TypeReference typeReference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Type _type = typeReference.getType();
      String _name = _type.getName();
      boolean _equals = Objects.equal(_name, "Integer");
      if (_equals) {
        _builder.append("Int32");
      } else {
        Type _type_1 = typeReference.getType();
        String _name_1 = _type_1.getName();
        _builder.append(_name_1, "");
      }
    }
    return _builder;
  }
  
  public CharSequence writePathParams(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        _builder.append("/{");
        String _name = parameter.getName();
        _builder.append(_name, "");
        _builder.append("}");
      }
    }
    return _builder;
  }
  
  public CharSequence writeStringParameter(final Parameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String ");
    String _name = parameter.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence writeStringParameters(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        CharSequence _writeStringParameter = this.writeStringParameter(parameter);
        _builder.append(_writeStringParameter, "");
        {
          EList<Parameter> _parameters_1 = function.getParameters();
          Parameter _last = IterableExtensions.<Parameter>last(_parameters_1);
          boolean _notEquals = (!Objects.equal(_last, parameter));
          if (_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence writeStringParameters2(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        CharSequence _writeStringParameter = this.writeStringParameter(parameter);
        _builder.append(_writeStringParameter, "");
        _builder.append("Input");
        {
          EList<Parameter> _parameters_1 = function.getParameters();
          Parameter _last = IterableExtensions.<Parameter>last(_parameters_1);
          boolean _notEquals = (!Objects.equal(_last, parameter));
          if (_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence writeEvaluatedParameters(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        String _name = parameter.getName();
        _builder.append(_name, "");
        {
          EList<Parameter> _parameters_1 = function.getParameters();
          Parameter _last = IterableExtensions.<Parameter>last(_parameters_1);
          boolean _notEquals = (!Objects.equal(_last, parameter));
          if (_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence writeParameter(final TypeReference parameter) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeTypeReferenceType = this.writeTypeReferenceType(parameter);
    _builder.append(_writeTypeReferenceType, "");
    _builder.append(" ");
    String _name = parameter.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  public CharSequence writeParameters(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        CharSequence _writeParameter = this.writeParameter(parameter);
        _builder.append(_writeParameter, "");
        {
          EList<Parameter> _parameters_1 = function.getParameters();
          Parameter _last = IterableExtensions.<Parameter>last(_parameters_1);
          boolean _notEquals = (!Objects.equal(_last, parameter));
          if (_notEquals) {
            _builder.append(", ");
          }
        }
      }
    }
    return _builder;
  }
}
