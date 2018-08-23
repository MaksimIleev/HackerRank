package String;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingString {

    static int alternatingCharacters(String s) {
        int count = 0;
        char currentChar = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == currentChar) {
                count++;
            } else
                currentChar = s.charAt(i);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getProperty("user.dir") + "/src/main/java/String/output"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = null;
            try {
                s = scanner.nextLine();
            } catch(Exception e) {
                e.printStackTrace();
                break;
            }

            int result = 0;
             try {
                 alternatingCharacters(s);
             } catch (Exception e) {
                 e.printStackTrace();
                 System.exit(-1);
             }

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
