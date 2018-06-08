package framgia.com.text;

import static framgia.com.reader.ColumnDefinition.*;
import static framgia.com.util.StringUtils.nomarlizeColType;

public class Row {

    private String strRow;
    private String name;
    private String tableName;
    private String colType;
    private String nulls;
    private String length;
    private String scale;

    public Row(String strRow) {
        this.strRow = strRow;
    }

    public Row row() {
        String[] cols = this.strRow.split(",");
        this.name = nomarlizeColType(cols[COL_NAME]);
        this.tableName = nomarlizeColType(cols[TABLE_NAME]);
        this.colType = nomarlizeColType(cols[COL_TYPE]);
        this.nulls = nomarlizeColType(cols[COL_NULL]);
        this.length = nomarlizeColType(cols[COL_LENGTH]);
        this.scale = nomarlizeColType(cols[COL_SCALE]);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getNulls() {
        return nulls;
    }

    public void setNulls(String nulls) {
        this.nulls = nulls;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
