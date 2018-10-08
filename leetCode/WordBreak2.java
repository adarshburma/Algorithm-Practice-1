class WordBreak2 {
    void dfs(ArrayList<String>[] pos, ArrayList<String> result, String curr, int i){
        if( i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String str = s + " " + curr;
            dfs(pos,result, str, i-s.length());
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String>[] pos = new ArrayList[s.length()+1];
        pos[0] = new ArrayList<>();
        for(int i =0 ; i < s.length(); i++){
            if(pos[i] != null){
                for(int j = i+1; j <= s.length(); j++){

                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j] == null){
                            pos[j] = new ArrayList<>();
                            pos[j].add(sub);
                        }else{
                            pos[j].add(sub);
                        }
                    }
                }
            }
        }

        if(pos[s.length()] == null){
            return new ArrayList<String>();
        } else {
            ArrayList<String> result = new ArrayList<>();
            dfs(pos, result, " ", s.length());
            return result;
        }
    }
}
