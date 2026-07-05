package Arrays;

import java.util.Arrays;

public class Set_Matrix_Zero {

    //BRUTE FORCE :-
    //THIS CODE FAILS WHEN THE MATRIX CONSTRAINT IS :- (-231 <= matrix[i][j] <= 231 - 1)
//    public static void markRow(int[][] matrix, int i) {
//        for(int j = 0; j < matrix[0].length; j++) {
//            if(matrix[i][j] != 0) {
//                matrix[i][j] = Integer.MIN_VALUE;
//            }
//        }
//    }
//
//    public static void markCol(int[][] matrix, int j) {
//        for(int i = 0; i < matrix.length; i++) {
//            if(matrix[i][j] != 0) {
//                matrix[i][j] = Integer.MIN_VALUE;
//            }
//        }
//    }
//
//    public static void setZeroes(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(matrix[i][j] == 0) {
//                    markRow(matrix, i);
//                    markCol(matrix, j);
//                }
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(matrix[i][j] == Integer.MIN_VALUE) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //BETTER SOLUTION :- SC : O(n + m)
//        int[] row = new int[n];
//        int[] col = new int[m];
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(matrix[i][j] == 0) {
//                    row[i] = 1;
//                    col[j] = 1;
//                }
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(row[i] == 1 || col[j] == 1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }

        //OPTIMAL SOLUTION :- Reducing the SC.
//        int[] row = new int[n];  -> matrix[..][0]
//        int[] col = new int[m];  -> matrix[0][..]

        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //mark the i-th row
                    matrix[i][0] = 0;
                    //mark the j-th col
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) for(int j = 0; j < m; j++) matrix[0][j] = 0;
        if(col0 == 0) for(int i = 0; i < n; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
