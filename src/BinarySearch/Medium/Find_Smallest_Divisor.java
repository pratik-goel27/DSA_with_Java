package BinarySearch.Medium;

public class Find_Smallest_Divisor {
    public static int getMaxi(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for(int i : arr) maxi = Math.max(maxi, i);
        return maxi;
    }

    public static int calcSum(int[] arr, int divisor) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            ans += (int)Math.ceil((double)arr[i]/divisor);
        }
        return ans;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
//        for(int i = 1; i <= getMaxi(nums); i++) {
//            if(calcSum(nums, i) <= threshold) {
//                return i;
//            }
//        }
//        return -1;

        int low = 1;
        int high = getMaxi(nums);
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(calcSum(nums, mid) <= threshold) {
                ans = Math.min(ans, mid);
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }
}
