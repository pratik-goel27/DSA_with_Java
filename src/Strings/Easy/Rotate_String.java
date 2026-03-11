package Strings.Easy;

public class Rotate_String {
    public static String reverse(String s, int start, int end) {
        char[] arr = s.toCharArray();

        while(start < end) {
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }

        return new String(arr);
    }

    public static String rotate(String s, int k) {
        int n = s.length();
        k = k % n;
        s = reverse(s,0,k-1);
        s = reverse(s,k,s.length()-1);
        s = reverse(s, 0, s.length()-1);
        return s;
    }

    public static boolean rotateString(String s, String goal) {
        //BRUTE FORCE :-
//        if(s.length() != goal.length()) return false;
//
//        for(int i = 0; i < s.length(); i++) {
//            if(rotate(s, i).equals(goal)) return true;
//        }

        //OPTIMAL SOLUTION :-
        if(s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(rotateString("abcdef", "bcdefa"));
    }
}