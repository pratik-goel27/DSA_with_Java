package SlidingWindow_TwoPointer;

public class Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {
        //BRUTE FORCE :-
        //T.C:- O(N2)
//        int maxLen = 0;
//        for(int i = 0; i < nums.length; i++) {
//            int cnt = 0;
//            for(int j = i; j < nums.length; j++) {
//                if(nums[j] == 0) cnt++;
//                if(cnt > k) break;
//                maxLen = Math.max(maxLen, j-i+1);
//            }
//        }
//        return maxLen;

        //OPTIMAL SOLUTION :-
        //T.C:- O(2N)
//        int left = 0, right = 0;
//        int maxLen = 0, zeros = 0;
//        while(right < nums.length) {
//            if(nums[right] == 0) zeros++;
//            if(zeros > k) {
//                while(zeros > k) {
//                    if(nums[left] == 1) left++;
//                    else {
//                        zeros--;
//                        left++;
//                    }
//                }
//            }
//            maxLen = Math.max(maxLen, right-left+1);
//            right++;
//        }
//        return maxLen;

        //THE PREVIOUS CODE RE WRITTEN :-
//        int left = 0, right = 0;
//        int maxLen = 0, zeros = 0;
//        while(right < nums.length) {
//            if(nums[right] == 0) zeros++;
//            while(zeros > k) {
//                if(nums[left] == 0) zeros--;
//                left++;
//            }
//            maxLen = Math.max(maxLen, right-left+1);
//            right++;
//        }
//        return maxLen;

        //SLIGHTLY MORE OPTIMAL :-
        int left = 0, right = 0;
        int maxLen = 0, zeros = 0;
        while(right < nums.length) {
            if(nums[right] == 0) zeros++;
            if(zeros > k) {
                if(nums[left] == 0) zeros--;
                left++;
            }
            if(zeros <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr, 2));
    }
}
