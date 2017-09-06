import org.hibernate.dialect.H2Dialect;

/**
 * @author onurozcan
 * @author ozlem.ulag
 */
public class H2DialectImproved extends H2Dialect {

  public H2DialectImproved() {
    super();
    registerExtraH2Keywords();
  }

  private void registerExtraH2Keywords() {
    registerKeyword("KEY");
    registerKeyword("READ");
  }

  @Override
  public char closeQuote() {
    return '`';
  }

  @Override
  public char openQuote() {
    return '`';
  }
}
