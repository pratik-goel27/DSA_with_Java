package Arrays;
import java.util.*;

public class Find_Duplicate {
    public static int findDuplicate(int[] nums) {
        //BRUTE FORCE SOLN :-
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length-1; i++) {
//            if(nums[i] == nums[i+1]) return nums[i];
//        }
//
//        return -1;

        //BETTER SOLUTION :-
//        int n = nums.length;
//        int[] freq = new int[n + 1];
//
//        for(int i = 0; i < n; i++) {
//            if (freq[nums[i]] == 0) {
//                // mark as seen
//                freq[nums[i]] += 1;
//            } else {
//                // duplicate found
//                return nums[i];
//            }
//        }
//        // fallback if none
//        return -1;

        //OPTIMAL SOLUTION :-
        int slow = nums[0];
        int fast = nums[0];

        // move slow by 1 step and fast by 2 steps until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset fast to start to find the entrance to the cycle
        fast = nums[0];

        // move both by 1 step until they meet at the duplicate
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // return the duplicate value
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }
}
