package Stacks;

import java.util.Arrays;

public class Next_Greater_Element_II {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        for(int i = 0; i < n; i++) {

            for(int j = i+1; j < i+n-1; j++) {
                int idx = j % n;
                nge[i] = -1;
                if(nums[idx] > nums[i]) {
                    nge[i] = nums[i];
                    break;
                }
            }
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}