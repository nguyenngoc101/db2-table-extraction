package framgia.com.entity;

public class Varchar implements ISqlElement {


    private final String name;
    private final Integer length;

    public Varchar(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public String getSqlText() {
        return name + " VARCHAR" + "(" + length + ")";
    }
}
