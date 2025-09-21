package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Enclaves {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        //checking for the boundary of the grid:-
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(i == 0 || i == m-1 || j == 0 || j == n-1) {
                    if(grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.offer(new Pair(i, j));
                    }
                }
            }
        }

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( (nrow >= 0 && nrow < m) && (ncol >= 0 && ncol < n)
                        && (grid[nrow][ncol] == 1) && !vis[nrow][ncol])
                {
                    vis[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}


