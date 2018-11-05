package org.practice.courses.courseapi;
import java.util.HashSet;

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
