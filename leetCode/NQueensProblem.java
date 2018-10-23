package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    static List<List<String>> result = new ArrayList<>();
    static class Position{
        int row;
        int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static void SolveQueens(int n) {
        Position[] position = new Position[n];
        SolutionUtil(n, position, 0);
    }

    static void SolutionUtil(int n, Position[] position, int row){

        if(row == n){
            result.add(returnSolution(n, position));
            printSolution(n, position);
        }

        for(int col = 0 ; col < n; col++){
            boolean foundSafe = true;
            for(int queen = 0; queen < row; queen++){
                if(position[queen].col == col || position[queen].row + position[queen].col == row + col || position[queen].row - position[queen].col == row-col){
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe){
                position[row] = new Position(row, col);
                SolutionUtil(n, position, row+1);
            }
        }
    }

    static List<String> returnSolution(int n, Position[] positions){
        List<String> res = new ArrayList<>();
        for(int i=0 ; i < positions.length; i++) {
            Position position = positions[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                if(position.row == i && position.col == j){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    static void printSolution(int n, Position[] positions){

        for(int i=0 ; i < positions.length; i++) {
            Position position = positions[i];
            for(int j = 0 ; j < n ; j++){
                if(position.row == i && position.col == j){
                    System.out.print(" Q");
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int n = 1;
        SolveQueens(n);
        System.out.println(result);
    }
}
