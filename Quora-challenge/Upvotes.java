package com.iheartmedia.inventory.cassandra.exception;
/*
At Quora, we have aggregate graphs that track the number of upvotes we get each day.

As we looked at patterns across windows of certain sizes, we thought about ways to track trends such as non-decreasing and non-increasing subranges as efficiently as possible.

For this problem, you are given N days of upvote count data, and a fixed window size K. For each window of K days, from left to right, find the number of non-decreasing subranges within the window minus the number of non-increasing subranges within the window.

A window of days is defined as contiguous range of days. Thus, there are exactly 𝑁−𝐾+1 windows where this metric needs to be computed. A non-decreasing subrange is defined as a contiguous range of indices [𝑎,𝑏], 𝑎<𝑏, where each element is at least as large as the previous element. A non-increasing subrange is similarly defined, except each element is at least as large as the next. There are up to 𝐾(𝐾−1)/2 of these respective subranges within a window, so the metric is bounded by [−𝐾(𝐾−1)/2,𝐾(𝐾−1)/2].

Constraints
1≤𝑁≤100,000 days
1≤𝐾≤𝑁 days

Input Format
Line 1: Two integers, 𝑁 and 𝐾

Line 2: 𝑁 positive integers of upvote counts, each integer less than or equal to 109.

Output Format
Line 1..: 𝑁−𝐾+1 integers, one integer for each window's result on each line

Sample Input
5 3
1 2 3 1 1


Sample Output
3
0
-2

*/

import java.util.ArrayList;
import java.util.List;

public class StrictlyIncreasing {

    static int strictlyIncreasing(int[] arr, int s, int e, int k) {
        int count = 0;
        boolean hasEqual = false;
        for(int prev = s; prev <= e-1 ; prev++){
            int next = prev + 1;
            System.out.println("prev : " + prev + " next : " + next);
            if(arr[prev] <= arr[next]){
                if(arr[prev] == arr[next]){
                    hasEqual = true;
                }
                count++;
            }
        }
        return count > 0 ? hasEqual && count != k ? count : count + 1 : count;
    }

    static int decreasing(int[] arr, int s, int e, int k) {
        int count = 0;
        boolean hasEqual = false;
        for(int prev = s; prev <= e-1; prev++){
            int next = prev + 1;
            System.out.println("prev : " + prev + " next : " + next);
            if(arr[prev] >= arr[next]){
                if(arr[prev] == arr[next]) {
                    hasEqual = true;
                }
                count++;
            }
        }
        return count > 0 ? hasEqual && count+1 != k ? count : count+1 : count;
    }
    static List<Integer> upvotes(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        int s = 0;
        int e = k-1;

        while(e < arr.length){
            System.out.println("s : " + s + " e : " + e);
            int inc = strictlyIncreasing(arr, s, e, k);
            int dec = decreasing(arr, s, e, k);
            System.out.println("inc: " + inc + "dec : " + dec + "diff: "+ (inc - dec));
            res.add(inc - dec);
            s++;
            e++;
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,1,1};
        System.out.print(upvotes(arr, 3));
    }
}
