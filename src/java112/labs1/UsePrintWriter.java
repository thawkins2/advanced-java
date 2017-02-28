

package java112.labs1;

import java.io.*;


public class UsePrintWriter extends java.lang.Object {

    private  PrintWriter  out;
    private  String       fileName;
    private  String       firstName;



    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



    public String getFileName() {
        return fileName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }



    public void run(String[] args) throws java.io.IOException {

        if (args.length == 0) {
            System.out.println("Please add a file name and a first name.");
            return;
        }
        
        setFileName(args[0]);
        setFirstName(args[1]);
        
       
        out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

        out.print("Hello ");
        out.println(firstName);
        out.println("How's it going?");

        
        
        out.close();
    }


    
    public static void main(String[] args) throws java.io.IOException {

        UsePrintWriter  usePrint  = new UsePrintWriter();

        usePrint.run(args);

    }

}

