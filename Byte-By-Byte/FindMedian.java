package org.practice.courses.courseapi.practice12;

public class MedianFinder {

    static class Subarray{
        int[] underlying;
        int start;
        int size;

        private static Subarray fromArray(int[] arr){
            Subarray s = new Subarray();
            s.underlying = arr;
            s.start = 0;
            s.size = arr.length;
            return s;
        }

        private Subarray subarray(int i, int j){
            if(i > j) throw new IllegalArgumentException();
            if(j > size) throw new IndexOutOfBoundsException();
            Subarray subarray = new Subarray();
            subarray.underlying = this.underlying;
            subarray.start = this.start + i;
            subarray.size = j - i;
            return subarray;
        }

        private int getSize(){
            return size;
        }

        private int getFirst(){
            return underlying[start];
        }

        private int getLast(){
            return underlying[start + size-1];
        }

        private double median() {
            if(this.size % 2 == 0){
                return (underlying[start + size/2 -1] + underlying[start + size/2])/2.;
            }

            return underlying[start + size/2];
        }
    }

    static double findMedian(int[] arr1, int[] arr2){
        if(arr1.length == 0 || arr1.length != arr2.length) {
            throw  new IllegalArgumentException();
        }

        return findMedian(Subarray.fromArray(arr1), Subarray.fromArray(arr2));
    }

    static double findMedian(Subarray arr1, Subarray arr2){
        if(arr1.getSize() == 1) {
            return (arr1.getFirst() + arr2.getFirst())/2.;
        }

        if(arr1.getSize() == 2){
            return (Math.max(arr1.getFirst(), arr2.getFirst()) +
                    Math.min(arr1.getLast(), arr2.getLast()))/2.;
        }

        double median1 = arr1.median();
        double median2 = arr2.median();

        if(median1 > median2){
            return findMedian(arr1.subarray(0, arr1.getSize()/2 + 1),
                    arr2.subarray((arr2.getSize() -1)/2 , arr2.getSize()));
        }

        return findMedian(arr1.subarray((arr1.getSize() -1)/2 , arr1.getSize()),
                arr2.subarray(0, arr2.getSize()/2 +1));
    }

    public static void main(String[] args){
        int[] arr1 = new int[] {1,3,5};
        int[] arr2 = new int[] {2,4,6};

        System.out.println("Median is: " + findMedian(arr1, arr2));
    }
}
