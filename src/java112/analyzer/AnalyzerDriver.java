package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * The main class for the Analyzer program. Main method will instantiate an
 * instance of the Analyze file class and analyze the text file passed in through
 * the command line.
 *
 * @author Thomas Hawkins
 * class AnalyzeDriver
 */
public class AnalyzerDriver {

    /**
     * Constructor for the AnalyzeDriver class
     */
    public AnalyzerDriver() {
    }


    /**
     * Driver for the Analyzer program. User adds file input path in as a
     * command line argument. Then passes in that argument into the AnalyzerFile
     * class.
     * @param arguments Text file location as a command line argument.
     */
    public static void main(String[] arguments) {
        AnalyzeFile analyze = new AnalyzeFile();
        analyze.runAnalysis(arguments);
    }
}
