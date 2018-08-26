public class NQueens {
    
   class Position{
       int row;
       int col;
       
       public Position(int row, int col){
           this.row = row;
           this.col = col;
       }
   }
   
   public Position[] solveNQueens(int n){
       Position[] positions = new Position[n];
       boolean hasSolution = solveNQueensUtil(n,0,positions);
       if(hasSolution){
           return positions;
       }else{
           return new Position[0];
       }
       
   }
   
   
   boolean solveNQueensUtil(int n, int row, Position[] positions){
       if(n == row){
           return true;
       }
   
       int col;
       for(col = 0; col < n ; col++){
           boolean foundSafe = true;
           for(int queen = 0 ; queen < row; queen++){
               if(positions[queen].col == col || positions[queen].row + positions[queen].col == row + col || positions[queen].row - positions[queen].col == row - col){
                   foundSafe = false;
                   break;
               }
           }
           if(foundSafe){
                positions[row] = new Position(row,col);
                if(solveNQueensUtil(n,row+1,positions)){
                    return true;
                }
            }
       }
     
       return false;
   }
    
    public static void main(String args[]) {
        MyClass my = new MyClass();
        int n = 4;
        Position[] position = my.solveNQueens(n);
        for(int i = 0 ; i<n ; i++){
            System.out.println("row: " + position[i].row + " col: "+ position[i].col);
        }
      
    }
}
