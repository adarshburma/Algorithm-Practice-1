/*
 Maximum number of chocolates to be distributed equally among k students
4
Given n boxes containing some chocolates arranged in a row. There are k number of students. 
The problem is to distribute maximum number of chocolates equally among k students by selecting a consecutive sequence of boxes from the given lot. 
Consider the boxes are arranged in a row with numbers from 1 to n from left to right. 
We have to select a group of boxes which are in consecutive order that could provide maximum number of chocolates equally to all the k students.
An array arr[] is given representing the row arrangement of the boxes and arr[i] represents number of chocolates in that box at position ‘i’.
Examples:
Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 6
The subarray is {7, 6, 1, 4} with sum 18.
Equal distribution of 18 chocolates among
3 students is 6.
Note that the selected boxes are in consecutive order
with indexes {1, 2, 3, 4}
 */

package org.practice.courses.courseapi;

import java.util.HashMap;

public class DistributeEqually {

    static int findEqualDistribution(int[] arr, int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int remUptoCurrent = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
            remUptoCurrent = sum % k;
            if(remUptoCurrent == 0 && sum/k > max) {
                max = sum/k;
            } else if(map.containsKey(remUptoCurrent)){
                int remUptoCurrentSum = map.get(remUptoCurrent);
                int currsum = sum - remUptoCurrentSum;
                if(currsum/k > max){
                    max = currsum/k;
                }
            } else {
                map.put(remUptoCurrent, sum);
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] input = new int[] {2,7,6,1,4,5};
        System.out.print(findEqualDistribution(input, 3));
    }
}
