class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        
        if(s.length() == 1){
            return s;
        }
        
        String longest = s.substring(0,1);
        String temp="";
        for(int i = 0 ; i < s.length(); i++){
            temp = helper(s,i,i);
            if(temp.length() > longest.length()){
                longest = temp;
            }
            
            temp = helper(s,i, i+1);
            if(temp.length() > longest.length()){
                longest = temp;
            }
        }
        
        return longest; 
    }  
    
    String helper(String s, int begin, int end){
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        
        return s.substring(begin+1, end);
    }
}
