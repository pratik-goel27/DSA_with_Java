package Arrays.Medium;

import java.util.*;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5,6};

        //BRUTE FORCE SOLUTION:-
//        Set<Integer> st = new HashSet<>();
//
//        for(int num : arr1) {
//            st.add(num);
//        }
//        for(int num : arr2) {
//            st.add(num);
//        }
//
//        int[] farr = new int[st.size()];
//        Iterator<Integer> itr = st.iterator();
//        int i = 0;
//        while(itr.hasNext()) {
//            farr[i++] = itr.next();
//        }
//
//        System.out.println(Arrays.toString(farr));

        //OPTIMAL SOLUTION:-
        int i = 0, j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        int lastEle = -1;
        while(i != arr1.length && j != arr2.length) {
            if(arr1[i] <= arr2[j]) {
                if (lastEle != arr1[i]) {
                    al.add(arr1[i]);
                    lastEle = arr1[i];
                }
                i++;
            }else {
                if (lastEle != arr2[j]) {
                    al.add(arr2[j]);
                    lastEle = arr2[j];
                }
                j++;
            }
        }

        while(i != arr1.length) {
            if(arr1[i] != lastEle) {
                al.add(arr1[i]);
                lastEle = arr1[i];
            }
            i++;
        }

        while(j != arr2.length) {
            if(arr2[j] != lastEle) {
                al.add(arr2[j]);
                lastEle = arr2[j];
            }
            j++;
        }

        System.out.println(al);
    }
}
