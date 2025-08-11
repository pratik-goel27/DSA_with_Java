package Arrays.Easy;

import java.util.Arrays;

public class RightRotate_Array_By_K_Places {

    public static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int d = 10;
        int n = arr.length;
        d = d % n;

        //BRUTE FORCE:-
//        int[] temp = new int[d];
//        for(int i = n-d; i < n; i++) {
//            temp[i-(n-d)] = arr[i];
//        }
//
//        for(int i = n-d-1; i >= 0; i--) {
//            arr[i+d] = arr[i];
//        }
//
//        for(int i = 0; i < d; i++) {
//            arr[i] = temp[i];
//        }
//
//        System.out.println(Arrays.toString(arr));

        //OPTIMAL SOLUTION:-
        reverse(arr,n-d,n-1);
        reverse(arr,0,n-d-1);
        reverse(arr,0,n-1);

        System.out.println(Arrays.toString(arr));
    }
}