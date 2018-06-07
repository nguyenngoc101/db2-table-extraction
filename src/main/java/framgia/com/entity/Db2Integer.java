package framgia.com.entity;

public class Db2Integer implements ISqlElement {
    private final String name;

    public Db2Integer(String name) {
        this.name = name;
    }

    public String getSqlText() {
        return name + " INTEGER";
    }
}
