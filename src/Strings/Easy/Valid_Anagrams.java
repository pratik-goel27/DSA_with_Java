package Strings.Easy;

import java.util.HashMap;

public class Valid_Anagrams {
    public static boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()) return false;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        for(int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//            int count = map.getOrDefault(ch, 0);
//            if(count == 0) return false;
//            map.put(ch, count-1);
//        }
//
//        return true;

        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        for(char ch : t.toCharArray()) {
            if(--freq[ch-'a'] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        int a = 5;
        {
            a = 10;
            System.out.println(a);
        }
        System.out.println(a);
    }
}