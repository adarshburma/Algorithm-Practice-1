package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;

public class ArrayPermutations {

    static ArrayList<int[]> permuteHelper(int[] arr){
        ArrayList<int[]> results = new ArrayList<>();
        permutations(arr, 0, results);
        return results;
    }

    static void permutations(int[] arr, int start, ArrayList<int[]> results){
        if(start >= arr.length){
            results.add(arr.clone());
        } else {
            for(int i = 0 ; i < arr.length; i++){
                swap(arr, start, i);
                permutations(arr, start+1, results);
                swap(arr, start, i);
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        for(int[] i : permuteHelper(arr)){
            System.out.print("[");
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
