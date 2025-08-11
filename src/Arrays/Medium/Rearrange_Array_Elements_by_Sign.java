package Arrays.Medium;

import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};

        //BRUTE SOLUTION:-
        int[] pos = new int[arr.length/2];
        int[] neg = new int[arr.length/2];
        int j = 0;
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                pos[j] = arr[i];
                j++;
            }else {
                neg[k] = arr[i];
                k++;
            }
        }

        for(int i = 0; i < pos.length; i++) {
            arr[2*i] = pos[i];
            arr[2*i+1] = neg[i];
        }
        System.out.println(Arrays.toString(arr));

        //OPTIMAL SOLUTION:-
//        int[] ans = new int[arr.length];
//        int pos = 0;
//        int neg = 1;
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] > 0) {
//                ans[pos] = arr[i];
//                pos = pos + 2;
//            }else {
//                ans[neg] = arr[i];
//                neg = neg + 2;
//            }
//        }
//
//        System.out.println(Arrays.toString(ans));
    }
}
