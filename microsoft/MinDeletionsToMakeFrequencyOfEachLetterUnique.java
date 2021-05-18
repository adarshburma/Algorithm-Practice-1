/* https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/ */

public int minDeletions(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        int deletions = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(char c : str.toCharArray()) {
            if(count.containsKey(c)) {
                count.put(c, count.get(c)+1);
            } else {
                count.put(c, 1);
            }
        }

        for(Map.Entry<Character,Integer> e : count.entrySet()) {
            int val = e.getValue();
            while(val > 0 && set.contains(val)) {
                deletions++;
                val--;
            }
            
            if(val > 0) {
                set.add(val);
            }
        }
        return deletions;
    }
}
