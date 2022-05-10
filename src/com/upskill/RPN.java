package com.upskill;

import java.util.HashMap;
import java.util.Hashtable;

public class RPN {

<<<<<<< HEAD
    public static int operation(char operand,int a, int b){
        HashMap<Character,Integer> operation = new HashMap<Character,Integer>();
        operation.put('+',a + b);
        operation.put('-',a - b);
        operation.put('*',a * b);
        operation.put('/',a / b);
=======


    public static void operation(char operand,double a, double b){
        Stack stack = new stack;
>>>>>>> bfdf6780785e4f50f648363da7002ef183a620cc

        return operation.get(operand);
    }

}
