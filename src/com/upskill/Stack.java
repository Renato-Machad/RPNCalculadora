package com.upskill;

public class Stack {

    private Node top;
    private int size;


    public int getSize(){
        return size;
    }


    public void push(double data){
//        if(top == null)
//            top = new Node(data);
//        else
//        {
//            Node current = new Node(data,top);
//            top = current;
//        }
//        size++;
    }

    public int pull() {
        final int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }
}
