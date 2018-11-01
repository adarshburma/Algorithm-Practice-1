package com.iheartmedia.salesforce.controller.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {

    static void addElement(PriorityQueue<Integer> minqueue,PriorityQueue<Integer> maxqueue, int ele){
        if(maxqueue.isEmpty() || maxqueue.peek() > ele) {
            maxqueue.add(ele);
        } else {
            minqueue.add(ele);
        }
    }

    static double balanceQueues(PriorityQueue<Integer> minqueue,PriorityQueue<Integer> maxqueue){
        PriorityQueue<Integer> biggerqueue = minqueue.size() > maxqueue.size() ? minqueue : maxqueue;
        PriorityQueue<Integer> smallqueue = minqueue.size() > maxqueue.size() ? maxqueue : minqueue;

        while((biggerqueue.size() - smallqueue.size()) >= 2){
            smallqueue.add(biggerqueue.poll());
        }

        if(biggerqueue.size() == smallqueue.size()){
            return ((double) biggerqueue.poll() + smallqueue.poll())/2;
        } else {
            return biggerqueue.size() > smallqueue.size() ? biggerqueue.poll() : smallqueue.poll();
        }
    }

    static double median(int[] arr) {
        PriorityQueue<Integer> minqueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1-o2 > 0){
                   return -1;
                }
                return 1;
            }
        });

        for(int i: arr){
            addElement(minqueue, maxqueue, i);
        }

        return balanceQueues(minqueue, maxqueue);
    }

    public static void main(String[] args){
        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4, 14};
        System.out.print("Running median: " + median(arr));
    }
}
