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
            Node current = new Node(data,top);
            top = current;
        }
        size++;
    }

//    public void push (Node novo){
//        novo.setNext(top);
//        top = novo;
//    }

    public int pull() {
        final int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public boolean isEmpty() {
        return true;
    }
}
