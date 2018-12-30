package org.practice.courses.courseapi.practice12;

public class MakeChange {

    static int coinChange(int total, int[] coins){
        int[] cache = new int[total+1];
        return coinChange(coins, total, cache);
    }

    static int coinChange(int[] coins, int total, int[] cache){
        if( total <= 0){
            return 0;
        }
        if(cache[total] > 0){
            return cache[total];
        }
        int min = Integer.MAX_VALUE;
        int currCoins = 0;
        for(int i : coins){
            if(i <= total){
                currCoins = 1 + coinChange(coins, total - i, cache);
                min = Math.min(currCoins, min);
            }
        }
        cache[total] = min;
        return min;
    }

    public static void main(String[] args){
        int[] coins = {1,5,10,25};
       System.out.println("Try 1: "+ coinChange(1, coins));
        System.out.println("Try 2: "+ coinChange(3, coins));
        System.out.println("Try 3: "+ coinChange(7, coins));
        System.out.println("Try 4: "+ coinChange(32, coins));
    }
}
