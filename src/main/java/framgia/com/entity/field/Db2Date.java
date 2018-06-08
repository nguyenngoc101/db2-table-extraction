package framgia.com.entity.field;

public class Db2Date implements IField {

    private String name;

    public Db2Date(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " DATE";
    }
}
