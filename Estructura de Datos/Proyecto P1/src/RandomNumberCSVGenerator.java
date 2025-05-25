import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberCSVGenerator {
    public static void main(String[] args) throws Exception {
        generateRandomNumbersCSV("numbers.csv", 1_000_000);
    }

    private static void generateRandomNumbersCSV(String fileName, int count) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                writer.write(random.nextInt(1000000) + ""); 
                if (i < count - 1) {
                    writer.write(","); 
                }
            }
            System.out.println("CSV generado: " + fileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
