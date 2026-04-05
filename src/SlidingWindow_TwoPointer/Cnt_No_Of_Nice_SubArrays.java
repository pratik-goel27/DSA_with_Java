package SlidingWindow_TwoPointer;

public class Cnt_No_Of_Nice_SubArrays {
    public static int helper(int[] nums, int k) {
        int left = 0, right = 0;
        int ans = 0, cntOdd = 0;
        while(right < nums.length) {
            if(nums[right] % 2 != 0) cntOdd++;
            while(cntOdd > k) {
                if(nums[left] % 2 != 0) cntOdd--;
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(arr, 2));
    }
}