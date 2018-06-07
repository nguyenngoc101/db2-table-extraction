package framgia.com.entity;

public class NotNullField implements ISqlElement {

    private ISqlElement original;

    public NotNullField(ISqlElement original) {
        this.original = original;
    }

    @Override
    public String getSqlText() {
        return original.getSqlText() + " NOT NULL";
    }
}
