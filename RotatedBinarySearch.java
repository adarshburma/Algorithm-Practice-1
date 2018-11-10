package org.practice.courses.courseapi;

public class RotatedBinarySearch {

    public int pivotedBinarySearch(int[] arr,int n, int key){
        int pivot = findPivot(arr, 0, n-1);
        if(arr[pivot] == key){
            return pivot;
        }
        if(pivot == -1){
            return binarySearch(arr,0, n-1, key);
        }
        if(arr[0] < key){
            return binarySearch(arr, 0,pivot-1,key);
        }

        return binarySearch(arr, pivot+1, n-1, key);
    }

    public int findPivot(int[] arr, int low, int high){
        if(high < low) {
            return -1;
        }

        if(high == low){
            return low;
        }

        int mid = (high + low)/2;

        if(mid < high && arr[mid] > arr[mid+1]){
            return mid;
        }

        if(mid > low && arr[mid] < arr[mid-1]){
            return mid-1;
        }

        if(arr[low] > arr[mid]){
            findPivot(arr, low, mid-1);
        }

        return findPivot(arr, mid+1, high);
    }

    public int binarySearch(int[] arr, int low, int high, int key){
        if(high < low){
            return -1;
        }

        int mid = (high+low)/2;
        if(arr[mid] == key){
            return mid;
        }
        if(arr[mid] > key){
            return binarySearch(arr,0, mid-1, key);
        }

        return binarySearch(arr, mid+1, high, key);
    }
    
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            
             if(nums[left]<nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                } else {
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                } else {
                    right=mid-1;
                }
            } else {
                left++;
            }    
    
        }
        return -1;
    }


    public static void main(String args[]){
        RotatedBinarySearch rotatedBinarySearch = new RotatedBinarySearch();
        int[] arr = new int[]{3,4,5,1,2};
        int index = rotatedBinarySearch.pivotedBinarySearch(arr, arr.length, 5);
        if(index == -1){
            System.out.println("Not found!");
        }else{
            System.out.println("Found:"+ arr[index]);
        }

    }
}
