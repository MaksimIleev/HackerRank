package String;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonSubstring {

    static String twoStrings(String s1, String s2) {
        char[] strOneChars = s1.toCharArray();
        char[] strTwoChars = s2.toCharArray();

        // Quick sorter
        Arrays.sort(strOneChars);
        Arrays.sort(strTwoChars);

        for(char c: strOneChars) {
            if(Arrays.binarySearch(strTwoChars, c) >= 0)
                return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        if(!(q >= 1 && q <= Math.pow(10, 1)))
            throw new InputMismatchException("Queries number has to be in [1-10]");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {

            String s1 = scanner.nextLine();
            if(!(s1.matches("[a-z]{" + s1.length() + "}")))
                throw new InputMismatchException("str must be in [a-z] format");

            if(!(s1.length() >= 1 && s1.length() <= Math.pow(10, 5)))
                throw new InputMismatchException(" String length should be in s1.length() >= 1 && s1.length() <= Math.pow(10, 5)");

            String s2 = scanner.nextLine();
            if(!s2.matches("[a-z]{" + s2.length() + "}"))
                throw new InputMismatchException("str must be in [a-z] format");

            if(!(s2.length() >= 1 && s2.length() <= Math.pow(10, 5)))
                throw new InputMismatchException(" String length should be in s2.length() >= 1 && s2.length() <= Math.pow(10, 5)");

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
