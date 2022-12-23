package com.practice.queuestack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> parenthesisStack = new Stack<>();
        char[] parenthesisArr = s.toCharArray();

        for(int i = 0;i < parenthesisArr.length;i++){
            if(!parenthesisStack.isEmpty()){
                if((parenthesisStack.peek() == '(' && parenthesisArr[i] == ')')
                  || (parenthesisStack.peek() == '{' && parenthesisArr[i] == '}')
                  || (parenthesisStack.peek() == '[' && parenthesisArr[i] == ']')){
                    parenthesisStack.pop();
                    continue;
                }
            }
            parenthesisStack.push(parenthesisArr[i]);
        }

        return parenthesisStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("is valid parenthesis "+isValid("()[]{}"));
    }
}
