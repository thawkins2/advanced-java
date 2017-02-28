/*
 *  Class: UseBufferedReader
 *  Author: Eric Knapp
 *  Create date: 1/20/2009
 *  Description: This class demonstrates many features of project 1.
 */
package java112.labs1;

import java.io.*;
import java.util.*;


public class UseBufferedReader {

 
    //private BufferedReader input;

 
    private List allTokens = new ArrayList();


    private Set uniqueTokens = new TreeSet();


 
    public void run() {

        readFileAndLoadCollections();
        printTokenList();
        printUniqueTokenList();

    }



    private void readFileAndLoadCollections() {

        try (
            BufferedReader input = new BufferedReader(new FileReader("sample.txt"))
        ) {
            //create a BufferedReader using a hard-coded file
            

            String inputLine = null;
            String[] tokenArray = null;
            String token = null;

            //loop through the input file one line at a time
            while (input.ready()) {
                inputLine = input.readLine();
                tokenArray = inputLine.split("\\W");
                
                processTokens(tokenArray);
                //for (int i = 0; i < tokenArray.length; i++) {
                //    tokens.add(tokenArray[i]);
                //    uniqueTokens.add(tokenArray[i]);
                //}

            }

        } catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Failed to read input file");
            fnfe.printStackTrace();
        } catch (Exception exception) {
            System.out.println("General Error");
            exception.printStackTrace();
        } 
    }



    private void printTokenList() {

        System.out.println("\n####################\ntoken list size: "
                 + allTokens.size());
        
        for (Iterator it = allTokens.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }



    private void printUniqueTokenList() {

        System.out.println("\n####################\nunique token list size: "
                 + uniqueTokens.size());
        
        for (Iterator it = uniqueTokens.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
    
    private void processTokens(String[] tokens) {
        
        for (String token : tokens) {
            allTokens.add(token);
            uniqueTokens.add(token);
        }
        
    }



    public static void main(String[] args) throws IOException {
        UseBufferedReader reader = new UseBufferedReader();
        reader.run();
    }

}

