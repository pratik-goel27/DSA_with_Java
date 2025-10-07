package Arrays.Medium;

import java.util.Arrays;

public class Set_Matrix_Zero {

    //BRUTE FORCE :-
    //THIS CODE FAILS WHEN THE MATRIX CONSTRAINT IS :- (-231 <= matrix[i][j] <= 231 - 1)
//    public static void markRow(int[][] matrix, int i) {
//        for(int j = 0; j < matrix[0].length; j++) {
//            if(matrix[i][j] == 1) {
//                matrix[i][j] = Integer.MIN_VALUE;
//            }
//        }
//    }
//
//    public static void markCol(int[][] matrix, int j) {
//        for(int i = 0; i < matrix.length; i++) {
//            if(matrix[i][j] == 1) {
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

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[i] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
