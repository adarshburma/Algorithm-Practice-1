package org.practice.courses.courseapi.practice12;

import java.util.Stack;

public class MaxStack {

    static class Node{
        Node next;
        Node oldMax;
        int val;
    }

    static Node stack;
    static Node max2;

    static void push2(int x){
        Node n = new Node();
        n.val = x;
        if(stack == null){
            stack = n;
        } else {
            n.next = stack;
            stack = n;
        }

        if(max2 == null || max2.val < n.val){
            n.oldMax = max2;
            max2 = n;
        }
    }

    static int pop2(){
        if(stack == null) throw new NullPointerException();
        Node n = stack;
        stack = n.next;
        max2 = n.oldMax;
        return n.val;
    }

    static int max2(){
        if(max2 == null) throw new NullPointerException();
        return max2.val;
    }

    static Stack<Integer> original = new Stack<Integer>();
    static Stack<Integer> max = new Stack<>();

    static void push(int i){
        if(!max.isEmpty() && max.peek() < i){
            max.push(i);
            original.push(i);
        } else if(max.isEmpty()){
            max.push(i);
            original.push(i);
        } else {
            original.push(i);
        }

    }

    static int pop(){
        int ele = original.pop();
        if(!max.isEmpty() && ele == max.peek()){
            max.pop();
        }
        return ele;
    }

    static int max(){
        return max.isEmpty()? -1 : max.peek();
    }

    public static void main(String[] args){
        push(1);
        System.out.println(max());
        push(2);
        System.out.println(max());
        push(1);
        System.out.println(max());
        System.out.println(pop());
        System.out.println(max());
        System.out.println(pop());
        System.out.println(max());

        push2(1);
        System.out.println(max2());
        push2(2);
        System.out.println(max2());
        push2(1);
        System.out.println(max2());
        System.out.println(pop2());
        System.out.println(max2());
        System.out.println(pop2());
        System.out.println(max2());
    }
}
