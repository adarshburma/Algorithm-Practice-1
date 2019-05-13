/*

There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

*/


package org.practice.courses.courseapi;

public class NumWays {
    static int ways(int n){
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            mat[0][i] = 1;
            mat[i][0] = 1;
        }
        for(int i = 1 ; i < n; i++){
            for(int j = 1; j < n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }

        return mat[n-1][n-1];
    }

    static void printCurrPrev(int[] curr, int[] prev, int n){
        System.out.print("curr: ");
        for(int k = 0 ; k < n ; k++){
            System.out.print(curr[k] + " ");
        }

        System.out.println();
        System.out.print("prev: ");
        for(int k = 0; k < n; k++){
            System.out.print(prev[k] + " ");
        }

        System.out.println();
    }

    static int waysOpti(int n){
        int[] even = new int[n];
        int[] odd = new int[n];

        for(int i = 0; i < n; i++){
            even[i] = 1;
        }

        int[] curr;
        int[] prev;
        for(int i = 1; i < n; i++){
            if(i % 2 != 0){
                curr = odd;
                prev = even;
            } else {
                curr = even;
                prev = odd;
            }

            for(int j = 0; j < n; j++){
                if(j == 0){
                    curr[j] = 1;
                    continue;
                }

                curr[j] = curr[j-1] + prev[j];
            }
        }

        if((n-1) % 2 == 0) {
            return even[n-1];
        }

        return odd[n-1];
    }

    public static void main(String[] args){
        System.out.println("Num of ways : " + ways(5));
        System.out.println("Num of ways optimized : " + waysOpti(5));
    }
}
