package com.upskill;

import java.util.HashMap;
import java.util.Hashtable;

public class RPN {

    public static int evaluate(String expr) {
        int start = 0;
        Stack stack = new Stack();

        if (expr.isEmpty()) return 0;

        do
        {
            int space = expr.substring(start).indexOf(' ');
            int end = space == -1 ? expr.length() : start + space;
            String current = expr.substring(start,end);
            if("+-*/".indexOf(current.charAt(0)) != -1)
            {
                int a = stack.pull();
                int b = stack.pull();
                stack.push(operation(current.charAt(0),b,a));
            }
            else
            {
                stack.push(Integer.parseInt(current));
            }
            start = end + 1;
        }while(start < expr.length());
        int result = stack.pull();

        while(!stack.isEmpty())
        {
            int current = stack.pull();
            result = current > result ? current : result;
        }

        return result;
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
