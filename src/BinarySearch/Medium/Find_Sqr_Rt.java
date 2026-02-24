package BinarySearch.Medium;

public class Find_Sqr_Rt {
    public static int floorSqrt(int n) {
        //BRUTE FORCE APPROACH :-
//        int ans = 0;
//        for(int i = 0; i <= n/2; i++) {
//            if(n == 0 || n == 1) return n;
//            if((i*i) <= n) {
//                ans = i;
//            }else{
//                break;
//            }
//        }
//        return ans;

        //OPTIMAL SOLUTION :-
        if(n == 0 || n == 1) return n;
        int low = 1, high = n/2;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(mid*mid == n) {
                return mid;
            }
            else if(mid*mid < n) {
                ans = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(28));
    }
}