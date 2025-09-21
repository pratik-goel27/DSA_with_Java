package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
public class Dist_of_Nearest_One {
    static class Pair {
        int first;
        int second;
        int dist;

        Pair(int first, int second, int dist) {
            this.first = first;
            this.second = second;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0}, {1,1,0,0}, {0,0,1,1}};
        System.out.println(Arrays.deepToString(nearest(grid)));
    }

    public static int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int dist = q.peek().dist;
            q.poll();
            ans[row][col] = dist;

            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( (nrow >= 0 && nrow < m) && (ncol >= 0 && ncol < n)
                    && !vis[nrow][ncol])
                {
                    vis[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol, dist+1));
                }
            }
        }
        return ans;
    }
}
