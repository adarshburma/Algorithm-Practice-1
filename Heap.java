package com.iheartmedia.salesforce.controller.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

    static void maxHeapify(int[] arr, int n, int i){
        int left = (2*i) + 1;
        int right = (2*i) + 2;

        int largest = i;

        if(left < n && arr[left] < arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] < arr[largest]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n , largest);
        }
    }

    static void sort(int[] arr){
        int n = arr.length;
        for(int i = n/2-1; i >= 0; i--){
            maxHeapify(arr, n, i);
        }

        for(int i = n-1; i >= 0 ; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            maxHeapify(arr,i,0);
        }
        printArray(arr);
    }

    static void printArray(int[] arr){
        for(int i : arr) {
            System.out.print(" " + i);
        }
    }


    static void minHeapify(int[] arr, int n, int i){
        int left = (2*i) + 1;
        int right = (2*i) + 2;
        int smallest = i;

        if(n > left && arr[left] > arr[smallest]){
            smallest = left;
        }

        if(n > right && arr[right] > arr[smallest]){
            smallest = right;
        }

        if(smallest != i){
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            minHeapify(arr, n, smallest);
        }
    }


    static void sortAsc(int[] arr){
        int n = arr.length;
        for(int i= n/2-1; i >= 0; i--){
            minHeapify(arr, n, i);
        }

        for(int i = n-1; i >= 0 ; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            minHeapify(arr, i, 0);
        }

        printArray(arr);
    }

    static void ascPriorityQueue(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.offer(i);
        }
        System.out.println();
        while(!pq.isEmpty()){
            System.out.print(" " + pq.poll());
        }
    }

    static void descPriorityQueue(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1-o2 > 0){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for(int i : arr){
            pq.offer(i);
        }
        System.out.println();
        while(!pq.isEmpty()){
            System.out.print(" " + pq.poll());
        }
    }

    public static void main(String[] args){
        int[] arr = {2,4,5,1,8,10};
        sortAsc(arr);
        descPriorityQueue(arr);
    }
}
