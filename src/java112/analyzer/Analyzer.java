package java112.analyzer;


/**
 * Main interface for the analyzer program. Interface is implemented in the
 * summary report and unique token analyzer classes.
 * @author Thomas Hawkins
 * class name Analyzer
 */
public interface Analyzer{

    /**
     * Method to process token count or each individual token
     * @param token Individual token
     */
    void processToken(String token);
    /**
     * Method to write out of summary report and unique token report.
     * @param inputFilePath input file
     * 
     */
    void writeOutputFile(String inputFilePath);
}
