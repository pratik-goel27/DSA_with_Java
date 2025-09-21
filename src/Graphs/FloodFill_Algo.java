package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class FloodFill_Algo {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{2,2,0},{2,2,2} };
        int sr = 2, sc = 0, color = 3;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];

        bfs(sr, sc, image, color, initColor);

        return image;
    }

    public static void bfs(int sr, int sc, int[][] image, int color, int initColor) {
        Queue<Pair> q = new LinkedList<>();
        image[sr][sc] = color;
        q.offer(new Pair(sr,sc));
        int m = image.length;
        int n = image[0].length;
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
                    && image[nrow][ncol] == initColor && image[nrow][ncol] != color)
                {
                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
}

