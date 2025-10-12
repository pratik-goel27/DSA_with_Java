package Arrays.Medium;

import java.util.HashMap;

public class Largest_SubArray_with_0_Sum {
    public static int maxLength(int[] arr) {
        // int n = arr.length;
        // int sum = 0;
        // int len = 0;

        //BRUTE FORCE :-
        // for(int i = 0; i < n; i++) {
        //     for(int j = i+1; j < n; j++) {
        //         sum = 0;
        //         for(int k = i; k <= j; k++) {
        //             sum += arr[k];
        //         }
        //         if(sum == 0) {
        //             len = Math.max(len, j-i+1);
        //         }
        //     }
        // }

        // return len;

        //BETTER SOLUTION :-
        // for(int i = 0; i < n; i++) {
        //     sum = 0;
        //     for(int j = i; j < n; j++) {
        //         sum += arr[j];

        //         if(sum == 0) {
        //             len = Math.max(len, j-i+1);
        //         }
        //     }
        // }

        // return len;

        //OPTIMAL SOLUTION :-
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == 0) {
                len = i+1;
            }

            if(map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLength(arr));
    }
}
