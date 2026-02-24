package BinarySearch.Medium;

public class MinDays_to_make_m_bouquets {
    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int num : arr) min = Math.min(min, num);
        return min;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max, num);
        return max;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0;
        int noOfB = 0;
        for(int i = 0; i < arr.length; i++) {
            if(day >= arr[i]) {
                cnt++;
            }else {
                noOfB += cnt/k;
                cnt = 0;
            }
        }
        noOfB += cnt/k;
        if(noOfB >= m) return true;
        else return false;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        //BRUTE FORCE :-
        if((long)m*k > bloomDay.length) return -1;
        for(int i = getMin(bloomDay); i <= getMax(bloomDay); i++) {
            if(possible(bloomDay, i, m, k)) return i;
        }
        return -1;

        //OPTIMAL SOLUTION :-
//        if((long)m*k > bloomDay.length) return -1;
//        int low = getMin(bloomDay), high = getMax(bloomDay);
//        while(low <= high) {
//            int mid = low + (high-low)/2;
//            if(possible(bloomDay, mid, m, k)) {
//                high = mid-1;
//            }else {
//                low = mid+1;
//            }
//        }
//        return low;

    }

    public static void main(String[] args) {
        int[] bloomDay = {1000000000,1000000000};
        int m = 1;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
