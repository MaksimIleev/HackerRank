package data_structures_algorithms.Stack;

import java.util.Arrays;
import java.util.Scanner;

/*
<ul>
    <li>A string containing only parentheses is balanced if the following is true: </li>
    <li>1. if it is an empty string </li>
    <li>2. if A and B are correct, AB is correct, </li>
    <li>3. if A is correct, (A) and {A} and [A] are also correct.</li>

     <li> Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})" </li>
     <li> Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc. </li>
     <li> Given a string, determine if it is balanced or not. </li>
 </ul>
 */
public class Paranthesis {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input: ");

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            input = input.replaceAll(" ", "");
            System.out.println(new Paranthesis().isBalanced(input)? "true" : "fasle");
        }
    }

    /*
    *  check if input is balanced
    * */
    public boolean isBalanced(String input) {

        int size = input.length();
        Stack stack = new Stack(size);

        char charArr[] = input.toCharArray();
        for(char c: charArr) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);

            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();

            } else if(c == '}') {
                if(stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();

            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();

            } /*else if(c != ' ') {
                return false;
            }*/
        }
        return stack.isEmpty();
    }

   private void checkBalance(String input) {
        if(isBalanced(input))
            System.out.println("" + true);
        else
            System.out.println("" + false);
    }

    /*
    *  Stack class (Last In First Out)
    *
    *   void push(Object o) - adds element on the top of the stack
    *   Object peek() - returns latest object from the top of the stack
    *   Object pop() 0 removes the latest object from the top and returns the next object
    * */
    public class Stack {

        Character arr[];
        int size;
        int topOfTheStack = - 1;
        boolean isDebug = false;

        public Stack(int size) {
            this.size = size;
            arr = new Character[size];
            Arrays.fill(arr, null);
        }

        public void push(Character input) {
            /*
            *  if the stack is not full
            * */
            if((topOfTheStack + 1) < size) {
                 //System.out.println("PUSH: " + input);

                topOfTheStack++;
                arr[topOfTheStack] = input;
            } else {
                //System.out.println("Stack is full");
            }
        }

        public Character pop() {
            if(topOfTheStack >= 0) {

                //System.out.println("POP: " + arr[topOfTheStack]);
                arr[topOfTheStack] = null;
                return arr[topOfTheStack--];

            } else {
                return null;
            }
        }

        public Character peek() {
            return arr[topOfTheStack];
        }

        public boolean isEmpty() {
            return topOfTheStack == -1;
        }

        public void display(){

            for(int n = 0; n < 61; n++)System.out.print("-");

            System.out.println();
            for(int n = 0; n < size; n++){
                System.out.format("| %2s  ", n);
            }

            System.out.println("|");

            for(int n = 0; n < 61; n++)System.out.print("-");

            System.out.println();

            for(int n = 0; n < size; n++){
                if(arr[n] == null) System.out.print("|     ");
                else System.out.print(String.format("| %2s "+ " ", arr[n]));
            }

            System.out.println("|");

            for(int n = 0; n < 61; n++)System.out.print("-");

            System.out.println();

        }

        public void setDebug(boolean isDebug) {
            this.isDebug = isDebug;
        }
    }

}
