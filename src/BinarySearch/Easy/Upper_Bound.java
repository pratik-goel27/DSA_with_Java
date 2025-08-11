package BinarySearch.Easy;

public class Upper_Bound {
    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= target) {
                low = mid+1;
            }else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10,10,11};
        int target = 8;
        System.out.println(upperBound(arr,target));
    }
}
