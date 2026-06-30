package Arrays;

public class Search_in_2D_Matrix {
    public static boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length-1;

        while(low <= high) {
            int mid = (low+high) / 2;
            if(row[mid] == target) return true;
            else if(row[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //BRUTE FORCE APPROACH :-
        int n = matrix.length;
        int m = matrix[0].length;
        //BRUTE FORCE APPROACH :- (Linear Search)
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(matrix[i][j] == target) return true;
//            }
//        }
//
//        return false;

        //BRUTE FORCE :-(Binary Search in row where the element exists)
//        for(int i = 0; i < n; i++) {
//            if(matrix[i][0] <= target && target <= matrix[i][m-1]) {
//                return binarySearch(matrix[i], target);
//            }
//        }
//
//        return false;


        //Optimal Solution for Strictly Sorted array and better solution for the other variety:-
//        int i = 0, j = m-1;
//        while(i < n && j >= 0) {
//            if(matrix[i][j] == target) return true;
//            if(matrix[i][j] > target) {
//                j--;
//            }else {
//                i++;
//            }
//        }
//
//        return false;

        //Optimal Solution when matrix is 1D sorted :-
        int low = 0;
        int high = (n * m) - 1;
        while(low <= high) {
            int mid = (low + (high - low) / 2);
            if(matrix[mid/m][mid%m] == target) return true;
            else if(matrix[mid/m][mid%m] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        //This is a sorted 1D array stored in 2D form.
        int[][] matrix = {{1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));

        //row wise and column wise sorted but not 1D sorted.
//        int[][] matrix = {{10,20,30,40},
//                            {11,21,36,43},
//                            {25,29,39,50},
//                            {50,60,70,80}};
//        System.out.println(searchMatrix(matrix, 42));

    }
}
