package com.ihm.fulfillment.controller.exceptions;

public class PalindromePartitioning {

    static boolean isPalindrome(String str){
        int start = 0 ;
        int end = str.length()-1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    static void printTable(int[][] dp){
        for(int i = 0 ;i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){
                System.out.print(" " + dp[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] palindromePartitioning(String str){
        int[][] dp = new int[str.length()+1][str.length()+1];
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){
                if(i == j){
                    dp[i][j] = 0;
                }
                if(j < i){
                    dp[i][j] = 0;
                }

                if(isPalindrome(str.substring(i,j))){
                    dp[i][j] = 0;
                } else {
                    for(int k = i; k < j-1 ; k++){
                        dp[i][j] = 1 + Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }

        return dp;
    }

    public static void main(String[] args){
       printTable(palindromePartitioning("aabbcdda"));
    }
}
