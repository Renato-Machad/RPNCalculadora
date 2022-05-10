package com.upskill;

import java.util.HashMap;
import java.util.Hashtable;

public class RPN {

    public static double evaluate(String expr) {
        return 0;
    }


    public static int operation(char operand, int a, int b) {

        int x = 0;

        switch (operand) {
            case '+':
                x = a + b;
                break;
            case '-':
                x = a - b;
                break;
            case '*':
                x = a * b;
                break;
            case '/':
                x = a / b;
                break;
        }

        return x;
       /* HashMap<Character,Integer> operation = new HashMap<Character,Integer>();
        operation.put('+',a + b);
        operation.put('-',a - b);
        operation.put('*',a * b);
        operation.put('/',a / b);

        return operation.get(operand);
               */
    }

}
