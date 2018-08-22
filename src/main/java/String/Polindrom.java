package String;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Polindrom {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        try {
            String aStr = scanner.next();

            if(!(aStr != null && aStr.length() <= 50))
                throw new InputMismatchException("input should be <= 50 chars");

            char[] arr = aStr.toCharArray();
            for(int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

            String reversedStr = "";
            for(char c: arr)
                reversedStr += c + "";

            if(aStr.equals(reversedStr))
                System.out.println("Yes");
            else
                System.out.println("No");

        } finally {
            scanner.close();
        }
    }
}
