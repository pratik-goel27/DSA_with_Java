package Stacks;

import java.util.Stack;

public class Postfix_to_Infix {

    public static String postfixToInfix(String str) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if( (ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9'))  {
                st.push(String.valueOf(ch));
            }else {
                String t1 = st.pop();
                String t2 = st.pop();
                String nstr = "("+t2+ch+t1+")";
                st.push(nstr);
            }
            i++;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println(postfixToInfix(str));
    }
}
