package BinarySearch.Medium;

public class Minimum_In_Rotated_Sorted_Arr {

    public static int minInRotatedSortedArr(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low+high)/2;
            //if the arr is already sorted: -
            //then arr[low] will always be the minimum in that search space.
            if(nums[low] <= nums[high]) {
                min = Math.min(min,nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]) {  //left half is sorted
                min = Math.min(min,nums[low]);
                low = mid+1;
            }else {  //right half is sorted
                min = Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        System.out.println(minInRotatedSortedArr(nums));
    }
}
