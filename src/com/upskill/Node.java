package com.upskill;

public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public double getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

}
