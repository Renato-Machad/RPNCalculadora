package com.upskill;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String value = "";

        System.out.println("---RPN Calculator---\n");
        System.out.println("Type a value:");

        //Adicionar valores à stack
        do {
            Scanner read = new Scanner(System.in);
            value = read.nextLine();

            stack.push(Integer.parseInt(value));

            System.out.println("Add another value Y/N?");
            value = read.nextLine();
        } while (value.equalsIgnoreCase("y"));
        System.out.println(stack);
        System.out.println(stack);

        //Escolher uma opção
        int option = 0;
        Scanner read = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("2 - Como utilizador quero remover o primeiro elemento da pilha da calculadora" + "\n" +
                "3 - Como utilizador quero listar o conteúdo da pilha" + "\n" +
                "10 - Como utilizador quero substituir os dois primeiros elementos da pilha pela sua soma" + "\n" +
                "11 - Como utilizador quero substituir os dois primeiros elementos da pilha pela sua multiplicação" + "\n" +
                "14 - Convert first element into negative");
        option = read.nextInt();

        //US14 Como utilizador quero substituir o primeiro elemento da pilha pelo seu negativo
        if (option == 14) {
            stack.convertIntoNegative(stack.getTop().getData());
            System.out.println(stack);
        }
        if (option == 3) {
            System.out.println(Stack.listNodes());
        }
    }
}
