package BinarySearch.Easy;

public class Search_Insert_Position {

    public static int searchInsPos(int[] arr, int target) {
        //BRUTE FORCE SOLUTION:-
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] >= target) {
//                return i;
//            }
//        }
//        return arr.length;

        //OPTIMAL SOLUTION:- (SIMILAR TO LOWER BOUND)
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = n;

        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] >= target) {
                ans = mid;
                end = mid-1;    //look for a smaller index on the left.
            }else {
                start = mid+1;  //look for right.
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7};
        int target = 5;
        System.out.println(searchInsPos(arr,target));
    }
}
