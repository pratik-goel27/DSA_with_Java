package Arrays.Easy;

import java.util.Arrays;

public class LeftRotate_By_Kth_Places {
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

        //BRUTE FORCE SOLUTION:-
//        int n = arr.length;
//        int d = 3;
//        d %= arr.length;
//
//        int[] temp = new int[d];
//        for(int i = 0; i < d; i++) {
//            temp[i] = arr[i];
//        }
//
//        for(int i = d; i < arr.length; i++) {
//            arr[i-d] = arr[i];
//        }
//
//        for(int i = n-d; i < arr.length; i++){
//            arr[i] = temp[i-(n-d)];
//        }
//
//        System.out.println(Arrays.toString(arr));

        //OPTIMAL SOLUTION:-
        int n = arr.length;
        int d = 3;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
}