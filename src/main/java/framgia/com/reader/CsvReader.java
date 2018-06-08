package framgia.com.reader;

import framgia.com.entity.ISqlElement;
import framgia.com.entity.table.Table;
import framgia.com.factory.SqlFactory;
import framgia.com.text.Row;
import framgia.com.text.TextInFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CsvReader implements IReader {

    private final File file;

    public CsvReader(File file) {
        this.file = file;
    }

    public CsvReader() {
        this(new File("/Users/apple/TS0T3.CSV"));
    }

    public List<Table> read() {
        List<Table> tables = new ArrayList<>();
        List<String> list = new TextInFile(this.file).read();

        List<Row> rows = this.getRowsFromRawText(list);

        Map<String, List<Row>> tableMap = convertRowsToTable(rows);
        tableMap.forEach((k, v) -> {
            Table table = new Table(k);
            List<ISqlElement> fields = v.stream().map(row -> SqlFactory.getField(row)).collect(Collectors.toList());
            table.setFields(fields);
            tables.add(table);
        });

        return tables;
    }

    public List<Row> getRowsFromRawText(List<String> rawRows) {
        return rawRows.stream().filter(e -> e.contains("DB2INST1")).map(Row::new).collect(toList());
    }

    public Map<String, List<Row>> convertRowsToTable(List<Row> rows) {
        return rows.stream().collect(Collectors.groupingBy(k -> k.getTableName(), Collectors.mapping((Row p) -> p, toList())));
    }
}
