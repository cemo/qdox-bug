import org.hibernate.dialect.MySQLDialect;

/**
 * @author ozlem.ulag
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class MySQLDialectImproved extends MySQLDialect {

  public MySQLDialectImproved() {
    super();
    registerExtraMySQLKeywords();
  }

  private void registerExtraMySQLKeywords() {
    registerKeyword("KEY");
    registerKeyword("READ");
  }
}
