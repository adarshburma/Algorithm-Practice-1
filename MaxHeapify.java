package com.ihm.automation.utils.uputils.fulfillment;

public class MaxHeapify {

    public void maxHeapify(int[] arr, int n, int i){

        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int largest = i;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            maxHeapify(arr, n, largest);
        }

    }

    public void sort(int[] arr){
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--){
            maxHeapify(arr, n , i);
        }

        int swap = 0;
        for(int i=n-1; i>=0; i--) {
            swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            maxHeapify(arr, i, 0);
        }
    }

    public void printArray(int[] arr){
        for( int i : arr){
            System.out.println(i);
        }
    }
}
