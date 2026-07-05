package Arrays;

public class Count_Inversions {
    public static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        int count = 0;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[k++] = arr[left];
                left++;
            }else {
                temp[k++] = arr[right];
                count += (mid - left + 1);
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

        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low >= high) return count;
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int inversionCount(int[] arr) {
        //BRUTE FORCE :-
//        int cnt = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i+1; j < arr.length; j++) {
//                if(arr[i] > arr[j]) {
//                    cnt++;
//                }
//            }
//        }
//
//        return cnt;

        //OPTIMAL
        return mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println(inversionCount(arr));
    }
}
