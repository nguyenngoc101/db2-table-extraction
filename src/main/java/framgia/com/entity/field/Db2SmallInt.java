package framgia.com.entity.field;

public class Db2SmallInt implements IField {

    private String name;

    public Db2SmallInt(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " SMALLINT";
    }
}
