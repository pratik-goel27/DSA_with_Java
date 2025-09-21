package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    static class Pair {
        int first;
        int second;
        int time;

        public Pair(int first, int second, int time) {
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        //initially adding all the rotten oranges into the queue.
        int cntfresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) { //if the orange is rotten add it into the queue and mark it as visited.
                    vis[i][j] = 2;
                    q.offer(new Pair(i, j, 0));
                }else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntfresh++;
            }
        }
        //now going with the algo of bfs.
        int tm = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int count = 0;
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().time;
            tm = Math.max(time, tm);
            q.poll();

            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( (nrow >= 0 && nrow < m) && (ncol >= 0 && ncol < n)
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    vis[nrow][ncol] = 2;
                    count++;
                    q.offer(new Pair(nrow, ncol, time+1));
                }
            }
        }
        if(cntfresh != count) return -1;
        return tm;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));
    }
}
