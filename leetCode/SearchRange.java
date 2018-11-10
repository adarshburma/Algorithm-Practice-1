/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = 0;
        int end = 0;
        while(left <= right){
            int mid= (left + right)/2;
            if(nums[mid] == target){
                start = mid;
                end = mid;
                for(int i = mid ; i >= 0; i--){
                    if(nums[i] != target){
                        start = i+1;
                        break;
                    }
                }
                
                if(nums[0] == target){
                    start = 0;
                }
                
                for(int i = mid ; i <= nums.length-1; i++){
                    if(nums[i] != target){
                        end = i-1;
                        break;
                    }
                }
                
                if(nums[nums.length-1] == target){
                    end = nums.length-1;
                }
                return new int[] {start, end};
            }
            
            if(nums[mid] > target){
                right = mid-1;
            } else if(nums[mid] < target){
                left = mid+1;
            } else {
                left++;
            }
            
        }
        
        return new int[]{-1,-1};
          
    }
}
