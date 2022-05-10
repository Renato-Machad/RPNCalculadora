package com.upskill;

import java.util.HashMap;
import java.util.Hashtable;

public class RPN {

    public static double evaluate(String expr) {
        int start = 0;
        Stack stack = new Stack();

        if (expr.isEmpty()) return 0;

        do
        {
            int space = expr.substring(start).indexOf(' ');
            int end = space == -1 ? expr.length() : start + space;
            String current = expr.substring(start,end);//current number or operator
            if("+-*/".indexOf(current.charAt(0)) != -1)//check if current is operator
            {//pop 2 and apply operation
                int a = stack.pull();
                int b = stack.pull();
                stack.push(operation(current.charAt(0),b,a));
            }
            else
            {
                stack.push(Integer.parseInt(current));
            }
            start = end + 1;//start over at index after the space
        }while(start < expr.length());
        double result = stack.pull();

        while(!stack.isEmpty())//stack non-empty -> return greatest val
        {
            double current = stack.pull();
            result = current > result ? current : result;
        }

        return result;
    }


    public static int operation(char operand,int a, int b){
        HashMap<Character,Integer> operation = new HashMap<Character,Integer>();
        operation.put('+',a + b);
        operation.put('-',a - b);
        operation.put('*',a * b);
        operation.put('/',a / b);

        return operation.get(operand);
    }

}
