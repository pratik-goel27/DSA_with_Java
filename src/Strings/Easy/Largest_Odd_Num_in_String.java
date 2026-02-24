package Strings.Easy;

import java.math.BigInteger;

public class Largest_Odd_Num_in_String {
    public static String largestOddNumber(String num) {
        int i;
        for(i = num.length()-1; i >= 0; i--) {
            if((num.charAt(i) - '0') % 2 != 0) return num.substring(0,i+1);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "420652";
        System.out.println(largestOddNumber(s));
    }
}
