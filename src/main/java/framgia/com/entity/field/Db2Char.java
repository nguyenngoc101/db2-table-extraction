package framgia.com.entity.field;

public class Db2Char implements IField {

    private String name;
    private String length;

    public Db2Char(String name, String length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String getSqlText() {
        return name + " CHAR" + "(" + length + ")";
    }
}
