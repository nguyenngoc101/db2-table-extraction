package framgia.com.entity;

public class Db2Date implements ISqlElement {

    private String name;

    public Db2Date(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " DATE";
    }
}
