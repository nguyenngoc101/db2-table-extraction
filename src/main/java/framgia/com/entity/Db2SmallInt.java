package framgia.com.entity;

public class Db2SmallInt implements ISqlElement {

    private String name;

    public Db2SmallInt(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " SMALLINT";
    }
}
