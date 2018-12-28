package org.practice.courses.courseapi.practice12;

/* Without using any additional data structures 
* 
* reverse:
* 
* stack = 1, 2, 3
* temp = 1 (x)
* stack = 2, 3
* temp = 2
* stack = 3
* 
* insertAtBottom:
* 
* 
* x = 1
* stack = 1
* 
* x = 2
* stack = 1
* temp = 1 // stack gets empty
* insertAtBottom(stack, 2)
* stack = 2
* push(temp)
* stack = 2 1
* 
*
* 
* */

import java.util.Stack;

public class ReverseStack {

   static Stack<Integer> reverse(Stack<Integer> stack){
       if(stack.isEmpty()){
           return stack;
       }

       int temp = stack.pop();
       reverse(stack); // returns empty stack here.
        insertAtBottom(stack, temp); //stack is empty here for first call
        return stack;
   }

   static void insertAtBottom(Stack<Integer> stack, int x){
       if(stack.isEmpty()){
           stack.push(x); 
           return;
       }

       int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
   }

   public static void main(String[] args){
       Stack<Integer> stack = new Stack<>();
       stack.push(1);
       stack.push(2);
       stack.push(3);
       System.out.println("Before reversal: ");
       for(int i: stack){
           System.out.print(i + " ");
       }
       System.out.println();
       reverse(stack);
       System.out.println();
       System.out.println("After reversal: ");
       for(int i: stack){
           System.out.print(i + " ");
       }
   }
}
