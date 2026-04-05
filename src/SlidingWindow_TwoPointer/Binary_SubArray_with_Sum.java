package SlidingWindow_TwoPointer;

public class Binary_SubArray_with_Sum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, right = 0;
        int cnt = 0, sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            cnt += right-left+1;
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums, 2) - numSubarraysWithSum(nums, 1));
    }
}