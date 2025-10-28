package BinarySearch.Hard;

public class Find_Peak_Element {
    public static int findPeakElement(int[] nums) {
    //BRUTE FORCE SOLUTION :-
//        int n = nums.length;
//        if(n == 1 || nums[0] > nums[1]) return 0;
//
//        for(int i = 1; i < n-1; i++) {
//            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
//                return i;
//            }
//        }
//        return n-1;


        int n = nums.length;
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Check left neighbor if exists
            boolean left = (i == 0) || (nums[i] >= nums[i - 1]);
            // Check right neighbor if exists
            boolean right = (i == n - 1) || (nums[i] >= nums[i + 1]);

            // If both conditions are true
            if (left && right) return i;
        }

        // In case no peak found
        return -1;


        //OPTIMAL SOLUTION :-
//        int n = nums.length;
//        if(n == 1) return 0;
//        if(nums[0] > nums[1]) return 0;
//        if(nums[n-1] > nums[n-2]) return n-1;
//
//        int low = 1, high = n-2;
//        while(low <= high) {
//            int mid = (low+high)/2;
//            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
//                return mid;
//            }else if(nums[mid] < nums[mid+1]) {
//                low = mid+1;
//            }else {
//                high = mid-1;
//            }
//        }
//
//        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
}
