import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    // type psvm and then tab
    public static void main(String[] args) {


        /**
         * Read in a json file and clean out blank lines or comments
         * entryFile = file with entry point abbreviations
         */

        /* One way is to just throw away FileNotFound and create it
            We're not using this cause if the file doesn't exist - we should exit
        File entryFile = new File("../data/entrypoints.json");
        if (!entryFile.exists()) {
            entryFile.createNewFile("");
        }*/

        // Using BufferedReader we will process the file line by line
        //   - FIRST: print it
        String line;
        List<String> goodLines = new ArrayList<>();
        fileCleaner fileCleaner = new fileCleaner();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/data/entrypoints.json"))) {
            // I am just "try"ing to load the file into the class
            // I have created no variable to hold the "lines" yet

            // Using reader we can process the "buffer" line-by-line
            while ((line = reader.readLine()) != null) {
                // while (I reader.readLine() is not returning null (lines left) {
                if (!fileCleaner.checkIfBlankLine(line) && !fileCleaner.checkIfComment(line)) {
                    goodLines.add(line);
                }
            }

        } catch (NoSuchFileException nofile) {
            nofile.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        if (goodLines.size() < 2) {
            System.out.println("your too small not saving changes");
            System.exit(0);
        }
        // Now we will write the "clean" version to "clean_entrypoints.json"
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/data/clean_entrypoints.json"))) {
            // I am just "try"ing to load the file into the class

            // Using writer to write out our clean lines
            for (String gl : goodLines) {
                writer.write(gl + "\n");
            }

        } catch (NoSuchFileException nofile) {
            nofile.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /**Read in a csv file and clean out blank lines or comments
        **/
        List<String> goodCsvLines = new ArrayList<>();
        csvCleaner csvCleaner = new csvCleaner();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/data/SEOExample.csv"))) {
            // I am just "try"ing to load the file into the class
            // I have created no variable to hold the "lines" yet

            // Using reader we can process the "buffer" line-by-line
            while ((line = reader.readLine()) != null) {
                // while (I reader.readLine() is not returning null (lines left) {
                if (!csvCleaner.checkIfBlankLine(line) && !csvCleaner.checkIfComment(line)
                        && !csvCleaner.checkIfCommas(line)) {
                    goodCsvLines.add(line);
                }
            }

        } catch (NoSuchFileException nofile) {
            nofile.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        if (goodLines.size() < 2) {
            System.out.println("your too small not saving changes");
            System.exit(0);
        }
        // Now we will write the "clean" version to "clean_seoexample.csv"
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/data/" +
                "clean_seoexample.csv"))) {
            // I am just "try"ing to load the file into the class

            // Using writer to write out our clean lines
            for (String gl : goodCsvLines) {
                writer.write(gl + "\n");
            }

        } catch (NoSuchFileException nofile) {
            nofile.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}