import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.util.List;

/**
 * Created by nikita on 21.05.15.
 */
public class TestEnumsWithFields {

  private static final String ENUM_WITHOUT_FIELDS = "public enum ClassicEnum {A,B}";

  private static final String ENUM_WITH_FIELDS =
      "public enum EnumWithFields {VALUEA(By.linkText(\"G\"),\"H\"), VALUEG(By.linkText(\"Q\"), \"z\");private By "
      + "literal;private final String symbol;CyrillicEnum(By literal, String symbol) {this.literal = literal;this"
      + ".symbol = symbol;}public By getLiteral() {return literal;}}";

  private static final String NEW_WITH_FIELDS =
      "import org.hibernate.dialect.H2Dialect;\n"
      + "import org.hibernate.dialect.HSQLDialect;\n"
      + "import org.hibernate.dialect.MySQLDialect;\n"
      + "import org.hibernate.dialect.Oracle10gDialect;\n"
      + "import org.hibernate.dialect.PostgreSQL82Dialect;\n"
      + "\n"
      + "public enum Dialect {\n"
      + "\n"
      + "  ORACLE(Oracle10gDialect.class.getName()),\n"
      + "  MYSQL(MySQLDialect.class.getName()),\n"
      + "  MYSQL_IMPROVED(MySQLDialectImproved.class.getName()) {\n"
      + "    @Override\n"
      + "    public String toString() {\n"
      + "      return MYSQL.toString();\n"
      + "    }\n"
      + "  },\n"
      + "  MYSQL4BYTEUNICODE(MySQLDialectWith4ByteUnicodeSupport.class.getName()),\n"
      + "  HSQL(HSQLDialect.class.getName()),\n"
      + "  H2(H2Dialect.class.getName()),\n"
      + "  H2_IMPROVED(H2DialectImproved.class.getName()) {\n"
      + "    @Override\n"
      + "    public String toString() {\n"
      + "      return H2.toString();\n"
      + "    }\n"
      + "  },\n"
      + "  POSTGRE(PostgreSQL82Dialect.class.getName());\n"
      + "\n"
      + "  private final String dialectClass;\n"
      + "\n"
      + "  Dialect(String dialectClass) {\n"
      + "    this.dialectClass = dialectClass;\n"
      + "  }\n"
      + "\n"
      + "  public String getDialectClass() {\n"
      + "    return dialectClass;\n"
      + "  }\n"
      + "\n"
      + "}\n";

  @Test
  public void testEnumWithoutFieldsParsing() {
    JavaProjectBuilder builder = new JavaProjectBuilder();
    JavaSource javaSource = builder.addSource(new StringReader(ENUM_WITHOUT_FIELDS));
    List<JavaClass> classes = javaSource.getClasses();
    Assert.assertFalse(classes.isEmpty());
  }

  @Test
  public void testCEnums() {
    JavaProjectBuilder builder = new JavaProjectBuilder();
    JavaSource javaSource = builder.addSource(new StringReader(ENUM_WITH_FIELDS));
    Assert.assertFalse(javaSource.getClasses().isEmpty());
  }

  @Test
  public void testNEnums() {
    JavaProjectBuilder builder = new JavaProjectBuilder();
    JavaSource javaSource = builder.addSource(new StringReader(NEW_WITH_FIELDS));
    Assert.assertFalse(javaSource.getClasses().isEmpty());
  }
}
