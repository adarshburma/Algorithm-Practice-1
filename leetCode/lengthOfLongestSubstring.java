class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0,j = 0,ans = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
