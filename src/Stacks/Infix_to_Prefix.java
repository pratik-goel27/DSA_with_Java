package Stacks;

import java.util.Stack;

public class Infix_to_Prefix {

    public static int prior(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        //reversing the String: -
        sb.reverse();
        while(i < sb.length()) {
            char ch = sb.charAt(i);
            if(ch == '(') {
                sb.setCharAt(i,')');
            }else if(ch == ')') {
                sb.setCharAt(i,'(');
            }
            i++;
        }
        //converting infix to postfix under some conditions: -
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        i = 0;
        while(i < sb.length()) {
            char ch = sb.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                ans.append(ch);
            }else if(ch == '(') {
                st.push(ch);
            }else if(ch == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }else {
                while(!st.isEmpty() && prior(ch) < prior(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        //reversing this string again: -
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "(a+b)*c-d+f";
        System.out.println(infixToPrefix(str));
    }
}