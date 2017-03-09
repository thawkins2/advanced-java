package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * Main processing class for the analyzer project. Takes in input file, processes it,
 * and calls for the creation of the final reports for the token analyzer.
 * @author Thomas Hawkins
 * class AnalyzeFile
 */
public class AnalyzeFile {

    private static final int COUNT_OF_ARGUMENTS = 2;
    private String inputFilePath;
    private SummaryReport summaryReport;
    private UniqueTokenAnalyzer uniqueTokenAnalyzer;
    private BigWordAnalyzer bigWordAnalyzer;
    private TokenCountAnalyzer tokenCountAnalyzer;
    private Properties properties;


    /**
     * Constructor for the AnalyzeFile class.
     */
    public AnalyzeFile() {
    }


    /**
     * Properties constructor for the AnalyzeFile class.
     */
    public AnalyzeFile(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Main method for the AnalyzerFile class. Checks for right amount of arguments
     * and assigns it to a variable. Also calls methods to create object instances,
     * open the file for reading/processing. Lastly calls the method to create the
     * summary reports.
     * @param arguments Command line argument for the text file to be processed.
     */
    public void runAnalysis(String[] arguments) {

        if (arguments.length != COUNT_OF_ARGUMENTS) {
            System.out.println("Missing arguments");
            return;
        }


        inputFilePath = arguments[0];
        loadProperties(arguments[1]);
        reportObject();
        openFile(inputFilePath);

        writeAllOutputFiles();
    }


    /**
     * Loads the properties file for AnalyzeFile class.
     */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Method creates the object instances for summaryReport and
     * uniqueTokenAnalyzer.
     */
    private void reportObject() {
        summaryReport = new SummaryReport(properties);
        uniqueTokenAnalyzer = new UniqueTokenAnalyzer(properties);
        bigWordAnalyzer = new BigWordAnalyzer(properties);
        tokenCountAnalyzer = new TokenCountAnalyzer(properties);
    }


    /**
     * Method uses bufferedreader to open the text file and call the readfile method.
     * Uses a try catch block for exception handling.
     * @param inputFilePath Contains the text file path to be used for processing.
     */
    private void openFile(String inputFilePath) {
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
     * Method takes in the text file and creates an array of tokens from each
     * indivudial line. Array of tokens is processed in another method before
     * it moves onto the next line.
     * @param input File with open reading stream for processing each line.
     * @throws IOException If there is an exception error. */
    private void readFile(BufferedReader input) throws IOException {
        String fileLine = null;
        String[] tokenArray = null;

        while (input.ready()) {
            fileLine = input.readLine();
            tokenArray = fileLine.split("\\W");

            processTokens(tokenArray);
        }
    }


    /**
     * Method takes in a array of tokens and processes each individual token. If
     * the token is empty, no processing is done.
     * @param tokenArray Array of tokens for each individual line.
     */
    private void processTokens(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!token.isEmpty()) {
                uniqueTokenAnalyzer.processToken(token);
                summaryReport.processToken(token);
                bigWordAnalyzer.processToken(token);
                tokenCountAnalyzer.processToken(token);
            }
        }
    }


    /**
     * Method calls for the creation of the summary report and unique tokens list.
     * File has been processed at this point.
     */
    private void writeAllOutputFiles() {
        summaryReport.writeOutputFile(inputFilePath);
        uniqueTokenAnalyzer.writeOutputFile(inputFilePath);
        bigWordAnalyzer.writeOutputFile(inputFilePath);
        tokenCountAnalyzer.writeOutputFile(inputFilePath);
    }
}
