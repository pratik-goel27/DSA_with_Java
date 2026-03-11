package SlidingWindow_TwoPointer;

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        //BRUTE FORCE SOLUTION :-
//        int maxLen = 0;
//        for(int i = 0; i < s.length(); i++) {
//            int[] hashArr = new int[26];
//            int maxf=0;
//            for(int j = i; j < s.length(); j++) {
//                char ch = s.charAt(j);
//                hashArr[ch - 'A']++;
//                maxf = Math.max(maxf, hashArr[ch - 'A']);
//                int changes = (j-i+1) - maxf;
//                if(changes <= k) maxLen = Math.max(maxLen, j-i+1);
//                else break;
//            }
//        }
//        return maxLen;

        //BETTER SOLUTION :-
//        int left = 0, right = 0;
//        int maxLen = 0, maxF = 0;
//        int[] hashArr = new int[26];
//        int n = s.length();
//
//        while(right < n) {
//            char ch = s.charAt(right);
//            hashArr[ch - 'A']++;
//            maxF = Math.max(maxF, hashArr[ch - 'A']);
//            while((right-left+1) - maxF > k) {
//                hashArr[s.charAt(left) - 'A']--;
//                maxF = 0;
//                for(int num : hashArr) maxF = Math.max(maxF, num);
//                left++;
//            }
//            maxLen = Math.max(maxLen, right-left+1);
//            right++;
//        }
//
//        return maxLen;

        //OPTIMAL SOLUTION :-
        int left = 0, right = 0;
        int maxLen = 0, maxF = 0;
        int[] hashArr = new int[26];
        int n = s.length();

        while(right < n) {
            char ch = s.charAt(right);
            hashArr[ch - 'A']++;
            maxF = Math.max(maxF, hashArr[ch - 'A']);
            if((right-left+1) - maxF > k) {
                hashArr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 2));
    }
}