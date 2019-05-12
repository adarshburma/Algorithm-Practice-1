/*
Eg:
i/p:
{
  {0,1,0,1,0},
  {0,0,1,1,1},
  {1,0,0,1,0},
  {1,0,1,0,1}
}

o/p: 5 (number of islands)

*/

package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.Stack;

public class CountIslands {
    static int rows = 0;
    static int cols = 0;

    static class Point{
        int x;
        int y;

        Point(int i, int j){
            x = i;
            y = j;
        }
    }

    static int countIslands(int[][] mat){
        rows = mat.length;
        cols = mat[0].length;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        ArrayList<Integer> sizes = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(!visited[i][j] && mat[i][j] == 1){
                    count++;
                    sizes.add(dfs(mat,i,j,visited));
                }
            }
        }

        System.out.println("sizes : " + sizes);
        return count;
    }

    static boolean isValid(int i, int j, boolean[][] visited, int[][] mat){
        return i >=0 && i < rows && j >= 0 && j < cols && !visited[i][j] && mat[i][j] == 1;
    }

    static int dfs(int[][] mat, int i, int j, boolean[][] visited) {
        int size = 0;
        Stack<Point> st = new Stack<>();
        visited[i][j] = true;
        st.push(new Point(i, j));
        while(!st.isEmpty()){
            Point poped = st.pop();
            int px = poped.x;
            int py = poped.y;

            size++;

            if(isValid(px+1, py, visited, mat)) {
                visited[px+1][py] = true;
                st.push(new Point(px+1, py));
            }

            if(isValid(px-1, py, visited, mat)){
                visited[px-1][py] = true;
                st.push(new Point(px-1, py));
            }

            if(isValid(px, py+1, visited, mat)){
                visited[px][py+1] = true;
                st.push(new Point(px, py+1));
            }

            if(isValid(px, py-1, visited, mat)){
                visited[px][py-1] = true;
                st.push(new Point(px, py-1));
            }
        }

        return size;
    }

    public static void main(String[] args){
        int[][] mat = {
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(countIslands(mat));
    }
}
