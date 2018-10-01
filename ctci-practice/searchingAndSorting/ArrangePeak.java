package org.practice.courses.courseapi;

import javax.persistence.criteria.CriteriaBuilder;

public class ArrangePeak {

    static int[] arr;

    static void swap(int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int findMax(int a, int b, int c){
        int aVal = (a >= 0 && a < arr.length) ? arr[a] : Integer.MIN_VALUE;
        int bVal = (b>= 0 && b < arr.length) ? arr[b] : Integer.MIN_VALUE;
        int cVal = (c >= 0 && c < arr.length) ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(cVal, Math.max(aVal, bVal));

        if(max == aVal){
            return a;
        } else if(max == bVal){
            return b;
        } else {
            return c;
        }
    }

    static void arrangePeak(){
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i+=2){
            max = findMax(i-1, i, i+1);
            if(i != max)
                swap(max, i);
        }
    }

    public static void main(String[] args){
        arr = new int[]{5,3,1,2,3};
        arrangePeak();

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
