package BinarySearch.Medium;

public class MinDays_to_make_m_bouquets {
    public static int getMinDay(int[] arr) {
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            mini = Math.min(mini, arr[i]);
        }
        return mini;
    }

    public static int getMaxDay(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static boolean possible(int[] arr, int days, int m, int k) {
        int cnt = 0, noOfB = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= days) {
                cnt++;
            }else {
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += cnt/k;
        if(noOfB >= m) return true;
        else return false;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int low = getMinDay(bloomDay);
        int high = getMaxDay(bloomDay);
        while(low <= high) {
            int mid = (low+high) / 2;
            if(possible(bloomDay, mid, m, k)) high = mid-1;
            else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
