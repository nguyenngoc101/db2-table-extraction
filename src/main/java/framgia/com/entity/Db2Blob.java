package framgia.com.entity;

public class Db2Blob implements ISqlElement {

    private String name;

    public Db2Blob(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " BLOB";
    }
}
