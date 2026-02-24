package BinarySearch.Hard;

import java.util.Arrays;

public class Aggressive_Cows {
    public static int getMin(int[] arr) {
        int mini = Integer.MAX_VALUE;
        for(int num : arr) mini = Math.min(mini, num);
        return mini;
    }

    public static int getMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for(int num : arr) maxi = Math.max(maxi, num);
        return maxi;
    }

    public static boolean possible(int[] arr, int minDist, int cows) {
        int j = 0;
        cows--;
        for(int i = 1; i < arr.length; i++) {
            if((arr[i] - arr[j]) >= minDist) {
                cows--;
                j = i;

                if(cows == 0) break;
            }
        }
        return cows == 0;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
//        int i;
//        for(i = 1; i <= (getMax(stalls) - getMin(stalls)); i++) {
//            if(!possible(stalls, i, k)) {
//                return i-1;
//            }
//        }
//        return (i-1);
        int low = 1, high = (getMax(stalls) - getMin(stalls));
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(possible(stalls, mid, k)) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,4,7,9,10};
        System.out.println(aggressiveCows(arr, 4));
    }
}