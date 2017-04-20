package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Thomas Hawkins
 * class KeywordAnalyzer
 */
public class KeywordAnalyzer implements Analyzer {
    
    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;
    
    /**
     * Constructor for KeywordAnalyzer
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List<Integer>>();
    }
    
    /**
     * Properties constructor for KeywordAnalyzer
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        openKeywordsFile();
        
    }
    
    public Map<String, List<Integer>> getKeywordMap() {
        return keywordMap;
    }
    
    public void processToken(String token) {
        tokenOccurence++;
        if (keywordMap.containsKey(token)) {
            addLocation(token);
        }
    }
    
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.dir")
                + properties.getProperty("output.file.keyword.tokens"))))
        ) {
            createKeywordFile(out);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private void openKeywordsFile() {
        String inputFilePath = properties.getProperty("output.dir.up")
                + properties.getProperty("output.file.keywords");
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath))
        ) {
            readFile(input);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private void readFile(BufferedReader input) throws IOException {
        String fileLine = null;
        String[] tokenArray = null;

        while (input.ready()) {
            fileLine = input.readLine();
            tokenArray = fileLine.split("\\W");

            loadMap(tokenArray);
        }
    }
    
    private void loadMap(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!token.isEmpty()) {
                keywordMap.put(token, new ArrayList<Integer>());
            }
        }
    }
    
    private void addLocation(String token) {
        keywordMap.get(token).add(tokenOccurence);
    }
    
    private void createKeywordFile(PrintWriter out) {
        for (Map.Entry <String, List<Integer>> entry : keywordMap.entrySet()) {
            String keywordOutput = formatOutput(entry);
            out.println(keywordOutput);
            out.println();
        }
    }
    
    private String formatOutput(Map.Entry <String, List<Integer>> entry) {
        String keywordOutput;
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getKey() + " = [");
        
        for (Integer location : entry.getValue()) {
            sb.append(location);
            sb.append(", ");
        }
        
        int i = 0;
        while ((i = sb.indexOf(" ", i + 80)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        
        sb.setLength(sb.length() - 2);
        sb.append("]");
        keywordOutput =  sb.toString();
        return keywordOutput;
    }
}