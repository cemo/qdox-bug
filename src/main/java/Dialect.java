import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.PostgreSQL82Dialect;

public enum Dialect {

  ORACLE(Oracle10gDialect.class.getName()),
  MYSQL(MySQLDialect.class.getName()),
  MYSQL_IMPROVED(MySQLDialectImproved.class.getName()) {
    @Override
    public String toString() {
      return MYSQL.toString();
    }
  },
  MYSQL4BYTEUNICODE(MySQLDialectWith4ByteUnicodeSupport.class.getName()),
  HSQL(HSQLDialect.class.getName()),
  H2(H2Dialect.class.getName()),
  H2_IMPROVED(H2DialectImproved.class.getName()) {
    @Override
    public String toString() {
      return H2.toString();
    }
  },
  POSTGRE(PostgreSQL82Dialect.class.getName());

  private final String dialectClass;

  Dialect(String dialectClass) {
    this.dialectClass = dialectClass;
  }

  public String getDialectClass() {
    return dialectClass;
  }

}
