package org.practice.courses.courseapi;

public class MergeToA {

    static int[] merge(int[] a, int[] b, int aLast, int bLast){
        int aIndex = aLast - 1;
        int bIndex = bLast - 1;
        int mergeIndex = aLast + bLast - 1;

        while (mergeIndex >= 0){
            if(aIndex >= 0 && a[aIndex] > b[bIndex]){
                a[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }
            mergeIndex--;
        }

        return a;
    }

    public static void main(String[] args){
        int[] a = new int[8];
        a[0] = 2;
        a[1] = 4;
        a[2] = 6;
        a[3] = 8;

        int[] b = {1,3,5,7};

        int[] merged = merge(a,b,4,4);

        for(int i : merged){
            System.out.print(i + " ");
        }
    }
}
