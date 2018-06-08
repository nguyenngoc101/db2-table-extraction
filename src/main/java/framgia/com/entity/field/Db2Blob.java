package framgia.com.entity.field;

public class Db2Blob implements IField {

    private String name;

    public Db2Blob(String name) {
        this.name = name;
    }

    @Override
    public String getSqlText() {
        return name + " BLOB";
    }
}
