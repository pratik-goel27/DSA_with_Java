package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//in place algo:- do not use extra space modify the same array and return your answer.
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};
        int largest = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }

        int[] narr = new int[largest+1];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            narr[arr[i]]++;
        }

        for(int i = 0; i < narr.length; i++) {
            if(narr[i] > 0) {
                list.add(i);
            }
        }

        //BRUTE FORCE SOLUTION:-
//        Set<Integer> st = new HashSet<>();
//        for(int num : arr) {
//            st.add(num);
//        }
//        int i =0;
//        for (Integer integer : st) {   //Iterator can also be used.
//            arr[i++] = integer;
//        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Size of the unique elements: "+i);

        //Optimal SOLUTION:-
//        int i = 0;
//        for(int j = 1; j < arr.length; j++) {
//            if(arr[j] != arr[i]) {
//                arr[++i] = arr[j];
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
