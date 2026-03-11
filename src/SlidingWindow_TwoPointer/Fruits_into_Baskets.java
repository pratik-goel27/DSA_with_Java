package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Fruits_into_Baskets {
    public static int totalFruit(int[] fruits) {
//        int maxLen = 0;
//        for(int i = 0; i < fruits.length; i++) {
//            Set<Integer> st = new HashSet<>();
//            for(int j = i; j < fruits.length; j++) {
//                st.add(fruits[j]);
//                if(st.size() > 2) break;
//                maxLen = Math.max(maxLen, j-i+1);
//            }
//        }
//        return maxLen;

        int left = 0, right = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            if(map.size() <= 2) {
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(arr));
    }
}
