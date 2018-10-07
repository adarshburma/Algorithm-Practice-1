class WordSearch {
    
    public boolean dfs(String str, int i, int j, int k, char[][] board){
        int m = board.length;
        int n = board[0].length;
        
        if(i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }
        
        if(board[i][j] == str.charAt(k)){
            char temp = board[i][j];
            board[i][j] = '#';
            if(k == str.length()-1){
                return true;
            } else if( dfs(str,i+1, j , k+1, board) ||
                     dfs(str,i, j+1 , k+1, board) ||
                     dfs(str,i-1, j , k+1, board) ||
                     dfs(str,i, j-1 , k+1, board)){
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(dfs(word, i, j, 0, board)){
                    return true;
                }
            }
        }
        return false;
    }
}
