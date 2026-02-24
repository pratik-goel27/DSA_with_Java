package BinarySearch.Hard;

public class Split_Array_Largest_Sum {
    public static int getMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for(int num : arr) maxi = Math.max(num, maxi);
        return maxi;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for(int num : arr) sum += num;
        return sum;
    }

    public static int findSplits(int[] arr, int maxSum) {
        int split = 1, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if((sum+arr[i]) <= maxSum) sum += arr[i];
            else {
                sum = arr[i];
                split++;
            }
        }
        return split;
    }

    public static int splitArray(int[] nums, int k) {
//        for(int i = getMax(nums); i <= getSum(nums); i++) {
//            int noOfSplits = findSplits(nums, i);
//            if(noOfSplits == k) return i;
//        }
//        return -1;

        int low = getMax(nums), high = getSum(nums);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int splits = findSplits(nums,mid);
            if(splits <= k) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr, 2));
    }
}
