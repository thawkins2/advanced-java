package java112.labs1;



public class LabThree {

    public void run(String input) {

        System.out.println("input: " + input);
    }


    public static void main(String[] arguments) {

        if (arguments.length != 1) {
            System.out.println("Please enter one argument on the command line");
            return;
        }


        LabThree demo = new LabThree();
        demo.run(arguments[0]);
    }
}
