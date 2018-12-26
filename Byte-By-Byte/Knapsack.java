package org.practice.courses.courseapi.practice12;

import java.util.Arrays;
import java.util.HashMap;

public class Knapsack {

    static class Item{
        int weight;
        int val;

        Item(int weight, int val){
            this.val = val;
            this.weight = weight;
        }
    }

    static Item[] items;

    static int knapsack(int W, int[] weights, int[] vals){
        int[] cache = new int[weights.length];
        Arrays.fill(cache, -1);
        return knapsack(W, weights, vals, 0, cache);
    }

    static int knapsack(int W, int[] weights, int[] vals, int i, int[] cache){
        if( i == weights.length) return 0;
        if(W - weights[i] < 0){
            return knapsack(W , weights, vals, i+1, cache);
        }

        return Math.max(knapsack(W - weights[i], weights, vals, i+1, cache) + vals[i],
                knapsack(W, weights, vals, i+1, cache));
    }

    static void insertItems(int[] vals, int[] weights){
        items = new Item[weights.length];
        for(int i = 0 ; i < vals.length; i++){
            items[i] = new Item(weights[i], vals[i]);
        }
    }

    static int knapsackOptimized(Item[] items, int W){
        HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<>();
        return knapsackOptimized(items, W, 0, cache);
    }

    static int knapsackOptimized(Item[] items, int W, int i, HashMap<Integer, HashMap<Integer,Integer>> cache){
        if( i == items.length){
            return 0;
        }

        if(! cache.containsKey(i)){
            cache.put(i, new HashMap<>());
        }
        Integer cached = cache.get(i).get(W);
        if(cached != null){
            return cached;
        }

        if(W - items[i].weight < 0){
            return knapsackOptimized(items, W, i+1, cache);
        }

        int toReturn = Math.max(knapsackOptimized(items, W , i+1, cache), knapsackOptimized(items, W - items[i].weight, i+1, cache) + items[i].val);
        cache.get(i).put(W, toReturn);
        return toReturn;

    }

    static int knapsackDynamic(int W, int[] vals, int[] weights) {
        int[][] cache  = new int[weights.length+1][W+1];
        for(int i = 1; i <= weights.length; i++){
            for(int j = 0; j <= W; j++){
                if(weights[i-1] > j) {
                    cache[i][j] = cache[i-1][j];
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j - weights[i-1]] + vals[i-1]);
                }
            }
        }

        for(int i = 0 ; i < cache.length; i++){
            for(int j = 0; j < cache[0].length; j++){
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }

        return cache[weights.length][W];
    }

    public static void main(String[] args){
        int[] weights = new int[] {10, 20, 30};
        int[] vals = new int[] {60, 100, 120};
        System.out.println("Maximum val: " + knapsack(50, weights, vals));
        System.out.println("Maximum val dynamic programming approach: " + knapsackDynamic(50, vals, weights));
        insertItems(vals, weights);
        System.out.println("Maximum val optimized recursion " + knapsackOptimized(items, 50));
    }
}
