package codegenerator.entity;

import codegenerator.entity.EntityGeneratorCode;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import evilsystem.Attribute;
import evilsystem.Entity;
import evilsystem.PackageElement;
import evilsystem.SimpleType;
import evilsystem.Type;
import evilsystem.TypeReference;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EntityGenerator implements IGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    EList<EObject> _contents = input.getContents();
    for (final EObject Entity : _contents) {
      this.compile(Entity, fsa);
    }
  }
  
  protected void _compile(final EObject m, final IFileSystemAccess fsa) {
  }
  
  protected void _compile(final evilsystem.System system, final IFileSystemAccess fsa) {
    EList<PackageElement> _elements = system.getElements();
    Iterable<Entity> _filter = Iterables.<Entity>filter(_elements, Entity.class);
    for (final Entity entity : _filter) {
      {
        this.compile(entity, fsa);
        this.compileTypeCollection(system, entity, fsa);
      }
    }
    EList<PackageElement> _elements_1 = system.getElements();
    Iterable<SimpleType> _filter_1 = Iterables.<SimpleType>filter(_elements_1, SimpleType.class);
    for (final SimpleType simpleType : _filter_1) {
      this.compileTypeCollection(system, simpleType, fsa);
    }
    this.compileDatabaseTesters(system, fsa);
  }
  
  public CharSequence writeTypeInJava(final TypeReference typeReference) {
    CharSequence _xifexpression = null;
    boolean _isCollection = typeReference.isCollection();
    if (_isCollection) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("List<");
      Type _type = typeReference.getType();
      String _name = _type.getName();
      _builder.append(_name, "");
      _builder.append(">");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      Type _type_1 = typeReference.getType();
      String _name_1 = _type_1.getName();
      _builder_1.append(_name_1, "");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public CharSequence defaultVauledVariable(final Attribute attribute) {
    CharSequence _xifexpression = null;
    boolean _isCollection = attribute.isCollection();
    if (_isCollection) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("= new ArrayList<");
      Type _type = attribute.getType();
      String _name = _type.getName();
      _builder.append(_name, " ");
      _builder.append(">()");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public void compile(final Entity entity, final IFileSystemAccess fsa) {
    String _name = entity.getName();
    String _plus = (_name + ".java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    evilsystem.System _system = entity.getSystem();
    String _systemNameSpace = _system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".entities;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.sql.Date;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.persistence.Column;");
    _builder.newLine();
    _builder.append("import javax.persistence.Entity;");
    _builder.newLine();
    _builder.append("import javax.persistence.GeneratedValue;");
    _builder.newLine();
    _builder.append("import javax.persistence.Id;");
    _builder.newLine();
    _builder.append("import javax.persistence.NamedQuery;");
    _builder.newLine();
    _builder.append("import javax.persistence.Table;");
    _builder.newLine();
    _builder.append("import javax.xml.bind.annotation.XmlRootElement;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Entity");
    _builder.newLine();
    _builder.append("@Table(name=\"");
    String _name_1 = entity.getName();
    _builder.append(_name_1, "");
    _builder.append("_Table\")");
    _builder.newLineIfNotEmpty();
    _builder.append("@XmlRootElement");
    _builder.newLine();
    _builder.append("public class ");
    String _name_2 = entity.getName();
    _builder.append(_name_2, "");
    CharSequence _xifexpression = null;
    Entity _superClass = entity.getSuperClass();
    boolean _notEquals = (!Objects.equal(_superClass, null));
    if (_notEquals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("extends ");
      Entity _superClass_1 = entity.getSuperClass();
      String _name_3 = _superClass_1.getName();
      _builder_1.append(_name_3, " ");
      _xifexpression = _builder_1;
    }
    _builder.append(_xifexpression, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Id");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GeneratedValue");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Column(name=\"");
    String _name_4 = entity.getName();
    _builder.append(_name_4, "	");
    _builder.append("_ID\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected long id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public long getId() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setId(long id) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.id=id;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      EList<Attribute> _attributes = entity.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        CharSequence _writeTypeInJava = this.writeTypeInJava(attribute);
        _builder.append(_writeTypeInJava, "	");
        _builder.append(" ");
        String _name_5 = attribute.getName();
        _builder.append(_name_5, "	");
        CharSequence _defaultVauledVariable = this.defaultVauledVariable(attribute);
        _builder.append(_defaultVauledVariable, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        CharSequence _writeTypeInJava_1 = this.writeTypeInJava(attribute);
        _builder.append(_writeTypeInJava_1, "	");
        _builder.append(" get");
        String _name_6 = attribute.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_6);
        _builder.append(_firstUpper, "	");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return this.");
        String _name_7 = attribute.getName();
        _builder.append(_name_7, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _name_8 = attribute.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_8);
        _builder.append(_firstUpper_1, "	");
        _builder.append("(");
        CharSequence _writeTypeInJava_2 = this.writeTypeInJava(attribute);
        _builder.append(_writeTypeInJava_2, "	");
        _builder.append(" ");
        String _name_9 = attribute.getName();
        _builder.append(_name_9, "	");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_10 = attribute.getName();
        _builder.append(_name_10, "		");
        _builder.append(" = ");
        String _name_11 = attribute.getName();
        _builder.append(_name_11, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus, "SOURCES", _builder);
  }
  
  public void compileTypeCollection(final evilsystem.System system, final Type type, final IFileSystemAccess fsa) {
    String _name = type.getName();
    String _plus = ("ArrayListv" + _name);
    String _plus_1 = (_plus + "v.java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _systemNameSpace = system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".entitycollections;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.sql.Date;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.xml.bind.annotation.XmlRootElement;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _systemNameSpace_1 = system.getSystemNameSpace();
    _builder.append(_systemNameSpace_1, "");
    _builder.append(".entities.*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@XmlRootElement");
    _builder.newLine();
    _builder.append("public class ArrayListv");
    String _name_1 = type.getName();
    _builder.append(_name_1, "");
    _builder.append("v extends ArrayList<");
    String _name_2 = type.getName();
    _builder.append(_name_2, "");
    _builder.append(">{");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus_1, "SOURCESCOLLECTION", _builder);
  }
  
  public void compileDatabaseTesters(final evilsystem.System system, final IFileSystemAccess fsa) {
    String _plus = (EntityGeneratorCode.DataBaseTesterInterfaceName + ".java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _systemNameSpace = system.getSystemNameSpace();
    _builder.append(_systemNameSpace, "");
    _builder.append(".entitytester;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("//Interface for testing the entity project");
    _builder.newLine();
    _builder.append("public interface ");
    _builder.append(EntityGeneratorCode.DataBaseTesterInterfaceName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String Test();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    fsa.generateFile(_plus, "TESTER", _builder);
    String _plus_1 = (EntityGeneratorCode.DataBaseTesterClassName + ".java");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package ");
    String _systemNameSpace_1 = system.getSystemNameSpace();
    _builder_1.append(_systemNameSpace_1, "");
    _builder_1.append(".entitytester;");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("import javax.ws.rs.*;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("//Interface for testing the entity project");
    _builder_1.newLine();
    _builder_1.append("@Path(\"/entitytester\")");
    _builder_1.newLine();
    _builder_1.append("public class ");
    _builder_1.append(EntityGeneratorCode.DataBaseTesterClassName, "");
    _builder_1.append(" implements ");
    _builder_1.append(EntityGeneratorCode.DataBaseTesterInterfaceName, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("@GET");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Path(\"/test\")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Produces(\"text/plain\")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public String Test()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return \"The entity project is working.\";");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    fsa.generateFile(_plus_1, "TESTER", _builder_1);
  }
  
  public void compile(final EObject system, final IFileSystemAccess fsa) {
    if (system instanceof evilsystem.System) {
      _compile((evilsystem.System)system, fsa);
      return;
    } else if (system != null) {
      _compile(system, fsa);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(system, fsa).toString());
    }
  }
}
