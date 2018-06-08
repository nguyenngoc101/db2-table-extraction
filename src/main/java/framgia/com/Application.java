package framgia.com;

import framgia.com.entity.table.Table;
import framgia.com.reader.CsvReader;

import java.util.List;

public class Application {
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
