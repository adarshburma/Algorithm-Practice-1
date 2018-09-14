package com.iheartmedia.salesforce.config.handler;

public class IslandProblem {

    public int countIslands(char[][] grid){
        int count = 0 ;
        for(int i = 0 ; i< grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    isIsland(grid, i , j);
                }
            }
        }
        return count;
    }

    public void isIsland(char[][] grid, int i, int j){
        if(i >= 0 && i <grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            isIsland(grid, i+1, j);
            isIsland(grid, i, j+1);
            isIsland(grid, i-1, j);
            isIsland(grid, i, j-1);
        }
    }

    public static void main(String args[]){
        char[][] grid = new char[][] {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
        IslandProblem islandProblem = new IslandProblem();
        System.out.print(islandProblem.countIslands(grid));
    }
}
