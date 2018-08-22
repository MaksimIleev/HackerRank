package output_formatting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringFormatMain {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i = 0; i < 3; i++) {

            String sl = sc.next();
            int spaces = 15;
            if(sl != null && sl.length() <= 10) {
                //spaces = 15 + (15 - (15 - (sl.length())));
            } else
                throw new InputMismatchException("String input should be max 10 characters");

            int x = sc.nextInt();
            if(!(x >= 0 && x<= 999))
                throw new InputMismatchException("int range should be between 0 - 999");


            System.out.println(String.format("%-" + spaces + "s%03d", sl, x));
        }
        System.out.println("================================");
    }
}
