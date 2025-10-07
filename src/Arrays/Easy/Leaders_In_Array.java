package Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Leaders_In_Array {
    public static ArrayList<Integer> leaders(int[] arr) {
        // BRUTE FORCE SOLUTION :-
        // int n = arr.length;
        // ArrayList<Integer> list = new ArrayList<>();
        // boolean greater = true;
        // for(int i = 0; i < n; i++) {
        //     greater = true;
        //     for(int j = i+1; j < n; j++) {
        //         if(arr[i] < arr[j]) {
        //             greater = false;
        //             break;
        //         }
        //     }

        //     if(greater) {
        //         list.add(arr[i]);
        //     }
        // }

        // return list;

        //OPTIMAL SOLUTION :-
        int n = arr.length;
        int maxi = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] > maxi) {
                list.add(arr[i]);
                maxi = arr[i];
            }
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 4, 5, 1, -4, -5};
        System.out.println(leaders(nums));
    }
}
