package com.upskill;

public class Stack {

    private Node top;
    private int size;


    public int getSize(){
        return size;
    }


    public void push(int data){
        if(top == null) // stack nao tem nada
            top = new Node(data);
        else
        {
            Node numb = new Node(data,top);
            top = numb;
        }
        size++;
    }
}
