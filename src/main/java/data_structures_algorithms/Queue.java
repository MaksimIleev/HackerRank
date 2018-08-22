package data_structures_algorithms;

import java.util.Arrays;

public class Queue {

    private String[] queueArray;
    private int queueSize;
    private int first, last = 0;
    private int numberOfItems = 0;

    public Queue(int size) {
        queueSize = size;
        queueArray = new String[queueSize];
        Arrays.fill(queueArray, "");
    }

    public void insert(String input) {
        if(numberOfItems + 1 <= queueSize) {
            queueArray[last] = input;
            last++;
            numberOfItems++;
            System.out.println("INSERT " + input);
        } else {
            System.out.println("Queue is full!");
        }
    }

    public void priorityInsert(String input) {
        int i;
        if(numberOfItems == 0)
            insert(input);
        else{
            for(i = numberOfItems - 1; i >= 0; i--) {
                if(Integer.parseInt(input) > Integer.parseInt(queueArray[i]))
                    queueArray[i + 1] = queueArray[i];
                else break;
            }

            queueArray[i + 1] = input;
            last++;
            numberOfItems++;
        }
    }

    public void remove() {
        if(numberOfItems > 0) {
            System.out.println("REMOVE " + queueArray[first]);
            queueArray[first] = "";
            first++;
            numberOfItems--;
        }
    }

    public void peek() {
        System.out.println("PEEK " + queueArray[first]);
    }

    public void displayTheQueue() {

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){

            System.out.format("| %2s  ", n);
        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){

            if(queueArray[n].equals("")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
        }
        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();
    }

    public static void main(String args[]) {
        Queue queue = new Queue(10);
        queue.priorityInsert("3");
        queue.priorityInsert("2");
        queue.priorityInsert("1");
        queue.displayTheQueue();
        queue.remove();
        queue.displayTheQueue();
    }


}
