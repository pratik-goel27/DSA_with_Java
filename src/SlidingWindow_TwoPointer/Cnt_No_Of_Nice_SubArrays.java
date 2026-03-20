package SlidingWindow_TwoPointer;

public class Cnt_No_Of_Nice_SubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
//        int cntOdd = 0;
//        int ans = 0;
//        for(int i = 0; i < nums.length; i++) {
//            cntOdd = 0;
//            for(int j = i; j < nums.length; j++) {
//                if(nums[j] % 2 != 0) cntOdd++;
//                if(cntOdd == k) ans++;
//                else if(cntOdd > k) break;
//            }
//        }
//
//        return ans;

        int left = 0, right = 0;
        int ans = 0, cntOdd = 0;
        while(right < nums.length) {
            if(nums[right] % 2 != 0) cntOdd++;
            if(cntOdd >= k) {
                if(cntOdd == k) ans++;
                if(nums[left] % 2 != 0) cntOdd--;
                left++;
            }
            if(cntOdd == k) ans++;
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,2,1,1};
        System.out.println(numberOfSubarrays(arr, 3));
    }
}
