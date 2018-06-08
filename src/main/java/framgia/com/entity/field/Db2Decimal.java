package framgia.com.entity.field;

public class Db2Decimal implements IField {

    private String name;
    private String length;
    private String scale;

    public Db2Decimal(String name, String length, String scale) {
        this.name = name;
        this.length = length;
        this.scale = scale;
    }

    @Override
    public String getSqlText() {
        return name + " DECIMAL" + "(" + length + "," + scale + ")";
    }
}
