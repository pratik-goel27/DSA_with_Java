package Arrays;

import java.util.Arrays;

public class Sort_0s_1s_2s {
    public static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};

        //BRUTE FORCE SOLUTION:- (or use any sorting technique).
//        int k = 0;
//        for(int i = 0; i <= 2; i++) {
//            for(int j = 0; j < arr.length; j++) {
//                if(arr[j] == i) {
//                    int temp = arr[j];
//                    arr[j] = arr[k];
//                    arr[k] = temp;
//                    k++;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

        //BETTER SOLUTION:-
//        int count0 = 0 , count1 = 0, count2 = 0;
//
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] == 0) count0++;
//            else if(arr[i] == 1) count1++;
//            else count2++;
//        }
//
//        for(int i = 0; i < count0; i++) arr[i] = 0;
//        for(int i = count0; i < count0+count1; i++) arr[i] = 1;
//        for(int i = count1+count0; i < arr.length; i++) arr[i] = 2;
//
//        System.out.println(Arrays.toString(arr));

        //OPTIMAL SOLUTION:-
        int low = 0, mid = 0, high = arr.length-1;

        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            } else if(arr[mid] == 1) mid++;
            else {
                swap(mid, high, arr);
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}