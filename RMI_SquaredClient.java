import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


public class RMI_SquaredClient {
    private static Scanner scan = null;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        try {
            RMI_SquaredInterface squaredapi = (RMI_SquaredInterface) Naming.lookup("rmi://localhost:7777/squared");

            scan = new Scanner(System.in);

            for (;;) {
                System.out.println("##########################");
                System.out.println("Squared and SquaredRoot");
                System.out.println("##########################");
                System.out.println();
                System.out.println(" What is your todays operation");
                System.out.println("1 - Get the Square of the Number ");
                System.out.println("2 - Get the SquareRoot of the Number ");

                int choice = getChoice();
                if (choice == 1) {
                    System.out.println(squaredapi.getSquare(getInput()));

                } else {
                    System.out.println(squaredapi.getSquareRoot(getInput()));
                }

            }
        }

        catch (Exception e) {
            System.out.println("ERROR: The RMI_SquaredClient is not running....");
            e.printStackTrace();
        }
    }

    public static int getChoice() {
        try {
            System.out.println("Enter Choice: ");
            int input = scan.nextInt();
            if (input < 1 || input > 2)
                throw new Exception();
            return input;
        } catch (Exception e) {
            System.err.println("ERROR: Please input a number from 1 to 2. ");
            return getChoice();
        }
    }

    public static double getInput() {
        try {
            System.out.println("Enter a number ");
            double input = scan.nextDouble();
            return input;
        }

        catch (Exception e) {
            System.err.println("ERROR: Please type a valid number");
            return getInput();
	}
    }

}

