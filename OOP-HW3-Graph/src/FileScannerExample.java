import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileScannerExample {
    public static void main(String[] args) throws IOException {
        // Part 1: Reading lines from the file
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (Scanner fileScanner = new Scanner(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                processLine(line, writer);
            }

            System.out.println("Data has been written to output.txt");
        }
    }

    // Part 2: Scanning each line
    private static void processLine(String line, FileWriter writer) throws IOException {
        Scanner lineScanner = new Scanner(line);

        while (lineScanner.hasNext()) {
            if (lineScanner.hasNextInt()) {
                int number = lineScanner.nextInt();
                writer.write("Integer entered: " + number + "\n");
            } else {
                String input = lineScanner.next();
                writer.write("String entered: " + input + "\n");
            }
        }

        lineScanner.close();
    }
}
