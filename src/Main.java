import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner scanner1 = new Scanner(System.in);

    public static void main(String[] args) {
        //Initialization of objects
        Scanner scanner = new Scanner(System.in);
        RandomNumberWriter numberWriter = new RandomNumberWriter();
        Main main = new Main();

        //Start the program:
        System.out.println("""
                Hello, It's project 8, please enter a mode you want to use here.\s
                The program can only accept "0" and "1".\s
                Enter "1" to create a file and then fill it with random numbers.\s
                Enter "0" to exit the program.""");

        //Initialization of the eternal cycle.
        while (true) {
            //Switch() declarations for different application modes.
            switch(main.controlSYS()) {
                //Exit the loop and the program as a whole.
                case ("0"): {
                    System.out.println("Before meeting!");
                    System.exit(0);
                }

                //Main code.
                case ("1"): {
                    System.out.println("Enter how you want to name the file: ");
                    File fileName = new File(scanner.nextLine());
                    System.out.println("Enter minimal range of random numbers: ");
                    int minRange = main.value();
                    System.out.println("Enter maximal range of random numbers: ");
                    int maxRange = main.value();
                    System.out.println("Enter amount of random numbers you want to create: ");
                    int count = main.value();

                    numberWriter.userInput(minRange, maxRange);
                    numberWriter.numberRandomizer(fileName, minRange, maxRange, count);
                    numberWriter.infoReader(fileName);
                    System.out.println("Do you want to continue? Enter \"1\" to re-generate the file " +
                            "and fill it further, or enter \"0\" to exit the program.");
                    break;
                }

                //In case of error or unforeseen situations.
                default: {
                    System.out.println("The program can only accept \"0\" and \"1\". " +
                            "Please try again correctly!");
                    break;
                }
            }
        }
    }

    //A block that controls and accompanies the program.
    public String controlSYS() {
        String _control = "0";
        try {
            _control = scanner1.nextLine();
        } catch(InputMismatchException e) {
            System.out.println("Please follow the instructions and be careful " +
                    "when working with this program!!!");
            _control = "6";
        }
        return _control;
    }

    //
    public int value() {
        int a = 0;
        try {
            a = scanner1.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter only integer values!");
            a = 100;
        }
        scanner1.nextLine();
        return a;
    }
}
