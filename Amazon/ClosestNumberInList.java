/*
 
Closest numbers from a list of unsorted integers
Given a list of distinct unsorted integers, find the pair of elements that have the smallest absolute difference between them? 
If there are multiple pairs, find them all.
Input : arr[] = {10, 50, 12, 100}
Output : (10, 12)
The closest elements are 10 and 12
Input : arr[] = {5, 4, 3, 2}
Output : (2, 3), (3, 4), (4, 5)
*/

package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDistance {

    static ArrayList<String> minDist(int[] arr){
        Arrays.sort(arr);
        ArrayList<String> res = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;
        for(int i =1 ; i < arr.length; i++){
            int dist = Math.abs(arr[i-1] - arr[i]);
            if( dist < minDist){
                minDist = dist;
            }
        }

        for(int i = 1 ;i < arr.length; i++){
            int dist = Math.abs(arr[i-1] - arr[i]);
            if(dist == minDist){
                res.add("(" + arr[i-1] + "," + arr[i] + ")");
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] list = new int[]{ 10, 50, 12, 100};
        System.out.print(minDist(list));
    }
}
