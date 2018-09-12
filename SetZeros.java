class SetZeros {
    public void setZeroes(int[][] matrix) {
        boolean firstrow = false;
        boolean firstcol = false;
        
        for(int i = 0 ; i < matrix[0].length; i++){
            if(matrix[0][i] == 0 ){
                firstrow = true;
                break;
            }
        }
        
         for(int i = 0 ; i < matrix.length; i++){
            if(matrix[i][0] == 0 ){
                firstcol = true;
                break;
            }
        }
        
        for(int i = 1 ; i < matrix.length; i++){
            for(int j = 1 ; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0 ;
                    matrix[0][j] = 0 ;
                }
            }
        }    
        
        for(int i = 1 ; i < matrix.length; i++){
            for(int j = 1 ; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
            
       if(firstrow){
           for(int i = 0 ; i < matrix[0].length; i++){
               matrix[0][i] = 0;
           }
       }
        
        if(firstcol){
            for(int i = 0 ; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
    
}
