package data_structures_algorithms.Set;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class CountDupes {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numbersCount = scanner.nextInt();
        if(numbersCount < 1 || numbersCount > 1000)
            throw new InputMismatchException("Number Count is wrong");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] numbers = new int[numbersCount];

        for (int i = 0; i < numbersCount; i++) {

            int numbersItem = scanner.nextInt();
            if(numbersItem < 1 || numbersItem > 1000 || i < 0 || i > numbersCount)
                throw new InputMismatchException("Number Count is wrong");

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            numbers[i] = numbersItem;
        }

        int res = countDuplicates(numbers);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int countDuplicates(int[] numbers) {

        if(numbers.length < 1 || numbers.length > 1000)
            throw new InputMismatchException("Number Count is wrong");

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {

            if((numbers[i] < 1 || numbers[i] > 1000) && (i < 0 || i > numbers.length))
                throw new InputMismatchException("Number Count is wrong");

            if(set.contains(numbers[i])) {
                count++;
            }
            set.add(numbers[i]);
        }
        return count;
    }

}
