package data_structures_algorithms.LinkList;

import java.util.LinkedList;
import java.util.Scanner;

public class ListPractice {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        try {
            //System.out.println("Number of values:");
            int numberOfValues = scanner.nextInt();

            if(numberOfValues < 1 && numberOfValues > 4000)
                throw new RuntimeException("N must be >= 1 && <= 4000");

            //System.out.println("Values:");
            scanner.nextLine();
            String values[] = scanValues();

            for(int i = 0; i < values.length; i++) {
                list.add(Integer.valueOf(values[i]));
            }

            //System.out.println("Number of queries:");
            int queriesNumber = scanner.nextInt();

            if(queriesNumber < 1 && queriesNumber > 4000)
                throw new RuntimeException("Q must be 1 <= && <= 4000");

            for(int i = 0; i < queriesNumber; i++) {

                //System.out.println("Insert or Delete?: ");
                String action = scanner.next();

                if(action.equalsIgnoreCase("Insert")) {
                    //System.out.println("index & value:");
                    int index = scanner.nextInt();
                    int value = scanner.nextInt();
                    list.add(index, value);

                } else if(action.equalsIgnoreCase("Delete")) {
                    //System.out.println("index:");
                    int index = scanner.nextInt();
                    list.remove(index);
                }

            }

            for(int i = 0; i < list.size(); i++) {
                try {
                    list.get(i + 1);
                    System.out.print(list.get(i) + " ");
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print(list.get(i));
                }
            }

        } finally {
            scanner.close();
        }

    }

    static String[] scanValues() {
        String valuesInput = scanner.nextLine();

        valuesInput = valuesInput.replaceAll(" +", " ");
        return valuesInput.split(" ");
    }

}
