package SlidingWindow_TwoPointer;

import java.util.Arrays;

public class LongestSubstring_Without_Repeating_Char {
    public static int lengthOfLongestSubstring(String s) {
//        int len = 0;
//        for(int i = 0; i < s.length(); i++) {
//            int[] arr = new int[256];
//            for(int j = i; j < s.length(); j++) {
//                char ch = s.charAt(j);
//                if(arr[ch] == 1) break;
//                len = Math.max(len, j-i+1);
//                arr[ch] = 1;
//            }
//        }
//
//        return len;

        int[] hasharr = new int[256];
        Arrays.fill(hasharr, -1);
        int left = 0, right = 0;
        int maxLen = 0, n = s.length();

        while(right < n) {
            char ch = s.charAt(right);
//            if(hasharr[ch] >= left) {
//                left = hasharr[ch] + 1;
//            }
            left = Math.max(left, hasharr[ch]+1);
            maxLen = Math.max(maxLen, right-left+1);
            hasharr[ch] = right;
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "cadbzabcd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
