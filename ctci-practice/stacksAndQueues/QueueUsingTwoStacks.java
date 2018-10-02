package com.iheartmedia.salesforce.config.handler;

import java.util.Stack;

public class QueueUsingTwoStacks {

    static class Queue<T> {
        Stack<T> oldValues = new Stack<T>();
        Stack<T> newValues = new Stack<T>();

        public void enqueue(T value){
            newValues.push(value);
        }

        public T peek(){
            updateStacks();
            return oldValues.peek();
        }

        public T pop(){
            updateStacks();
            return oldValues.pop();
        }

        public void updateStacks(){
            if(oldValues.isEmpty()){
                while(!newValues.isEmpty()){
                    oldValues.push(newValues.pop());
                }
            }
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Peek: " + queue.peek());
        System.out.print("pop1: "  +queue.pop()+ " ");
        System.out.print("pop2: "  +queue.pop()+ " ");
        System.out.print("pop3: "  +queue.pop()+ " ");
        System.out.print("pop4: "  +queue.pop()+ " ");

        System.out.println();
        System.out.print("New Peek" + queue.peek());
    }
}
