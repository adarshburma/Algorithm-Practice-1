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
