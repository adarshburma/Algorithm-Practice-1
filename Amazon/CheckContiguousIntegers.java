package org.practice.courses.courseapi;
import java.util.HashSet;


/*
Check if array contains contiguous integers with duplicates allowed
Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”. 
Input : arr[] = {5, 2, 3, 6, 4, 4, 6, 6}
Output : Yes
The elements form a contiguous set of integers
which is {2, 3, 4, 5, 6}.
Input : arr[] = {10, 14, 10, 12, 12, 13, 15}
Output : No
*/

public class CheckContiguousIntegers {
    static boolean checkContiguous(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++){
          if(!set.contains(arr[i])) {
              set.add(arr[i]);
          }

          if(arr[i] < min){
              min = arr[i];
          }

          if(arr[i] > max) {
              max = arr[i];
          }
        }

        if(max-min >= arr.length){
            return false;
        }

        while(min<=max) {
            if(!set.contains(min)) {
                return false;
            }
            min++;
        }

        return true;
    }
}
