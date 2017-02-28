package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * Creates a final summary report about the token analyzer. Includes the final
 * token count and information on when the analyzer was run.
 * @author Thomas Hawkins
 * class SummaryReport
 */
public class SummaryReport implements Analyzer {

    // Only allowed instance variable
    private int totalTokensCount;


    /**
     * Constructor for SummaryReport
     */
    public SummaryReport() {
    }


    /**
     * Getter for the total count of tokens in the file.
     * @return totalTokensCount Total of all tokens in file, including duplicates.
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    /**
     * Increments the totalTokensCount as each token is passed in. totalTokensCount
     * will reflect the total number of tokens in the text file.
     * @param token Individual token
     */
    public void processToken(String token) {
        totalTokensCount++;
    }


    /**
     * Uses printwriter to open a new stream to writeout a summary report file.
     * Uses a try catch block for exception handling.
     * @param inputFilePath Text file
     * @param outputFilePath Summary report
     */
    public void writeOutputFile(String inputFilePath, String outputFilePath) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {

            buildFile(inputFilePath, out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Uses the printwriter paramater passed in to write out to the summary report.
     * @param inputFilePath Input text file path
     * @param out Output file stream and path
     */
    private void buildFile(String inputFilePath, PrintWriter out) {
        out.println("Application: UniqueText");
        out.println("Author: Thomas Hawkins, T-H 2:30-4:15");
        out.println("Email: thawkins2@madisoncollege.edu");
        out.println("Input File: " + inputFilePath);
        out.println("Analyzed on: " + new Date());
        out.println("Total token count: " + getTotalTokensCount());
    }
}
