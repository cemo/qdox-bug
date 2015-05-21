import org.openqa.selenium.By;

/**
 * Created by nikita on 21.05.15.
 */
public enum CyrillicEnum {

    VALUEA(By.linkText("G"),"H"), VALUEG(By.linkText("Q"), "z");


    private By literal;
    private final String symbol;

    CyrillicEnum(By literal, String symbol) {
        this.literal = literal;

        this.symbol = symbol;
    }

    public By getLiteral() {
        return literal;
    }
}
