package com.iheartmedia.salesforce.config.handler;

public class MinCostDP {
    public static int findMinimumCost(int[][] cost, int m, int n){
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }

        if(m == 0 && n == 0){
            return cost[m][n];
        }

        return cost[m][n] + minCost(findMinimumCost(cost, m-1, n-1) , findMinimumCost(cost, m-1, n), findMinimumCost(cost, m, n-1));
    }

    public static int minCost(int m, int n, int o){
        if( m < n && m < o){
            return m;
        }else if( n < o){
            return n;
        } else {
            return o;
        }
    }

    public static void main(String args[]){
        int[][] cost = new int[][] { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };

        System.out.print("Minimum cost: " + findMinimumCost(cost, 2, 2));
    }
}
