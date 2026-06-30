package Arrays;
import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[k++] = arr[left];
                left++;
            }else {
                temp[k++] = arr[right];
                right++;
            }
        }

        while(left <= mid) {
            temp[k++] = arr[left];
            left++;
        }

        while(right <= high) {
            temp[k++] = arr[right];
            right++;
        }

        for(int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,3};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
