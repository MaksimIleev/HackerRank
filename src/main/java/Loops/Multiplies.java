package Loops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiplies {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        if(!(n >= 2 && n <= 20))
            throw new InputMismatchException("input n should be n >= 2 && n <= 20");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = " + (n * i), n, i);
            System.out.println();
        }
        scanner.close();
    }
}
