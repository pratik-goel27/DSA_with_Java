package BinarySearch.Easy;

import java.util.Arrays;

public class Find_First_and_Last_Occurrences {

    public static int getLastOccur(int[] nums, int  target) {
        int low = 0, high = nums.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int getFirstOccur(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                ans = mid;
                high = mid-1;
            }else if(nums[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = getFirstOccur(nums, target);
        ans[1] = getLastOccur(nums, target);
        return ans;
    }

    public static int countOccurrence(int[] nums, int target) {
        int first = getFirstOccur(nums,target);
        int last = getLastOccur(nums,target);
        if(first == -1) {
            System.out.println("target value is not present in the array");
            return -1;
        }else {
            return (last-first+1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr,8)));
        System.out.println(countOccurrence(arr,8));
    }
}
