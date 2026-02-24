package BinarySearch.Medium;

public class Capacity_to_Ship_Packages {
    public static int max(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for(int i : arr) maxi = Math.max(maxi, i);
        return maxi;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int num : arr) sum += num;
        return sum;
    }

    public static int noOfDays(int[] arr, int cap) {
        int days = 1, load = 0;
//        for(int i = 0; i < arr.length; i++) {
//            if((load + arr[i]) > cap) {
//                days++;
//                load = arr[i];
//            }else {
//                load += arr[i];
//            }
//        }
//        return days;

        for(int i = 0; i < arr.length; i++) {
            load += arr[i];
            if(load > cap) {
                load = arr[i];
                days++;
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
//        for(int i = max(weights); i <= sum(weights); i++) {
//            int calcDays = noOfDays(weights, i);
//            if(calcDays <= days) {
//                return i;
//            }
//        }

        int low = max(weights), high = sum(weights);
        while(low <= high) {
            int mid = (low+high) / 2;
            if(noOfDays(weights, mid) <= days) {
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr, 5));
    }
}
