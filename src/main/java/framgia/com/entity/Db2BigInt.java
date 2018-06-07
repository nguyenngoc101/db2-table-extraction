package framgia.com.entity;

public class Db2BigInt implements ISqlElement {

    private String name;

    public Db2BigInt(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " BIGINT";
    }
}
