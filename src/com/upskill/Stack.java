package com.upskill;

public class Stack {

    private static Node top;
    private int size;

    public int getSize() {
        return size;
    }

    public Node getTop() {
        return top;
    }

    public void push(int data) {
        if (top == null) // stack nao tem nada
            top = new Node(data);
        else {
            Node current = new Node(data, top);
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

    public void convertIntoNegative(int lastInput) {
        pull();
        int negative = lastInput * (-1);
        lastInput = negative;
        push(lastInput);
    }

    public boolean isEmpty() {
        return true;
    }

    // este metodo apaga os registos anteriores ao percorre-los
    public static String listNodes() {
        StringBuilder result = new StringBuilder();
        if (top != null) {
            Node current = top;
            while (current.getNext() != null) {
                result.append(current.getData());
                if (current.getNext() != null) {
                    result.append(", ");
                }
                current = current.getNext();
            }
            return "List: " + result;
        } else
            return "A lista está vazia";
    }

    @Override
    public String toString() {
        return top.toString();
    }
}
