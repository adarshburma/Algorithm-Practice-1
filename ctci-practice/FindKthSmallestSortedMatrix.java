package org.practice.courses.courseapi;

public class FindKthSmallestSortedMatrix {

    static class HeapNode{
        int val;
        int row;
        int col;

        HeapNode(int data, int i, int j){
            val = data;
            row = i;
            col = j;
        }
    }

    static void heapifyMin(HeapNode[] arr, int n, int i){
        int left = 2 * i + 1;
        int right = 2 * i +2;
        int smallest = i;

        if(left < n && arr[left].val < arr[smallest].val){
            smallest = left;
        }

        if(right < n && arr[right].val < arr[smallest].val){
            smallest = right;
        }

        if(smallest != i){
            HeapNode swap = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = swap;
            heapifyMin(arr, n, smallest);
        }
    }

    static void minHeapCreate(HeapNode[] arr, int n){
        for(int i = (n-1)/2; i >= 0; i--){
            heapifyMin(arr, n , i);
        }
    }

    public static int kthSmallest(int[][] arr, int k){
        int n = arr.length;
        if (k <= 0 || k > n*n)
            return Integer.MAX_VALUE;
        HeapNode heaparr[] = new HeapNode[n];

        //create array with first row.
        for(int i = 0 ; i < n; i++) {
            heaparr[i] = new HeapNode(arr[0][i], 0, i);
        }

        minHeapCreate(heaparr, n);
        HeapNode hr = null;
        for(int i = 0 ; i < k ;i++){
            hr = heaparr[0];

            int nextVal = (hr.row < (n-1)) ? arr[hr.row + 1][hr.col] : Integer.MAX_VALUE;

            heaparr[0] = new HeapNode(nextVal, hr.row+1, hr.col);
            heapifyMin(heaparr, n, 0);
        }
        return hr.val;
    }

    public static void main(String[] args){
        int[][] arr = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50},
        };
        System.out.print(kthSmallest(arr, 7));

    }
}
