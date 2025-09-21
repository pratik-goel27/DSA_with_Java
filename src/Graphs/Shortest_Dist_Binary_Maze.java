// User function Template for Java
package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Dist_Binary_Maze {
    static class Pair {
        int first;
        int second;
        int third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        //condition for blocked src or dest :-
         if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
             return -1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, source[0], source[1]));
        int[][] dst = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dst[i][j] = (int)1e9;
            }
        }
        dst[source[0]][source[1]] = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()) {
            int dist = q.peek().first;
            int ro = q.peek().second;
            int co = q.peek().third;
            q.poll();
            if(ro == destination[0] && co == destination[1]) return dist;

            for(int i = 0; i < 4; i++) {
                int nrow = ro + delrow[i];
                int ncol = co + delcol[i];

                if((nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) &&
                        (grid[nrow][ncol] == 1) && (dist + 1 < dst[nrow][ncol]))
                {
                    dst[nrow][ncol] = dist + 1;
                    q.offer(new Pair(dist + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};

        int[] source = {0, 1};
        int[] destination = {2, 2};

        System.out.println(shortestPath(grid, source, destination));
    }
}
