package Graphs;
import java.util.Arrays;

public class Replace_Os_with_Xs {
    public static void dfs(int ro, int co, boolean[][] vis, char[][] board, int[] delrow, int[] delcol, int m, int n) {
        vis[ro][co] = true;

        for(int i = 0; i < 4; i++) {
            int nrow = ro + delrow[i];
            int ncol = co + delcol[i];
            if( (nrow >= 0 && nrow < m) && (ncol >= 0 && ncol < n) &&
                (board[nrow][ncol] == 'O') && !vis[nrow][ncol])
            {
                dfs(nrow, ncol, vis, board, delrow, delcol, m, n);
            }
        }
    }

    public static char[][] solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        //checking for the boundary:-
        //traversing to the first and the last row:-
        for(int j = 0; j < n; j++) {
            if(board[0][j]  == 'O' && !vis[0][j]) {
                dfs(0, j, vis, board, delrow, delcol, m, n);
            }
            if(board[m-1][j] == 'O' && !vis[m-1][j]) {
                dfs(m-1, j, vis, board, delrow, delcol, m, n);
            }
        }

        //traversing to the first and the last column:-
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, vis, board, delrow, delcol, m, n);
            }
            if(board[i][n-1] == 'O' && !vis[i][n-1]) {
                dfs(i, n-1, vis, board, delrow, delcol, m, n);
            }
        }

        //changing all the remaining O's to X's:-
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        System.out.println(Arrays.deepToString(solve(board)));
    }
}