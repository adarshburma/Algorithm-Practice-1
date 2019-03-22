/*
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while( i < n){
            if(stack.isEmpty() || A.get(i) >= A.get(stack.peek())){
                stack.push(i++);
            } else {
                int height = A.get(stack.pop());
                int area = height * (stack.isEmpty()?i:(i-stack.peek()-1));
                if(area > max){
                    max = area;
                }
            }
        }
        
        while(!stack.isEmpty()){
             int height = A.get(stack.pop());
                int area = height * (stack.isEmpty()?i:(i-stack.peek()-1));
                if(area > max){
                    max = area;
                }
        }
        
        return max;
    }
}
