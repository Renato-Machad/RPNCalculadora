package com.upskill;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String expression = null;

        System.out.println("---RPN Calculator---\n");
        System.out.println("Type 'Exit' at any time to quit.\n");


        Scanner read = new Scanner(System.in);

        while(expression != "Exit") {
            System.out.println("Type the expression:");
            expression = read.nextLine();
            try{
                System.out.println(RPN.evaluate(expression));
            } catch(Exception e)
            {
                System.out.println("Invalid Expression. Try again or type 'Exit' to quit.");
            }
        }
    }
}
