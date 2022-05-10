package com.upskill.Tests;

import com.upskill.Node;
import com.upskill.Stack;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @org.junit.Test
    public void listagemVazia() {
        //arrange
        //int data = 3;
        //Node previousTop = new Node(3);
        //Node top = new Node(5,previousTop);

        //act
        String resultado = Stack.listNodes();

        //assert
        assertEquals(resultado, "A lista está vazia");
    }
}
