package Arrays.Medium;

import java.util.*;

public class _3_Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        /*BRUTE FORCE :-
        This code is taking approximately O(n4) time because of the list.contains() method*/

//        List<List<Integer>> list  = new ArrayList<>();
//        int n = nums.length;

//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                List<Integer> temp = new ArrayList<>();
//
//                for(int k = j+1; k < n; k++) {
//
//                    if(nums[i] + nums[j] + nums[k] == 0) {
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//
//                        temp.sort(null);
//
//                        if(!list.contains(temp)) {
//                            list.add(new ArrayList<>(temp));
//                        }
//
//                        temp.clear();
//                    }
//                }
//            }
//        }
//
//        return list;


        /*Brute Force but better than the prev sol here TC is O(n3)*/
//        Set<List<Integer>> st = new HashSet<>();
//        int n = nums.length;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                for(int k = j+1; k < n; k++) {
//                    if(nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
//                        temp.sort(null);
//                        st.add(temp);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(st);


        //BETTER SOLUTION :-(O(n2))
//        Set<List<Integer>> ans = new HashSet<>();
//        Set<Integer> st = new HashSet<>();
//
//        for(int i = 0; i < nums.length; i++) {
////            st = new HashSet<>();
//            for(int j = i+1; j < nums.length; j++) {
//                int num = -(nums[i] + nums[j]);
//                if(st.contains(num)) {
//                    List<Integer> temp = Arrays.asList(nums[i], nums[j], num);
//                    temp.sort(null);
//                    ans.add(temp);
//                }
//                st.add(nums[j]);
//            }
//            st.clear();
//        }
//
//        return new ArrayList<>(ans);


        //OPTIMAL SOLUTION :-
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] > 0) break;  //no need to proceed as the arr is sorted.

            int j = i+1, k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                }else if(sum > 0) {
                    k--;
                }else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    list.add(temp);
                    j++; k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

        System.out.println(1000000000 + 1000000000 + 1000000000+1000000000);
    }
}