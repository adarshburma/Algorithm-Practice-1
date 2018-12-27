package org.practice.courses.courseapi.practice12;

public class BooleanMatrix {

    static void matrixConversion(boolean[][] input){
        boolean zeroRow = false;
        boolean zeroCol = false;

        for (boolean i : input[0]) {
            if(i){
                zeroRow = true;
                break;
            }
        }

        for( int i =0 ; i < input.length; i++){
            if(input[i][0]){
                zeroCol = true;
                break;
            }
        }

        for(int i = 1; i < input.length; i++){
            for(int j = 1; j < input[0].length; j++){
                if(input[i][j]){
                    input[0][j] = true;
                    input[i][0] = true;
                }
            }
        }

        for(int i = 1; i < input.length; i++){
            if(input[i][0]){
                for(int j = 1 ; j < input[i].length; j++) {
                    input[i][j] = true;
                }
            }
        }

        for(int i = 1; i < input[0].length; i++){
            if(input[0][i]){
                for(int j = 1; j < input.length; j++){
                    input[j][i] = true;
                }
            }
        }

        if(zeroRow){
            for(int i = 0; i < input[0].length; i++){
                input[0][i] = true;
            }
        }

        if(zeroCol){
            for(int i = 0 ; i < input.length; i++){
                input[i][0] = true;
            }
        }
    }

    public static void zeroMatrix(boolean[][] matrix) {

        // Verify the input array is nonzero
        if (matrix.length == 0 || matrix[0].length == 0) return;

        // Determine whether the first row or first column is true
        boolean rowZero = false, colZero = false;
        for (boolean i : matrix[0]) {
            rowZero |= i;
        }
        for (boolean[] i : matrix) {
            colZero |= i[0];
        }

        // For each cell not in the first row/column, if it is true, set the
        // cell in the first row/same column and first column/same row to be
        // true
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    matrix[i][0] = true;
                    matrix[0][j] = true;
                }
            }
        }

        // Go through the first column and set each row to true where cell in
        // the first column is true
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = true;
                }
            }
        }

        // Repeat for the rows
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = true;
                }
            }
        }

        // Set first row/column to true if necessary
        if (rowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = true;
            }
        }

        if (colZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = true;
            }
        }
    }

    public static void main(String[] args){
        boolean[][] input = {   {true, false , false},
                                {false, false, false},
                                {false, false, false}
                            };

        matrixConversion(input);


        for(int i = 0 ; i < input.length; i++){
            for(int j = 0; j < input[0].length; j++){
                System.out.print(" " + input[i][j]);
            }
            System.out.println();
        }
    }
}
