package framgia.com.entity;

public class Db2Double implements ISqlElement {

    private String name;
    private String length;
    private String scale;

    public Db2Double(String name, String length, String scale) {
        this.name = name;
        this.length = length;
        this.scale = scale;
    }

    @Override
    public String getSqlText() {
        return name + " DOUBLE" + "(" + length + "," + scale + ")";
    }
}
