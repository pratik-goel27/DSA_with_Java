package Stacks;

import java.util.*;

public class Next_Greater_Element_I {
    public static int[] nextLargerElement(int[] arr) {
        //BRUTE FORCE :-
//         ArrayList<Integer> al = new ArrayList<>();
//         boolean eleIns;
//         for (int i = 0; i < arr.length; i++) {
//             eleIns = false;
//             for (int j = i+1; j < arr.length; j++) {
//                 if (arr[j] > arr[i]) {
//                     al.add(arr[j]);
//                     eleIns = true;
//                     break;
//                 }
//             }
//             if (!eleIns) {
//                 al.add(-1);
//             }
//         }
//
//         return al;

        //OPTIMAL SOLUTION :-
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(arr[i]);
        }
        return ans;
    }

    //MONOTONIC STACK + HASHMAP :-
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();

            int nextGreater = st.isEmpty() ? -1 : st.peek();
            map.put(nums2[i], nextGreater);

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}