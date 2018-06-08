package framgia.com.entity.field;

public class Varchar implements IField {

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
