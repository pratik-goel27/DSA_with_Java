package Arrays.Easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Longest_Consecutive_Sequence {

    public static boolean ls(int[] arr, int ele) {
        boolean ans = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ele) {
                ans = true;
            }
        }

        return ans;
    }

    // Function to return length of longest subsequence of consecutive integers.
    public static int longestConsecutive(int[] arr) {
        // Brute Force Solution :-
//         int largest = 1;
//         int cnt = 1;
//
//         for(int i = 0; i < arr.length; i++) {
//             int x = arr[i];
//             cnt = 1;
//             while(ls(arr, x+1)) {
//                 cnt++;
//                 x++;
//                 largest = Math.max(largest, cnt);
//             }
//         }
//
//         return largest;

        //BETTER SOLUTION :-
//         Arrays.sort(arr);
//         int cntCurr = 0;
//         int largest = 1;
//         int lastSmaller = Integer.MIN_VALUE;
//
//         for(int i = 0; i < arr.length; i++) {
//             if(arr[i] - 1 == lastSmaller) {
//                 cntCurr++;
//                 lastSmaller = arr[i];
//             }else if(arr[i] != lastSmaller) {
//                 cntCurr = 1;
//                 lastSmaller = arr[i];
//             }
//
//             largest = Math.max(largest, cntCurr);
//         }
//
//         return largest;


        //OPTIMAL SOLUTION :-
        if(arr.length == 0) return 0;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }

        int cnt = 1;
        int largest = 1;

        for(int it : st) {
            int curr = it;
            cnt = 1;
            if(!st.contains(curr - 1)) {
                while(st.contains(curr + 1)) {
                    curr = curr + 1;
                    cnt++;
                }
            }

            largest = Math.max(largest, cnt);
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestConsecutive(arr));
    }
}