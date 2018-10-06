package org.practice.courses.courseapi;

import java.util.PriorityQueue;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Double> queue = new PriorityQueue<>();

        int queueLength = nums1.length + nums2.length;
        double[] res = new double[queueLength];

        for(int i = 0; i < nums1.length; i++){
            queue.offer(new Double(nums1[i]));
        }

        for(int i = 0 ; i < nums2.length; i++){
            queue.offer(new Double(nums2[i]));
        }

        int i = 0;
        while(!queue.isEmpty()){
            res[i] = queue.poll();
            i++;
        }

        for(double d : res){
            System.out.print(d + " ");
        }

        if(res.length % 2 != 0){
            return res[res.length/2];
        } else {
            return (res[res.length/2 - 1] + res[res.length/2])/2;
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2, 4};

        System.out.print(findMedianSortedArrays(nums1, nums2));
    }
}
