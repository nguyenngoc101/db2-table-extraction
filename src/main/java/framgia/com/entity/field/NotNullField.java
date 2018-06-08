package framgia.com.entity.field;

public class NotNullField implements IField {

    private IField original;

    public NotNullField(IField original) {
        this.original = original;
    }

    @Override
    public String getSqlText() {
        return original.getSqlText() + " NOT NULL";
    }
}
