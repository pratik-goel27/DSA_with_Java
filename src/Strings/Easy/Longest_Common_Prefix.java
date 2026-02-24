package Strings.Easy;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            String word = strs[i];
            while(j < word.length() && j < prefix.length() ) {
                if(word.charAt(j) == prefix.charAt(j)) j++;
                else break;
            }
            if(j == 0) return "";
            else prefix.setLength(j);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
