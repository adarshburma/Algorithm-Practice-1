/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/


package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.Stack;

public class CombinationSum {

    static class Point{
        int x;
        int y;

        Point(int i, int j){
            this.x = i;
            this.y = j;
        }
    }

    static ArrayList<ArrayList<Integer>> construct(boolean[][] mat, int[] arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int j = mat[0].length -1;
        for(int i = mat.length-1 ; i >= 0; i-- ){

            if(mat[i][j]){
                Stack<Point> stack = new Stack<>();
                stack.push(new Point(i, j));
                ArrayList<Integer> list = new ArrayList<>();
                // stack.push(new Point(i, j));

                while(!stack.isEmpty()){
                    Point p = stack.pop();
                    int x = p.x;
                    int y = p.y;
                    if(y <= 0){
                        break;
                    }

                    list.add(arr[x-1]);
                    if(x-1 >= 0 && y - arr[x-1] >= 0 && mat[x-1][y-arr[x-1]]){
                        stack.push(new Point(x-1, y-arr[x-1]));
                    }

                    if(x-1 >= 0 && y - arr[x-1] >= 0 && mat[x][y - arr[x-1]]) {
                        stack.push(new Point(x, y-arr[x-1]));
                    }
                }

                res.add(list);
            }
        }

        return res;
    }

    static ArrayList<ArrayList<Integer>> combinations(int[] arr, int target){
        boolean[][] mat = new boolean[arr.length+1][target+1];
        for(int i = 0 ; i < arr.length+1; i++){
            mat[i][0] = true;
        }

        for(int i = 1 ; i < mat.length; i++){
            for(int j = 1; j < mat[0].length; j++){
                if(j - arr[i-1] >= 0){
                    mat[i][j] = mat[i-1][j-arr[i-1]] || mat[i][j-arr[i-1]];
                }

            }
        }

        return construct(mat, arr);
    }

    public static void main(String[] args){
        int[] arr = {2,3,5};
        for(ArrayList<Integer> list : combinations(arr, 8)){
            System.out.println(list);
        }
    }
}
