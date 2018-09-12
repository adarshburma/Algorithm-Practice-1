package org.practice.courses.courseapi;

public class RotateMatrix {

    public boolean rotate(int[][] mat){
        if(mat.length != mat[0].length){
            return false;
        }

        int N= mat.length;

        for(int layer = 0 ; layer< N/2; layer++){
            int first = layer;
            int last = N-1-layer;

            for(int i = first ; i < last; i++){
                int offset = i - first;
                int top = mat[first][i];

                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[i][last];
                mat[i][last] = top;
            }
        }

        return true;
    }

    public boolean rotateMatrix(int[][] mat){
        if(mat.length != mat[0].length){
            return false;
        }
        int n = mat.length;
        for(int layer=0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first; i<last; i++){
                int offset = i - first;
                int top = mat[first][i];
                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[i][last];
                mat[i][last] = top;
            }
        }
        return true;
    }

    public void setZerosEfficient(int[][] mat){
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for(int i = 0 ; i < mat.length; i++){
            if(mat[i][0] == 0){
                nullifyRow(mat, i);
            }
        }

        for(int j = 0 ; j < mat[0].length; j++){
            if(mat[0][j] == 0 ){
                nullifyCol(mat,j);
            }
        }
    }



    public void setZeros(int[][] mat){
        boolean[] rows = new boolean[mat.length];
        boolean[] cols = new boolean[mat[0].length];

        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }


        for(int i = 0 ; i<rows.length; i++){
            if(rows[i]) nullifyRow(mat, i);
        }

        for(int j = 0 ; j< cols.length; j++){
            if(cols[j]) nullifyCol(mat, j);
        }
    }

    public void nullifyRow(int[][] mat, int row){
        for(int i = 0 ; i< mat[0].length; i++){
            mat[row][i] = 0;
        }
    }

    public void nullifyCol(int[][] mat, int col){
        for(int j = 0; j< mat.length; j++){
            mat[j][col] = 0;
        }
    }

    public static void main(String args[]){
        int[][] mat = new int[][] {{1,2,3,4}, {5,6,7,0}, {9,10,10,11}, {12,13,14,15}};
        RotateMatrix rotateMatrix = new RotateMatrix();
       // rotateMatrix.rotateMatrix(mat);
        rotateMatrix.rotateMatrix2(mat);

        for(int i= 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }

        rotateMatrix.setZerosEfficient(mat);
        System.out.println();

        for(int i= 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public boolean rotateMatrix2(int[][] mat){
        if(mat.length != mat[0].length){
            return false;
        }
        int n = mat.length;
        for(int layer = 0 ; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i< last; i++){
                int offset = i - first;
                int top = mat[first][i];
                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[i][last];
                mat[i][last] = top;
            }
        }

        return true;
    }
}
