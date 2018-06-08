package framgia.com.entity.field;

public class Timestamp implements IField {

    private final String name;

    public Timestamp(String name) {
        this.name = name;
    }

    public String getSqlText() {
        return name + " TIMESTAMP";
    }
}
