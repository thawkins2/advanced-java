package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Thomas Hawkins
 * BigWordAnalyzer
 */
public class BigWordAnalyzer implements Analyzer {

    private Properties properties;
    private Set<String> bigWords;
    private int minimumWordLength;


    /**
     * Constructor for BigWordAnalyzer.
     */
    public BigWordAnalyzer() {
    }


    /**
     * Properties constructor for BigWordAnalyzer.
     * @param properties Property variable
     */
    public BigWordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        bigWords = new TreeSet<String>();
        minimumWordLength = Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
    }


    /**
     * Get for bigWords set.
     * @return bigWords The set of words 18 character or more.
     */
    public Set<String> getBigWords() {
        return bigWords;
    }


    /**
     * Method to process each token with a length of 18 or more.
     * @param token Individual token of length 18 or more.
     */
    public void processToken(String token) {
        if (token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }


    /**
     * Use print write to write out words with a length of 18 or more.
     * @param inputFilePath Input text file.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(properties.getProperty("output.dir") + properties.getProperty("output.file.bigwords"))))
        ) {

            createBigWordList(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Loops through the set and write to a file.
     * @param out Printwrite stream output file path
     */
    private void createBigWordList(PrintWriter out) {
        for (String token : bigWords) {
            out.println(token);
        }
    }
}

