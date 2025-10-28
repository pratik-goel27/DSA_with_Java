package BinarySearch.Easy;

public class NoOfTimes_Arr_Is_Rotated {
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length-1;
        int ans = Integer.MAX_VALUE, index = -1;

        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[low] <= arr[high]) {
                if(arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }

            if(arr[low] <= arr[mid]) { //left half is sorted
                if(arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid+1;
            }else { //right half is sorted
                if(arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(findKRotation(arr));
    }
}