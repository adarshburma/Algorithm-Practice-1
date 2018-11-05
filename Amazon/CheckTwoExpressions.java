package org.practice.courses.courseapi;

import org.hibernate.dialect.SybaseAnywhereDialect;

import java.util.Stack;

/*
 Check if two expressions with brackets are same
4
Given two expressions in the form of strings. The task is to compare them and check if they are similar. Expressions consist of lowercase alphabets, ‘+’, ‘-‘ and ‘( )’.

Examples:

Input  : exp1 = "-(a+b+c)"
         exp2 = "-a-b-c"
Output : Yes

Input  : exp1 = "-(c+b+a)"
         exp2 = "-c-b-a"
Output : Yes

Input  : exp1 = "a-b-(c-d)"
         exp2 = "a-b-c-d"
Output : No
It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.
 */


public class CheckTwoExpressions {

    static void checkExpressions(String input, String output){
        if(input.equals(output)){
           System.out.println("YES");
           return;
        }
        System.out.println("NO");
    }

    static String decodeExpression(String str){
        if(str == null){
            return null;
        }

        Stack<Character> sign = new Stack<>();
        String expressionOutput = "";
        char[] arr = str.toCharArray();
        boolean inBracket = false;
        for(int i = 0 ; i < arr.length; i++){
            char c = arr[i];
            if(c == '+' || c == '-') {
                if(sign.size() == 0){
                    sign.push(c);
                } else {
                    char lastSign = sign.peek();
                    sign.push(arr[i] == '-' ? '+' : '-');
                }
            } else if( arr[i] == '('){
                inBracket = true;
            } else if(arr[i] == ')'){
                inBracket = false;
                sign.pop();
            }
            else if( arr[i] > 96 && arr[i] < 104){
                char signs  = ' ';
                if(inBracket && sign.size()  == 1){
                    signs = sign.peek();
                } else if(sign.size() > 0){
                    signs = sign.pop();
                }
               expressionOutput = expressionOutput + ' ' + signs + ' ' +  arr[i];
            }
        }
        return expressionOutput.replace(" ", "");
    }

    static String decodeExpression2(String str) {
        if(str == null){
            return null;
        }
        boolean inBrackets = false;
        String expression = "";
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == '+' || arr[i] == '-'){
                if(stack.size() == 0 ){
                    stack.push(arr[i]);
                } else {
                    char lastSign = stack.peek();
                    stack.push(arr[i] == '-' ? '+' : '-');
                }
            } else if(arr[i] == '('){
                inBrackets = true;
            } else if(arr[i] == ')'){
                inBrackets = false;
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else if(arr[i] > 96 && arr[i] < 104){
                char sign = ' ';
                if(inBrackets && stack.size() == 1){
                    sign = stack.peek();
                } else if(stack.size() > 0){
                    sign = stack.pop();
                }
                expression = expression + ' ' + sign + ' ' + arr[i];
            }
        }
        return expression.replace(" ", "" );
    }

    public static void main(String[] args){
        String input = "-(c+b)-(d-e-f))";
        String output = "-c-b-d+e+f";
        System.out.println(decodeExpression2(input));
        checkExpressions(decodeExpression2(input), output);
    }
}
