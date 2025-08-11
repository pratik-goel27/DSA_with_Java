package Stacks;

import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }else {
                if(st.isEmpty()) return false;
                char poped = st.pop();
                if ( (poped == '(' && ch == ')') || (poped == '{' && ch == '}') ||
                    (poped == '[' && ch == ']') ) {
                        continue;
                }else return false;
            }
        }

        return st.isEmpty();

    }

    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(isValidParentheses(str));
    }
}
