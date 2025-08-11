package Stacks;

import java.util.Stack;

public class Infix_to_Postfix {

    public static int Prior(char ch) {
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

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        int i = 0;

        while(i < s.length()) {
            char ch = s.charAt(i);
            if    ( (ch >= 'A' && ch <= 'Z') ||
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= '0' && ch <= '9') ) {
                ans.append(ch);
            }else if(ch == '(') {
                st.push(ch);
            }else if(ch == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }else {
                while(!st.isEmpty() && Prior(ch) <= Prior(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }

        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        String str = "a+b*(c^d-e)";
        System.out.println(infixToPostfix(str));
    }
}
