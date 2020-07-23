/*

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.


Given an array of integers out of order, determine the bounds of the smallest window that must be sorted in order for the entire array to be sorted. For example, given [3, 7, 5, 6, 9], you should return (1, 3)

*/



public class ShortestUnsortedRange {
    static int[] findMinRange(int[] arr) {
        int start = 0, end = 0;
        int i = 1;
        while(arr[i-1] <= arr[i]) {
            i++;
        }
        start = i-1;
        for(i = start; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                end = i;
            }
        }

        return new int[] {start, end};
    }

    static int findLengthOfEleNeedSorting(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int l,r;

        for(int i = 1 ; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                min = Math.min(min, arr[i]);
            }
        }

        for(int i = arr.length-2 ; i >= 0; i--) {
            if(arr[i] > arr[i+1]) {
                max = Math.max(max, arr[i]);
            }
        }

        for(l = 0 ; l < arr.length; l++) {
            if(min < arr[l]){
                break;
            }
        }

        for(r = arr.length-1; r >=0; r--) {
            if(max > arr[r]) {
                break;
            }
        }

        return r-l+1;
    }

    public static void main(String[] args) {
        int[] inp = new int[] {3,6,5,7,9};
        int[] ans = findMinRange(inp);
        System.out.println(ans[0] + " " + ans[1]);
        System.out.println(findLengthOfEleNeedSorting(inp));
    }
}
