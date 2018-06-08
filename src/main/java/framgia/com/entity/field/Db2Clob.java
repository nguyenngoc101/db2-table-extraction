package framgia.com.entity.field;

public class Db2Clob implements IField {

    private String name;

    public Db2Clob(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " CLOB";
    }
}
