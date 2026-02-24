package BinarySearch.Hard;

public class Book_Allocation {
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(num, max);
        return max;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        return sum;
    }

    public static int findNoOfStud(int[] arr, int pages) {
        int cnt = 1, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if((sum + arr[i]) <= pages) {
                sum += arr[i];
                continue;
            }else {
                sum = arr[i];
                cnt++;
            }
        }

        return cnt;
    }

    public static int findPages(int[] arr, int k) {
//        if(k > arr.length) return -1;
//        for(int pages = getMax(arr); pages <= sum(arr); pages++) {
//            int noOfStud = findNoOfStud(arr, pages);
//            if((noOfStud == k)) return pages;
//        }
//        return -1;

        if(k > arr.length) return -1;
        int low = getMax(arr), high = sum(arr);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(findNoOfStud(arr, mid) > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(findPages(arr, 2));
    }
}