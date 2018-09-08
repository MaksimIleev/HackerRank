package RegEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SplitByTokens {

    public static void main(String[] args) {

        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
            String s = scan.nextLine();

            if ((s != null && s.length() < 1) || (s != null && s.length() > 4 * (Math.pow(10, 5))))
                //throw new InputMismatchException("input length is wrong!");
                System.exit(1);

            if (!(s.matches("[A-Za-z !,?\\.\\_'@]+")))
                //throw new InputMismatchException("wrong input format");
                System.exit(1);

            if (s.trim().length() == 0) {
                System.out.println(0);
                System.exit(1);
            }

            String arr[] = null;
            arr = (s.trim().split("[ !,?\\.\\_'@]+"));

            System.out.println(arr.length);
            for (String str : arr)
                System.out.println(str);


        } finally {
            if(scan != null)
                scan.close();
        }

    }
}
