package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * Processes unique tokens and creates a list of unique tokens.
 * @author Thomas Hawkins
 * class UniqueTokenAnalyzer
 */
public class UniqueTokenAnalyzer implements Analyzer {

    // Only allowed instance variable
    private Set<String> uniqueTokensList;
    private Properties properties;


    /**
     * Empty constructor for UniqueTokenAnalyzer.
     */
    public UniqueTokenAnalyzer() {
    }


    /**
     * Properties constructor for UniqueTokenAnalyzer.
     */
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        uniqueTokensList = new TreeSet<String>();
    }


    /**
     * Getter for the set list.
     * @return uniqueTokensList Set of each unique token
     */
    public Set<String> getUniqueTokensList() {
        return uniqueTokensList;
    }


    /**
     * Adds each token passed in, into the Set list.
     * @param token Individual token
     */
    public void processToken(String token) {
        uniqueTokensList.add(token);
    }


    /**
     * Uses printwriter to write to a specific file path and file name. Will
     * create a new file if it doesn't exist or overwrite an existing one. Uses a
     * try catch block for exception handling.
     * @param inputFilePath Text file
     * @param outputFilePath Unique token report
     */
    public void writeOutputFile(String inputFilePath) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(properties.getProperty("output.dir") + properties.getProperty("output.file.unique"))))
        ) {

            createTokenList(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Loops through set list and prints out each token on it's own line.
     * @param out Printwriter stream and output file path for printing each token.
     */
    private void createTokenList(PrintWriter out) {
        for (String token : uniqueTokensList) {
            out.println(token);
        }
    }
}
