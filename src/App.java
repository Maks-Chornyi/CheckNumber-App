import java.util.Scanner;

public class App {
    public static void main(String... args) {

        int loopCount = 0;              //variable for showing item 4 in menu
        boolean oneNumberloop = true;   //variable for loop
        boolean wrongSymbol = true;     //variable for while loop which checking entered non number symbols
        int userNumber = 0;             //number entered by user in console

        //Use scanner for reading from console
        Scanner sc = new Scanner(System.in);

        while (oneNumberloop) {
            //show greeting message and aks for number in user
            System.out.println("Welcome to \"CheckYourNumber\" application!\n\nEnter any number you want, please: ");

            //while loop which checking entered integer numbers only
            while (wrongSymbol) {
                if (!(sc.hasNextInt())) {
                    System.out.println("Oops! We expected integer number.");
                    sc.nextLine();

                } else {
                    String enteredLine = sc.nextLine();
                    if(enteredLine.matches("\\d+"))
                    {
                        userNumber = Integer.parseInt(enteredLine);//Integer.parseInt(enteredLine);
                        wrongSymbol = false;    //assign false to WrongSymbol variable for exit from while loop
                    }
                    else {
                        System.out.println("Can you enter a number without whitespaces, please:");
                    }
                }
            }

            System.out.println("You've entered number " + userNumber);

            while (oneNumberloop) {
                System.out.println("\nPress 1\t\t to check does this number is even?"
                        + "\nPress 2\t\t to check does this number is prime?"
                        + "\nPress 3\t\t to check does this number positive or negative?");


                if (loopCount > 0)
                    System.out.println("Press 4\t\t to exit from program");

                int checkMenuItem = 0;
                boolean wrongItem = true;

                while (wrongItem) {
                    if (sc.hasNextInt()) {
                        String inputLine = sc.nextLine();

                        if(inputLine.matches("\\d+")) {                                                         //if in string digits only
                            checkMenuItem = Integer.parseInt(inputLine);
                            if (checkMenuItem > 0 && checkMenuItem < 4 + loopCount) {                             //and 0<digit<4+loopCount
                                wrongItem = false;                                                                //exit from loop
                            } else {
                                System.out.println("Enter a number from 1 to " + (3 + loopCount) + ", please");   //error message
                            }
                        }
                        else{
                            System.out.println("Can you enter a number without whitespaces, please:");
                        }
                    } else {
                        sc.nextLine();
                        System.out.println("Oh, can you enter a number, please");
                    }
                }


                if (checkMenuItem == 1) {
                    //сode for checking does number even || not
                    if (userNumber % 2 == 0)
                        System.out.println("Number \"" + userNumber + "\" is even");
                    else
                        System.out.println("Number \"" + userNumber + "\" isn't even");
                } else if (checkMenuItem == 2) {
                    //сode for checking does number prime || not
                    String primeOrNot = "is prime";
                    if (userNumber > 1) {
                        for (int d = 2; d < userNumber; d++) {
                            if (userNumber % d == 0) {
                                primeOrNot = "isn't prime";
                                break;
                            }
                        }
                    } else {
                        primeOrNot = "isn't prime";
                    }
                    System.out.println("Number \"" + userNumber + "\" " + primeOrNot);
                } else if (checkMenuItem == 3) {
                    //сode for checking does number positive || negative || zero
                    if (userNumber > 0)
                        System.out.println("Number \"" + userNumber + "\" is positive");
                    else if (userNumber < 0)
                        System.out.println("Number \"" + userNumber + "\" is negative");
                    else
                        System.out.println("You entered zero. So it's not negative either positive number.");

                } else if (checkMenuItem == 4) {
                    //code for exiting from code;
                    oneNumberloop = false;
                }
                loopCount = 1;
            }
        }
        System.out.println("Hope this program was useful for you. Take care yourself!");
    }
}