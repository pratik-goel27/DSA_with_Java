package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n-1;
        int left = 0, right = m-1;
        List<Integer> ans = new ArrayList<>();


        while(left <= right && top <= bottom) {
            //right
            for(int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            //bottom
            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            //left
            if(top <= bottom) {
                for(int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            //top
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {12,13,14,5},{11,16,15,6},{10,9,8,7}};

        System.out.println(spiralOrder(matrix));
    }
}

