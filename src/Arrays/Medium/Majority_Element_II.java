package Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Majority_Element_II {
    public static List<Integer> majorityElement(int[] nums) {
        //BRUTE FORCE SOLUTION :-
//        List<Integer> list = new ArrayList<>();
//        int count = 0, n = nums.length;
//        for(int i = 0; i < n; i++) {
//            if(!list.contains(nums[i])) {
//                count = 0;
//                for(int j = 0; j < n; j++) {
//                    if(nums[i] == nums[j]) {
//                        count++;
//                    }
//                }
//
//                if(count > n/3) {
//                    list.add(nums[i]);
//                }
//            }
//
//            if(list.size() == 2) break;
//        }
//
//        return list;


        //BETTER SOLUTION :-(USING 2 LOOPS)
//        HashMap<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        int n = nums.length;
//        for(int i = 0; i < n; i++) {
//            int val = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], val+1);
//        }
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() > n/3) {
//                list.add(entry.getKey());
//            }
//        }
//
//        return list;

        //BETTER SOLUTION (USING 1 LOOP)
//        HashMap<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        int n = nums.length;
//        int min = n/3 + 1;
//
//        for(int i = 0; i < n; i++) {
//            int val = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], val+1);
//
//            if(map.get(nums[i]) == min) {
//                list.add(nums[i]);
//            }
//
//            if(list.size() == 2) break;
//        }
//
//        return list;

        //OPTIMAL SOLUTION :-
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int cnt1 = 0, ele1 = Integer.MIN_VALUE;
        int cnt2 = 0, ele2 = Integer.MIN_VALUE;

        //Applied the algorithm :-
        for(int i = 0; i < n; i++) {
            if(cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        //CHECKING If ele1 and ele2 are the majority
        cnt1 = cnt2 = 0;
        for(int i = 0; i < n; i++) {
            if(ele1 == nums[i]) cnt1++;
            if(ele2 == nums[i]) cnt2++;
        }

        int min = n/3 + 1;
        if(cnt1 >= min) list.add(ele1);
        if(cnt2 >= min) list.add(ele2);

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2};
        System.out.println(majorityElement(arr));
    }
}