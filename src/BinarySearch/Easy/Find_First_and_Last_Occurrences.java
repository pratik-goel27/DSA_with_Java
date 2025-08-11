package BinarySearch.Easy;

import java.util.Arrays;

public class Find_First_and_Last_Occurrences {

    public static int getFirstOccurrence(int[] nums, int target) {
        //for firstOcc:-(LOWER BOUND)
        int firstOcc = -1;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                firstOcc = mid;
                high = mid-1;
            }else if(nums[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return firstOcc;
    }

    public static int getLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int lastOcc = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                lastOcc = mid;
                low = mid+1;
            }else if(nums[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return lastOcc;
    }

    public static int[] getFirstandLastOcc(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = getFirstOccurrence(nums,target);
        ans[1] = getLastOccurrence(nums,target);
        return ans;
    }

    public static int countOccurrence(int[] nums, int target) {
        int first = getFirstOccurrence(nums,target);
        int last = getLastOccurrence(nums,target);
        if(first == -1) {
            System.out.println("target value is not present in the array");
            return -1;
        }else {
            return (last-first+1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(getFirstandLastOcc(arr,target)));
        System.out.println(countOccurrence(arr,target));
    }
}
