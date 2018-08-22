package stdin_stdout;

import java.util.Scanner;

public class StdInOut {

    public static String stringInput;
    public static int intInput;
    public static double doubleInput;

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        stringInput = scan.nextLine();
        intInput = scan.nextInt();
        doubleInput = scan.nextDouble();

        System.out.println("String: " + stringInput);
        System.out.println("Double: " + doubleInput);
        System.out.println("Int: " + intInput);

        scan.close();

    }
}
