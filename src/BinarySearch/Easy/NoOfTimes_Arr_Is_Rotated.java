package BinarySearch.Easy;

public class NoOfTimes_Arr_Is_Rotated {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int low = 0, high = arr.length-1;
        int min = Integer.MAX_VALUE, index = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            //if the array is already sorted
//            if(arr[low] <= arr[high]) {
//                if(arr[low] < min) {
//                    min = arr[low];
//                    index = low;
//                }
//                break;
//            }
            if(arr[low] <= arr[mid]) { //left half is sorted
                if(arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid+1;
            }else { //right half is sorted
                if(arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }
        System.out.println(index);
    }
}