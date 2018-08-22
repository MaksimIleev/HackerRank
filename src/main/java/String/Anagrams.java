package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    public boolean isAnagram(String one, String two) {

        if(one == null || two == null || one.length() != two.length())
            return false;

        validate(one);
        validate(two);

       Map<String, Integer> frequencyMapOne = new HashMap<String, Integer>();
       Map<String, Integer> frequencyMapTwo = new HashMap<String, Integer>();

       int count = 1;
       for(char c: one.toCharArray()) {

           String letter = (c + "").toLowerCase();
           Integer apperences = frequencyMapOne.get(letter);

           if(apperences != null) {
               frequencyMapOne.put(letter, ++apperences);

           } else
           frequencyMapOne.put((c + "").toLowerCase(), count);
       }

       count = 1;
        for(char c: two.toCharArray()) {
            String letter = (c + "").toLowerCase();
            Integer apperences = frequencyMapTwo.get(letter);

            if(apperences != null) {
                frequencyMapTwo.put(letter, ++apperences);

            } else
            frequencyMapTwo.put((c + "").toLowerCase(), count);
        }

        for(java.util.Map.Entry<String, Integer> entry: frequencyMapOne.entrySet()) {
            int frequency = entry.getValue();
            String letter = entry.getKey();

            if(frequencyMapTwo.get(letter) == null || frequency != frequencyMapTwo.get(letter))
                return false;
        }

        return true;
    }

    private void validate(String input) {
        if(!(input != null && input.length() >= 1 && input.length() <= 50)) {
            throw new RuntimeException("Input shold be in range of n >=1 && n <= 50");
        }

        if(!(input.matches("^[a-zA-Z0-9.]+$")))
        throw new RuntimeException("Only English letters can be used");
    }


    public static void main(String args[]) {

        Anagrams anagrams = new Anagrams();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter first word: ");
            String wordOne = scanner.next();
            anagrams.validate(wordOne);

            System.out.println("Enter second word: ");
            String wordTwo = scanner.next();
            anagrams.validate(wordTwo);

            System.out.println(anagrams.isAnagram(wordOne, wordTwo) ? "Anagrams": "Not Anagrams");

        } finally {
            if(scanner != null)
                scanner.close();
        }
    }
}
