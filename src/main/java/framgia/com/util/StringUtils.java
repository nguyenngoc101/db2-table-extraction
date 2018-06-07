package framgia.com.util;

public class StringUtils {
    public static String nomarlizeColType(String colType) {
        return colType.replaceAll("\"", "").trim();
    }
}
