package framgia.com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table implements ISqlElement {

    private List<ISqlElement> fields = new ArrayList<ISqlElement>();
    private String name;

    public Table(String name) {
        this.name = name;
    }

    public void addField(ISqlElement field) {
        fields.add(field);
    }

    public String getSqlText() {
        return  "CREATE TABLE " + name + "(" + getSqlTextFields() + ");";
    }

    private String getSqlTextFields() {
        return fields.stream().map(e ->e.getSqlText()).collect(Collectors.joining(", "));
    }

    public List<ISqlElement> getFields() {
        return fields;
    }

    public void setFields(List<ISqlElement> fields) {
        this.fields = fields;
    }
}
