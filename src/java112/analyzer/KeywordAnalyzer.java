package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Thomas Hawkins
 * class KeywordAnalyzer
 */
public class KeywordAnalyzer implements Analyzer {

    private Map<String, List <Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;


    /**
     * Constructor for KeywordAnalyzer
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List <Integer>>();
    }


    /**
     * Properties constructor for KeywordAnalyzer
     * @param properties Property variable
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        openKeywordsFile();
    }


    /**
     * Get method for the keywordMap TreeMap.
     * @return keywordMap Highest number of token length found.
     */
    public Map<String, List <Integer>> getKeywordMap() {
        return keywordMap;
    }


    /**
     * Checks if token is found in keywordMap and adds tokenOccurence to
     * associated list. tokenOccurance is incremented with each token passed in.
     * @param token Individual token
     */
    public void processToken(String token) {
        tokenOccurence++;
        if (keywordMap.containsKey(token)) {
            addLocation(token);
        }
    }


    /**
     * Write out each keyword and what location they were found.
     * @param inputFilePath input file
     */
    public void writeOutputFile(String inputFilePath) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
        new FileWriter(properties.getProperty("output.dir")
        + properties.getProperty("output.file.keyword"))))
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


    /**
     * Opens keyword file using properties and instantiated map with each keyword.
     */
    private void openKeywordsFile() {
        String inputFilePath = properties.getProperty("file.path.keywords");
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


    /**
     * Processes keyword file and loads map with each individual keyword.
     * @param input input file
     * @throws IOException If there is an exception error.
     */
    private void readFile(BufferedReader input) throws IOException {
        String fileLine = null;
        String[] tokenArray = null;

        while (input.ready()) {
            fileLine = input.readLine();
            tokenArray = fileLine.split("\\W");

            loadMap(tokenArray);
        }
    }


    /**
     * Adds each keyword to map from array.
     * @param tokenArray array of keyword tokens
     */
    private void loadMap(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!token.isEmpty()) {
                keywordMap.put(token, new ArrayList<Integer>());
            }
        }
    }


    /**
     * Uses token as key to add tokenOccurance to list.
     * @param token indiviudal token
     */
    private void addLocation(String token) {
        keywordMap.get(token).add(tokenOccurence);
    }


    /**
     * Loops through each keywordMap entry and outputs formatted string.
     * @param out Printwriter variable
     */
    private void createKeywordFile(PrintWriter out) {
        for (Map.Entry <String, List <Integer>> entry : keywordMap.entrySet()) {
            String keywordOutput = formatOutput(entry);
            out.println(keywordOutput);
        }
    }


    /**
     * Takes in keyword entry set and uses stringbuilder to format the keyword output.
     * Returns string to be output to file.
     * @param entry TreeMap entry set
     * @return formatted output for keyword
     */
    private String formatOutput(Map.Entry <String, List <Integer>> entry) {
        String keywordOutput;
        StringBuilder keyword = new StringBuilder();
        keyword.append(entry.getKey() + " =");
        keyword.append(System.getProperty("line.separator"));
        keyword.append("[");

        keyword = keywordBuilder(entry, keyword);

        keyword = formatKeyword(keyword);

        if (!entry.getValue().isEmpty()) {
            keyword.setLength(keyword.length() - 2);
        }


        keyword.append("]");
        keyword.append(System.getProperty("line.separator"));
        keywordOutput = keyword.toString();
        return keywordOutput;
    }


    /**
     * Builds keyword string to be formatted.
     * @param entry ArrayList of keyword locations
     * @param keyword Stringbuilder keyword string
     * @return keyword string
     */
    private StringBuilder keywordBuilder(Map.Entry <String, List <Integer>> entry, StringBuilder keyword) {
        for (Integer location : entry.getValue()) {
            keyword.append(location);
            keyword.append(", ");
        }
        return keyword;
    }


    /**
     * Takes in keyword string and formats it correctly.
     * @param keyword StringBuilder string
     * @return formatted keyword string
     */
    private StringBuilder formatKeyword(StringBuilder keyword) {

        int counter = 0;
        while ((counter = keyword.indexOf(" ", counter + 80)) != -1) {
            keyword.replace(counter, counter + 1, System.getProperty("line.separator"));
        }

        return keyword;
    }
}
