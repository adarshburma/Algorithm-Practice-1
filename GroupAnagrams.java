class Solution {
    
    public HashMap<String, List<String>> groupAnagramsHelper(String[] input){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : input){
            char[] str_c = str.toCharArray();
            Arrays.sort(str_c);
            String str_k = new String(str_c);

            if(!map.containsKey(str_k)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str_k, list);
            }else{
                map.get(str_k).add(str);
                map.put(str_k, map.get(str_k));
            }
        }

        return map;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
       List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = groupAnagramsHelper(strs);
        for(HashMap.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;

    }
}
