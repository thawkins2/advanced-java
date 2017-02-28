package java112.labs1;

import java.io.*;


public class WriteDemo {
    

    public void run() {
        
        try (
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))
        ) {

            out.println("Yay");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }
    

    public static void main(String[] arguments) {
        WriteDemo demo = new WriteDemo();
        demo.run();
    }
    
}
