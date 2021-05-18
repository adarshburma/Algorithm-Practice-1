/* https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/ */

public int minDeletions(String str) {
        //map to hold original counts atmost O(26) constant space
        HashMap<Character, Integer> count = new HashMap<>();
        
        // minimum number of deletions
        int deletions = 0;
        
        // set contains only unique counts
        HashSet<Integer> set = new HashSet<>();
        
        // capture originak counts
        for(char c : str.toCharArray()) {
             count.put(c, count.getOrDefault(c, 0)+1);
        }
        
       // loop through entries 
        for(Map.Entry<Character,Integer> e : count.entrySet()) {
            int val = e.getValue();
            
            // delete character until its count doesn't match any counts until then
            while(val > 0 && set.contains(val)) {
                deletions++;
                val--;
            }
            
            // add count val only if its > 0
            if(val > 0) {
                set.add(val);
            }
        }
        
        // return deletions
        return deletions;
    }
    
    // Time : O(len(s))
    // Space: O(26) - constant
