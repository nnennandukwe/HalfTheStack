package com.company;

public class Main {

    public static void main(String[] args) {

        /**
         * HALF THE STACK:
         * A program for building array stacks and linkedlist stacks.
         * Test banks are provided in the program to exercise the different
         * functionality methods available for each type of stack, including:
         * push, pop, clear, adding to the stack, and more.
         */

        Main me = new Main();
        me.doIt();
    }

    public void doIt(){

        // initialize new ArrayStack, which sets its default object variables
        ArrayStack arrayStack = new ArrayStack();

        // an array of strings shows there are random left and right parenthesis
        // embedded into each string
        String[] testBank = {
            "(guyg()080ik)",
            "((hhhhh(()9u0u)",
            "())jiojojj)",
            "()()()(g)",
            "()()()((3w4sd67g8huioj()())(((((()",
        };

        // a testing string containing left and right parentheses
        String unbalancedTestWord = "()()()((3w4sd67g8huioj()())(((((()";
        String balancedString = "(((())))";

        // introduction print statement
        System.out.println("HELLO, WELCOME TO 'HALF THE STACK' \n\n");

        // call methods to produce output from the array stack
        arrayStack.add(testBank);
        arrayStack.clear();
        System.out.println("UNBALANCED EXAMPLE: " + unbalancedTestWord);
        arrayStack.add(unbalancedTestWord);
        arrayStack.check();
        arrayStack.clear();

        System.out.println("BALANCED EXAMPLE: " + balancedString);
        arrayStack.add(balancedString);
        // print out entire stack
        System.out.printf("ARRAY STACK \n%s%n", arrayStack.toString());
        arrayStack.check();

        // call methods to produce output from the linkedlist stack
        LinkedListStack linkedListStack = new LinkedListStack();

        linkedListStack.add(testBank);
        linkedListStack.check();
        linkedListStack.clear();

        System.out.println("UNBALANCED LNIKEDLIST EXAMPLE " + unbalancedTestWord);
        linkedListStack.add(unbalancedTestWord);
        System.out.printf("LINKED LIST STACK \n %s%n", linkedListStack.toString());
        linkedListStack.check();
        linkedListStack.clear();

        System.out.println("BALANCED LINKEDLIST STRING EXAMPLE: " + balancedString);
        linkedListStack.add(balancedString);
        linkedListStack.check();
        linkedListStack.clear();

    }

}
