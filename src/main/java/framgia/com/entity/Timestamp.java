package framgia.com.entity;

public class Timestamp implements ISqlElement {

    private final String name;

    public Timestamp(String name) {
        this.name = name;
    }

    public String getSqlText() {
        return name + " TIMESTAMP";
    }
}
