package com.upskill;

public class Node {

    private double data;
    private Node next;

    public Node(double data) {
        this.data = data;
    }

    public Node(double data, Node next) {
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
