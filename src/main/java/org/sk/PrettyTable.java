// Made by skebir & edited by AuntieConsumer
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrettyTable {
    private List<String> headers = new ArrayList<>();
    private List<List<String>> data = new ArrayList<>();

    public PrettyTable(String... headers) {
        this.headers.addAll(Arrays.asList(headers));
    }

    public void addRow(String... row) {
        data.add(Arrays.asList(row));
    }

    private int getMaxSize(int column) {
        int maxSize = headers.get(column).length();
        for (List<String> row : data) {
            if (row.get(column).length() > maxSize)
                maxSize = row.get(column).length();
        }
        return maxSize;
    }

    private String formatRow(List<String> row) {
        int len;
        String  space1 = "​​ ";
        String  space2 = "​​ "; 
        StringBuilder result = new StringBuilder();
        result.append("|");
        for (int i = 0; i < row.size(); i++) {
            space1 = " ";
            space2 = " ";
            len = (getMaxSize(i))-(row.get(i).length());
            for (int j = 0; j < len/2; j++) {
              space1 = space1 + " ";
              space2 = space2 + " ";
            }
            if (!(len % 2 == 0)){
              space2 = space2+" ";
            } 
            result.append(space1+row.get(i)+space2);
            result.append("|");
        }
        result.append("\n");
        return result.toString();
    }

    private String formatRule() {
        StringBuilder result = new StringBuilder();
        result.append("+");
        for (int i = 0; i < headers.size(); i++) {
            for (int j = 0; j < getMaxSize(i) + 2; j++) {
                result.append("-");
            }
            result.append("+");
        }
        result.append("\n");
        return result.toString();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(formatRule());
        result.append(formatRow(headers));
        result.append(formatRule());
        for (List<String> row : data) {
            result.append(formatRow(row));
        }
        result.append(formatRule());
        return result.toString();
    }

}

