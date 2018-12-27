package org.practice.courses.courseapi.practice12;

public class MergeArraysNoSpace {

    static void mergeArrays(int[] a, int[] b){
        int aLength = a.length - b.length;
        merge(a, b, aLength, b.length);
    }

    static void merge(int[] a, int[] b, int aLength, int bLength){
        if(aLength + bLength - 1 > a.length) throw new IllegalArgumentException();
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        int mergeIndex = aLength + bLength - 1;

        while(aIndex >= 0 && bIndex >= 0){
            if(a[aIndex] > b[bIndex]){
                a[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }

            mergeIndex--;
        }

        while(bIndex >= 0){
            a[mergeIndex] = b[bIndex];
            bIndex--;
            mergeIndex--;
        }
    }

    public static void main(String[] args){
        int[] a = {1,3,5,0,0,0};
        int[] b = {2,4,6};

        mergeArrays(a,b);
        
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }
}
