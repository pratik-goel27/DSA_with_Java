package Arrays.Medium;

import java.util.HashMap;

public class SubArrays_Sum_Equals_K {
    public static int subarraySum(int[] nums, int k) {
        //BRUTE FORCE SOLUTION:-
//         int sum = 0, cnt = 0;
//         int n = nums.length;
//
//         for(int i = 0; i < n; i++) {
//             for(int j = i; j < n; j++) {
//                 sum = 0;
//                 for(int k = i; k <= j; k++) {
//                     sum += nums[k];
//                 }
//                 if(sum == K) {
//                     cnt++;
//                 }
//             }
//         }
//
//         return cnt;

        //BETTER SOLUTION :-
//        int sum = 0, cnt = 0;
//        int n = nums.length;
//
//        for(int i = 0; i < n; i++) {
//            sum = 0;
//            for(int j = i; j < n; j++) {
//                sum += nums[j];
//                if(sum == k) {
//                    cnt++;
//                }
//            }
//        }
//
//        return cnt;

        //OPTIMAL SOLUTION :-
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, cnt = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum == k) {
                cnt++;
            }

            if(sum > k) {
                if (map.containsKey(sum - k)) {
                    cnt++;
                }
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return cnt;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};

        System.out.println(subarraySum(arr, 3));
    }
}
