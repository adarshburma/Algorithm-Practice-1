package org.practice.courses.courseapi.practice12;

public class MatrixSearch {
    static boolean matrixSearch(int[][] matrix, int key){
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(key == matrix[row][col]) return true;
            if(key > matrix[row][col]) row++;
            else col--;
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.print("Search element:" + matrixSearch(matrix, -1));
    }
}
