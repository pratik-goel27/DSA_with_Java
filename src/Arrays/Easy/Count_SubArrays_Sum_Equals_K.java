package Arrays.Easy;

import java.util.HashMap;

public class Count_SubArrays_Sum_Equals_K {

    public static int subarraySum(int[] nums, int k) {
        //BRUTE FORCE SOLUTION:- O(N3)
//         int sum = 0, cnt = 0;
//         int n = nums.length;
//
//         for(int i = 0; i < n; i++) {
//             for(int j = i; j < n; j++) {
//                 sum = 0;
//                 for(int k = i; k <= j; k++) {
//                     sum += nums[k];
//                 }
//                 if(sum == K) cnt++;
//             }
//         }
//         return cnt;

        //BETTER SOLUTION :-O(N2)
//        int sum = 0, cnt = 0;
//        int n = nums.length;
//
//        for(int i = 0; i < n; i++) {
//            sum = 0;
//            for(int j = i; j < n; j++) {
//                sum += nums[j];
//                if(sum == k) cnt++;
//            }
//        }
//        return cnt;

        //OPTIMAL SOLUTION :-
        int sum = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                cnt += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;


//        int sum = 0, cnt = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0,1);
//
//        for(int i = 0; i < nums.length; i++) {
//            //add curr ele into the sum :-
//            sum += nums[i];
//
//            //cal x-k
//            int remove = sum - k;
//
//            // add the number of sub arrays to be removed :-
//            cnt += map.getOrDefault(remove, 0);
//
//            //update the cnt of sum in the hash map :-
//            map.put(sum , map.getOrDefault(sum,0)+1);
//        }
//
//        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};

        System.out.println(subarraySum(arr, 3));
    }
}
