package org.practice.courses.courseapi.practice12;

import java.util.HashSet;

public class ConsecutiveSequence {

    static int longestConsecutiveSequence(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i : set){
            if(set.contains(i-1)) continue;
            int length = 0;
            while(set.contains(i++)) length++;
            max = Math.max(max, length);
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = {4,2,1,6,5};
        System.out.println("length of longest consecutive sequence: " + longestConsecutiveSequence(arr));
    }
}
