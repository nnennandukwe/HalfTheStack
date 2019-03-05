package com.company;

public class LinkedListStack implements MyStack {
    //Vic built this with "extract interface" from Eclipse
    // Vic also changed all the integers of data to Doubles to make RPNCalc a better calculator. I didn't do that here.

    Node head = null;
    int count = 0;

    @Override
    public boolean push(Integer data){
        Node n = new Node();
        n.setData(data);
        n.setNext(head);
        head = n;
        count++; //increase the count
        return true;
    }

    @Override
    public Integer pop(){
        if(isEmpty()){
            return null;
        } else {
            Integer tmp = head.getData();
            head = head.getNext();
            count--; //decrement the count
            return tmp;
        }
    }

    @Override
    public boolean isFull(){
        return false;
    }

    @Override
    public boolean isEmpty(){
        return (count ==0); //returns true if count is zero
    }

    @Override
    public Integer top() {
        if(isEmpty()) {
            return null;
        } else {
            Integer n = new Integer(head.getData()); //new int as copy of head
            return n;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        head = null;
        count = 0;
    }

    //dont need to add this to an interface file because we're using the default one from Object
    public String toString(){
        if(isEmpty()){
            return "<Empty>";
        }
        String rtn = "";
        Node tmp = head;

        for(int i=0; i>=0; i--){
            if(i == 0){
                rtn+="top -> " + tmp.getData() + "\n";
            } else {
                rtn += "   " + tmp.getData() + "\n";
            }
            tmp = tmp.getNext();
        }

        return rtn;
    }

}