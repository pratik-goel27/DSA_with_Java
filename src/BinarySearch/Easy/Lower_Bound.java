package BinarySearch.Easy;

public class Lower_Bound {
    public static int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = n;

        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] >= target) {
                ans = mid;
                //look for more small index on left.
                end = mid-1;
            }else {
                start = mid+1;  //look for right.
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10,10,11};
        int target = 9;
        System.out.println(lowerBound(arr,target));
    }
}