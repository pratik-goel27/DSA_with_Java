package BinarySearch.Medium;

public class Koko_Eating_Bananas {
    public static class KokoEatingBananas {
        //    public static int minEatingSpeed(int[] piles, int h) {
        ////        //finding max ele in piles :-
        ////        int max = 0;
        ////        for(int i = 0; i < piles.length; i++) {
        ////            if(piles[i] > max) max = piles[i];
        ////        }
        ////
        //////        System.out.println(max);
        ////        int sum = 0;
        ////        for(int i = 1; i <= max; i++) {
        ////            sum = 0;
        ////            for(int j = 0; j < piles.length; j++) {
        ////                sum += (int)Math.ceil((double) piles[j] / i);
        ////            }
        ////            if(sum <= h) {
        ////                return i;
        ////            }
        ////        }
        ////        return -1;
        ////        int max = Integer.MIN_VALUE;
        ////        for(int i = 0; i < piles.length; i++) {
        ////            if(piles[i] > max) {
        ////                max = piles[i];
        ////            }
        ////        }
        ////
        ////        for(int i = 1; i <= max; i++) {
        ////            int totalTime = calcTotalTime(piles, i);
        ////            if(totalTime <= h) {
        ////                return i;
        ////            }
        ////        }
        ////        return -1;
        //
        //
        //    }

        public static int findMax(int[] arr) {
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++) {
                maxi = Math.max(maxi, arr[i]);
            }
            return maxi;
        }

        public static int calcTime(int[] arr, int h) {
            int totalTime = 0;
            for(int i = 0; i < arr.length; i++) {
                totalTime += (int)Math.ceil((double)arr[i] / h);
            }
            return totalTime;
        }

        public static int minEatingSpeed(int[] arr, int h) {
            int low = 1, high = findMax(arr);
            while(low <= high) {
                int mid = (low + high) / 2;
                int totalH = calcTime(arr, mid);
                if(totalH <= h) {
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            return low;
        }

        public static void main(String[] args) {
            int[] piles = {3,6,7,11};
            System.out.println(minEatingSpeed(piles, 8));
        }
    }
}
