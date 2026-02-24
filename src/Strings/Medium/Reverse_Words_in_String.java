package Strings.Medium;

public class Reverse_Words_in_String {
    public static String reverseWords(String s) {
        //BRUTE FORCE :-
//        if(s == null || s.trim().isEmpty()) return "";
//        s = s.trim();
//        StringBuilder ans = new StringBuilder();
//        String[] words = s.split("\\s+");
//        for(int i = words.length-1; i >= 0; i--) {
//            ans.append(words[i]);
//            if(i != 0) ans.append(" ");
//        }
//        return ans.toString();

        StringBuilder ans = new StringBuilder();
        String rs = new StringBuilder(s).reverse().toString();
        for(int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            while(i < s.length() && rs.charAt(i) != ' ') {
                temp.append(rs.charAt(i));
                i++;
            }
            if (!temp.isEmpty()) {
                if(!ans.isEmpty()) ans.append(" ");
                ans.append(temp.reverse());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "the pen";
        System.out.println(reverseWords(s));
    }
}
