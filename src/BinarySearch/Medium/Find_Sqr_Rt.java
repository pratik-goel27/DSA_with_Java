package BinarySearch.Medium;

public class Find_Sqr_Rt {
    public static void main(String[] args) {

        //BRUTE FORCE:-
//        int n = 0;
//        int ans = -1;
//        if(n == 0 || n == 1) {
//            ans = n;
//        }else {
//            int low = 1;
//            int high = n;
//
//            while (low <= high) {
//                int mid = (low + high) / 2;
//                if ((mid * mid) == n) {
//                    ans = Math.max(ans, mid);
//                    break;
//                } else if ((mid * mid) > n) {
//                    high = mid - 1;
//                } else {
//                    ans = Math.max(ans, mid);
//                    low = mid + 1;
//                }
//            }
//        }
//        System.out.println(ans);

        //OPTIMAL SOLUTION:-
        int n = 1;
        int low = 1, high = n;
        while(low <= high) {
            long mid = (low+high)/2;
            long val = mid*mid;
            if(val <= n) {
                low = (int)mid+1;
            }else {
                high = (int) mid-1;
            }
        }
        System.out.println(high);
    }
}