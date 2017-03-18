package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * Analyzes token with map key and either increments value or adds new key value
 * pair to the map.
 * @author Thomas Hawkins
 * class TokenCountAnalyzer
 */
public class TokenCountAnalyzer implements Analyzer {

    private Properties properties;
    private Map<String, Integer> tokenCounts;


    /**
     * Get method for the token count variable
     * @return tokenCounts Map with each token and the number of times it appears.
     */
    public Map getTokenCounts() {
        return tokenCounts;
    }


    /**
     * Constructor for TokenCountAnalyzer
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }


    /**
     * Properties constructor for TokenCountAnalyzer.
     * @param properties Property variable
     */
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Checks map keys for token. Increments value if key is found. Adds new key
     * and value if not.
     * @param token Individual token
     */
    public void processToken(String token) {
        if (tokenCounts.containsKey(token)) {
            incrementCount(token);
        } else {
            addNewMapKey(token);
        }
    }


    /**
     * Write out individual tokens and the number of times found.
     * @param inputFilePath input file
     */
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(properties.getProperty("output.dir") + properties.getProperty("output.file.token.count"))))
        ) {

            createTokenCountList(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Write out TreeMap to file.
     * @param out Outputfile
     */
    private void createTokenCountList(PrintWriter out) {
        for (Map.Entry <String, Integer> entry : tokenCounts.entrySet()) {
            out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }


    /**
     * Increments Integer value associated with key
     * @param token Token key used to increment Integer.
     */
    private void incrementCount(String token) {
        Integer newCount = tokenCounts.get(token);
        newCount++;
        tokenCounts.put(token, newCount);
    }


    /**
     * Adds new key and value to map.
     * @param token Token to be added to TreeMap.
     */
    private void addNewMapKey(String token) {
        tokenCounts.put(token, new Integer(
        Integer.parseInt(properties.getProperty("token.count.min"))));
    }
}
