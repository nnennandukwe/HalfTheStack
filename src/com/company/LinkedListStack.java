package com.company;

public class LinkedListStack implements MyStack {

    Node head = null;
    int count = 0;

    /**
     * implementing push() from MyStack interface
     * @param data
     * @return boolean value of whether push was successful or not
     */
    @Override
    public boolean push(String data){
        Node n = new Node();
        n.setData(data);

        // set the head Node as first node for loop
        Node tmp = head;

        // handle the case that the head node is not set yet
        if (tmp == null){
            // set the head node with the newly created node
            this.setHead(n.getData());
            return true;
        }

        while (tmp != null){
            // if the current node is the tail node
            if (tmp.getNext() == null){
                // set the tail as the new node
                tmp.setNext(n);
                n.setNext(null);
            }
            tmp = tmp.getNext();
        }
        // increase the overall count of nodes
        count++;
        return true;
    }

    /**
     * @return String of the node data that was removed from the stack
     */
    @Override
    public String pop(){
        // an empty stack cannot have anything removed from it
        if(isEmpty()){
            // represents underflow
            // warn user about stack underflow
            System.out.println("ERROR!!!");
            System.out.println(">>> STACK UNDERFLOW!!!");
            System.out.println("YOU HAVE ATTEMPTED TO REMOVE AN ELEMENT FROM AN EMPTY STACK");
            return null;
        } else {
            // if there are nodes in the linkedlist,
            // set the temporary node data at the beginning of the
            // linkedlist (head)
            String tmp = head.getData();
            // set the new head node to be the next node
            head = head.getNext();
            // decrement the count of the nodes by 1 to represent
            // the loss of the previous head node
            count--;
            return tmp; // return the data of that removed node
        }
    }

    /**
     * @return boolean value of whether or not the linkedlist is full
     */
    @Override
    public boolean isFull(){
        return false;
    }

    /**
     * Checks if there are 0 nodes in linkedlist
     * @return boolean value of whether or not the linkedlist is empty
     */
    @Override
    public boolean isEmpty(){
        return (count == 0); // returns true if count is zero
    }

    /**
     * @return String that represents the data of the top node in linkedlist
     */
    @Override
    public String top() {
        if(isEmpty()) {
            // Inform user that the linkedlist is empty, therefore no
            // top data exists
            System.out.println("ERROR!!!");
            System.out.println(">>> CANNOT RETURN TOP OF AN EMPTY STACK!!!!");
            return null;
        } else {
            // provide head node data
            return head.getData();
        }
    }

    /**
     * @return int that represents number of nodes existing in linkedlist
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * method for resetting entire linkedlist to ZERO
     */
    @Override
    public void clear() {
        head = null;
        count = 0;
    }

    /**
     * setHead allows for the head node to be manually
     * set with data from the param and set the next Node
     * connected to it be defaulted to null
     * @param data
     */
    public void setHead(String data){
        head = new Node(); // create new node to be head
        head.setData(data); // set head node with input data
        // set next node to be null, indicating this node is
        // both the head and the tail of the linkedlist by the
        // end of this method
        head.setNext(null);
        count++; // record the fact a new node has been added to linkedlist
    }

    /**
     * HELPER METHOD: converts the entire stack linkedlist to a
     * string output that is readable to user when printed
     * @return String
     */
    public String toString(){
        if(isEmpty()){
            return "<Empty>";
        }
        String rtn = "";
        Node tmp = head;

        if (tmp != null) {
            rtn += "top -> " + tmp.getData() + "\n";
            tmp = tmp.getNext();

            while ( tmp != null ){
                rtn += "   " + tmp.getData() + "\n";
                tmp = tmp.getNext();
            }
        } else {
            return "<Empty>";
        }
        return rtn;
    }

    /**
     * FUNCTIONALITY METHOD: allows for an array of inputs
     * to be added, iteratively, to the stack linkedlist by
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
            System.out.println(">>> YOU HAVE " + this.size() + " MORE LEFT PARENTHESES THAN ANTICIPATED!!!!");
        }
        else {
            System.out.println("SUCCESS!!! :)");
            System.out.println("EVERYTHING LOOKS BALANCED!!!");
        }
    }

}