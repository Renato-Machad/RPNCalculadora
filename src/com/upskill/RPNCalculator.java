package com.upskill;

import java.util.Scanner;

public class RPNCalculator {

    public static void main(String[] args) {
        int value = 0;

        System.out.println("---RPN Calculator---\n");
        System.out.println("Type the expression:");

        Scanner read = new Scanner(System.in);

        while (value != 4) {
            value = read.nextInt();
            System.out.println(RPN.evaluate(String.valueOf(value)));
            try {
                System.out.println(RPN.evaluate(String.valueOf(value)));
            } catch (Exception e) {
                System.out.println("Invalid expression. Try again or type 4 to quit.");
            }
        }

        /*do {
            switch (value = RPNCalculator.reader()) {
                case 1:
                    //double result =
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    System.out.println("Invalid expression.");
                    break;
            }
        } while (value != 4);

         */
    }

    public static int reader() {
        Scanner read = new Scanner(System.in);
        int option = 0;
        System.out.println("Choose from the following: \n" +
                "1 - Add an element to the stack \n" +
                "2 - Remove the first element from the stack \n" +
                "3 - List the content of the stack \n" +
                "4 - Replace the first two elements of the stack by their sum \n" +
                "5 - Replace the first two elements of the stack by their multiplication \n" +
                "6 - Replace the first element of the stack by its negative \n" +
                "4 - Quit");
        return option = read.nextInt();
    }
}


