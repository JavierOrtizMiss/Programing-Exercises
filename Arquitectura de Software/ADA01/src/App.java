import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String filename = "nombres.txt";
        DataProcessor dataProcessor = new DataProcessor();
        ArrayList<String> result = dataProcessor.processNames(filename);
        for (String name : result) {
            System.out.println(name);
        }
    }
}


