package org.practice.courses.courseapi;

public class KnapsackProblem {

    public int knapsack(int W, int[] w, int[] val, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(w[n-1] > W){
           return knapsack(W, w, val, n-1);
        }

        return Math.max(val[n-1] + knapsack(W - w[n-1], w, val, n-1), knapsack(W,w, val, n-1));
    }

    public static void main(String args[]){
        int[] w = {10, 20, 30};
        int[] val = {60, 100, 120};
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        System.out.println(knapsackProblem.knapsack(50, w, val, w.length));
    }
}
