package BinarySearch.Hard;

public class Painters_Partition {
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max, num);
        return max;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for(int num : arr) sum += num;
        return sum;
    }

    public static int getPainters(int[] arr, int time) {
        int cnt = 1, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if((sum + arr[i]) <= time) {
                sum += arr[i];
            }else {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static int minTime(int[] arr, int k) {
//        for(int time = getMax(arr); time <= getSum(arr); time++) {
//            int noOfPainters = getPainters(arr, time);
//            if(noOfPainters <= k) return time;
//        }
//        return -1;

        int low = getMax(arr), high = getSum(arr);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((getPainters(arr, mid)) > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        System.out.println(minTime(arr, 3));
    }
}
