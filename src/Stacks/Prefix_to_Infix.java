package Stacks;

import java.util.Stack;

public class Prefix_to_Infix {

    public static String prefixToInfix(String str) {
        Stack<String> st = new Stack<>();
        int i = str.length()-1;
        while(i >= 0) {
            char ch = str.charAt(i);
            if((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            }else {
                String t1 = st.pop();
                String t2 = st.pop();
                String nstr = "("+t1+ch+t2+")";
                st.push(nstr);
            }
            i--;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String str = "*+PQ-MN";
        System.out.println(prefixToInfix(str));
    }
}
