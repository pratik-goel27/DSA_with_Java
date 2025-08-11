package Arrays.Easy;

import java.util.ArrayList;

public class Leaders_In_Array {
    public static void main(String[] args) {
        int[] nums = {-3, 4, 5, 1, -4, -5};
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<>();

        //BRUTE FORCE:-
        for(int i = 0; i < n; i++) {
            boolean greater = true;
            for(int j = i+1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    greater = false;
                    break;
                }
            }
            if(greater) {
                al.add(nums[i]);
            }
        }
        System.out.println(al);

        //OPTIMAL SOLUTION:-
//        int max = nums[n-1];
//        al.add(nums[n-1]);
//        for(int i = n-1; i >= 0; i--) {
//            if(nums[i] > max) {
//                max = nums[i];
//                al.add(max);
//            }
//        }
//
//        System.out.println(al);
    }
}
