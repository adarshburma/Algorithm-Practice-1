/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

*/

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        char[] sArray = s.toCharArray();
        for(int i = 0 ; i < sArray.length; i++){
            if(sArray[i] == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    res = Math.max(i - stack.peek(), res);
                } else {
                    stack.push(i);
                }
            }
        }
        
        return res;
    }
}
