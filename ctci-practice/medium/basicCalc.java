package org.practice.courses.courseapi;

import java.util.Stack;

public class CalculatorBasics {

    public enum Operator {
        ADD, SUB, MUL, DIV, BLANK
    }

    static double computeExpression(String seq){
        Stack<Double> numStack = new Stack<Double>();
        Stack<Operator> opsStack = new Stack<Operator>();
        for(int i = 0 ; i < seq.length(); i++){
            try{
                int val = parseNextInt(seq, i);
                System.out.println("Int" + val);
                numStack.push((double)val);
                i += Integer.toString(val).length();

                if(i >= seq.length()){
                    break;
                }

                Operator op = parseNextOp(seq, i);
                System.out.println("operator" + op.toString());
                collapseTop(numStack, opsStack, op);
                opsStack.push(op);
            } catch (NumberFormatException ex){
                return Integer.MIN_VALUE;
            }
        }

        System.out.println("peek" + numStack.peek());
        collapseTop(numStack,opsStack, Operator.BLANK);
        if(numStack.size() == 1 && opsStack.size() == 0){
            return numStack.pop();
        }

        return 0;
    }

    static void collapseTop(Stack<Double> numStack, Stack<Operator> opsStack, Operator futureTop){
        while(opsStack.size() >= 1 && numStack.size() >= 2){
            if(operatorPriority(futureTop) <= operatorPriority(opsStack.peek())){
                double second = numStack.pop();
                double first = numStack.pop();
                Operator op = opsStack.pop();
                double result = performOp(first,op,second);
                System.out.println(result);
                numStack.push(result);
            } else {
                break;
            }
        }
    }

    static int parseNextInt(String seq, int offset){
        StringBuilder sb = new StringBuilder();
        while(offset < seq.length() && Character.isDigit(seq.charAt(offset))){
            sb.append(seq.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }

    static Operator parseNextOp(String seq, int offset){
        if(offset < seq.length()){
            char c = seq.charAt(offset);
            switch (c){
                case '+' : return Operator.ADD;
                case '-' : return Operator.SUB;
                case '*' : return Operator.MUL;
                case '/' : return Operator.DIV;
            }
        }
        return Operator.BLANK;
    }

    static int operatorPriority(Operator op){
        switch(op){
            case ADD: return 1;
            case SUB : return 1;
            case DIV : return 2;
            case MUL : return 2;
            case BLANK: return 0;
        }

        return 0;
    }

    static double performOp(double left, Operator op , double right){
        switch(op){
            case ADD: return left + right;
            case DIV: return left/right;
            case SUB: return left - right;
            case MUL: return left * right;
        }
        return right;
    }

    public static void main(String[] args){
        System.out.println(computeExpression("2-6-7*8/2+5"));
    }

}
