package com.iheartmedia.salesforce.config.handler;

import java.util.ArrayList;
import java.util.HashSet;

public class SudokuValidator {

    public static boolean isValid(int[][] board){
        if(!isvalidRowsCols(board)){
            return false;
        }

        if(!isValidBlock(board)){
            return false;
        }

        return true;
    }

    public static boolean isvalidRowsCols(int[][] board){
        ArrayList<HashSet<Integer>> rowsList = new ArrayList<>();
        ArrayList<HashSet<Integer>> colsList = new ArrayList<>();

        for(int i = 0 ; i < board.length; i++){
            rowsList.add(new HashSet<>());
        }

        for(int i = 0 ; i< board[0].length; i++){
            colsList.add(new HashSet<>());
        }

        for(int i=0 ; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==-1){
                    continue;
                }
                if(board[i][j] < 1 || board[i][j] > 9){
                    return false;
                }

                if(!rowsList.get(i).contains(board[i][j])){
                    rowsList.get(i).add(board[i][j]);
                }else{
                    return false;
                }

                if(!colsList.get(j).contains(board[i][j])){
                    colsList.get(j).add(board[i][j]);
                } else{
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidBlock(int[][] board){
        ArrayList<HashSet<Integer>> blocksList = new ArrayList<>();
        for(int i = 0 ; i< 9; i++){
            blocksList.add(new HashSet<>());
        }
        for(int rowBlock = 0 ; rowBlock < 3; rowBlock++){
            for(int colBlock = 0 ; colBlock <  3; colBlock++){
                for(int miniRow = 0 ; miniRow < 3; miniRow++){
                    for(int miniCol = 0 ; miniCol < 3; miniCol++){
                        int row = rowBlock * 3 + miniRow;
                        int col = colBlock * 3 + miniCol;

                        if(board[row][col] == -1){
                            continue;
                        }

                        if(board[row][col] < 1 || board[row][col] > 9){
                            return false;
                        }

                        int blockNumber = rowBlock * 3 + colBlock;

                        if(!blocksList.get(blockNumber).contains(board[row][col])){
                            blocksList.get(blockNumber).add(board[row][col]);
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int[][] board = new int[][] {
                {-1, -1, -1, -1, -1,  1, -1,  9, -1},
                { 1, -1, -1, -1, -1, -1,  2, -1,  3},
                { 2, -1,  3, -1, -1, -1, -1,  7, -1},

                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 3, -1, -1, -1,  7, -1,  4, -1,  5},
                { 4, -1,  5, -1, -1,  2, -1,  8, -1},

                {-1, -1, -1, -1, -1, -1, -1,  4, -1},
                { 5, -1, -1, -1, -1, -1,  6, -1,  7},
                { 6, -1,  7, -1, -1, -1, -1,  5, -1},
        };

        System.out.println("Is board valid: " + isValid(board));

    }
}
