package BinarySearch.Medium;
import java.util.Arrays;
public class Find_Floor_and_Ceil {

    public static int getFloor(int[] nums, int x) {
        int floor = -1;
        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] <= x) {
                floor = nums[mid];
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return floor;
    }

    public static int getCeil(int[] nums, int x) {
        int ceil = -1;
        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] >= x) {
                ceil = nums[mid];
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return ceil;
    }

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        ans[0] = getFloor(nums,x);
        ans[1] = getCeil(nums,x);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 7, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(getFloorAndCeil(nums,target)));
    }
}