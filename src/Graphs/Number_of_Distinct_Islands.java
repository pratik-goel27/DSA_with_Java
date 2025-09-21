package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class Number_of_Distinct_Islands {

    public static void dfs(int row, int col, int n, int m, int row0, int col0, boolean[][] vis,
    int[][] grid, int[] delrow, int [] delcol, ArrayList<String> list)
    {
        vis[row][col] = true;
        list.add(toString(row - row0, col - col0));

        for(int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if((nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) &&
              (grid[nrow][ncol] == 1) && !vis[nrow][ncol])
            {
                dfs(nrow, ncol, n, m, row0, col0, vis, grid, delrow, delcol, list);
            }
        }
    }

    public static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, n, m, i, j, vis, grid, delrow, delcol, list);
                    st.add(list);
                }
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(countDistinctIslands(grid));
    }
}