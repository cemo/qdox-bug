import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaSource;
import org.junit.Test;

import java.io.StringReader;

/**
 * Created by nikita on 21.05.15.
 */
public class TestCyrillicEnums {


    private static final String ENUM = "public enum CyrillicEnum {\n" +
            "\n" +
            "    VALUEA(By.linkText(\"Б\"),\"Ъ\"), VALUEG(By.linkText(\"Г\"), \"Ц\");\n" +
            "\n" +
            "\n" +
            "    private By literal;\n" +
            "    private final String symbol;\n" +
            "\n" +
            "    CyrillicEnum(By literal, String symbol) {\n" +
            "        this.literal = literal;\n" +
            "\n" +
            "        this.symbol = symbol;\n" +
            "    }\n" +
            "\n" +
            "    public By getLiteral() {\n" +
            "        return literal;\n" +
            "    }\n" +
            "}";

    @Test
    public void testCEnums(){
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource javaSource = builder.addSource(new StringReader(ENUM));
    }
}
