class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = findMinimumDistance(word1, word2);
        return dp[m][n];
        
    }
    

    public static int[][] findMinimumDistance(String word1, String word2){
        int m = word1.length()+1;
        int n = word2.length()+1;

        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){

                if(i == 0){
                    dp[i][j] = j;
                }

                else if(j == 0){
                    dp[i][j] = i;
                }

                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Math.min(1 + dp[i-1][j-1],
                            Math.min(1 + dp[i-1][j], 1+ dp[i][j-1]));
                }
            }
        }

        return dp;
    }
}
