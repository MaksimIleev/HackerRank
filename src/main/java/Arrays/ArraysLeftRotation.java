package Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysLeftRotation {
    /*
    *  [1,2,3,4,5] -> [2,3,4,5,1] and so on
    * */
    static int[] rotLeft(int[] a, int d) {
         for(int i = 0; i < d; i++) {
             // save first value
             int tmp = a[0];
             // shift al values to the left
             for(int j = 0; j < a.length - 1; j++) {
                 a[j] = a[j + 1];
             }
             // replace last one with saved tmp
             a[a.length -1] = tmp;
         }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0].trim());
        if(!(n >= 1 && n <= Math.pow(10, 5)))
            throw new InputMismatchException("Array size has to be in n >= 1 && n <= Math.pow(10, 5)");

        int d = Integer.parseInt(nd[1].trim());
        if(!(d >= 1 && d <= n))
            throw new InputMismatchException("Number to shift has to be in d >= 1 && d <= array.length");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().replaceAll("\\s+", " ").split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            if(!(aItem >= 1 && aItem <= Math.pow(10, 6)))
                throw new InputMismatchException("Integer hast to be in aItem >= 1 && aItem <= Math.pow(10, 6)");

            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

