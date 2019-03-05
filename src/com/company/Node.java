package com.company;

public class Node {
    private Integer data;
    private Node next;

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public void setData(Integer data){
        this.data = data;
    }

    public Integer getData(){
        return this.data;
    }
}
