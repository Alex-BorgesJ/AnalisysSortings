package dataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSet {

    private List<String> columns;
    private List<Map<String, Object>> rows;

    public DataSet() {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public void addRow(Map<String, Object> rowData) {
        rows.add(rowData);
    }

    public void addColumn(String columnName) {
        columns.add(columnName);
        for (Map<String, Object> row : rows) {
            row.put(columnName, null);
        }
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void printDataSet() {
        Map<String, Integer> columnWidths = new HashMap<>();
        for (String columnName : columns) {
            columnWidths.put(columnName, columnName.length());
        }

        for (Map<String, Object> row : rows) {
            for (String columnName : columns) {
                Object value = row.get(columnName);
                int valueLength = value == null ? 4 : value.toString().length(); // "null" length is 4
                if (valueLength > columnWidths.get(columnName)) {
                    columnWidths.put(columnName, valueLength);
                }
            }
        }

        for (String columnName : columns) {
            System.out.printf("%-" + columnWidths.get(columnName) + "s\t", columnName);
        }
        System.out.println();

        for (Map<String, Object> row : rows) {
            for (String columnName : columns) {
                Object value = row.get(columnName);
                System.out.printf("%-" + columnWidths.get(columnName) + "s\t", value);
            }
            System.out.println();
        }
    }
}

