package org.practice.courses.courseapi.practice12;

public class SizeSubMatrix {

    static int subSize(int[][] matrix) {
        int x = matrix.length;
        if(x == 0) return 0;
        int y = matrix[0].length;
        if(y == 0) return 0;
        int max = 0;
        int[][] sizes = new int[x][y];
        for(int i = 0 ; i < x; i++){
            for(int j = 0; j < y; j++){
              if(i == 0 || j == 0){
                  sizes[i][j] = matrix[i][j];
              } else if(matrix[i][j] == 1){
                  sizes[i][j] = Math.min(Math.min(sizes[i-1][j], sizes[i][j-1]), sizes[i-1][j-1]) + 1;
              }

                max = Math.max(max, sizes[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        };

        System.out.print("Max size : " + subSize(matrix));
    }
}
