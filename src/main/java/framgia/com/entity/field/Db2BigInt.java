package framgia.com.entity.field;

public class Db2BigInt implements IField {

    private String name;

    public Db2BigInt(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " BIGINT";
    }
}
