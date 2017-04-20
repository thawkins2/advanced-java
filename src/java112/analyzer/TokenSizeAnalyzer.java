package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Your Name Here
 * class TokenSizeAnalyzer
 */
public class TokenSizeAnalyzer implements Analyzer {

    private Map<Integer, Integer> tokenSizes;
    private Properties properties;
    private int maximumSize;


    /**
     * Constructor for TokenSizeAnalyzer
     */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }


    /**
     * Properties constructor for TokenSizeAnalyzer
     * @param properties Property variable
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Get method for the tokenSizes variable
     * @return tokenSizes Map with each token size and number of times that length is found.
     */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }


    /**
     * Get method for the maximumSize variable
     * @return maximumSize Highest number of token length found.
     */
    public int getMaximumSize() {
        return maximumSize;
    }


    /**
     * Checks map keys for token. Increments value if key is found. Adds new key
     * and value if not.
     * @param token Individual token
     */
    public void processToken(String token) {
        if (tokenSizes.containsKey(token.length())) {
            incrementCount(token);
        } else {
            addNewMapKey(token);
        }
    }


    /**
     * Write out individual token lengths and the number of times found.
     * @param inputFilePath input file
     */
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
        new FileWriter(properties.getProperty("output.dir")
        + properties.getProperty("output.file.token.size"))))
        ) {
            findMaximumSize();
            createTokenSizeReport(out);
            createHistogramReport(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Increments Integer value associated with key
     * @param token Token key used to increment Integer.
     */
    private void incrementCount(String token) {
        Integer newCount = tokenSizes.get(token.length());
        newCount++;
        tokenSizes.put(token.length(), newCount);
    }


    /**
     * Adds new key and value to map.
     * @param token Token to be added to TreeMap.
     */
    private void addNewMapKey(String token) {
        tokenSizes.put(token.length(), new Integer(1));
    }


    /**
     * Write out TreeMap to file.
     * @param out Outputfile
     */
    private void createTokenSizeReport(PrintWriter out) {
        for (Map.Entry <Integer, Integer> size : tokenSizes.entrySet()) {
            out.println(size.getKey() + "\t" + size.getValue());
        }
    }


    /**
     * Loops through token sizes and outputs token size and asterisk representation.
     * @param out Outputfile
     */
    private void createHistogramReport(PrintWriter out) {

        // double calcAsterisks = maximumSize / 73;
        for (Map.Entry <Integer, Integer> size : tokenSizes.entrySet()) {

            // int numOfAsterisks = (int)Math.ceil(size.getValue() / calcAsterisks);
            // String asterisks = new String(new char[numOfAsterisks]).replace("\0", "*");
            String asterisks = getAsterisks(size.getValue());

            out.println(size.getKey() + "\t" + asterisks);
        }
    }


    /**
     * Takes in size and calculates how many asterisks are needed to represent size.
     * @param size Number of tokens that length
     * @return string of asterisks to be output
     */
    private String getAsterisks(Integer size) {
        double calcAsterisks = maximumSize / 73.0;
        int numOfAsterisks = (int)Math.ceil(size / calcAsterisks);
        return new String(new char [numOfAsterisks] ).replace("\0", "*");
    }


    /**
     * Finds the token length found most and assigns it to maximumSize.
     */
    private void findMaximumSize() {
        maximumSize = Collections.max(tokenSizes.values());
    }
}
