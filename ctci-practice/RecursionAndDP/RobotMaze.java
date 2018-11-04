package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.HashSet;

/*
*
* Searching right and below ....
*
* */
public class RobotMaze {
    static class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static ArrayList<Point> getPath(boolean[][] maze) {
        if(maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if(getPath(maze, 0, 0, path)){
            return path;
        }

        return null;
    }

    static boolean getPath(boolean[][] maze, int row, int col , ArrayList<Point> path){
        if(row > maze.length-1 || col > maze[0].length-1 || !maze[row][col]){
            return false;
        }

        boolean isDestination  = (row == maze.length-1) && (col == maze[0].length-1);
        if(isDestination || getPath(maze, row+1, col , path) || getPath(maze, row, col+1, path)){
            Point p = new Point(row,col);
            path.add(p);
            return true;
        }
        return false;
    }

    /*
    * Optimizing solution by returning when visiting already failed points
    *
    * */

    static ArrayList<Point> mazeFinder(boolean[][] maze){
        if(maze == null || maze.length == 0){
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failed = new HashSet<>();
        if(mazeFinderHelper(maze, maze.length-1, maze[0].length-1, path, failed)){
            return path;
        }

        return null;
    }

    static boolean mazeFinderHelper(boolean[][] maze, int row, int col,
                                    ArrayList<Point> path, HashSet<Point> failed) {
        if(row < 0 || col < 0 || !maze[row][col]){
            return false;
        }

        Point p = new Point(row, col);

        if(failed.contains(p)) {
            return false;
        }

        boolean isOrigin = (row == 0) && (col == 0);
        if(isOrigin || mazeFinderHelper(maze, row -1, col, path, failed)
                || mazeFinderHelper(maze, row, col -1, path, failed)){
            Point p1 = new Point(row, col);
            path.add(p);
            return true;
        }

        failed.add(p);
        return false;
    }

    public static void main(String[] args){
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {false, true, false},
                {false, true, true}
        };
        for(Point point : mazeFinder(maze)){
            if(point != null){
                System.out.println(" row : " + point.row + " col : " + point.col);
            }
        }
    }
}
