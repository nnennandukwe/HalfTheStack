package com.company;

public class Node {
    private String data;
    private Node next;

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }
}
