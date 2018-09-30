package org.practice.courses.courseapi;

public class SparseSearch {

    /*
     * Modified version of Binary search we will have to first find non-Empty index of Mid then apply
     * Binary search to find the key.
     */

    static int searchHelper(String[] arr, String key, int l, int r){
        int mid = (l+r)/2;

        if(l > r){
            return -1;
        }

        if(arr[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while (true){
                if(!arr[left].isEmpty()){
                    mid = left;
                    break;
                } else if(!arr[right].isEmpty()){
                    mid = right;
                    break;
                }

                left++;
                right--;
            }
        }

        if(arr[mid].equals(key)){
            return mid;
        }

        if(arr[mid].compareTo(key) < 0){
            return searchHelper(arr, key, mid+1, r);
        } else {
            return searchHelper(arr, key, l, mid -1);
        }
    }

    static int search(String[] arr, String key){
        if(arr == null || key.isEmpty() || key == "" || key == null){
            return -1;
        }else{
            return searchHelper(arr, key, 0, arr.length-1);
        }
    }

    public static void main(String[] args){
        String[] input = {"at", "", "", "", "ball", "", "", "car", "" ,"dad", "", ""};
        System.out.print("Index of ball is: "+ search(input, "dad"));
    }
}
