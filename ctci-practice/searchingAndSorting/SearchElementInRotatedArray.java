package org.practice.courses.courseapi;

public class SearchElementInRotatedArray {
    static int search(int[] arr, int left, int right, int key){
        int mid = (left+right)/2;
        if(arr[mid] == key){
            return mid;
        }

        if(right < left){
            return -1;
        }

        if(arr[left] < arr[mid]){
            if(key >= arr[left] && key < arr[mid]){
                return search(arr, left, mid-1, key);
            }else{
                return search(arr, mid+1, right, key);
            }
        } else if (arr[left] > arr[mid]){
            if(key <= arr[right] && key > arr[mid]){
                return search(arr, mid+1, right, key);
            }else{
                return search(arr, left, mid-1, key);
            }
        } else if(arr[mid] == arr[left]){
            if(arr[mid] != arr[right]){
                return search(arr, mid+1, right, key);
            } else{
                int result = search(arr, left, mid-1, key);
                if(result == -1){
                    return search(arr, mid+1, right, key);
                }else{
                    return result;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] input = {6,7,8,9,1,2,3,5};
        System.out.print("Index of key: " + search(input, 0, input.length-1, 5));
    }
}
