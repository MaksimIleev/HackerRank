package RegEx;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {
        /*
        *  '(\b\w+\b)'- group exact word
        *  '(\b\s+\1\b)' - backreference to group with space(s)
        *  '+' - one or more occurences
        * */
        String regex = "(\\b\\w+\\b)(\\b\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        if(numSentences < 1 || numSentences > 100)
            throw new InputMismatchException("Number of sentences should be greater then 1 and less then 100");

        while (numSentences-- > 0) {
            String input = in.nextLine();
            if(input.length() > Math.pow(10, 4) || !(input.matches("[a-zA-Z\\s]+")))
                throw new InputMismatchException("Input should consist of letters and spaces and max length of 10000 chars");

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input.trim());
        }

        in.close();
    }
}
