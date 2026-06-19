package Arrays;

import java.util.Arrays;

public class Rotate_Image {
    public static void rotate(int[][] matrix) {
        //BRUTE FORCE SOLN :-
//        int n = matrix.length;
//        int[][] ans = new int[n][n];
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                ans[j][(n-1)-i] = matrix[i][j];
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                matrix[i][j] = ans[i][j];
//            }
//        }

        //OPTIMAL SOLUTION :-
        int n = matrix.length;
        //transpose :-
        for(int i = 0; i <= n-2; i++) {
            for(int j = i+1; j <= n-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse :-
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            // Swap elements from both ends moving toward center
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
