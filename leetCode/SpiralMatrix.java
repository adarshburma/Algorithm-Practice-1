class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minRow = 0;
        int minCol = 0;
        int maxRow = rows-1;
        int maxCol = cols-1;
        int value = 1;
        while(value <= rows*cols){
            
            for(int i = minCol; i <= maxCol; i++){
                if(value++ > rows*cols){
                    break;
                }
                
                res.add(matrix[minRow][i]);
            }
            
            for(int i = minRow+1; i <= maxRow; i++){
                if(value++ > rows*cols){
                    break;
                }
                res.add(matrix[i][maxCol]);
            }
            
            for(int i = maxCol-1; i >= minCol; i--){
                if(value++ > rows*cols){
                    break;
                }
                res.add(matrix[maxRow][i]);
            }
            
             for(int i = maxRow-1; i >= minRow+1; i--){
                if(value++ > rows*cols){
                    break;
                }
                res.add(matrix[i][minCol]);
            }
            
            minRow++;
            minCol++;
            maxCol--;
            maxRow--;
        }
    
        return res;
    }
}
