/*

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/


class Solution {
  
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) 
            return 0;
 
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 1 ; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            } 
        }
        
        for(int j = 1 ; j < n ; j++){
            if(obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
            }else {
                dp[0][j] = dp[0][j-1];
            }
        }
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
