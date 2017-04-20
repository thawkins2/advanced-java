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
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    
    public Map<Integer, Integer> getTokenSizes() {
    return tokenSizes;
    }
     
    public int getMaximumSize() {
        return maximumSize;
    }
    
    public void processToken(String token) {
        if (tokenSizes.containsKey(token.length())) {
            incrementCount(token);
        } else {
            addNewMapKey(token);
        }
    }
    
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.dir")
                + properties.getProperty("output.file.token.size"))))
        ) {
            findMaximumSize();
            createTokenSizeReport(out);
            out.println();
            out.println();
            createHistogramReport(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private void incrementCount(String token) {
        Integer newCount = tokenSizes.get(token.length());
        newCount++;
        tokenSizes.put(token.length(), newCount);
    }
    
    private void addNewMapKey(String token) {
        tokenSizes.put(token.length(), new Integer(1));
    }
    
    private void createTokenSizeReport(PrintWriter out) {
        for (Map.Entry<Integer, Integer> size : tokenSizes.entrySet()) {
            out.println(size.getKey() + "\t" + size.getValue());
        }
    }
    
    private void createHistogramReport(PrintWriter out) {
        //double calcAsterisks = maximumSize / 73;
        
        
        for (Map.Entry<Integer, Integer> size : tokenSizes.entrySet()) {
            //int numOfAsterisks = (int)Math.ceil(size.getValue() / calcAsterisks);
            
            //String asterisks = new String(new char[numOfAsterisks]).replace("\0", "*");
            String asterisks = getAsterisks(size.getValue());
            
            out.println(size.getKey() + "\t" + asterisks);
        }
    }
    
    private String getAsterisks(Integer size) {
        double calcAsterisks = maximumSize / 73;
        int numOfAsterisks = (int)Math.ceil(size / calcAsterisks);
        return new String(new char[numOfAsterisks]).replace("\0", "*");
    }
    
    private void findMaximumSize() {
        maximumSize = Collections.max(tokenSizes.values());
    }
    
}