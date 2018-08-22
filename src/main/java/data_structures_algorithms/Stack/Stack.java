package data_structures_algorithms.Stack;

import java.util.Arrays;

/*
*  The Stack allows access last item added to the stack (LIFO)
* */
public class Stack {

    private String[] stackArray;
    private int stackSize;
    private int topOfTheStack = -1;

    public Stack(int size) {
        stackSize = size;
        stackArray = new String[stackSize];

        Arrays.fill(stackArray, "");
    }

    public void push(String input) {
        if(topOfTheStack + 1 < stackSize) {
            topOfTheStack++;
            stackArray[topOfTheStack] = input;
            System.out.println("PUSH: " + input);
        } else {
            System.out.println("data_structures_algorithms.Stack.Stack is full!");
        }
    }

    public String pop() {
        if(topOfTheStack >= 0) {

            System.out.println("POP: " + stackArray[topOfTheStack] + " was removed...");
            stackArray[topOfTheStack] = "";

            return stackArray[topOfTheStack--];

        } else {
            System.out.println("data_structures_algorithms.Stack.Stack is empty");
            return "";
        }
    }

    public String peek() {
        System.out.println("PEEK: "  + stackArray[topOfTheStack] + " is the top of the stack");
        return stackArray[topOfTheStack];
    }

    public void displayTheStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s  ", n);
        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            if(stackArray[n].equals("")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

    public static void main(String args[]) {
      Stack stack = new Stack(20);
      stack.push("10");
      stack.displayTheStack();
      stack.push("11");
      stack.displayTheStack();
      stack.push("12");
      stack.displayTheStack();
      stack.pop();
      stack.displayTheStack();
      stack.peek();
      stack.displayTheStack();
    }
}
