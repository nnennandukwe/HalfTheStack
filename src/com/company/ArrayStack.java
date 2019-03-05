package com.company;

public class ArrayStack {

    private int top; //integer index of the top, which is the NEXT PLACE that data can be added, not the location of the last piece of data. If you return it directly it will be null.
    private Integer []stack; //the stack
    private static final int STACK_SIZE = 32; //stack size doesnt change

    public ArrayStack(){
        stack = new Integer[STACK_SIZE];
    }

    //return boolean if the push/pop was a success (instead of throwing an error)
    public boolean push(Integer data){
        if(!isFull()){
            stack[top++] = data; //add the data to the top of the stack
            return true; //success!
        }

        return false; //  OVERFLOW no success :*(
    }

    public Integer pop(){
        if(isEmpty()){
            //UNDERFLOW
            return null;
        } else {
            return stack[--top]; //subtract one from top and then return that
        }
    }

    public boolean isFull(){
        return  (top == STACK_SIZE); //returns true if the top is at 32 (last available spot is 31)
    }

    public boolean isEmpty(){
        return(top ==0);
    }

    //this is the same as peeking at the top
    public Integer top(){
        if(!isEmpty()){
            Integer tmp = new Integer(stack[top-1]);
            return tmp;
            // return stack[top-1]; this violates information hiding
        }
        return null;
    }

    public int size(){
        return top;
    }

    public void clear(){
        for (int i = 0; i<top; i++){
            stack[i] = null;
        }

        top = 0;
    }

    public String toString(){
        if(isEmpty()){
            return "<Empty>";
        }
        String rtn = "";

        for(int i=top-1; i>=0; i--){
            if(i == top-1){
                rtn+="top -> " + stack[i] + "\n";
            } else {
                rtn += "   " + stack[i] + "\n";
            }
        }

        return rtn;
    }
}
