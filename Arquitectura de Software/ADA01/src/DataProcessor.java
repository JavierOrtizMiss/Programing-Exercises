import java.util.ArrayList;

public class DataProcessor {
    private Reader reader;
    private NameFormatter formatter;
    private NameSorter sorter;

    public DataProcessor() {
        this.reader = new Reader();
        this.formatter = new NameFormatter();
        this.sorter = new NameSorter();
    }

    public ArrayList<String> processNames(String filename) {
        ArrayList<String> names = new ArrayList<>(reader.readNames(filename));
        ArrayList<String> formattedNames = new ArrayList<>();
        for (String name : names) {
            formattedNames.add(formatter.format(name));
        }
        sorter.sort(formattedNames);
        return formattedNames;
    }
}
