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

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;
    }

    public static int recurBinSearch(int[] arr, int low, int high, int target) {
        if(low > high) {
            return -1;
        }
        int mid = (low+high) / 2;
        if(arr[mid] == target) {
            return mid;
        }else if(arr[mid] > target) {
            return recurBinSearch(arr, low, mid-1, target);
        }else {
            return recurBinSearch(arr, mid+1, high, target);
        }
    }

    public static int searchRotatedSortedArr(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[low] < arr[mid]) {
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                if(arr[mid] <= target && target <= arr[high]) {
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(searchRotatedSortedArr(arr, 2));
    }
}