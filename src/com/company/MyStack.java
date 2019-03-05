package com.company;

public interface MyStack {
    public boolean push(Integer data);

    public Integer pop();

    public boolean isFull();

    public boolean isEmpty();

    public Integer top();

    public int size();

    public void clear();
}
