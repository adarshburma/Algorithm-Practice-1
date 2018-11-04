package org.practice.courses.courseapi;

public class MagicIndexWithoutDistintElements {

    /*
    * Find magic index a[i] = i.
    * when elements in array are not distinct.
    * */


    static int magixIndex (int[] arr){
       return magicIndexHelper(arr, 0, arr.length-1);
    }

    static int magicIndexHelper (int[] arr, int start, int end){
        if(end < start){
            return -1;
        }
        int midIndex = (start+end)/2;
        int midValue = arr[midIndex];
        if(midIndex == midValue){
            return midIndex;
        }

        int leftIndex = Math.min(midIndex-1, midValue);
        int left = magicIndexHelper(arr, start, leftIndex);
        if(left >= 0){
            return left;
        }

        int rightIndex = Math.max(midIndex+1, midValue);
        int right = magicIndexHelper(arr, rightIndex, end);
        return right;
    }

    public static void main(String[] args){
        int[] input = new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.print("Magic index "  + magixIndex(input));
    }
}
