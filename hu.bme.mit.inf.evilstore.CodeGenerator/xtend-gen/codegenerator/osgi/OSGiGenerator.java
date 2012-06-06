package codegenerator.osgi;

import com.google.common.base.Objects;
import evilsystem.Component;
import evilsystem.Entity;
import evilsystem.Function;
import evilsystem.MethodType;
import evilsystem.NamedQuery;
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
public class OSGiGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
  }
  
  public void compile(final Component component, final IFileSystemAccess fsa) {
    EList<Service> _services = component.getServices();
    for (final Service service : _services) {
      {
        this.compileInt(service, fsa, component);
        this.compileImplHelper(service, fsa, component);
        this.compileImpl(service, fsa, component);
      }
    }
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
  
  public void compileInt(final Service service, final IFileSystemAccess fsa, final Component component) {
    String _path = service.getPath();
    String _plus = ("I" + _path);
    String _plus_1 = (_plus + "Service.java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    evilsystem.System _system = component.getSystem();
    String _systemNameSpace = _system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".");
    String _name = component.getName();
    _builder.append(_name, "");
    _builder.append(".interfaces;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface I");
    String _path_1 = service.getPath();
    _builder.append(_path_1, "");
    _builder.append("Service {");
    _builder.newLineIfNotEmpty();
    {
      EList<Function> _functions = service.getFunctions();
      for(final Function function : _functions) {
        _builder.append("\t");
        _builder.append("public String ");
        String _name_1 = function.getName();
        _builder.append(_name_1, "	");
        _builder.append("(");
        CharSequence _writeStringParameters = this.writeStringParameters(function);
        _builder.append(_writeStringParameters, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus_1, "SERVICEINTERFACES", _builder);
  }
  
  public CharSequence writePathParameters(final Function function) {
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
  
  public CharSequence writeAnnotedStringParameters(final Function function) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Parameter> _parameters = function.getParameters();
      for(final Parameter parameter : _parameters) {
        _builder.append("@PathParam(\"");
        String _name = parameter.getName();
        _builder.append(_name, "");
        _builder.append("\") String ");
        String _name_1 = parameter.getName();
        _builder.append(_name_1, "");
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
  
  public CharSequence writeTypeReferenceType(final TypeReference typeReference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCollection = typeReference.isCollection();
      if (_isCollection) {
        _builder.append("ArrayList<");
        Type _type = typeReference.getType();
        String _name = _type.getName();
        _builder.append(_name, "");
        _builder.append(">");
      } else {
        Type _type_1 = typeReference.getType();
        String _name_1 = _type_1.getName();
        _builder.append(_name_1, "");
      }
    }
    return _builder;
  }
  
  public CharSequence writeTypeReferenceTypeStrong(final TypeReference typeReference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCollection = typeReference.isCollection();
      if (_isCollection) {
        _builder.append("ArrayListv");
        Type _type = typeReference.getType();
        String _name = _type.getName();
        _builder.append(_name, "");
        _builder.append("v");
      } else {
        Type _type_1 = typeReference.getType();
        String _name_1 = _type_1.getName();
        _builder.append(_name_1, "");
      }
    }
    return _builder;
  }
  
  public void compileImplHelper(final Service service, final IFileSystemAccess fsa, final Component component) {
    String _path = service.getPath();
    String _plus = (_path + "ServiceHelper.java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    evilsystem.System _system = component.getSystem();
    String _systemNameSpace = _system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".");
    String _name = component.getName();
    _builder.append(_name, "");
    _builder.append(".interfaces;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.sql.Date;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    evilsystem.System _system_1 = component.getSystem();
    String _systemNameSpace_1 = _system_1.getSystemNameSpace();
    _builder.append(_systemNameSpace_1, "");
    _builder.append(".entities.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    evilsystem.System _system_2 = component.getSystem();
    String _systemNameSpace_2 = _system_2.getSystemNameSpace();
    _builder.append(_systemNameSpace_2, "");
    _builder.append(".entitycollections.*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManagerFactory;");
    _builder.newLine();
    _builder.append("import javax.persistence.Persistence;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.codehaus.jackson.JsonGenerationException;");
    _builder.newLine();
    _builder.append("import org.codehaus.jackson.JsonParseException;");
    _builder.newLine();
    _builder.append("import org.codehaus.jackson.map.JsonMappingException;");
    _builder.newLine();
    _builder.append("import org.codehaus.jackson.map.ObjectMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Path(\"/");
    String _path_1 = service.getPath();
    _builder.append(_path_1, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _path_2 = service.getPath();
    _builder.append(_path_2, "");
    _builder.append("ServiceHelper implements I");
    String _path_3 = service.getPath();
    _builder.append(_path_3, "");
    _builder.append("Service {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static EntityManager getEntityManager()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("EntityManagerFactory factory = Persistence.createEntityManagerFactory(\"osgi.demo.jpa\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return factory.createEntityManager();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Function> _functions = service.getFunctions();
      for(final Function function : _functions) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        MethodType _methodType = function.getMethodType();
        _builder.append(_methodType, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Path(\"/");
        String _name_1 = function.getName();
        _builder.append(_name_1, "	");
        CharSequence _writePathParameters = this.writePathParameters(function);
        _builder.append(_writePathParameters, "	");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Produces(\"text/plain\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String ");
        String _name_2 = function.getName();
        _builder.append(_name_2, "	");
        _builder.append("(");
        CharSequence _writeAnnotedStringParameters = this.writeAnnotedStringParameters(function);
        _builder.append(_writeAnnotedStringParameters, "	");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("//Objektumok parse-ol\u00E1sa a bemenetb\u0151l.");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("ObjectMapper objectMapper = new ObjectMapper();");
        _builder.newLine();
        {
          EList<Parameter> _parameters = function.getParameters();
          for(final Parameter p : _parameters) {
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _writeTypeReferenceType = this.writeTypeReferenceType(p);
            _builder.append(_writeTypeReferenceType, "		");
            _builder.append(" ");
            String _name_3 = p.getName();
            _builder.append(_name_3, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            String _name_4 = p.getName();
            _builder.append(_name_4, "			");
            _builder.append(" = objectMapper.readValue(");
            String _name_5 = p.getName();
            _builder.append(_name_5, "			");
            _builder.append("Input, ");
            CharSequence _writeTypeReferenceTypeStrong = this.writeTypeReferenceTypeStrong(p);
            _builder.append(_writeTypeReferenceTypeStrong, "			");
            _builder.append(".class);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (JsonParseException e) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return \"Error: Nem siker\u00FClt kiolvasni az al\u00E1bbi Json param\u00E9tert: \\\"");
            String _name_6 = p.getName();
            _builder.append(_name_6, "			");
            _builder.append("\\\"!\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (JsonMappingException e) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return \"Error: Nem siker\u00FClt kiolvasni a(z) \\\"");
            String _name_7 = p.getName();
            _builder.append(_name_7, "			");
            _builder.append("\\\" param\u00E9terb\u0151l egy \\\"");
            Type _type = p.getType();
            String _name_8 = _type.getName();
            _builder.append(_name_8, "			");
            _builder.append("\\\" p\u00E9ld\u00E1nyt!\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (IOException e) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return \"Error: Nem siker\u00FClt kiolvasni az al\u00E1bbi param\u00E9tert: \\\"");
            String _name_9 = p.getName();
            _builder.append(_name_9, "			");
            _builder.append("\\\"!\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("//M\u0171velet v\u00E9grahajt\u00E1sa:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _writeTypeReferenceType_1 = this.writeTypeReferenceType(function);
        _builder.append(_writeTypeReferenceType_1, "		");
        _builder.append(" result =");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        evilsystem.System _system_3 = component.getSystem();
        String _systemNameSpace_3 = _system_3.getSystemNameSpace();
        _builder.append(_systemNameSpace_3, "			");
        _builder.append(".");
        String _name_10 = component.getName();
        _builder.append(_name_10, "			");
        _builder.append(".implementations.");
        String _path_4 = service.getPath();
        _builder.append(_path_4, "			");
        _builder.append("Service.");
        String _name_11 = function.getName();
        _builder.append(_name_11, "			");
        _builder.append("(");
        CharSequence _writeEvaluatedParameters = this.writeEvaluatedParameters(function);
        _builder.append(_writeEvaluatedParameters, "			");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("//Eredm\u00E9ny soros\u00EDt\u00E1sa:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return objectMapper.writeValueAsString(result);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (JsonParseException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return \"Error: Nem siker\u00FClt Json-ba \u00EDrni a m\u0171velet eredm\u00E9ny\u00E9t!\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (JsonMappingException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return \"Error: Nem siker\u00FClt \u00EDrni egy \\\"");
        CharSequence _writeTypeReferenceType_2 = this.writeTypeReferenceType(function);
        _builder.append(_writeTypeReferenceType_2, "			");
        _builder.append("\\\" p\u00E9ld\u00E1nyt!\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (IOException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return \"Error: Nem siker\u00FClt ki\u00EDrni a m\u0171velet eredm\u00E9ny\u00E9t!\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus, "SERVICEINTERFACES", _builder);
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
  
  public void compileImpl(final Service service, final IFileSystemAccess fsa, final Component component) {
    String _path = service.getPath();
    String _plus = (_path + "Service.java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    evilsystem.System _system = component.getSystem();
    String _systemNameSpace = _system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".");
    String _name = component.getName();
    _builder.append(_name, "");
    _builder.append(".implementations;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    evilsystem.System _system_1 = component.getSystem();
    String _systemNameSpace_1 = _system_1.getSystemNameSpace();
    _builder.append(_systemNameSpace_1, "");
    _builder.append(".entities.*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManagerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _path_1 = service.getPath();
    _builder.append(_path_1, "");
    _builder.append("Service{");
    _builder.newLineIfNotEmpty();
    {
      EList<Function> _functions = service.getFunctions();
      for(final Function function : _functions) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static ");
        CharSequence _writeParameter = this.writeParameter(function);
        _builder.append(_writeParameter, "	");
        _builder.append("(");
        CharSequence _writeParameters = this.writeParameters(function);
        _builder.append(_writeParameters, "	");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("//EntityManager l\u00E9trehoz\u00E1sa:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("EntityManager entityManager =");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        evilsystem.System _system_2 = component.getSystem();
        String _systemNameSpace_2 = _system_2.getSystemNameSpace();
        _builder.append(_systemNameSpace_2, "			");
        _builder.append(".");
        String _name_1 = component.getName();
        _builder.append(_name_1, "			");
        _builder.append(".interfaces.");
        String _path_2 = service.getPath();
        _builder.append(_path_2, "			");
        _builder.append("ServiceHelper.getEntityManager();");
        _builder.newLineIfNotEmpty();
        {
          EList<NamedQuery> _queries = function.getQueries();
          boolean _isEmpty = _queries.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//A modell szerint az al\u00E1bbi query-ket haszn\u00E1lja a f\u00FCggv\u00E9ny:");
            _builder.newLine();
          }
        }
        {
          EList<NamedQuery> _queries_1 = function.getQueries();
          for(final NamedQuery nq : _queries_1) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List");
            {
              Entity _referred = nq.getReferred();
              boolean _notEquals = (!Objects.equal(_referred, null));
              if (_notEquals) {
                _builder.append("<");
                Entity _referred_1 = nq.getReferred();
                String _name_2 = _referred_1.getName();
                _builder.append(_name_2, "		");
                _builder.append(">");
              }
            }
            _builder.append(" ");
            String _name_3 = nq.getName();
            _builder.append(_name_3, "		");
            _builder.append("Result = entityManager.createQuery(\"");
            String _query = nq.getQuery();
            _builder.append(_query, "		");
            _builder.append("\").getResultList();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        {
          MethodType _methodType = function.getMethodType();
          boolean _notEquals_1 = (!Objects.equal(_methodType, MethodType.GET));
          if (_notEquals_1) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// Ha tranzakci\u00F3szer\u0171 a f\u00FCggv\u00E9ny, akkor elkezdj\u00FCk a tranzakci\u00F3t:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("entityManager.getTransaction().begin();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// Ide ker\u00FCl m\u0171velet.");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        {
          MethodType _methodType_1 = function.getMethodType();
          boolean _notEquals_2 = (!Objects.equal(_methodType_1, MethodType.GET));
          if (_notEquals_2) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// \u00DAj elem l\u00E9trehoz\u00E1sa \u00E9s ment\u00E9se a k\u00F6vetkez\u0151k\u00E9ppen t\u00F6rt\u00E9nik:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// entityManager.persist(...);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// Ha tranzakci\u00F3szer\u0171 a f\u00FCggv\u00E9ny, akkor egyszer befejezz\u00FCk azt:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("entityManager.getTransaction().commit();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// EntityManager lez\u00E1r\u00E1sa:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("entityManager.close();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("//De ez a f\u00FCggv\u00E9ny m\u00E9g nincs k\u00E9sz:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new UnsupportedOperationException();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus, "SERVICEIMPLEMENTATIONS", _builder);
  }
}
