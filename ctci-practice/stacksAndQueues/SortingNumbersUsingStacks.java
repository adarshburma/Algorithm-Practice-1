package org.practice.courses.courseapi;

import java.util.Stack;

public class SortingNumbersUsingStacks {
    
    //Sorting elements using only 2 stacks without using extra data structure

    static Stack<Integer> sort(Stack<Integer> s1){
        Stack<Integer> temp = new Stack<>();
        int t =0;
        while(!s1.isEmpty()){
            t = s1.pop();
            while(!temp.isEmpty() && temp.peek() > t){
                s1.push(temp.pop());
            }
            temp.push(t);
        }

        while (!temp.isEmpty()){
            s1.push(temp.pop());
        }

        return s1;
    }

    public static void main(String args[]){
        Stack<Integer> s1 = new Stack<>();

        s1.push(3);
        s1.push(4);
        s1.push(2);
        s1.push(5);

        Stack<Integer> res = sort(s1);

        while(!res.isEmpty()){
            System.out.print(" " + res.pop());
        }

    }
}
