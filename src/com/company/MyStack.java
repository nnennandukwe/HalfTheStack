package com.company;

public interface MyStack {
    public boolean push(String data);

    public String pop();

    public boolean isFull();

    public boolean isEmpty();

    public String top();

    public int size();

    public void clear();
}
