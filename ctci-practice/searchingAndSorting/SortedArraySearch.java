package org.practice.courses.courseapi;

public class SortedArraySearch {

    static Coordinate findElement(int[][] mat, int key, Coordinate origin, Coordinate dest){
        if(!origin.inBounds(mat) || !dest.inBounds(mat)){
            return null;
        }
        if(mat[origin.row][origin.col] == key){
            return origin;
        } else if(!origin.isBefore(dest)){
            return null;
        }
        Coordinate start = origin.cloneCoordinate();
        int diagDist = Math.min(dest.row - origin.row, dest.col - origin.col);
        Coordinate end = new Coordinate(start.row + diagDist, start.col + diagDist);
        Coordinate mid = new Coordinate(0,0);

        while(start.isBefore(end)){
            mid.setAverage(start,end);
            if(mat[mid.row][mid.col] < key){
                start.row = start.row+1;
                start.col = start.col+1;
            }else{
                end.row = end.row-1;
                end.col = end.col-1;
            }
        }

        return partition(mat, key, origin, dest, start);
    }

    static Coordinate partition(int[][] mat, int key, Coordinate origin, Coordinate dest, Coordinate pivot){
        Coordinate bottomLeftOrigin = new Coordinate(pivot.row, origin.col);
        Coordinate bottomLeftDest = new Coordinate(dest.row, pivot.col -1);
        Coordinate topRightOrigin = new Coordinate(origin.row, pivot.col);
        Coordinate topRightDest = new Coordinate(pivot.row -1, dest.col);

        Coordinate left = findElement(mat, key, bottomLeftOrigin, bottomLeftDest);
        if(left == null){
            return findElement(mat, key, topRightOrigin, topRightDest);
        } else {
            return left;
        }
    }

    static Coordinate findElement(int[][] mat, int key){
        Coordinate origin = new Coordinate(0,0);
        Coordinate dest = new Coordinate(mat.length-1, mat[0].length-1);
        return findElement(mat, key, origin, dest);
    }

    static class Coordinate {
         int row;
         int col;

         Coordinate(int row, int col){
             this.row = row;
             this.col = col;
         }

         boolean inBounds(int[][] mat){
             return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
         }

         boolean isBefore(Coordinate dest){
             return row <= dest.row && col <= dest.col;
         }

         void setAverage(Coordinate origin, Coordinate dest){
             row = (origin.row + dest.row)/2;
             col = (origin.col + dest.col)/2;
         }

         Coordinate cloneCoordinate(){
            return new Coordinate(row, col);
         }
    }

    public static void main(String args[]){
        int[][] mat = {
                {15,20,70, 85},
                {20,35,80,95},
                {30, 55, 90,105}
        };

        Coordinate res = findElement(mat, 35);

        System.out.print(res.row + ", "+ res.col);

    }
}
