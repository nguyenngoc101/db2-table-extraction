package framgia.com.factory;

import framgia.com.entity.*;
import framgia.com.entity.field.*;
import framgia.com.text.Row;

public class SqlFactory {

    public static ISqlElement getField(Row row) {
        switch (row.getColType()) {
            case "INTEGER":
                return ifNotNullField(
                        new Db2Integer(row.getName()),
                        row.getNulls()
                );
            case "VARCHAR":
                return ifNotNullField(
                        new Varchar(row.getName(), Integer.valueOf(row.getLength())),
                        row.getNulls()
                );
            case "TIMESTMP":
                return ifNotNullField(
                        new Timestamp(row.getName())
                        ,row.getNulls()
                );
            case "DATE":
                return ifNotNullField(
                        new Db2Date(row.getName()),
                        row.getNulls()
                );
            case "DECIMAL":
                return ifNotNullField(
                        new Db2Decimal(row.getName(), row.getLength(), row.getScale()),
                        row.getNulls()
                );
            case "CHAR":
                return ifNotNullField(
                        new Db2Char(row.getName(), row.getLength())
                        ,row.getNulls()
                );
            case "SMALLINT":
                return ifNotNullField(
                        new Db2SmallInt(row.getName()),
                        row.getNulls()
                );
            case "DOUBLE":
                return ifNotNullField(
                        new Db2Double(row.getName(), row.getLength(), row.getScale()),
                        row.getNulls()
                );
            case "CLOB":
                return ifNotNullField(
                        new Db2Clob(row.getName())
                        ,row.getNulls()
                );
            case "BLOB":
                return ifNotNullField(
                    new Db2Blob(row.getName())
                        ,row.getNulls()
                );
            case "BIGINT":
                return ifNotNullField(
                        new Db2BigInt(row.getName()),
                        row.getNulls()
                );
            default:
                throw new IllegalArgumentException(row.getColType() + ": Coltype is not valid!");
        }
    }

    private static ISqlElement ifNotNullField(ISqlElement field, String nullType) {
        return "N".equals(nullType) ? new NotNullField(field) : field;
    }
}
