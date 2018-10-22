class Solution {
    public int trap(int[] height) {
        int fill = 0;
        
        if(height.length == 0 || height.length <= 2) {
            return fill;
        }
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int max= height[0];
        left[0] = height[0];
        for(int i = 1 ; i < height.length; i++){
            if(height[i] < max){
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }
        
        max = height[height.length-1];
        right[height.length-1] = height[height.length-1]; 
        for(int i = height.length-2; i >= 0; i--){
            if(height[i] < max){
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }
        
        for(int i = 0 ; i < height.length; i++){
            fill += Math.min(left[i], right[i]) - height[i];
        }
        
        return fill;
    }
}
