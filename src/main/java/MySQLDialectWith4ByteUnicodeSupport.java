/**
 * @author onurozcan
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class MySQLDialectWith4ByteUnicodeSupport extends MySQLDialectImproved {

  @Override
  public String getTableTypeString() {
    return " DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci";
  }
}
