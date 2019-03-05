package com.company;

public class ArrayStack implements MyStack{

    private int top; // integer index of the top
    private String[] stack; // the stack
    private static final int STACK_SIZE = 32; // stack size is a CONSTANT

    // CONSTRUCTOR
    public ArrayStack(){
        stack = new String[STACK_SIZE];
    }

    /**
     * ACCESSOR METHOD
     * @return stack
     */
    public String[] getStack(){
        return stack;
    }

    /**
     * FUNCTIONALITY METHOD: push on top of stack
     * @param data
     * @return boolean
     */
    public boolean push(String data){
        // return boolean if the push/pop was a success
        if(!isFull()){
            // if the stack is not full,
            // add the data to the top of the stack
            stack[top++] = data;
            return true;
        }
        // if the stack is full, return false
        // and inform user of stack overflow
        System.out.println("ERROR!!!");
        System.out.println(">>> YOU HAVE EXCEEDED STACK SIZE!!!!");
        return false;
    }

    /**
     * FUNCTIONALITY METHOD: take the first element off of the stack
     * and return that value
     * @return
     */
    public String pop(){
        if(isEmpty()){
            // represents underflow
            // warn user about stack underflow
            System.out.println("ERROR!!!");
            System.out.println(">>> STACK UNDERFLOW!!!");
            System.out.println("YOU HAVE ATTEMPTED TO REMOVE AN ELEMENT FROM AN EMPTY STACK");
            return null;
        } else {
            // subtract one from top and then return that
            return stack[--top];
        }
    }

    /**
     * Provides user with information about whether the stack array
     * has filled all of its slots with data/an element or not
     * @return boolean
     */
    public boolean isFull(){
        // returns true if the top is at 32 (last available spot is 31)
        return  (top == STACK_SIZE);
    }

    /**
     * Provides user with information about whether or not
     * the stack array has any elements in the 32 placeholders
     * @return boolean
     */
    public boolean isEmpty(){
        // stack is empty if the top stack as an index of 0
        return(top == 0);
    }

    /**
     * Returns the string value of the element at the top
     * of the stack
     * @return String
     */
    public String top(){
        if(!isEmpty()){
            return stack[top - 1];
        }
        return null;
    }

    /**
     * Returns the size (length) of the stack array
     * @return int
     */
    public int size(){
        return top;
    }

    /**
     * FUNCTIONALITY METHOD: deletes all elements in the stack
     * by reseting the top of the stack at index 0
     */
    public void clear(){
        for (int i = 0; i<top; i++){
            stack[i] = null;
        }

        top = 0;
    }

    /**
     * HELPER METHOD: converts the entire stack array to a
     * string output that is readable to user when printed
     * @return String
     */
    public String toString(){
        if(isEmpty()){
            return "<Empty>";
        }
        String rtn = "";

        for(int i = top-1; i >= 0; i--){
            if ( i == top-1 ){
                rtn+="top -> " + stack[i] + "\n";
            } else {
                rtn += "   " + stack[i] + "\n";
            }
        }

        return rtn;
    }

    /**
     * FUNCTIONALITY METHOD: allows for an array of inputs
     * to be added, iteratively, to the stack array by
     * converting each string into an array of characters that
     * are compared to the left and right parenthesis characters
     * prior to decisions about adding character to the stack with
     * the push() method or removing from the stack with the pop() method
     * @param inputArray
     */
    public void add(String[] inputArray){

        // set up characters that will be checked for in the
        // conditionals in the looping processes
        // left parenthesis represents the opportunity to push to the
        // stack. a right parenthesis found in a string is the signal
        // to pop from the stack.
        char leftP = '(';
        char rightP = ')';

        try {
            // loop through array of string inputs
            for (int i = 0; i < inputArray.length; i++) {
                // convert each string element from array into
                // an array of characters
                // e.g arr[0] = "hello" -> {'h','e','l','l','o'}
                char[] inputCharArray = inputArray[i].toCharArray();
                // loop through each character in char array
                for (char c : inputCharArray) {
                    // if a left parenthesis character is found in
                    // the char array...
                    if (c == leftP) {
                        // convert to a string
                        String charToString = String.valueOf(c);
                        // push to the stack as a string
                        this.push(charToString);
                        // if the right parenthesis char is found in
                        // the char array...
                    } else if (c == rightP) {
                        // remove the top element from the stack
                        // and return that removed element
                        this.pop();
                    }
                }
            }
        } catch (Exception e){
            // if any extraneous errors are produced during this process,
            // print it out for the user here
            System.out.print(e.getMessage());
        }
    }

    /**
     * FUNCTIONALITY METHOD: Add a left parenthesis to the stack or
     * remove a parenthesis from the stack
     * by iterating through each character in one string input
     * and checking for the value of the character in the string
     * @param inputString
     */
    public void add(String inputString){

        // set up characters that will be checked for in the
        // conditionals in the looping processes
        // left parenthesis represents the opportunity to push to the
        // stack. a right parenthesis found in a string is the signal
        // to pop from the stack.
        char leftP = '(';
        char rightP = ')';

        // loop through each character in string input
        for (int i = 0; i < inputString.length(); i++){
            // check if each char happens to be a left parenthesis
            if (inputString.charAt(i) == leftP){
                // if so, convert to string and push to stack
                this.push(String.valueOf(leftP));
            }
            // check for a right parenthesis and if so, pop left
            // parenthesis from stack
            else if (inputString.charAt(i) == rightP){
                this.pop();
            }
        }
    }

    /**
     * METHOD for determining whether there are too many left
     * parentheses in the stack with an unmatched right parenthesis
     * or not
     */
    public void check(){

        // check if the stack has a size of 0
        if (this.size() > 0){
            // if the stack has a size that is greater than 0,
            // then there are extra left parenthesis with no right
            // parenthesis match! print out to user the number of
            // excessive left parentheses!
            System.out.println(">>> UNBALANCED STACK!!!!");
            System.out.printf(">>> YOU HAVE %d MORE LEFT PARENTHESES THAN ANTICIPATED!!!!%n", this.size());
        }
        else {
            System.out.println("SUCCESS!!! :)");
            System.out.println("EVERYTHING LOOKS BALANCED!!!");
        }
    }
}
