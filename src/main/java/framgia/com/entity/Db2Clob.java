package framgia.com.entity;

public class Db2Clob implements ISqlElement {

    private String name;

    public Db2Clob(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " CLOB";
    }
}
