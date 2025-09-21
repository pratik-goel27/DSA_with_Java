package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int countIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 'L') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    public static void bfs(int ro, int co, boolean[][] visited, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        visited[ro][co] = true;
        q.add(new Pair(ro, co));
        int m = grid.length;
        int n = grid[0].length;

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int delrow = -1; delrow <= 1; delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if((nrow >= 0 && nrow < m) && (ncol >= 0 && ncol < n)
                        && !visited[nrow][ncol] && grid[nrow][ncol] == 'L')
                    {
                        visited[nrow][ncol] = true;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = { {'L', 'L', 'W', 'W', 'W'}, {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'}, {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'} };

        System.out.println(countIslands(grid));
    }
}
