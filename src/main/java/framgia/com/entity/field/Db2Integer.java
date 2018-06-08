package framgia.com.entity.field;

public class Db2Integer implements IField {
    private final String name;

    public Db2Integer(String name) {
        this.name = name;
    }

    public String getSqlText() {
        return name + " INTEGER";
    }
}
