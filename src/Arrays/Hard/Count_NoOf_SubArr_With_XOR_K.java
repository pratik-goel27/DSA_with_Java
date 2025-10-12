package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class Count_NoOf_SubArr_With_XOR_K {
    public static long subarrayXor(int[] arr, int K) {
        //BRUTE FORCE :-
//        int ans = 0;
//        int cnt = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i; j < arr.length; j++) {
//                ans = 0;
//                for(int k = i; k <= j; k++) {
//                    ans = ans ^ arr[k];
//                }
//                if(ans == K) cnt++;
//            }
//        }
//
//        return cnt;

        //BETTER SOLUTION :-
//        int ans = 0;
//        int cnt = 0;
//        for(int i = 0; i < arr.length; i++) {
//            ans = 0;
//            for(int j = i; j < arr.length; j++) {
//                ans = ans ^ arr[j];
//
//                if(ans == K) {
//                    cnt++;
//                }
//            }
//        }
//        return cnt;

        //OPTIMAL SOLUTION :-
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];

            int remove = ans-K;

            cnt += map.getOrDefault(remove, 0);

            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        System.out.println(subarrayXor(arr, 6));

    }
}
