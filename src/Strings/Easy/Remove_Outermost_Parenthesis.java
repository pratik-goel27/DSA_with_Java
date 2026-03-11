package Strings.Easy;

import java.util.Stack;

public class Remove_Outermost_Parenthesis {
    public static String removeOuterParentheses(String s) {
        //O(N) space :-
//        Stack<Character> st = new Stack<>();
//        StringBuilder ans = new StringBuilder();
//        for(char ch : s.toCharArray()) {
//            if(ch == '(') {
//                if(!st.isEmpty()) ans.append(ch);
//                st.push(ch);
//            }else {
//                st.pop();
//                if(!st.isEmpty()) ans.append(ch);
//            }
//        }
//        return ans.toString();

        //O(1) space :-
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(cnt > 0) ans.append(ch);
                cnt++;
            }else {
                cnt--;
                if(cnt > 0) ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "((()))(()())";
        System.out.println(removeOuterParentheses(s));
    }
}