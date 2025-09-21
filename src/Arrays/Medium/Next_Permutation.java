package Arrays.Medium;
import java.util.Arrays;
public class Next_Permutation {

    public static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }

    public static int[] nextPermutation(int[] nums) {
        //Finding the break point :-
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            reverse(nums, 0, n-1);
            return nums;
        }

        //Finding the num just greater than the break point :-
        for(int i = n-1; i > idx; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //sort the remaining numbers :-
        reverse(nums, idx+1, n-1);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(nextPermutation(arr)));
    }
}
