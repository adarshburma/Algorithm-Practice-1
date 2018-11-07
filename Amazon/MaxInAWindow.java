/*
 Sliding Window Maximum (Maximum of all subarrays of size k)
3.5
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
Examples:
Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6
Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90
 */

package org.practice.courses.courseapi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MaxInAWindow {

    static void maxWindow(int[] arr, int k){
        LinkedList<Integer> dequeue = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            while(!dequeue.isEmpty() && arr[i] > arr[dequeue.getLast()]){
                dequeue.removeLast();
            }

            dequeue.addLast(i);
        }

        for(int i = k ; i < arr.length; i++){
            System.out.println(" " + arr[dequeue.getFirst()]);
            if(dequeue.size() > 0 && dequeue.getFirst() <= i-k){
                dequeue.removeFirst();
            }

            while(!dequeue.isEmpty() && arr[i] > arr[dequeue.getLast()]){
                dequeue.removeLast();
            }
            dequeue.addLast(i);
            System.out.println();
           for(int j = 0; j < dequeue.size(); j++){
               System.out.println(dequeue.get(j));
           }
        }

       System.out.println(" " + arr[dequeue.getFirst()]);
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,1,4,5,2,3,6};
        maxWindow(input, 3);
    }
}
