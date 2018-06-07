package framgia.com.reader;

import framgia.com.entity.ISqlElement;
import framgia.com.entity.Table;
import framgia.com.factory.SqlFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static framgia.com.util.StringUtils.nomarlizeColType;
import static java.util.stream.Collectors.toList;

public class CsvReader implements IReader {

    private String path;

    public CsvReader(String path) {
        this.path = path;
    }

    public CsvReader() {
        this("/Users/apple/TS0T3.CSV");
    }

    public List<Table> read() {
        List<Table> tables = new ArrayList<>();

        List<String> list = this.readRawCsv();
        List<Row> rows = this.getRowsFromRawText(list);
        Map<String, List<Row>> tableMap = convertRowsToTable(rows);
        tableMap.forEach((k, v) -> {
            Table table = new Table(k);
            List<ISqlElement> fields = v.stream().map(this::convertToSqlElement).collect(Collectors.toList());
            table.setFields(fields);
            tables.add(table);
        });

        return tables;
    }

    public ISqlElement convertToSqlElement(Row row) {
        return SqlFactory.getField(row);
    }

    public List<String> readRawCsv() {
        // reading csv file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(this.path),  Charset.forName("UTF-8"))) {
            return  stream.collect(toList());

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Row> getRowsFromRawText(List<String> rawRows) {
        return rawRows.stream().filter(e -> e.contains("DB2INST1")).map(this::getRow).collect(toList());
    }

    private Row getRow(String s) {
        String[] cols = s.split(",");
        Row row = new Row();
        row.setName(nomarlizeColType(cols[0]));
        row.setTableName(nomarlizeColType(cols[1]));
        row.setColType(nomarlizeColType(cols[4]));
        row.setNulls(nomarlizeColType(cols[5]));
        row.setLength(nomarlizeColType(cols[8]));
        row.setScale(nomarlizeColType(cols[9]));
        return row;
    }

    public Map<String, List<Row>> convertRowsToTable(List<Row> rows) {
        return rows.stream().collect(Collectors.groupingBy(k -> k.getTableName(), Collectors.mapping((Row p) -> p, toList())));
    }

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();

        List<Table> tables = csvReader.read();
        System.out.println("Total tables: "+tables.size());

        tables.stream().forEach(e ->{
            System.out.println(e.getSqlText());
            System.out.println();
        });
    }
}
