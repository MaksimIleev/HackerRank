package Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeString {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            String res;
            String _a;
            try {
                _a = in.nextLine();
            } catch (Exception e) {
                _a = null;
            }

            String _b;
            try {
                _b = in.nextLine();
            } catch (Exception e) {
                _b = null;
            }

            res = mergeStrings(_a, _b);
            bw.write(res);
            bw.newLine();

        } finally {
            if(bw != null)
                bw.close();
        }

    }

    static String mergeStrings(String a, String b) {
        if(a == null && b == null)
            return null;

        char mergeArr[] = null;

        if(a == null)
            mergeArr = new char[b.length()];

        else if(b == null)
            mergeArr = new char[a.length()];

        else
            mergeArr = new char[a.length() + b.length()];

        int focusIdx = 0;
        for(int i = 0; i < mergeArr.length - 1; i++) {
            if(i > focusIdx)
                focusIdx = i;
            try {
               char aChar = a.charAt(i);
               mergeArr[focusIdx] = aChar;
                focusIdx++;
            } catch(IndexOutOfBoundsException ex) {
               // skip
            }
            try {
                char bChar = b.charAt(i);
                mergeArr[focusIdx++] = bChar;
            } catch(IndexOutOfBoundsException ex2) {
               // skip
            }
        }
        String out = "";
        for(char c: mergeArr)
           out += c + "";

        System.out.println(out);

        return out;
    }

}
