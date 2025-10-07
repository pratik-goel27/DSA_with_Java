package Arrays.Hard;

import java.util.*;

public class _4_Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //BRUTE FORCE :- O(N4)
//        Set<List<Integer>> st = new HashSet<>();
//        int n = nums.length;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                for(int k = j+1; k < n; k++) {
//                    for(int l = k+1; l < n; l++) {
//                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
//                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                            temp.sort(null);
//                            st.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(st);


        //BETTER SOLUTION :- O(N3) here set ds is used so extra space is used.
//        Set<Long> st = new HashSet<>();
//        Set<List<Integer>> ans = new HashSet<>();
//        int n = nums.length;
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                for(int k = j+1; k < n; k++) {
//                    long sum3 = (long)nums[i] + nums[j] + nums[k];
//                    long fourth = (long)target-sum3;
//                    if(st.contains(fourth)) {
//                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
//                        temp.sort(null);
//                        ans.add(temp);
//                    }
//                    st.add((long)nums[k]);
//                }
//                st.clear();
//            }
//        }
//
//        return new ArrayList<>((ans));


        //OPTIMAL SOLUTION :-O(N3) here no extra space is used to solve the problem.
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k < l) {
                    long sum3 = (long)nums[i]+nums[j]+nums[k];
                    long sum = (long)sum3 + nums[l];
                    if(sum < target) {
                        k++;
                    }else if(sum > target) {
                        l--;
                    }else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        list.add(temp);
                        k++; l--;

                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
}