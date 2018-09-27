package org.practice.courses.courseapi;


public class ZeroMatrix {
    static int[][] arr;
    static void nullifyRow(int[][] arr, int row){
        for (int i = 0 ; i < arr[0].length; i++){
            arr[row][i] = 0;
        }
    }

    static void nullifyCol(int[][] arr, int col){
        for(int i = 0; i < arr.length; i++){
            arr[i][col] = 0;
        }
    }
    static int[][] makeZero(int[][] arr){
        boolean rowZero = false;
        boolean colZero = false;

        // first row zero
        for(int i=0; i< arr.length; i++){
            if(arr[i][0] == 0){
                rowZero = true;
            }
        }

        //first col zero
        for(int j = 0 ; j < arr[0].length; j++){
            if(arr[0][j] == 0){
                colZero = true;
            }
        }

        for(int i= 1 ; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] == 0){
                nullifyRow(arr, i);
            }
        }

        for(int j = 1; j < arr[0].length; j++){
            if(arr[0][j] == 0){
                nullifyCol(arr, j);
            }
        }

        if(rowZero){
            nullifyRow(arr, 0);
        }

        if(colZero) {
            nullifyCol(arr, 0);
        }

        return arr;
    }

    static void print(){
        for (int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        arr = new int[][] {{0,1,1},{1,2,3},{1,3,0}};
        makeZero(arr);
        print();

    }
}
