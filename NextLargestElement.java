package org.practice.courses.courseapi;

import java.util.Stack;

public class NextLargestElement {
    public static int[] nextLargest2(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 2 * arr.length -1; i>=0; i--){
            while(!stack.empty() && arr[stack.peek()] <= arr[i % arr.length]){
                stack.pop();
            }

            res[i % arr.length] = stack.empty() ? -1 : arr[stack.peek()];
            stack.push(i % arr.length);
        }
        return res;
    }

    public static int[] nextLargestElement(int[] arr){
        int[] res = new int[arr.length];
       Stack<Integer> stack = new Stack<>();
       for(int i = 2 * arr.length -1 ; i >= 0 ; --i){
           while(!stack.empty() && arr[stack.peek()] <= arr[i % arr.length]){
               stack.pop();
           }
           res[i % arr.length] = stack.empty() ? -1 : arr[stack.peek()];
           stack.push(i % arr.length);
       }

       return res;
    }

    public static void main(String args[]){
        int[] input = new int[] {1,3,2,4};
        int[] res= nextLargest2(input);
        for(int i = 0 ; i < input.length; i++){
            System.out.println(input[i] + " : " + res[i] );
        }
    }
}
