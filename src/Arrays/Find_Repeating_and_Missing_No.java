package Arrays;

import java.sql.Array;
import java.util.*;

public class Find_Repeating_and_Missing_No {
    public static ArrayList<Integer> findTwoElement(int[] arr) {
        //BRUTE FORCE :- (O(N2) approach)
//        int repeating = -1, missing = -1;
//
//        for(int i = 1; i <= arr.length; i++) {
//            int cnt = 0;
//            for(int j = 0; j < arr.length; j++) {
//                if(arr[j] == i) cnt++;
//            }
//            if(cnt == 2) repeating = i;
//            else if(cnt == 0) missing = i;
//            if(repeating != -1 && missing != -1) break;
//        }
//
//        return new ArrayList<>(Arrays.asList(repeating, missing));


        //BETTER SOLUTION :-(Hashing using freq arr)
//        int n = arr.length;
//        int missing = -1;
//        int repeating = -1;
//        int[] hash = new int[n+1];
//
//        for(int i = 0; i < arr.length; i++) {
//            hash[arr[i]]++;
//        }
//
//        for(int i = 1; i < hash.length; i++) {
//            if(hash[i] == 0) missing = i;
//            else if(hash[i] == 2) repeating = i;
//            if(repeating != -1 && missing != -1) break;
//        }
//
//        return new ArrayList<>(Arrays.asList(repeating, missing));

        //OPTIMAL SOLUTION :-(BASIC MATHS)
//        //S - SN = x - y
//        //S2 - S2N
//        int n = arr.length;
//        long SN = ((long)n * (n + 1)) / 2;
//        long S2N = ((long)n * (n+1) * (2L*n+1)) / 6;
//        long S = 0, S2 = 0;
//
//        for(int i = 0; i < arr.length; i++) {
//            S += arr[i];
//            S2 += (long)arr[i] * arr[i];   //if one operand is long then java automatically treats the other as long.
//        }
//
//        long val1 = S - SN;  //x - y
//        long val2 = S2 - S2N;
//        val2 = val2 / val1;  //x + y
//
//        long x = (val1 + val2) / 2;
//        long y = x - val1;
//        return new ArrayList<>(Arrays.asList((int)x, (int)y));

        //OPTIMAL SOLUTION :-(XOR Approach)
        //finding the num after xor.
        long xr = 0;
        for(int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];
            xr = xr ^ (i+1);
        }

        int bitNo = 0;
        while(true) {
            if((xr & (1L << bitNo)) != 0) {
                break;
            }
            bitNo++;
        }
//        long number = xr & ~(xr - 1);  this is number variable can be used instead of bitNo .Generating num with 1 at the differentiating bit.

        //finding the differentiating bit i.e first 1 from RHS.
        int zero = 0;
        int one = 0;
        for(int i = 0; i < arr.length; i++) {
            //part of 1 club
            if((arr[i] & (1L << bitNo)) != 0) {
                one = one ^ arr[i];
            }
            //part of 0 club
            else {
                zero = zero ^ arr[i];
            }
        }
        for(int i = 1; i <= arr.length; i++) {
            //part of 1 club
            if((i & (1L << bitNo)) != 0) {
                one = one ^ i;
            }
            //part of 0 club
            else {
                zero = zero ^ i;
            }
        }

        //Now one and zero are the ans. Checking if one is repeating or missing same for zero.
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == one) cnt++;
        }

        if(cnt == 2) return new ArrayList<>(Arrays.asList(one, zero));
        return new ArrayList<>(Arrays.asList(zero, one));
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }
}
