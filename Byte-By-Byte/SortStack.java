package org.practice.courses.courseapi.practice12;

import java.util.Stack;

public class SortStack {
    static void sortAsc(Stack<Integer> ori){
        Stack<Integer> temp = new Stack<>();
        while(!ori.isEmpty()) {
            int s = ori.pop();
            while (!temp.isEmpty() &&  temp.peek() < s){
                ori.push(temp.pop());
            }

            temp.push(s);
        }

        while(!temp.isEmpty()){
            ori.push(temp.pop());
        }
    }

    static void sortDesc(Stack<Integer> ori){
        Stack<Integer> temp = new Stack<>();
        while(!ori.isEmpty()) {
            int s = ori.pop();
            while (!temp.isEmpty() &&  temp.peek() > s){
                ori.push(temp.pop());
            }

            temp.push(s);
        }

        while(!temp.isEmpty()){
            ori.push(temp.pop());
        }
    }


    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        sortAsc(stack);
        for(int i : stack){
            System.out.print(i + " ");
        }
        System.out.println();
        sortDesc(stack);
        for(int i : stack){
            System.out.print(i + " ");
        }
    }
}
