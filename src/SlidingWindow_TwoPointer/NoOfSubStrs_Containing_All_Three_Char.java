package SlidingWindow_TwoPointer;
import java.util.Arrays;
public class NoOfSubStrs_Containing_All_Three_Char {
    public static int numberOfSubstrings(String s) {
        //BRUTE FORCE SOLUTION :-
//        int cnt = 0, n = s.length();
//        for(int i = 0; i < s.length(); i++) {
//            int[] hashArr = new int[3];
//            for(int j = i; j < s.length(); j++) {
//                hashArr[s.charAt(j) - 'a'] = 1;
//                if(hashArr[0] + hashArr[1] + hashArr[2] == 3) {
//                    cnt = cnt + (n - j);   //slight optimization.
//                    break;
//                }
//            }
//        }
//
//        return cnt;

        //OPTIMAL SOLUTION :-
        int[] lastSeen = new int[3];
        int cnt = 0;
        Arrays.fill(lastSeen, -1);
        for(int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                cnt = cnt + (1 + Math.min(lastSeen[0] , Math.min(lastSeen[1], lastSeen[2])));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}