package BinarySearch;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
//    public static int getLastOccur(int[] nums, int  target) {
//        int low = 0, high = nums.length-1;
//        int ans = -1;
//        while(low <= high) {
//            int mid = (low + high)/2;
//            if(nums[mid] == target) {
//                ans = mid;
//                low = mid+1;
//            }else if(nums[mid] < target) {
//                low = mid+1;
//            }else {
//                high = mid-1;
//            }
//        }
//
//        return ans;
//    }
//
//    public static int getFirstOccur(int[] nums, int target) {
//        int low = 0, high = nums.length-1;
//        int ans = -1;
//        while(low <= high) {
//            int mid = (low + high)/2;
//            if(nums[mid] == target) {
//                ans = mid;
//                high = mid-1;
//            }else if(nums[mid] < target) {
//                low = mid+1;
//            }else {
//                high = mid-1;
//            }
//        }
//
//        return ans;
//    }
//
//    public static int[] searchRange(int[] nums, int target) {
//        int[] ans = new int[2];
//        ans[0] = getFirstOccur(nums, target);
//        ans[1] = getLastOccur(nums, target);
//        return ans;
//    }

//    public static int search(int[] nums, int target) {
//        int low = 0, high = nums.length-1;
//        while(low <= high) {
//            int mid = (low+high)/2;
//            if(nums[mid] == target) {
//                return mid;
//            }
//
//            if(nums[low] <= nums[mid]) {
//                if(nums[low] <= target && target <= nums[mid]) {
//                    high = mid-1;
//                }else {
//                    low = mid+1;
//                }
//            }else {
//                if(nums[mid] <= target && target <= nums[high]) {
//                    low = mid+1;
//                }else {
//                    high = mid-1;
//                }
//            }
//        }
//
//        return -1;
//    }

//    public static int findMin(int[] nums) {
//        int low = 0, high = nums.length-1;
//        int ans = Integer.MAX_VALUE;
//        while(low <= high) {
//            int mid = (low+high)/2;
//
//            if(nums[low] <= nums[mid]) {
//                ans = Math.min(ans, nums[low]);
//                low = mid+1;
//            }else {
//                ans = Math.min(ans, nums[mid]);
//                high = mid-1;
//            }

//        }
//        return ans;
//    }




    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
    }
}