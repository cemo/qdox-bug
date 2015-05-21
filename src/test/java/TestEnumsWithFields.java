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
    private static final String ENUM_WITH_FIELDS = "public enum EnumWithFields {VALUEA(By.linkText(\"G\"),\"H\"), VALUEG(By.linkText(\"Q\"), \"z\");private By literal;private final String symbol;CyrillicEnum(By literal, String symbol) {this.literal = literal;this.symbol = symbol;}public By getLiteral() {return literal;}}";


    @Test
    public void testEnumWithoutFieldsParsing(){
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource javaSource = builder.addSource(new StringReader(ENUM_WITHOUT_FIELDS));
        List<JavaClass> classes = javaSource.getClasses();
        Assert.assertFalse(classes.isEmpty());
    }

    @Test
    public void testCEnums(){
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource javaSource = builder.addSource(new StringReader(ENUM_WITH_FIELDS));
        Assert.assertFalse(javaSource.getClasses().isEmpty());
    }
}
