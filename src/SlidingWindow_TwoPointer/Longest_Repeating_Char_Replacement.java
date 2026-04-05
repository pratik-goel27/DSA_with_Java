package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Repeating_Char_Replacement {
    public static int characterReplacement(String s, int k) {
        //BRUTE FORCE SOLUTION :-
//        int maxLen = 0;
//        for(int i = 0; i < s.length(); i++) {
//            Set<Character> st = new HashSet<>();
//            for(int j = i; j < s.length(); j++) {
//                st.add(s.charAt(j));
//                if(st.size() > k) break;
//                maxLen = Math.max(maxLen, j-i+1);
//            }
//        }
//        return maxLen;

        //OPTIMAL SOLUTION :-

        int left = 0, right = 0;
        int maxLen = 0;
        if(k == 0) return maxLen;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            if(map.size() <= k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aaabbccd";
        System.out.println(characterReplacement(str, 2));
    }
}